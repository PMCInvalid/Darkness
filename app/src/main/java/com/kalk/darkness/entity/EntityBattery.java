package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;

public class EntityBattery extends Entity
{
    public int energy = 100;

    public EntityBattery(Game _game)
    {
        super(_game, "battery_tile");
    }/*

    @Override
    public void onPlayerCollision()
    {
        game.battery.energy = 100;
        game.player.helper2 = "empty_tile";
        game.player.helper1 = "empty_tile";
        game.battery.corY = -1;
        game.battery.corX = -1;
    }*/
}
