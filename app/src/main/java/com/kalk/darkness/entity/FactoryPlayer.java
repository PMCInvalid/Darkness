package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.GameVec;
import com.kalk.darkness.Gameplay;
import com.kalk.darkness.Globals;
import com.kalk.darkness.MapGenerator;

public class FactoryPlayer extends FactoryMobs
{
    @Override
    public EntityPlayer spawn(Game game, Gameplay activity, String[][] map)
    {
        EntityPlayer player = new EntityPlayer(game, activity);

        boolean check = true;

        while (check)
        {
            player.setPosition(MapGenerator.getRandomCords());

            if (Entity.isWalkable(game.getMap(), player.position, 0))
                if (haveWay(player.position, new GameVec(player.position.getY(), player.position.getX())))
                    check = false;
        }

        game.addEntitty(player);

        Globals.playerPosition = player.position;

        return player;
    }

    @Override
    public void mapGen()
    {

    }
}
