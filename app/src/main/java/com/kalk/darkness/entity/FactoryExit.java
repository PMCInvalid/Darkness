package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactoryExit extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity)
    {
        EntityExit exit = new EntityExit(game);

        return exit;
    }

    @Override
    public void mapGen()
    {

    }
}
