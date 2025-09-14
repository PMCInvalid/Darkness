package com.kalk.darkness.entity;

import static com.kalk.darkness.Gameplay.game;
import com.kalk.darkness.Entity;
import com.kalk.darkness.Game;
import com.kalk.darkness.GameVec;
import com.kalk.darkness.Gameplay;

import java.util.LinkedList;
import java.util.Queue;

public class FactoryMobs
{
    private boolean isCloseToPlayer(GameVec a)
    {
        return GameVec.distance(a, game.player.getPosition()) < 3;
    }

    public boolean haveWay(GameVec start, GameVec end)
    {
        if (!game.isWalkable(start) || !game.isWalkable(end))
        {
            return false;
        }

        if (start.getX() == end.getX() && start.getY() == end.getY())
        {
            return true;
        }

        int[][] directions =
                {
                        {-1, -1}, {-1, 0}, {-1, 1},
                        {0, -1},          {0, 1},
                        {1, -1},  {1, 0}, {1, 1}
                };

        boolean[][] visited = new boolean[game.maxX][game.maxY];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start.getX(), start.getY()});
        visited[start.getX()][start.getY()] = true;

        while (!queue.isEmpty())
        {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions)
            {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX == end.getX() && newY == end.getY())
                {
                    return true;
                }

                if (newX > 0 && newY > 0 && newX < game.maxX && newY < game.maxY)
                    if (game.isWalkable(start) && !visited[newX][newY])
                    {
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
            }
        }

        return false;
    }

    public Entity spawn(Game game, Gameplay activity, String[][] map)
    {
        return null;
    }

    public void mapGen()
    {

    }
}