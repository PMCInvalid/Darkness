package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.GameVec;
import com.kalk.darkness.Gameplay;
import com.kalk.darkness.Globals;
import com.kalk.darkness.MapGenerator;
import com.kalk.darkness.Statistics;

public class FactoryExit extends FactoryMobs
{
    @Override
    public EntityExit spawn(Game game, Gameplay activity, String[][] map)
    {
        EntityExit exit = new EntityExit(game);

        boolean check = false;

        exit.setPosition(MapGenerator.getRandomCords());

        while (check)
        {
            exit.setPosition(MapGenerator.getRandomCords());

            if (Entity.isWalkable(game.getMap(), exit.position, 0))
                if (haveWay(exit.position, Globals.playerPosition))
                    check = false;
        }

        game.addEntitty(exit);

        return exit;
    }

    @Override
    public void mapGen()
    {

    }
}
