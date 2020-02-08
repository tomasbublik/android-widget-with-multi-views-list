package cz.bublik.testwidgetapp.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;

public class BroadcastReceiver extends android.content.BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BroadcastReceiver", "intent=" + intent);
        // For our example, we'll also update all of the widgets when the timezone
        // changes, or the user or network sets the time.
        String action = intent.getAction();

        if (action.equals(Intent.ACTION_TIME_CHANGED)) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ArrayList<Integer> appWidgetIds = new ArrayList<>();
            ArrayList<String> texts = new ArrayList<>();
            AppWidgetConfigure.loadAllTitlePrefs(context, appWidgetIds, texts);
            final int N = appWidgetIds.size();
            for (int i = 0; i < N; i++) {
                AppWidget.updateAppWidget(
                        context,
                        appWidgetManager,
                        appWidgetIds.get(i),
                        null
                );
            }
        }
    }
}