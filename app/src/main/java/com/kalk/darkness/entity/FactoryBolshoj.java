package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class FactoryBolshoj extends FactoryMobs
{
    @Override
    public Entity spawn(Game game, Gameplay activity)
    {
        EntityBolshoj bolshoj = new EntityBolshoj(game);

        return bolshoj;
    }

    @Override
    public void mapGen()
    {

    }
}
