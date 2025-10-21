package com.kalk.darkness;

import java.util.HashMap;
import java.util.Map;
import android.content.SharedPreferences;

public class Statistics
{
    HashMap<String, Float> scores = new HashMap<>();
    SharedPreferences sharedPreferences;
    Settings settings;

    public Statistics (SharedPreferences _sharedPreferences, Settings _settings)
    {
        this.sharedPreferences = _sharedPreferences;
        this.settings = _settings;
    }

    public float getScore(String difficulty)
    {
        return scores.getOrDefault(difficulty, 0.0f);
    }

    public void setScore()
    {
        scores.put(Globals.settings.getDifficulty(), Globals.activeScore);
    }

    public void save()
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        for (Map.Entry<String, Float> entry : scores.entrySet())
            editor.putFloat(entry.getKey() + "Score", entry.getValue());

        editor.apply();
    }

    public void load()
    {
        for (String difficulity : Constants.difficulties)
        {
            scores.put(difficulity, sharedPreferences.getFloat(difficulity + "Score", 0));
        }
    }
}

