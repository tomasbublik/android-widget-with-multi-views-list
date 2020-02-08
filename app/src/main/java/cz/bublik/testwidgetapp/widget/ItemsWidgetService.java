package cz.bublik.testwidgetapp.widget;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import cz.bublik.testwidgetapp.R;
import cz.bublik.testwidgetapp.widget.model.WidgetDataModel;

import static cz.bublik.testwidgetapp.utils.ModelUtils.dataModelIsNotEmpty;
import static cz.bublik.testwidgetapp.utils.ModelUtils.loadDataModelFromSharedPreferences;
import static cz.bublik.testwidgetapp.utils.ModelUtils.loadLastPage;
import static cz.bublik.testwidgetapp.widget.Const.VARIANT;
import static cz.bublik.testwidgetapp.widget.Const.VARIANT_A;

public class ItemsWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new StackRemoteViewsFactory(this.getApplicationContext(), intent);
    }
}

class StackRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private static final String TAG = "StackRemoteViewsFactory";
    BroadcastReceiver broadcastReceiver;

    private Context mContext;
    private String chosenVariant = VARIANT_A;
    private WidgetDataModel widgetDataModel;
    private WidgetDataModel.Page shownPage;

    StackRemoteViewsFactory(Context context, Intent intent) {
        mContext = context;
        chosenVariant = intent.getStringExtra(VARIANT);
    }

    public void onCreate() {
        Log.d(TAG, "onCreate");

        IntentFilter screenStateFilter = new IntentFilter();
        screenStateFilter.addAction(Intent.ACTION_SCREEN_ON);
        screenStateFilter.addAction(Intent.ACTION_SCREEN_OFF);
        screenStateFilter.addAction(Intent.ACTION_USER_PRESENT);
        broadcastReceiver = new BroadcastReceiver();
        mContext.registerReceiver(broadcastReceiver, screenStateFilter);


        widgetDataModel = loadDataModelFromSharedPreferences(mContext);
        if (dataModelIsNotEmpty(widgetDataModel)) {
            // Show the first page
            shownPage = widgetDataModel.getPages().get(0);
        }
    }

    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        mContext.unregisterReceiver(broadcastReceiver);
        // In onDestroy() you should tear down anything that was setup for your data source,
        // eg. cursors, connections, etc.
    }

    public int getCount() {
        return noItemsToShow() ? 0 : getCountForVariant();
    }

    private int getCountForVariant() {
        return chosenVariant.equals(VARIANT_A) ? itemsSize() : getItemsCountForSecondVariant();
    }

    private boolean noItemsToShow() {
        return shownPage == null || shownPage.getItems() == null || shownPage.getItems().isEmpty();
    }

    private int getItemsCountForSecondVariant() {
        return isDivisibleByTwo() ? (itemsSize() / 2) : (itemsSize() / 2) + 1;
    }

    private int itemsSize() {
        return shownPage.getItems().size();
    }

    private boolean isDivisibleByTwo() {
        return itemsSize() % 2 == 0;
    }

    public RemoteViews getViewAt(int position) {
        return createRemoteViewsForVariantFromShownPage(position);
    }

    private RemoteViews createRemoteViewsForVariantFromShownPage(int position) {
        if (shownPage == null) {
            shownPage = widgetDataModel.getPages().get(0);
        }
        RemoteViews remoteViews;
        if (chosenVariant.equals(VARIANT_A)) {
            remoteViews = prepareOneColumnVariant(position);
        } else {
            remoteViews = prepareTwoColumnsVariant(position);
        }

        return remoteViews;
    }

    /**
     * Main rendering method for two-columns variant. For every item position calculates
     * its presentation (text, icon, etc.)
     * @param position Position of the item
     * @return Remote views to be showed inside the widget
     */
    private RemoteViews prepareTwoColumnsVariant(int position) {
        RemoteViews remoteViews;
        remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.widget_item_doubled);

        if (itemsSize() > (position * 2)) {
            remoteViews.setTextViewText(R.id.widget_item_text_1, shownPage.getItems().get(position * 2).getItemTitle());
            remoteViews.setTextViewText(R.id.widget_item_text_small_1, shownPage.getItems().get(position * 2).getItemSubTitle());
            remoteViews.setImageViewResource(R.id.widget_item_image_1, R.drawable.ico_home);

            if (!shownPage.getItems().get(position * 2).isActive()) {
                remoteViews.setTextColor(R.id.widget_item_text_1, Color.GRAY);
                remoteViews.setTextColor(R.id.widget_item_text_small_1, Color.GRAY);
            } else {
                remoteViews.setTextColor(R.id.widget_item_text_1, Color.BLACK);
                remoteViews.setTextColor(R.id.widget_item_text_small_1, Color.BLACK);
            }
        }

        if (itemsSize() > (position * 2) + 1) {
            remoteViews.setTextViewText(R.id.widget_item_text_2, shownPage.getItems().get((position * 2) + 1).getItemTitle());
            remoteViews.setTextViewText(R.id.widget_item_text_small_2, shownPage.getItems().get((position * 2) + 1).getItemSubTitle());
            remoteViews.setImageViewResource(R.id.widget_item_image_2, R.drawable.ico_home);
            remoteViews.setViewVisibility(R.id.widget_item_image_2, View.VISIBLE);

            if (!shownPage.getItems().get((position * 2) + 1).isActive()) {
                remoteViews.setTextColor(R.id.widget_item_text_2, Color.GRAY);
                remoteViews.setTextColor(R.id.widget_item_text_small_2, Color.GRAY);
            } else {
                remoteViews.setTextColor(R.id.widget_item_text_2, Color.BLACK);
                remoteViews.setTextColor(R.id.widget_item_text_small_2, Color.BLACK);
            }

        } else {
            remoteViews.setTextViewText(R.id.widget_item_text_2, "");
            remoteViews.setTextViewText(R.id.widget_item_text_small_2, "");
            remoteViews.setViewVisibility(R.id.widget_item_image_2, View.INVISIBLE);
        }
        return remoteViews;
    }

    /**
     * Main rendering method for one-columnc variant. For every item position calculates
     * its presentation (text, icon, etc.)
     * @param position Position of the item
     * @return Remote views to be showed inside the widget
     */
    private RemoteViews prepareOneColumnVariant(int position) {
        RemoteViews remoteViews;
        remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.widget_item);

        remoteViews.setTextViewText(R.id.widget_item_text, shownPage.getItems().get(position).getItemTitle());
        remoteViews.setTextViewText(R.id.widget_item_text_small, shownPage.getItems().get(position).getItemSubTitle());
        remoteViews.setImageViewResource(R.id.widget_item_image, R.drawable.ico_home);

        if (!shownPage.getItems().get(position).isActive()) {
            remoteViews.setTextColor(R.id.widget_item_text, Color.GRAY);
            remoteViews.setTextColor(R.id.widget_item_text_small, Color.GRAY);
        } else {
            remoteViews.setTextColor(R.id.widget_item_text, Color.BLACK);
            remoteViews.setTextColor(R.id.widget_item_text_small, Color.BLACK);
        }
        return remoteViews;
    }

    public RemoteViews getLoadingView() {
        // You can create a custom loading view (for instance when getViewAt() is slow.) If you
        // return null here, you will get the default loading view.
        return null;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public long getItemId(int position) {
        return position;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void onDataSetChanged() {
        Log.d(TAG, "onDataSetChanged");
        widgetDataModel = loadDataModelFromSharedPreferences(mContext);
        shownPage = loadLastPage(widgetDataModel, mContext);
    }
}