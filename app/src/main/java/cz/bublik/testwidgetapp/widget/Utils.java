package cz.bublik.testwidgetapp.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RemoteViews;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cz.bublik.testwidgetapp.R;
import cz.bublik.testwidgetapp.widget.model.DataModel;

import static cz.bublik.testwidgetapp.widget.StackRemoteViewsFactory.TEST_JSON;

class Utils {

    static DataModel loadDataModelFromSharedPreferences(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.widgetDataStorage), Context.MODE_PRIVATE);
        String widgetData = sharedPref.getString(String.valueOf(R.string.widgetData), TEST_JSON);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        return gson.fromJson(widgetData, DataModel.class);
    }

    static boolean dataModelIsNotEmpty(DataModel dataModel) {
        return dataModel.getPages() != null && dataModel.getPages().size() > 0;
    }

    static DataModel.Page loadLastPage(DataModel dataModel, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.page_id_index_key), Context.MODE_PRIVATE);
        int pageIndex = sharedPref.getInt(String.valueOf(R.string.page_index), 0);
        if (dataModel.getPages().size() > pageIndex) {
            return dataModel.getPages().get(pageIndex);
        } else {
            return dataModel.getPages().get(0);
        }
    }

    static RemoteViews getRemoteViewsForByOptions(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        // See the dimensions and
        Bundle options = appWidgetManager.getAppWidgetOptions(appWidgetId);

        // Get min width and height.
        int minWidth = options.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);
        int minHeight = options.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT);

        // Obtain appropriate widget and update it.
        return getRemoteViews(context, minWidth, minHeight);
    }

    /**
     * Determine appropriate view based on row or column provided.
     *
     * @param minWidth
     * @param minHeight
     * @return
     */
    private static RemoteViews getRemoteViews(Context context, int minWidth, int minHeight) {
        // First find out rows and columns based on width provided.
        int rows = getCellsForSize(minHeight);
        int column = getCellsForSize(minWidth);
        // Now you changing layout base on you column count
        // In this code from 1 column to 4
        // you can make code for more columns on your own.

        return column >= 4 ? new RemoteViews(context.getPackageName(), R.layout.appwidget_provider_doubled_list) : new RemoteViews(context.getPackageName(), R.layout.appwidget_provider);
    }

    /**
     * Returns number of cells needed for given size of the widget.
     *
     * @param size Widget size in dp.
     * @return Size in number of cells.
     */
    private static int getCellsForSize(int size) {
        int n = 2;
        while (70 * n - 30 < size) {
            ++n;
        }
        return n - 1;
    }
}
