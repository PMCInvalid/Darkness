package com.kalk.darkness;

import androidx.appcompat.app.AppCompatActivity;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class mob extends AppCompatActivity
{
    public int corX = -1;
    public int corY = -1;
    public int helper1 = 0;
    public int helper2 = 0;

    private static final int[][] DIRECTIONS =
            {
            {0, -1}, {1, -1}, {1, 0}, {1, 1},
            {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}
            };

    private int[][] distanceMap;
    private int[][] directionMap;

    public static int[] movePattern(int a, int b)
    {
        int[] arr = new int[2];

        int Y = 0;
        int X = 0;

        if (a == 1)
        {
            Y = -1;
            X = 0;
        }

        if (a == 2)
        {
            Y = -1;
            X = 1;
        }

        if (a == 3)
        {
            Y = 0;
            X = 1;
        }

        if (a == 4)
        {
            Y = 1;
            X = 1;
        }

        if (a == 5)
        {
            Y = 1;
            X = 0;
        }

        if (a == 6)
        {
            Y = 1;
            X = -1;
        }

        if (a == 7)
        {
            Y = 0;
            X = -1;
        }

        if (a == 8)
        {
            Y = -1;
            X = -1;
        }

        if (a == 0)
        {
            Y = 0;
            X = 0;
        }

        arr[0] = Y;
        arr[1] = X;

        return arr;
    }

    public void computeFlowField(int[][] map, int endX, int endY, int mobType)
    {
        int width = map.length;
        int height = map[0].length;

        // Инициализация карт
        distanceMap = new int[width][height];
        directionMap = new int[width][height];

        // Заполняем distanceMap "бесконечностью" (или большим числом)
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                distanceMap[x][y] = Integer.MAX_VALUE;
            }
        }

        // Очередь для обхода в ширину (BFS)
        Queue<Node> queue = new LinkedList<>();
        Node endNode = new Node(endX, endY);

        // Начинаем с цели
        queue.add(endNode);
        distanceMap[endX][endY] = 0;

        // Обход в ширину
        while (!queue.isEmpty())
        {
            Node current = queue.poll();

            for (int i = 0; i < DIRECTIONS.length; i++)
            {
                if (canMove(i + 1, mobType))
                {
                    int newX = current.x + DIRECTIONS[i][0];
                    int newY = current.y + DIRECTIONS[i][1];

                    // Проверяем, можно ли идти в эту клетку
                    if (newX >= 0 && newY >= 0 && newX < width && newY < height && isWalkable(map, newX, newY))
                    {
                        int newDistance = distanceMap[current.x][current.y] + 1;

                        if (newDistance < distanceMap[newX][newY])
                        {
                            distanceMap[newX][newY] = newDistance;
                            queue.add(new Node(newX, newY));
                        }
                    }
                }
            }
        }

        // Вычисляем направления для каждой клетки
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                directionMap[x][y] = calculateDirection(x, y, mobType);
            }
        }
    }

    public int getDirection(int x, int y)
    {
        if (x < 0 || y < 0 || x >= directionMap.length || y >= directionMap[0].length)
        {
            return 9; // Если клетка за пределами карты, возвращаем случайное направление
        }
        return directionMap[x][y];
    }

    private boolean isWalkable(int[][] map, int x, int y)
    {
        if (y < 0 || x < 0 || y >= map.length || x >= map[0].length)
        {
            return false;
        }

        int cell = map[y][x];

        boolean helperCell = false;

        if (cell < 11 || cell == 21)
        {
            helperCell = true;
        }

        return helperCell;
    }

    private int calculateDirection(int x, int y, int mobType)
    {
        int minDistance = distanceMap[x][y];
        int bestDirection = 9; // По умолчанию — случайное направление

        // Перебираем все возможные направления
        for (int i = 0; i < DIRECTIONS.length; i++)
        {
            if (canMove(i + 1, mobType))
            { // Проверяем, может ли моб двигаться в этом направлении
                int newX = x + DIRECTIONS[i][0];
                int newY = y + DIRECTIONS[i][1];

                // Проверяем, что клетка в пределах карты
                if (newX >= 0 && newY >= 0 && newX < distanceMap.length && newY < distanceMap[0].length)
                {
                    if (distanceMap[newX][newY] < minDistance)
                    {
                        minDistance = distanceMap[newX][newY];
                        bestDirection = i + 1; // Направление от 1 до 8
                    }
                }
            }
        }

        return bestDirection;
    }

    private boolean canMove(int direction, int mobType)
    {
        switch (mobType)
        {
            case 1: // Только вертикали и горизонтали
                return direction == 1 || direction == 3 || direction == 5 || direction == 7;
            case 2: // Только диагонали
                return direction == 2 || direction == 4 || direction == 6 || direction == 8;
            case 3: // Все 8 направлений
                return true;
            default:
                return false;
        }
    }

    private static class Node
    {
        int x, y;

        Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}