package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;

public class EntityRivers extends Entity
{
    public EntityRivers(Game _game)
    {
        super(_game, "river_tile");
    }

    public int riverDir = 1;
}
