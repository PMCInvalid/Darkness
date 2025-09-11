package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.MapGenerator;

public class EntityMedved extends Entity
{
    EntityMedved(Game _game)
    {
        super(_game, "medved_tile");
    }/*

    public void tick()
    {
        int direction = EntityPlayer.getPlayerMoveRem();

        if (direction == 9)
            direction = MapGenerator.rand.nextInt(9) + 1;

        movement(direction);
    }*/
}
