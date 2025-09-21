package com.kalk.darkness.entity;

import com.kalk.darkness.Constants;
import com.kalk.darkness.Direction;
import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.GameVec;
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

    public void tick(Direction direction, String difficulty)
    {
        boolean moveCheck = false;

        if (direction != Direction.NONE)
        {
            GameVec newPosition = GameVec.sum(position, Direction.DirToGV(direction));

            if (Entity.isWalkable(game.getMap(), newPosition, 1))
            {
                movement(direction, game.getMap());
                playerMoveRem = Direction.toInt(direction);
                moveCheck = true;
            }
        }

        else
        {
            moveCheck = true;
            flashlight = 1;
            playerMoveRem = 9;
        }

        if (moveCheck)
        {
            if (!playerInBushes)
            {
                if (difficulty.equals(Constants.difficulty_easy))
                {
                    gameplayActivity.drawMap();
                    game.abi(ability);
                }

                else if (difficulty.equals(Constants.difficulty_hard) || direction == Direction.NONE)
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
