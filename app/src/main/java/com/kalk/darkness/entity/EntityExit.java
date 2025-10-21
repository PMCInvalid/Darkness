package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Globals;

public class EntityExit extends Entity
{
    public EntityExit(Game _game)
    {
        super(_game, "extraction_tile");
    }

    @Override
    public void onPlayerCollision(String difficulty)
    {
        if (game.playerCanExit())
        {
            Globals.addScore(1);
            Globals.statistics.setScore();
            Globals.statistics.save();
            game.init(0, difficulty);
        }
    }
}