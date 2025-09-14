package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;

public class EntityLever extends Entity
{
    public EntityLever(Game _game)
    {
        super(_game, "lever_tile");
    }

    public boolean triggered = false;

    @Override
    public boolean playerCanExit()
    {
        return triggered;
    }

    @Override
    public void onPlayerCollision(String difficulty)
    {
        triggered = true;
        System.out.println("Triggered");
    }

    @Override
    public void tick()
    {

    }
}
