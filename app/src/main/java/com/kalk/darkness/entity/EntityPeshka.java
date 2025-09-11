package com.kalk.darkness.entity;

import android.content.Context;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.MapGenerator;

public class EntityPeshka extends Entity
{
    public EntityPeshka(Game _game)
    {
        super(_game, "peshka_tile");
    }

    @Override
    public void tick()
    {
        int direction = 9;

        if (!game.player.hidden)
        {
            computeFlowField(game.getMap(), game.player.getPosition().getY(), game.player.getPosition().getX(), 1);

            direction = getDirection();
        }

        else
            direction = (MapGenerator.rand.nextInt(4) + 1) * 2 - 1;

        movement(direction, game.getMap());
    }
}