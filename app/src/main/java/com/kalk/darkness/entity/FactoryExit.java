package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.GameVec;
import com.kalk.darkness.Gameplay;
import com.kalk.darkness.MapGenerator;

public class FactoryExit extends FactoryMobs
{
    @Override
    public EntityExit spawn(Game game, Gameplay activity)
    {
        EntityExit exit = new EntityExit(game);

        exit.setPosition(MapGenerator.getRandomCords());

        game.addEntitty(exit);

        return exit;
    }

    @Override
    public void mapGen()
    {

    }
}
