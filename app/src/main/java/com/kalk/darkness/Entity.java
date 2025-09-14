package com.kalk.darkness;

import java.util.LinkedList;
import java.util.Queue;

public class Entity
{
    protected Game game;
    public String tile;
    public GameVec position;

    public GameVec getPosition() {
        return position;
    }

    public void setPosition(GameVec position) {
        this.position = position;
    }
    
    public Game getGame()
    {
        return game;
    }

    public void setGame(Game game)
    {
        this.game = game;
    }

    public Entity(Game _game, String _tile)
    {
        this.game = _game;
        this.tile = _tile;
    }

    private static final int[][] DIRECTIONS =
            {
                    {0, -1},  // 1: Вверх
                    {1, -1},  // 2: Вверх и вправо
                    {1, 0},   // 3: Вправо
                    {1, 1},   // 4: Вправо и вниз
                    {0, 1},   // 5: Вниз
                    {-1, 1},  // 6: Вниз и влево
                    {-1, 0},  // 7: Влево
                    {-1, -1}, // 8: Влево и вверх
            };

    private static int[][] distanceMap;
    private static int[][] directionMap;

    public static void computeFlowField(String[][] map, int endX, int endY, int mobType)
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

    public int calcDirection(GameVec vec)
    {
        if (vec.getX() < 0 || vec.getY() < 0 || vec.getX() >= game.maxX || vec.getY() >= game.maxY)
        {
            return 9; // Если клетка за пределами карты, возвращаем случайное направление
        }
        return directionMap[vec.getX()][vec.getY()];
    }

    public int getDirection()
    {
        return calcDirection(position);
    }

    private static boolean isWalkable(String[][] map, int x, int y)
    {
        if (y < 0 || x < 0 || y >= map.length || x >= map[0].length)
        {
            return false;
        }

        String cell = map[y][x];

        boolean helperCell = false;

        if (cell.equals("empty_tile") || cell.equals("gonchaja_territory_tile") || cell.equals("river_tile") || cell.equals("bushes_tile"))
        {
            helperCell = true;
        }

        return helperCell;
    }

    private static int calculateDirection(int x, int y, int mobType)
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
                    if (distanceMap[newX][newY] < minDistance) {
                        minDistance = distanceMap[newX][newY];
                        bestDirection = i + 1;
                    }
                }
            }
        }

        return bestDirection;
    }

    private static boolean canMove(int direction, int mobType)
    {
        switch (mobType) {
            case 1: // Только вертикали и горизонтали (1 клетка)
                return direction == 1 || direction == 3 || direction == 5 || direction == 7;
            case 2: // Только диагонали (1 клетка)
                return direction == 2 || direction == 4 || direction == 6 || direction == 8;
            case 3: // Все 8 направлений (1 клетка)
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

    public void movement(int direction, String[][] map)
    {
        if (direction == 1)
        {
            this.position = position.offSet(this.position, Direction.up, 1);
        }

        else if (direction == 2)
        {
            this.position = position.offSet(this.position, Direction.upright, 1);
        }

        else if (direction == 3)
        {
            this.position = position.offSet(this.position, Direction.right, 1);
        }

        else if (direction == 4)
        {
            this.position = position.offSet(this.position, Direction.downright, 1);
        }

        else if (direction == 5)
        {
            this.position = position.offSet(this.position, Direction.down, 1);
        }

        else if (direction == 6)
        {
            this.position = position.offSet(this.position, Direction.downleft, 1);
        }

        else if (direction == 7)
        {
            this.position = position.offSet(this.position, Direction.left, 1);
        }

        else if (direction == 8)
        {
            this.position = position.offSet(this.position, Direction.upleft, 1);
        }
    }

    public void onPlayerCollision(String difficulty)
    {
        game.endGame();
    }

    public boolean playerCanExit()
    {
        return true;
    }
    
    public void tick()
    {
        
    }
}