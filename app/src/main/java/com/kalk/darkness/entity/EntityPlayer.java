package com.kalk.darkness.entity;

import com.kalk.darkness.Constants;
import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;

public class EntityPlayer extends Entity
{
    static int playerMoveRem;
    int energy = 100;
    boolean playerInBushes = false;
    int ability = 0;
    Gameplay gameplayActivity;

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public static int getPlayerMoveRem()
    {
        return playerMoveRem;
    }

    public boolean isPlayerInBushes()
    {
        return playerInBushes;
    }

    public void setPlayerInBushes(boolean playerInBushes)
    {
        this.playerInBushes = playerInBushes;
    }

    public EntityPlayer(Game _game, Gameplay activity)
    {
        super(_game, "player_tile");
        this.gameplayActivity = activity;
    }

    public boolean hidden = false;
    int flashlight = 0;

    public void tick(int a)
    {
        int moveCheck = 0;

        game.settings.load();

        if (a == 1)
        {
            if (!game.getMap()[game.player.getPosition().getY()][game.player.getPosition().getX()].equals("wall_tile"))
            {
                movement(1, game.getMap());
                moveCheck = 1;
                playerMoveRem = 1;
            }
        }

        else if (a == 2)
        {
            if(!game.getMap()[game.player.getPosition().getY() - 1][game.player.getPosition().getX() + 1].equals("wall_tile"))
            {
                movement(2, game.getMap());

                moveCheck = 1;

                playerMoveRem = 2;
            }
        }

        else if (a == 3)
        {
            if(!game.getMap()[game.player.getPosition().getY()][game.player.getPosition().getX() + 1].equals("wall_tile"))
            {
                movement(3, game.getMap());
                moveCheck = 1;
                playerMoveRem = 3;
            }
        }

        else if (a == 4)
        {
            if(!game.getMap()[game.player.getPosition().getY() + 1][game.player.getPosition().getX() + 1].equals("wall_tile"))
            {
                movement(4, game.getMap());
                moveCheck = 1;
                playerMoveRem = 4;
            }
        }

        else if (a == 5)
        {
            if (!game.getMap()[game.player.getPosition().getY() + 1][game.player.getPosition().getX()].equals("wall_tile"))
            {
                movement(5, game.getMap());
                moveCheck = 1;
                playerMoveRem = 5;
            }
        }

        else if (a == 6)
        {
            if (!game.getMap()[game.player.getPosition().getY() + 1][game.player.getPosition().getX() - 1].equals("wall_tile"))
            {
                movement(6, game.getMap());
                moveCheck = 1;
                playerMoveRem = 6;
            }
        }

        else if (a == 7)
        {
            if (!game.getMap()[game.player.getPosition().getY()][game.player.getPosition().getX() - 1].equals("wall_tile"))
            {
                movement(7, game.getMap());
                moveCheck = 1;
                playerMoveRem = 7;
            }
        }

        else if (a == 8)
        {
            if(!game.getMap()[game.player.getPosition().getY() - 1][game.player.getPosition().getX() - 1].equals("wall_tile"))
            {
                movement(8, game.getMap());
                moveCheck = 1;
                playerMoveRem = 8;
            }
        }

        else if (a == 9)
        {
            moveCheck = 1;
            flashlight = 1;
            playerMoveRem = 9;
        }

        if (moveCheck == 1)
        {
            if (!playerInBushes)
            {
                if (game.settings.getDifficulty().equals(Constants.difficulty_easy))
                {
                    gameplayActivity.drawMap();
                    game.abi(ability);
                }

                else if (game.settings.getDifficulty().equals(Constants.difficulty_hard) || a == 9)
                {
                    if (flashlight == 1 && energy > 0)
                    {
                        gameplayActivity.drawMap();
                        flashlight = 0;
                        energy-=3;
                    }

                    else
                    {
                        gameplayActivity.drawMap();
                        game.enemySence();
                        energy--;
                        game.abi(ability);
                    }
                }

                else
                {
                    if (flashlight == 1 && energy > 0)
                    {
                        gameplayActivity.drawMap();
                        flashlight = 0;
                        energy -= 6;
                    }

                    else
                    {
                        gameplayActivity.drawMap();
                        energy -= 2;
                        game.abi(ability);
                    }
                }
            }

            else
            {
                gameplayActivity.drawMap();
                game.abi(ability);
            }
        }
    }
}
