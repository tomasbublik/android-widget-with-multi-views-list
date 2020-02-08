package cz.bublik.testwidgetapp.utils;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;

import cz.bublik.testwidgetapp.R;

public class ViewUtils {

    private ViewUtils() {}

    public static RemoteViews getRemoteViewsForByOptions(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
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
        // int rows = getCellsForSize(minHeight);
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
