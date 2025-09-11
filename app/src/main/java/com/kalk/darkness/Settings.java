package com.kalk.darkness;

import android.content.SharedPreferences;

public class Settings
{
    SharedPreferences sharedPreferences;
    String difficulty = "easy";

    public Settings(SharedPreferences _sharedPreferences)
    {
        this.sharedPreferences = _sharedPreferences;
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

    public void load()
    {
        difficulty = sharedPreferences.getString("difficulty", "");
    }
}
