package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.GameVec;
import com.kalk.darkness.Gameplay;
import com.kalk.darkness.MapGenerator;

public class FactoryLever extends FactoryMobs
{
    @Override
    public EntityLever spawn(Game game, Gameplay activity, String[][] map)
    {
        EntityLever lever = new EntityLever(game);

        boolean check = true;

        while (check)
        {
            lever.setPosition(MapGenerator.getRandomCords());

            if (Entity.isWalkable(game.getMap(), lever.position.getY(), lever.position.getX(), 0))
                check = false;
        }

        game.addEntitty(lever);

        return lever;
    }

    @Override
    public void mapGen()
    {

    }
}
