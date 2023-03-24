package ru.ironcodes.islamicwikipedia;

import java.util.Calendar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class BootReceiver extends BroadcastReceiver{

    SharedPreferences preferences;
    private AlarmReceiver alarmReceiver = new AlarmReceiver();

    @Override
    public void onReceive(Context context, Intent intent) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(preferences.getLong("alarmTime2",
                System.currentTimeMillis()));
        new AlarmTask(context, c).run();

        SharedPreferences sharedPreferences = context.getSharedPreferences("checkFail1", Context.MODE_PRIVATE);
        int hours = sharedPreferences.getInt("minutes", 60);
        alarmReceiver.setAlarm(context, hours);
    }

}
