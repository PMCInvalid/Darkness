package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactorySkorol  extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity)
    {
        EntitySKorol skorol = new EntitySKorol(game);

        return skorol;
    }

    @Override
    public void mapGen()
    {

    }
}
