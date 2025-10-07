package com.kalk.darkness;

import java.util.ArrayDeque;
import java.util.Arrays;

public final class Pathfinding
{
    private Pathfinding() {}

    public static Direction findNextStep(String[][] map, int sx, int sy, int tx, int ty, int mobType, int walkableType)
    {
        int height = map.length;
        if (height == 0) return Direction.NONE;
        int width = map[0].length;

        if (!inBounds(sx, sy, width, height) || !inBounds(tx, ty, width, height))
        {
            return Direction.NONE;
        }

        if (sx == tx && sy == ty) return Direction.NONE;

        if (!Entity.isWalkable(map, new GameVec(tx, ty), walkableType))
        {
            return Direction.NONE;
        }

        final int INF = Integer.MAX_VALUE;
        int[][] dist = new int[height][width];
        for (int y = 0; y < height; y++) Arrays.fill(dist[y], INF);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[ty][tx] = 0;
        q.add(new int[]{tx, ty});

        while (!q.isEmpty())
        {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (Direction dir : Direction.values())
            {
                int code = Direction.toInt(dir);
                if (code == 9) continue; // NONE
                if (!canMove(code, mobType)) continue;

                int nx = cx + dir.dx();
                int ny = cy + dir.dy();
                if (!inBounds(nx, ny, width, height)) continue;
                if (!Entity.isWalkable(map, new GameVec(nx, ny), walkableType)) continue;

                int nd = dist[cy][cx] + 1;

                if (nd < dist[ny][nx])
                {
                    dist[ny][nx] = nd;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int best = dist[sy][sx];
        Direction bestDir = Direction.NONE;

        for (Direction dir : Direction.values()) {
            int code = Direction.toInt(dir);
            if (code == 9) continue;
            if (!canMove(code, mobType)) continue;

            int nx = sx + dir.dx();
            int ny = sy + dir.dy();
            if (!inBounds(nx, ny, width, height)) continue;
            if (!Entity.isWalkable(map, new GameVec(nx, ny), walkableType)) continue;

            if (dist[ny][nx] < best) {
                best = dist[ny][nx];
                bestDir = dir;
            }
        }

        return bestDir;
    }

    private static boolean inBounds(int x, int y, int w, int h)
    {
        return x >= 0 && y >= 0 && x < w && y < h;
    }

    private static boolean canMove(int direction, int mobType)
    {
        switch (mobType)
        {
            case 1: return direction == 1 || direction == 3 || direction == 5 || direction == 7;
            case 2: return direction == 2 || direction == 4 || direction == 6 || direction == 8;
            case 3: return direction >= 1 && direction <= 8;
            default: return false;
        }
    }
}
