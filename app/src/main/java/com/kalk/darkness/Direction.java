package com.kalk.darkness;

public enum Direction
{
    UP(0, -1),
    UPRIGHT(1, -1),
    RIGHT(1, 0),
    DOWNRIGHT(1, 1),
    DOWN(0, 1),
    DOWNLEFT(-1, 1),
    LEFT(-1, 0),
    UPLEFT(-1, -1);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy)
    {
        this.dx = dx;
        this.dy = dy;
    }

    public int dx() { return dx; }
    public int dy() { return dy; }

    public static GameVec DirToGV(Direction dir)
    {
        return new GameVec(dir.dx(), dir.dy());
    }

    public static Direction fromInt(int i)
    {
        switch (i) {
            case 1: return UP;
            case 2: return UPRIGHT;
            case 3: return RIGHT;
            case 4: return DOWNRIGHT;
            case 5: return DOWN;
            case 6: return DOWNLEFT;
            case 7: return LEFT;
            case 8: return UPLEFT;
            default: throw new IllegalArgumentException("Invalid direction: " + i);
        }
    }
}