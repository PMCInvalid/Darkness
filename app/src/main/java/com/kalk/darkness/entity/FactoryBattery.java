package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactoryBattery extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity, String[][] map)
    {
        EntityBattery battery = new EntityBattery(game);

        return battery;
    }

    @Override
    public void mapGen()
    {

    }
}
