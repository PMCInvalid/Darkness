package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;

public class EntityPowerUp extends Entity
{
    public EntityPowerUp(Game _game, String _tile)
    {
        super(_game, "power_tile");
    }

    public int ability = 0;
}
