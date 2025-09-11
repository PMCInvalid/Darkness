package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;

public class EntityGonchaja extends Entity
{
    public int gonTer = 0;
    public int gonchajaBaseX;
    public int gonchajaBaseY;

    EntityGonchaja(Game _game)
    {
        super(_game, "gonchaja_tile");
    }/*

    public boolean gonScan(int range)
    {
        boolean playerIsHere = false;

        for (int i = gonchajaBaseY - range; i <= gonchajaBaseY + range; i++)
        {
            for (int j = gonchajaBaseX - range; j <= gonchajaBaseX + range; j++)
            {
                if (map[i][j].equals("player_tile"))
                    playerIsHere = true;
            }
        }

        return playerIsHere;
    }

    public void tick()
    {
        boolean act = gonScan(gonTer);

        int direction = 0;

        for (int i = 0; i < 2; i++)
        {
            if (act)
            {
                computeFlowField(game.map, game.player.corX, game.player.corY, 3);

                direction = getDirection();
            }

            else
            {
                computeFlowField(game.map, game.player.corX, game.player.corY, 3);

                direction = getDirection();
            }

            movement(direction);
        }
    }*/
}
