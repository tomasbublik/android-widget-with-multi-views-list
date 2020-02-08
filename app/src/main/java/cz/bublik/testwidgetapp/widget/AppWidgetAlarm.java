package cz.bublik.testwidgetapp.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

import cz.bublik.testwidgetapp.widget.model.WidgetDataModel;

class AppWidgetAlarm {

    private static final int HOURLY_ALARM_ID = 0;
    private static final int END_PERIOD_ALARM_ID = 1;
    private static final int END_TIME_SLOT_ALARM_ID = 2;

    private static final String TAG = "AppWidgetAlarm";

    private Context mContext;

    AppWidgetAlarm(Context context) {
        mContext = context;
    }

    private void startAlarms(WidgetDataModel widgetDataModel) {
        Log.d(TAG, "Alarms start called");

        Intent alarmIntent = new Intent(mContext, AppWidget.class);
        alarmIntent.setAction(AppWidget.ACTION_AUTO_UPDATE);

        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);

        PendingIntent hourlyPendingIntent = PendingIntent.getBroadcast(mContext, HOURLY_ALARM_ID, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent endPeriodPendingIntent = PendingIntent.getBroadcast(mContext, END_PERIOD_ALARM_ID, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent endSlotPendingIntent = PendingIntent.getBroadcast(mContext, END_TIME_SLOT_ALARM_ID, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        long triggerAtMillis = System.currentTimeMillis() + AlarmManager.INTERVAL_HALF_HOUR;
        alarmManager.setRepeating(AlarmManager.RTC, triggerAtMillis, AlarmManager.INTERVAL_HOUR, hourlyPendingIntent);

        Calendar testCalendar = Calendar.getInstance();
        testCalendar.setTimeInMillis(triggerAtMillis);
        logAlarmSetting(testCalendar, "Regular repeat time");

        if (widgetDataModel.getAlarmPeriodChange() != null) {
            Calendar calendar = widgetDataModel.getAlarmPeriodChange();
            calendar.add(Calendar.SECOND, 10);
            logAlarmSetting(calendar, "Closest alarm place period change");
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), endPeriodPendingIntent);
        }
        if (widgetDataModel.getNearestAlarmDate() != null) {
            Calendar calendar = widgetDataModel.getNearestAlarmDate();
            calendar.add(Calendar.SECOND, 10);
            logAlarmSetting(calendar, "Closest alarm HDO change");
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), endSlotPendingIntent);
        }

        Log.d(TAG, "All alarms set");
    }

    private void logAlarmSetting(Calendar calendar, String name) {
        Log.d(TAG, "Setting alarm for: " + name);

        Log.d(TAG, "Setting alarm to year: " + calendar.get(Calendar.YEAR));
        Log.d(TAG, "Setting alarm to month: " + calendar.get(Calendar.MONTH));
        Log.d(TAG, "Setting alarm to day: " + calendar.get(Calendar.DAY_OF_WEEK));
        Log.d(TAG, "Setting alarm to day of month: " + calendar.get(Calendar.DAY_OF_MONTH));
        Log.d(TAG, "Setting alarm to hour: " + calendar.get(Calendar.HOUR_OF_DAY));
        Log.d(TAG, "Setting alarm to minute: " + calendar.get(Calendar.MINUTE));
        Log.d(TAG, "Setting alarm to second: " + calendar.get(Calendar.SECOND));
    }


    void stopAlarms() {
        Log.d(TAG, "Alarms stop called");
        Intent alarmIntent = new Intent(mContext, AppWidget.class);
        alarmIntent.setAction(AppWidget.ACTION_AUTO_UPDATE);
        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);

        PendingIntent hourlyPendingIntent = PendingIntent.getBroadcast(mContext, HOURLY_ALARM_ID, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent endPeriodPendingIntent = PendingIntent.getBroadcast(mContext, END_PERIOD_ALARM_ID, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent endSlotPendingIntent = PendingIntent.getBroadcast(mContext, END_TIME_SLOT_ALARM_ID, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        alarmManager.cancel(hourlyPendingIntent);
        alarmManager.cancel(endPeriodPendingIntent);
        alarmManager.cancel(endSlotPendingIntent);

        Log.d(TAG, "All alarms destroyed");
    }

    void resetAlarms(WidgetDataModel widgetDataModel) {
        stopAlarms();
        startAlarms(widgetDataModel);
    }
}
