package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactorySlon extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity)
    {
        EntitySlon battery = new EntitySlon(game);

        return battery;
    }

    @Override
    public void mapGen()
    {

    }
}
