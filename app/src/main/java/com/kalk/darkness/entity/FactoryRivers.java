package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactoryRivers extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity, String[][] map)
    {
        EntityRivers rivers = new EntityRivers(game);

        return rivers;
    }

    @Override
    public void mapGen()
    {

    }
}
