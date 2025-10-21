package com.kalk.darkness;

import static java.lang.Math.abs;

import androidx.annotation.NonNull;

public class GameVec
{
    int cord[] = new int [2];

    public GameVec()
    {
        cord[0] = -1;
        cord[1] = -1;
    }

    public GameVec(int x, int y)
    {
        this.cord[0] = x;
        this.cord[1] = y;
    }

    public void setX(int x)
    {
        cord[0] = x;
    }

    public void setY(int y)
    {
        cord[1] = y;
    }

    public int getX()
    {
        return cord[0];
    }

    public int getY()
    {
        return cord[1];
    }

    public GameVec mul(int v)
    {
        return new GameVec(getX()*v, getY()*v);
    }

    public GameVec sum(int v)
    {
        return new GameVec(getX()+v, getY()+v);
    }

    public static GameVec sum(GameVec a, GameVec b)
    {
        return new GameVec((a.getX() + b.getX()), (a.getY() + b.getY()));
    }

    public static int distance(GameVec a, GameVec b)
    {
        return Math.min(abs(a.getX() - b.getX()), abs(a.getY() - b.getY()));
    }

    public static boolean equals(GameVec a, GameVec b)
    {
        return (a.getX() == b.getX()) && (a.getY() == b.getY());
    }

    public static boolean equals(GameVec a, int x, int y)
    {
        return (a.getX() == x) && (a.getY() == y);
    }

    public static boolean equals(int aX, int aY, int bX, int bY)
    {
        return (aX == bX) && (aY == bY);
    }

    public GameVec offSet(GameVec position, Direction dir, int steps)
    {
        return sum(position, Direction.DirToGV(dir).mul(steps));
    }
}
