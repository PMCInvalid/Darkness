package com.kalk.darkness.entity;


import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.MapGenerator;

public class EntitySlon extends Entity
{
    EntitySlon(Game _game)
    {
        super(_game, "slon_tile");
    }/*

    public void tick()
    {
        int direction = 9;

        if (!game.player.hidden)
        {
            computeFlowField(game.map, game.player.corX, game.player.corY, 2);

            direction = getDirection();
        }

        else
            direction = (MapGenerator.rand.nextInt(4) + 1) * 2;

        movement(direction);
    }*/
}
