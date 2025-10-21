package com.kalk.darkness.entity;

import com.kalk.darkness.Constants;
import com.kalk.darkness.Direction;
import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.GameVec;
import com.kalk.darkness.Gameplay;
import com.kalk.darkness.Globals;

public class EntityPlayer extends Entity
{
    static int playerMoveRem;
    int energy = 100;
    boolean playerInBushes = false;
    int ability = 0;
    public boolean hidden = false;

    int flashlight = 0;
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

    public int getPlayerMoveRem()
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

    public int getFlashlight() {
        return flashlight;
    }

    public void setFlashlight(int flashlight) {
        this.flashlight = flashlight;
    }

    public EntityPlayer(Game _game, Gameplay activity)
    {
        super(_game, "player_tile");
        this.gameplayActivity = activity;
    }

    public void tick(Direction direction)
    {

        if (direction != Direction.NONE)
        {
            GameVec newPosition = GameVec.sum(position, Direction.DirToGV(direction));

            if (Entity.isWalkable(game.getMap(), newPosition, 1))
            {
                movement(direction, game.getMap());
                playerMoveRem = Direction.toInt(direction);
            }
        }

        else
        {
            flashlight = 1;
            playerMoveRem = 9;
        }
    }
}
