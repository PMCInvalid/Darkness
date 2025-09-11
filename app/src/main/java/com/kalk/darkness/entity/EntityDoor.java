package com.kalk.darkness.entity;

import android.content.SharedPreferences;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Statistics;

public class EntityDoor extends Entity
{
    Statistics statistics;

    public EntityDoor(Game _game)
    {
        super(_game, "door_tile");
    }

    @Override
    public void onPlayerCollision()
    {
        game.score += 0.25;
        statistics.setScore(game.score);
        statistics.save();
        //game.init(0);
    }
}
