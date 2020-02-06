package cz.bublik.testwidgetapp.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import cz.bublik.testwidgetapp.R;
import cz.bublik.testwidgetapp.widget.model.DataModel;

import static cz.bublik.testwidgetapp.widget.Utils.dataModelIsNotEmpty;
import static cz.bublik.testwidgetapp.widget.Utils.getRemoteViewsForByOptions;
import static cz.bublik.testwidgetapp.widget.Utils.loadDataModelFromSharedPreferences;
import static cz.bublik.testwidgetapp.widget.Utils.loadLastPage;

public class AppWidget extends AppWidgetProvider {

    public static final String VARIANT = "cz.bublik.testwidgetapp.widget.VARIANT";

    public static final String VARIANT_A = "cz.bublik.testwidgetapp.widget.VARIANT_A";
    public static final String VARIANT_B = "cz.bublik.testwidgetapp.widget.VARIANT_B";

    private static final String TAG = "ExampleAppWidgetProvide";

    public static final String LEFT_BUTTON_CLICKED = "leftButtonClicked";
    public static final String RIGHT_BUTTON_CLICKED = "rightButtonClicked";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(TAG, "onUpdate");
        // For each widget that needs an update, get the text that we should display:
        //   - Create a RemoteViews object for it
        //   - Set the text in the RemoteViews object
        //   - Tell the AppWidgetManager to show that views object for the widget.

        DataModel dataModel = loadDataModelFromSharedPreferences(context);

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId, loadLastPage(dataModel, context));
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

        DataModel.Page newPage = getNewPage(context, intentAction);

        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.items_list_doubled);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.items_list);

        updateAppWidget(context, appWidgetManager, appWidgetId, newPage);

        super.onReceive(context, intent);
    }

    private DataModel.Page getNewPage(Context context, String intentAction) {
        DataModel dataModel = loadDataModelFromSharedPreferences(context);
        DataModel.Page lastPage = loadLastPage(dataModel, context);
        return storeShownPage(context, intentAction, dataModel, lastPage);
    }

    private DataModel.Page storeShownPage(Context context, String action, DataModel dataModel, DataModel.Page currentPage) {
        DataModel.Page newPage = calculateShownPageBaseOnClick(action, dataModel, currentPage);

        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.page_id_index_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(String.valueOf(R.string.page_index), dataModel.getPages().indexOf(newPage));
        editor.commit();

        return newPage;
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
        // When the first widget is created, register for the TIMEZONE_CHANGED and TIME_CHANGED
        // broadcasts.  We don't want to be listening for these if nobody has our widget active.
        // This setting is sticky across reboots, but that doesn't matter, because this will
        // be called after boot if there is a widget instance for this provider.
        /*PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(
                new ComponentName("cz.bublik.testwidgetapp", ".widget.BroadcastReceiver"),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);*/
    }

    @Override
    public void onDisabled(Context context) {
        // When the first widget is created, stop listening for the TIMEZONE_CHANGED and
        // TIME_CHANGED broadcasts.
        Log.d(TAG, "onDisabled");
        /*PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(
                new ComponentName("cz.bublik.testwidgetapp", ".appwidget.BroadcastReceiver"),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);*/
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        Log.d(TAG, "onAppWidgetOptionsChanged");

        updateAppWidget(context, appWidgetManager, appWidgetId, getNewPage(context, "0"));

        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    static void updateAppWidget(Context context,
                                AppWidgetManager appWidgetManager,
                                int appWidgetId,
                                DataModel.Page shownPage) {
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
            remoteViews.setImageViewResource(R.id.main_icon_view, R.drawable.btn_green);
            remoteViews.setTextViewText(R.id.placeName, shownPage.getPlaceName());
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

    private DataModel.Page calculateShownPageBaseOnClick(String buttonClickedDirection, DataModel dataModel, DataModel.Page currentPage) {
        if (dataModelIsNotEmpty(dataModel) && currentPage != null) {
            if (buttonClickedDirection.equals(LEFT_BUTTON_CLICKED)) {
                if (dataModel.getPages().indexOf(currentPage) == 0) {
                    return dataModel.getPages().get(dataModel.getPages().size() - 1);
                } else {
                    return dataModel.getPages().get(dataModel.getPages().indexOf(currentPage) - 1);
                }
            }
            if (buttonClickedDirection.equals(RIGHT_BUTTON_CLICKED)) {
                if (dataModel.getPages().indexOf(currentPage) == (dataModel.getPages().size() - 1)) {
                    return dataModel.getPages().get(0);
                } else {
                    return dataModel.getPages().get(dataModel.getPages().indexOf(currentPage) + 1);
                }
            }
        }
        return currentPage;
    }
}
