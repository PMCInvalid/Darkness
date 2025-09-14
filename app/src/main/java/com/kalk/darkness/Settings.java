package com.kalk.darkness;

import android.app.Application;
import android.content.SharedPreferences;

public class Settings extends Application
{
    SharedPreferences sharedPreferences;
    String difficulty = "easy";

    public Settings()
    {

    }

    public String getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }

    public void save()
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("difficulty", difficulty);
        editor.apply();
    }
}
