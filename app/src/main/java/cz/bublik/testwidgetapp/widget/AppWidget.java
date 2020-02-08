package cz.bublik.testwidgetapp.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import cz.bublik.testwidgetapp.R;
import cz.bublik.testwidgetapp.widget.model.WidgetDataModel;

import static cz.bublik.testwidgetapp.utils.ModelUtils.getNewPage;
import static cz.bublik.testwidgetapp.utils.ModelUtils.loadDataModelFromSharedPreferences;
import static cz.bublik.testwidgetapp.utils.ModelUtils.loadLastPage;
import static cz.bublik.testwidgetapp.utils.ModelUtils.shortenIfNecessary;
import static cz.bublik.testwidgetapp.utils.ViewUtils.getRemoteViewsForByOptions;
import static cz.bublik.testwidgetapp.widget.Const.LEFT_BUTTON_CLICKED;
import static cz.bublik.testwidgetapp.widget.Const.RIGHT_BUTTON_CLICKED;
import static cz.bublik.testwidgetapp.widget.Const.VARIANT;
import static cz.bublik.testwidgetapp.widget.Const.VARIANT_A;
import static cz.bublik.testwidgetapp.widget.Const.VARIANT_B;

/**
 * Main widget class having the necessary callback for its controls
 */
public class AppWidget extends AppWidgetProvider {

    private static final String TAG = "ExampleAppWidgetProvide";

    // Intent action called by alarm to cause the widget update
    public static final String ACTION_AUTO_UPDATE = "AUTO_UPDATE";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(TAG, "onUpdate");
        // For each widget that needs an update, get the text that we should display:
        //   - Create a RemoteViews object for it
        //   - Tell the AppWidgetManager to show that views object for the widget.

        // Load the widget model to be presented
        WidgetDataModel widgetDataModel = loadDataModelFromSharedPreferences(context);

        // Alarms resetting based on the newly calculated model
        resetAlarms(context, widgetDataModel);

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId, loadLastPage(widgetDataModel, context));
        }

        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        Log.d(TAG, "onReceived action: " + intentAction);

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);

        WidgetDataModel widgetDataModel = loadDataModelFromSharedPreferences(context);
        if (intentAction != null && intentAction.equals(ACTION_AUTO_UPDATE)) {
            Log.d(TAG, "Widget update requested by alarm scheduler");
            // Alarms are reset only when auto update is called, no need to do that when
            // for example, user clicked.
            resetAlarms(context, widgetDataModel);
        }

        WidgetDataModel.Page newPage = getNewPage(context, intentAction, widgetDataModel);

        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, AppWidget.class));
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.items_list);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.items_list_doubled);

        updateAppWidget(context, appWidgetManager, appWidgetId, newPage);

        super.onReceive(context, intent);
    }

    private void resetAlarms(Context context, WidgetDataModel widgetDataModel) {
        AppWidgetAlarm appWidgetAlarm = new AppWidgetAlarm(context.getApplicationContext());
        appWidgetAlarm.resetAlarms(widgetDataModel);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.d(TAG, "onDeleted");
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            AppWidgetConfigure.deleteTitlePref(context, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        Log.d(TAG, "onEnabled");
        WidgetDataModel widgetDataModel = loadDataModelFromSharedPreferences(context);

        AppWidgetAlarm appWidgetAlarm = new AppWidgetAlarm(context.getApplicationContext());
        appWidgetAlarm.resetAlarms(widgetDataModel);
    }

    @Override
    public void onDisabled(Context context) {
        Log.d(TAG, "onDisabled");
        AppWidgetAlarm appWidgetAlarm = new AppWidgetAlarm(context.getApplicationContext());
        appWidgetAlarm.stopAlarms();
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        Log.d(TAG, "onAppWidgetOptionsChanged");

        WidgetDataModel widgetDataModel = loadDataModelFromSharedPreferences(context);
        resetAlarms(context, widgetDataModel);

        updateAppWidget(context, appWidgetManager, appWidgetId, getNewPage(context, "0", widgetDataModel));

        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    static void updateAppWidget(Context context,
                                AppWidgetManager appWidgetManager,
                                int appWidgetId,
                                WidgetDataModel.Page shownPage) {
        RemoteViews remoteViews = getRemoteViewsForByOptions(context, appWidgetManager, appWidgetId);
        // Here we setup the intent which points to the StackViewService which will
        // provide the views for this collection.
        Intent serviceIntent = new Intent(context, ItemsWidgetService.class);
        if (remoteViews.getLayoutId() == R.layout.appwidget_provider) {
            serviceIntent.putExtra(VARIANT, VARIANT_A);
            remoteViews.setRemoteAdapter(R.id.items_list, serviceIntent);
            // The empty view is displayed when the collection has no items. It should be a sibling
            // of the collection view.
            remoteViews.setEmptyView(R.id.items_list, R.id.empty_view);
        } else {
            serviceIntent.putExtra(VARIANT, VARIANT_B);
            remoteViews.setRemoteAdapter(R.id.items_list_doubled, serviceIntent);
        }
        // When intents are compared, the extras are ignored, so we need to embed the extras
        // into the data so that the extras will not be ignored.
        serviceIntent.setData(Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME)));
        if (shownPage != null) {
            remoteViews.setImageViewResource(R.id.main_icon_view, R.drawable.ico_socket);
            remoteViews.setTextViewText(R.id.placeName, shortenIfNecessary(shownPage.getPlaceName()));
        } else {
            Log.d(TAG, "Shown page is null");
        }

        // Here we setup the a pending intent template. Individuals items of a collection
        // cannot setup their own pending intents, instead, the collection as a whole can
        // setup a pending intent template, and the individual items can set a fillInIntent
        // to create unique before on an item to item basis.

        remoteViews.setOnClickPendingIntent(R.id.leftButton, getPendingSelfIntent(context, LEFT_BUTTON_CLICKED, appWidgetId));
        remoteViews.setOnClickPendingIntent(R.id.rightButton, getPendingSelfIntent(context, RIGHT_BUTTON_CLICKED, appWidgetId));

        // Tell the widget manager
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }

    protected static PendingIntent getPendingSelfIntent(Context context, String action, int appWidgetId) {
        Log.d(TAG, "getPendingSelfIntent");
        Intent intent = new Intent(context, AppWidget.class);
        intent.setAction(action);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);

        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

}
