package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactoryGonchaja extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity, String[][] map)
    {
        EntityGonchaja gonchaja = new EntityGonchaja(game);

        return gonchaja;
    }

    @Override
    public void mapGen()
    {

    }
}
