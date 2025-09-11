package com.kalk.darkness.entity;

import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.MapGenerator;

public class EntityKrot extends Entity
{
    private int krotMoves = 0;
    private int krotDim = 0;

    EntityKrot(Game _game)
    {
        super(_game, "krot_tile");
    }/*

    public void tick()
    {
        if (krotMoves <= 0)
        {
            krotDim = MapGenerator.rand.nextInt(10) + 1;

            krotMoves = MapGenerator.rand.nextInt(10) + 1;
        }

        else
        {
            switch(krotDim)
            {
                case 1:
                    if (game.krot.corY - 1 <= 1)
                    {
                        krotMoves = 0;
                        break;
                    }
                    game.map[game.krot.corY][game.krot.corX] = "empty_tile";
                    game.krot.corY -= 1;
                    game.map[game.krot.corY][game.krot.corX] = "krot_tile";
                    krotMoves--;
                    break;

                case 2:
                    if (game.krot.corY - 1 <= 1 || game.krot.corX + 1 >= 30)
                    {
                        krotMoves = 0;
                        break;
                    }
                    game.map[game.krot.corY][game.krot.corX] = "empty_tile";
                    game.krot.corY -= 1;
                    game.krot.corX += 1;
                    game.map[game.krot.corY][game.krot.corX] = "krot_tile";
                    krotMoves--;
                    break;

                case 3:
                    if (game.krot.corX + 1 >= 30)
                    {
                        krotMoves = 0;
                        break;
                    }
                    game.map[game.krot.corY][game.krot.corX] = "empty_tile";
                    game.krot.corX += 1;
                    game.map[game.krot.corY][game.krot.corX] = "krot_tile";
                    krotMoves--;
                    break;

                case 4:
                    if (game.krot.corY + 1 >= 30 || game.krot.corX + 1 >= 30)
                    {
                        krotMoves = 0;
                        break;
                    }
                    game.map[game.krot.corY][game.krot.corX] = "empty_tile";
                    game.krot.corY += 1;
                    game.krot.corX += 1;
                    game.map[game.krot.corY][game.krot.corX] = "krot_tile";
                    krotMoves--;
                    break;

                case 5:
                    if (game.krot.corY + 1 >= 30)
                    {
                        krotMoves = 0;
                        break;
                    }
                    game.map[game.krot.corY][game.krot.corX] = "empty_tile";
                    game.krot.corY += 1;
                    game.map[game.krot.corY][game.krot.corX] = "krot_tile";
                    krotMoves--;
                    break;

                case 6:
                    if (game.krot.corY + 1 >= 30 || game.krot.corX - 1 <= 1)
                    {
                        krotMoves = 0;
                        break;
                    }
                    game.map[game.krot.corY][game.krot.corX] = "empty_tile";
                    game.krot.corY += 1;
                    game.krot.corX -= 1;
                    game.map[game.krot.corY][game.krot.corX] = "krot_tile";
                    krotMoves--;
                    break;

                case 7:
                    if (game.krot.corX - 1 <= 1)
                    {
                        krotMoves = 0;
                        break;
                    }
                    game.map[game.krot.corY][game.krot.corX] = "empty_tile";
                    game.krot.corX -= 1;
                    game.map[game.krot.corY][game.krot.corX] = "krot_tile";
                    krotMoves--;
                    break;

                case 8:
                    if (game.krot.corY - 1 <= 1 || game.krot.corX - 1 <= 1)
                    {
                        krotMoves = 0;
                        break;
                    }
                    game.map[game.krot.corY][game.krot.corX] = "empty_tile";
                    game.krot.corY -= 1;
                    game.krot.corX -= 1;
                    game.map[game.krot.corY][game.krot.corX] = "krot_tile";
                    krotMoves--;
                    break;

                case 9:
                    krotMoves--;
            }
        }
    }*/
}
