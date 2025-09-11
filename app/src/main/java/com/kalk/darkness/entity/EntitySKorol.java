package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.MapGenerator;

public class EntitySKorol extends Entity
{
    EntitySKorol(Game _game)
    {
        super(_game, "sking_tile");
    }/*

    public void tick()
    {
        int direction = MapGenerator.rand.nextInt(8) + 1;

        if (game.sKorol.corY - game.player.corY == 1)
            direction = 1;

        if (game.sKorol.corY - game.player.corY == 1 && game.sKorol.corX - game.player.corX == -1)
            direction = 2;

        if (game.sKorol.corX - game.player.corX == -1)
            direction = 3;

        if (game.sKorol.corY - game.player.corY == -1 && game.sKorol.corX - game.player.corX == -1)
            direction = 4;

        if (game.sKorol.corY - game.player.corY == -1)
            direction = 5;

        if (game.sKorol.corY - game.player.corY == -1 && game.sKorol.corX - game.player.corX == 1)
            direction = 6;

        if (game.sKorol.corX - game.player.corX == 1)
            direction = 7;

        if (game.sKorol.corY - game.player.corY == 1 && game.sKorol.corX - game.player.corX == 1)
            direction = 8;

        movement(direction);
    }*/
}
