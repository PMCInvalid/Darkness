package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.GameVec;
import com.kalk.darkness.Gameplay;
import com.kalk.darkness.MapGenerator;

public class FactoryLever extends FactoryMobs
{
    @Override
    public EntityLever spawn(Game game, Gameplay activity)
    {
        EntityLever lever = new EntityLever(game);

        lever.setPosition(MapGenerator.getRandomCords());

        game.addEntitty(lever);

        return lever;
    }

    @Override
    public void mapGen()
    {

    }
}
