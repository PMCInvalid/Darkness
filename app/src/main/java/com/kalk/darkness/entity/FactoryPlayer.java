package com.kalk.darkness.entity;

import com.kalk.darkness.Game;
import com.kalk.darkness.GameVec;
import com.kalk.darkness.Gameplay;
import com.kalk.darkness.MapGenerator;

public class FactoryPlayer extends FactoryMobs
{
    @Override
    public EntityPlayer spawn(Game game, Gameplay activity, String[][] map)
    {
        EntityPlayer player = new EntityPlayer(game, activity);

        GameVec pos = MapGenerator.getRandomCords();

        boolean solution = true;

        player.setPosition(pos);
        player.getPosition().setY(pos.getY());
        player.getPosition().setX(pos.getX());

        game.addEntitty(player);

        //game.player.isHere = true;

        return player;
    }

    @Override
    public void mapGen()
    {

    }
}
