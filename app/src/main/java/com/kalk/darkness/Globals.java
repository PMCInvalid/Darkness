package com.kalk.darkness;

import android.app.Application;
import android.content.SharedPreferences;

public class Globals extends Application
{
    public static Statistics statistics;
    public static Settings settings;
    public static GameVec playerPosition;

    public void onCreate()
    {
        super.onCreate();

        SharedPreferences statisticsSharedPreferences = getSharedPreferences("AppStatistics", MODE_PRIVATE);
        SharedPreferences settingsSharedPreferences = getSharedPreferences("AppSettings", MODE_PRIVATE);

        statistics = new Statistics(statisticsSharedPreferences, settings);
        settings = new Settings(settingsSharedPreferences);
        playerPosition = new GameVec();
        statistics.load();
    }
}
