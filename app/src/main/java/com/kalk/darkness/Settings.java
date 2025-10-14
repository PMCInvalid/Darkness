package com.kalk.darkness;

import android.content.SharedPreferences;

public class Settings
{
    SharedPreferences prefs;
    String difficulty = Constants.difficulty_easy;

    public Settings(SharedPreferences prefs)
    {
        this.prefs = prefs;
        this.difficulty = prefs.getString("difficulty", Constants.difficulty_easy);
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
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("difficulty", difficulty);
        editor.apply();
    }
}
