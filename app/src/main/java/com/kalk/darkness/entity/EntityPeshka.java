package com.kalk.darkness.entity;

import com.kalk.darkness.Direction;
import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.MapGenerator;
import com.kalk.darkness.Pathfinding;

public class EntityPeshka extends Entity
{
    public EntityPeshka(Game _game)
    {
        super(_game, "peshka_tile");
    }

    @Override
    public void tick()
    {
        Direction dir;

        if (!game.player.hidden)
            dir = Pathfinding.findNextStep(game.getMap(), position.getX(), position.getY(), game.player.getPosition().getX(), game.player.getPosition().getY(), 1, 0);

        else
        {
            dir = Direction.fromInt(MapGenerator.rand.nextInt(9) + 1);
        }

        movement(dir, game.getMap());
    }
}