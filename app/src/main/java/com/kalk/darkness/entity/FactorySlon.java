package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;
import com.kalk.darkness.MapGenerator;

public class FactorySlon extends FactoryMobs
{
    @Override
    public EntitySlon spawn(Game game, Gameplay activity, String[][] map)
    {
        EntitySlon slon = new EntitySlon(game);

        boolean check = true;

        while (check)
        {
            slon.setPosition(MapGenerator.getRandomCords());

            if (Entity.isWalkable(map, slon.position, 1))
                check = false;
        }

        game.addEntitty(slon);

        return slon;
    }

    @Override
    public void mapGen()
    {

    }
}
