package com.kalk.darkness.entity;

import com.kalk.darkness.Direction;
import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.MapGenerator;
import com.kalk.darkness.Pathfinding;

public class EntitySlon extends Entity
{
    EntitySlon(Game _game)
    {
        super(_game, "slon_tile");
    }

    public void tick()
    {
        Direction dir = Direction.NONE;

        if (!game.player.hidden)
        {
            dir = Pathfinding.findNextStep(game.getMap(), position.getX(), position.getY(), game.player.getPosition().getX(), game.player.getPosition().getY(), 2, 0);
        }

        else if (dir == Direction.NONE)
            dir = Direction.fromInt(MapGenerator.rand.nextInt(9) + 1);

        movement(dir, game.getMap());
    }
}
