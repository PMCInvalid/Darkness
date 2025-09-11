package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactoryPeshka extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity)
    {
        EntityPeshka peshka = new EntityPeshka(game);

        return peshka;
    }

    @Override
    public void mapGen()
    {

    }
}
