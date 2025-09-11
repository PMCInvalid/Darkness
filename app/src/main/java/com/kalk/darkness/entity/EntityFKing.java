package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.MapGenerator;

public class EntityFKing extends Entity
{
    EntityFKing(Game _game)
    {
        super(_game, "sking_tile");
    }/*

    public void tick()
    {
        int direction = 9;

        if (!game.player.hidden)
        {
            computeFlowField(game.map, game.player.corX, game.player.corY, 3);

            direction = getDirection();
        }
        else
            direction = (MapGenerator.rand.nextInt(4) + 1) * 2 - 1;

        movement(direction);
    }*/
}
