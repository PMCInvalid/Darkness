package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;
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
                check = false;
        }

        game.addEntitty(player);

        return player;
    }

    @Override
    public void mapGen()
    {

    }
}
