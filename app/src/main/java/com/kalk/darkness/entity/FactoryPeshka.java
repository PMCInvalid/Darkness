package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;
import com.kalk.darkness.MapGenerator;

public class FactoryPeshka extends FactoryMobs
{
    @Override
    public EntityPeshka spawn(Game game, Gameplay activity, String[][] map)
    {
        EntityPeshka peshka = new EntityPeshka(game);

        boolean check = true;

        while (check)
        {
            peshka.setPosition(MapGenerator.getRandomCords());

            if (game.isWalkable(peshka.position))
                check = false;
        }

        game.addEntitty(peshka);

        return peshka;
    }

    @Override
    public void mapGen()
    {

    }
}
