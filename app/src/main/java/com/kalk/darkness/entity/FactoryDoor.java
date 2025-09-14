package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactoryDoor extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity, String[][] map)
    {
        EntityDoor door = new EntityDoor(game);

        return door;
    }

    @Override
    public void mapGen()
    {

    }
}
