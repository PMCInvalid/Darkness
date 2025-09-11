package com.kalk.darkness;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

public class MainMenu extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);
        SharedPreferences settingsSharedPreferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences statisticsSharedPreferences = getSharedPreferences("AppStatistics", MODE_PRIVATE);
        Globals.settings = new Settings(settingsSharedPreferences);
        Globals.statistics = new Statistics(statisticsSharedPreferences, Globals.settings);
    }

    public void dive(View v)
    {
        Intent pip = new Intent(this, dive_choise.class);
        startActivity(pip);
    }

    public void rules(View v)
    {
        Intent pip = new Intent(this, MainMenu.class);
        startActivity(pip);
    }

    public void authors(View v)
    {
        Intent pip = new Intent(this, authors.class);
        startActivity(pip);
    }

    public void exit(View v)
    {
        Globals.settings.save();
        Globals.statistics.save();

        finish();
        System.exit(0);
    }
}