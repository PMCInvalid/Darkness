package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactoryKrot extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity, String[][] map)
    {
        EntityKrot krot = new EntityKrot(game);

        return krot;
    }

    @Override
    public void mapGen()
    {

    }
}
