package com.kalk.darkness;

public class Direction
{
    GameVec d;
    String name;

    public Direction(String name, int x, int y)
    {
        this.d = new GameVec(x, y);
        this.name = name;
    }

    public static Direction up = new Direction("up", 0, -1);
    public static Direction left = new Direction("left", -1, 0);
    public static Direction down = new Direction("down", 0, 1);
    public static Direction right = new Direction("right", 1, 0);

    public static Direction upleft = new Direction("upleft", -1, -1);
    public static Direction downleft = new Direction("downleft", -1, 1);
    public static Direction upright = new Direction("upright", 1, -1);
    public static Direction downright = new Direction("downright", 1, 1);
}