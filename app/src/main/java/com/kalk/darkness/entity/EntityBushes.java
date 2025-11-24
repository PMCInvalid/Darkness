package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;

public class EntityBushes extends Entity
{
    public EntityBushes(Game _game)
    {
        super(_game, "bushes_tile");
    }

    @Override
    public void onPlayerCollision(String difficulty)
    {
        game.player.hidden = true;
    }
}
