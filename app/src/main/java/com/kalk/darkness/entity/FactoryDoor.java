package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.GameVec;
import com.kalk.darkness.Gameplay;
import com.kalk.darkness.MapGenerator;

import java.util.Random;

public class FactoryDoor extends FactoryMobs
{
    @Override
    public EntityDoor spawn(Game game, Gameplay activity, String[][] map)
    {
        EntityDoor door = new EntityDoor(game);

        door.setPosition(new GameVec(2, 1));

        int newX = MapGenerator.getRandomCords().getX();
        int newY;
        if (newX == 1 || newX == game.maxX - 2)
        {
            newY = MapGenerator.getRandomCords().getY();
        }

        else
        {
            newY = new Random().nextBoolean() ? 1 : game.maxY - 2;
        }

        door.setPosition(new GameVec(newX, newY));

        game.addEntitty(door);

        return door;
    }

    @Override
    public void mapGen()
    {

    }
}
