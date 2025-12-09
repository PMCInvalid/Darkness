package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Globals;
import com.kalk.darkness.Statistics;

public class EntityDoor extends Entity
{
    Statistics statistics;

    public EntityDoor(Game _game)
    {
        super(_game, "door_tile");
    }

    @Override
    public void onPlayerCollision(String difficulty)
    {
        Globals.activeScore += 0.25f;
        Globals.statistics.setScore();
        Globals.statistics.save();
        game.init(0, difficulty);
    }
}
