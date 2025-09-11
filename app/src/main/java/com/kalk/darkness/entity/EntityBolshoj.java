package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;

public class EntityBolshoj extends Entity
{
    EntityBolshoj(Game _game)
    {
        super(_game, "bolshoj_tile");
    }/*

    public void tick()
    {
        int direction = 9;
        int needMove = 1;
        if (!game.player.hidden)
        {
            if (game.bolshoj.corY - game.player.corY < 2 && game.bolshoj.corX - game.player.corX < 2 && game.bolshoj.corY - game.player.corY > -2 && game.bolshoj.corX - game.player.corX > -2) {
                direction = 9;

                needMove = 0;
            } else {
                computeFlowField(game.map, game.player.corX, game.player.corY, 1);
                direction = getDirection();

                if (game.player.corX < game.bolshoj.corX && game.player.corY - 1 == game.bolshoj.corY || (game.player.corY + 1) == game.bolshoj.corY && game.player.corX < game.bolshoj.corX)
                    direction = 7;

                if (game.player.corX > game.bolshoj.corX && game.player.corY - 1 == game.bolshoj.corY || (game.player.corY + 1) == game.bolshoj.corY && game.player.corX > game.bolshoj.corX)
                    direction = 3;
            }
        }

        if (direction == 1)
        {
            game.bolshoj.helper1 = game.bolshoj.helper2;
            game.bolshoj.helper2 = game.map[game.bolshoj.corY - 2][game.bolshoj.corX];
            game.map[game.bolshoj.corY][game.bolshoj.corX] = game.bolshoj.helper1;
            game.bolshoj.corY -= 2;
            game.map[game.bolshoj.corY][game.bolshoj.corX] = "bolshoj_b_tile";
        }

        if (direction == 5)
        {
            game.bolshoj.helper1 = game.bolshoj.helper2;
            game.bolshoj.helper2 = game.map[game.bolshoj.corY + 2][game.bolshoj.corX];
            game.map[game.bolshoj.corY][game.bolshoj.corX] = game.bolshoj.helper1;
            game.bolshoj.corY += 2;
            game.map[game.bolshoj.corY][game.bolshoj.corX] = "bolshoj_b_tile";
        }

        if (direction == 3)
        {
            game.bolshoj.helper1 = game.bolshoj.helper2;
            game.bolshoj.helper2 = game.map[game.bolshoj.corY][game.bolshoj.corX + 2];
            game.map[game.bolshoj.corY][game.bolshoj.corX] = game.bolshoj.helper1;
            game.bolshoj.corX += 2;
            game.map[game.bolshoj.corY][game.bolshoj.corX] = "bolshoj_b_tile";
        }

        if (direction == 7)
        {
            game.bolshoj.helper1 = game.bolshoj.helper2;
            game.bolshoj.helper2 = game.map[game.bolshoj.corY][game.bolshoj.corX - 2];
            game.map[game.bolshoj.corY][game.bolshoj.corX] = game.bolshoj.helper1;
            game.bolshoj.corX -= 2;
            game.map[game.bolshoj.corY][game.bolshoj.corX] = "bolshoj_b_tile";
        }

        else if (direction == 9)
        {
            int direction2 = 0;

            if (!game.player.hidden)
            {
                if (game.player.corY < game.bolshoj.corY && needMove == 1)
                    direction2 = 1;

                if (game.player.corY > game.bolshoj.corY && needMove == 1)
                    direction2 = 5;
            }

            if (direction2 == 1 && needMove == 1)
            {
                if (game.player.corX < game.bolshoj.corX && game.player.corY - 1 == game.bolshoj.corY || (game.player.corY + 1) == game.bolshoj.corY && game.player.corX < game.bolshoj.corX)
                    direction2 = 7;

                else if (game.player.corX > game.bolshoj.corX && game.player.corY - 1 == game.bolshoj.corY || (game.player.corY + 1) == game.bolshoj.corY && game.player.corX > game.bolshoj.corX)
                    direction2 = 3;

                else
                {
                    game.bolshoj.helper1 = game.bolshoj.helper2;
                    game.bolshoj.helper2 = game.map[game.bolshoj.corY - 2][game.bolshoj.corX];
                    game.map[game.bolshoj.corY][game.bolshoj.corX] = game.bolshoj.helper1;
                    game.bolshoj.corY -= 2;
                    game.map[game.bolshoj.corY][game.bolshoj.corX] = "bolshoj_b_tile";
                }
            }

            if (direction2 == 5 && needMove == 1)
            {
                if (game.player.corX < game.bolshoj.corX && game.player.corY - 1 == game.bolshoj.corY || (game.player.corY + 1) == game.bolshoj.corY && game.player.corX < game.bolshoj.corX)
                    direction2 = 7;

                else if (game.player.corX > game.bolshoj.corX && game.player.corY - 1 == game.bolshoj.corY || (game.player.corY + 1) == game.bolshoj.corY && game.player.corX > game.bolshoj.corX)
                    direction2 = 3;

                else
                {
                    game.bolshoj.helper1 = game.bolshoj.helper2;
                    game.bolshoj.helper2 = game.map[game.bolshoj.corY + 2][game.bolshoj.corX];
                    game.map[game.bolshoj.corY][game.bolshoj.corX] = game.bolshoj.helper1;
                    game.bolshoj.corY += 2;
                    game.map[game.bolshoj.corY][game.bolshoj.corX] = "bolshoj_b_tile";
                }
            }

            if (direction2 == 3 && needMove == 1)
            {
                game.bolshoj.helper1 = game.bolshoj.helper2;
                game.bolshoj.helper2 = game.map[game.bolshoj.corY][game.bolshoj.corX + 2];
                game.map[game.bolshoj.corY][game.bolshoj.corX] = game.bolshoj.helper1;
                game.bolshoj.corX += 2;
                game.map[game.bolshoj.corY][game.bolshoj.corX] = "bolshoj_b_tile";
            }

            if (direction2 == 7 && needMove == 1)
            {
                game.bolshoj.helper1 = game.bolshoj.helper2;
                game.bolshoj.helper2 = game.map[game.bolshoj.corY][game.bolshoj.corX - 2];
                game.map[game.bolshoj.corY][game.bolshoj.corX] = game.bolshoj.helper1;
                game.bolshoj.corX -= 2;
                game.map[game.bolshoj.corY][game.bolshoj.corX] = "bolshoj_b_tile";
            }
        }
    }*/
}
