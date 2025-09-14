package com.kalk.darkness.entity;

import android.app.Application;

import com.kalk.darkness.Constants;
import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.Gameplay;
import com.kalk.darkness.Globals;

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

    public void tick(int direction, String difficulty)
    {
        int moveCheck = 0;

        switch (direction)
        {
            case 1:
                if (!game.getMap()[game.player.getPosition().getY() - 1][game.player.getPosition().getX()].equals("wall_tile"))
                {
                    movement(1, game.getMap());
                    moveCheck = 1;
                    playerMoveRem = 1;
                }
                break;

            case 2:
                if(!game.getMap()[game.player.getPosition().getY() - 1][game.player.getPosition().getX() + 1].equals("wall_tile"))
                {
                    movement(2, game.getMap());
                    moveCheck = 1;
                    playerMoveRem = 2;
                }
                break;

            case 3:
                if(!game.getMap()[game.player.getPosition().getY()][game.player.getPosition().getX() + 1].equals("wall_tile"))
                {
                    movement(3, game.getMap());
                    moveCheck = 1;
                    playerMoveRem = 3;
                }
                break;

            case 4:
                if(!game.getMap()[game.player.getPosition().getY() + 1][game.player.getPosition().getX() + 1].equals("wall_tile"))
                {
                    movement(4, game.getMap());
                    moveCheck = 1;
                    playerMoveRem = 4;
                }
                break;

            case 5:
                if (!game.getMap()[game.player.getPosition().getY() + 1][game.player.getPosition().getX()].equals("wall_tile"))
                {
                    movement(5, game.getMap());
                    moveCheck = 1;
                    playerMoveRem = 5;
                };
                break;

            case 6:
                if (!game.getMap()[game.player.getPosition().getY() + 1][game.player.getPosition().getX() - 1].equals("wall_tile"))
                {
                    movement(6, game.getMap());
                    moveCheck = 1;
                    playerMoveRem = 6;
                }
                break;

            case 7:
                if (!game.getMap()[game.player.getPosition().getY()][game.player.getPosition().getX() - 1].equals("wall_tile"))
                {
                    movement(7, game.getMap());
                    moveCheck = 1;
                    playerMoveRem = 7;
                }
                break;

            case 8:
                if(!game.getMap()[game.player.getPosition().getY() - 1][game.player.getPosition().getX() - 1].equals("wall_tile"))
                {
                    movement(8, game.getMap());
                    moveCheck = 1;
                    playerMoveRem = 8;
                }
                break;

            case 9:
                moveCheck = 1;
                flashlight = 1;
                playerMoveRem = 9;
                break;
        }

        if (moveCheck == 1)
        {
            if (!playerInBushes)
            {
                if (difficulty.equals(Constants.difficulty_easy))
                {
                    gameplayActivity.drawMap();
                    game.abi(ability);
                }

                else if (difficulty.equals(Constants.difficulty_hard) || direction == 9)
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
