package com.kalk.darkness.entity;

import android.content.SharedPreferences;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Statistics;

public class EntityExit extends Entity
{
    Statistics statistics;

    public EntityExit(Game _game)
    {
        super(_game, "extraction_tile");
    }

    @Override
    public void onPlayerCollision(String difficulty)
    {
        if (game.playerCanExit())
        {
            game.score++;
            //statistics.setScore(game.score);
            //statistics.save();
            game.init(0, difficulty);
        }
    }
}
