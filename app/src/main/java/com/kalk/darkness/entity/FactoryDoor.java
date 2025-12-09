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

        door.setPosition(new GameVec(3, 1));

        int newX = MapGenerator.getRandomCords().getX();
        int newY;
        if (newX == 3 || newX == game.maxX - 3)
        {
            newY = MapGenerator.getRandomCords().getY();
        }

        else
        {
            newY = new Random().nextBoolean() ? 2 : game.maxY - 3;
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
