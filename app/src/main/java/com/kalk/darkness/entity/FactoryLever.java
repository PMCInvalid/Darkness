package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactoryLever extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity)
    {
        EntityLever lever = new EntityLever(game);

        return lever;
    }

    @Override
    public void mapGen()
    {

    }
}
