package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactoryFKing extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity)
    {
        EntityFKing Fking = new EntityFKing(game);

        return Fking;
    }

    @Override
    public void mapGen()
    {

    }
}
