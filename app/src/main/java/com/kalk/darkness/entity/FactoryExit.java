package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.GameVec;
import com.kalk.darkness.Gameplay;
import com.kalk.darkness.MapGenerator;

public class FactoryExit extends FactoryMobs
{
    @Override
    public EntityExit spawn(Game game, Gameplay activity, String[][] map)
    {
        EntityExit exit = new EntityExit(game);

        boolean check = false;

        while (!check)
        {
            exit.setPosition(MapGenerator.getRandomCords());

            if (game.isWalkable(exit.position))
                if (haveWay(exit.position, game.player.position))
                    check = true;
        }

        game.addEntitty(exit);

        return exit;
    }

    @Override
    public void mapGen()
    {

    }
}
