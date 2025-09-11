package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactoryMedved extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity)
    {
        EntityMedved medved = new EntityMedved(game);

        return medved;
    }

    @Override
    public void mapGen()
    {

    }
}
