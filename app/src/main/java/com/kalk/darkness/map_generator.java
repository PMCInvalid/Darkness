package com.kalk.darkness;

import static java.lang.Math.abs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class map_generator extends AppCompatActivity
{
    static Random rand = new Random();


    static public int[][] map = new int[32][32];

    static public int playerX = -1;
    static public int playerY = -1;

    static public int peshkaX = -1;
    static public int peshkaY = -1;

    static public int slonX = -1;
    static public int slonY = -1;

    static public int sKorolX = -1;
    static public int sKorolY = -1;

    static public int bratX = -1;
    static public int bratY = -1;

    static public int krotX = -1;
    static public int krotY = -1;

    static public int medvedX = -1;
    static public int medvedY = -1;

    static public int extrX = -1;
    static public int extrY = -1;

    static public int leverX = -1;
    static public int leverY = -1;

    public static void main(String args[])
    {
        /*emptySetter();
        wallGen();
        mobGen();
        extrGen();
        testDraw(map);*/
    }

    public static int[][] mapThrower()
    {
        emptySetter();
        wallGen();
        mobGen();
        extrGen();

        return map;
    }

    public static int[] playerCorThrower()
    {
        int[] a = new int[2];

        a[0] = playerY;
        a[1] = playerX;

        return a;
    }

    public static void emptySetter()
    {
        for (int i = 0; i < 32; i++)
        {
            map[0][i] = 11;
            map[1][i] = 11;
            map[31][i] = 11;
            map[30][i] = 11;
            map[i][0] = 11;
            map[i][1] = 11;
            map[i][31] = 11;
            map[i][30] = 11;
        }

        for(int i = 2; i < 30; i++)
        {
            for(int j = 2; j < 30; j++)
            {
                map[i][j] = 0;
            }
        }
    }

    public static void wallGen()
    {
        for (int i = 0; i <= 25;)
        {
            int xCor = (rand.nextInt(27) + 2);
            int yCor = (rand.nextInt(27) + 2);
            int a = rand.nextInt(11);

            if (a == 1 && yCor + 2 < 32 && xCor + 2 < 32)
            {
                map[yCor][xCor] = 11;
                map[yCor + 1][xCor] = 11;
                map[yCor][xCor + 1] = 11;
                map[yCor + 1][xCor + 1] = 11;

                i++;
            }

            if (a == 2 && yCor + 3 < 32 && xCor + 3 < 32)
            {
                map[yCor][xCor] = 11;
                map[yCor + 1][xCor] = 11;
                map[yCor][xCor + 1] = 11;
                map[yCor + 1][xCor + 1] = 11;
                map[yCor + 2][xCor] = 11;
                map[yCor][xCor + 2] = 11;
                map[yCor + 1][xCor + 2] = 11;
                map[yCor + 2][xCor + 1] = 11;
                map[yCor + 2][xCor + 2] = 11;

                i++;
            }

            if (a == 3 && yCor + 4 < 32 && xCor + 3 < 32)
            {
                map[yCor][xCor] = 11;
                map[yCor + 1][xCor] = 11;
                map[yCor + 2][xCor] = 11;
                map[yCor + 3][xCor] = 11;
                map[yCor + 4][xCor] = 11;
                map[yCor + 2][xCor + 1] = 11;
                map[yCor + 3][xCor + 1] = 11;
                map[yCor + 3][xCor + 2] = 11;

                i++;
            }

            if (a == 4 && yCor + 3 < 32 && xCor + 3 < 32)
            {
                map[yCor][xCor] = 11;
                map[yCor + 2][xCor] = 11;
                map[yCor + 3][xCor] = 11;
                map[yCor][xCor + 1] = 11;
                map[yCor + 2][xCor + 1] = 11;
                map[yCor + 3][xCor + 1] = 11;
                map[yCor][xCor + 2] = 11;
                map[yCor + 2][xCor + 2] = 11;
                map[yCor + 3][xCor + 2] = 11;

                i++;
            }

            if (a == 5 && yCor + 1 < 32 && xCor + 2 < 32)
            {
                map[yCor][xCor + 1] = 11;

                map[yCor + 1][xCor] = 11;
                map[yCor + 1][xCor + 1] = 11;
                map[yCor + 1][xCor + 2] = 11;
                i++;
            }

            if (a == 6 && yCor + 4 < 32 && xCor + 4 < 32)
            {
                map[yCor][xCor] = 11;
                map[yCor][xCor + 1] = 11;
                map[yCor][xCor + 3] = 11;
                map[yCor][xCor + 4] = 11;

                map[yCor + 1][xCor] = 11;
                map[yCor + 1][xCor + 4] = 11;

                map[yCor + 3][xCor] = 11;
                map[yCor + 3][xCor + 4] = 11;

                map[yCor  + 4][xCor] = 11;
                map[yCor  + 4][xCor + 1] = 11;
                map[yCor  + 4][xCor + 3] = 11;
                map[yCor  + 4][xCor + 4] = 11;
                i++;
            }

            if (a == 7 && yCor + 4 < 32 && xCor + 4 < 32)
            {
                map[yCor][xCor + 2] = 11;

                map[yCor + 1][xCor + 1] = 11;
                map[yCor + 1][xCor + 2] = 11;
                map[yCor + 1][xCor + 3] = 11;

                map[yCor + 2][xCor] = 11;
                map[yCor + 2][xCor + 1] = 11;
                map[yCor + 2][xCor + 2] = 11;
                map[yCor + 2][xCor + 3] = 11;
                map[yCor + 2][xCor + 4] = 11;

                map[yCor + 3][xCor + 1] = 11;
                map[yCor + 3][xCor + 2] = 11;
                map[yCor + 3][xCor + 3] = 11;
                map[yCor + 4][xCor + 2] = 11;

                i++;
            }

            if (a == 8&& yCor + 4 < 32)
            {
                map[yCor][xCor] = 11;
                map[yCor + 1][xCor] = 11;
                map[yCor + 2][xCor] = 11;
                map[yCor + 3][xCor] = 11;
                map[yCor + 4][xCor] = 11;

                i++;
            }

            if (a == 9 && xCor + 4 < 32)
            {
                map[yCor][xCor] = 11;
                map[yCor][xCor + 1] = 11;
                map[yCor][xCor + 2] = 11;
                map[yCor][xCor + 3] = 11;
                map[yCor][xCor + 4] = 11;

                i++;
            }

            if (a == 10 && yCor + 7 < 32 && xCor + 7 < 32)
            {
                i++;

                map[yCor][xCor] = 11;
                map[yCor][xCor + 1] = 11;
                map[yCor][xCor + 2] = 11;
                map[yCor][xCor + 3] = 11;
                map[yCor][xCor + 6] = 11;
                map[yCor][xCor + 7] = 11;

                map[yCor + 1][xCor + 2] = 11;
                map[yCor + 1][xCor + 3] = 11;
                map[yCor + 1][xCor + 4] = 11;
                map[yCor + 1][xCor + 5] = 11;
                map[yCor + 1][xCor + 7] = 11;

                map[yCor + 2][xCor] = 11;
                map[yCor + 2][xCor + 1] = 11;
                map[yCor + 2][xCor + 2] = 11;
                map[yCor + 2][xCor + 3] = 11;
                map[yCor + 2][xCor + 4] = 11;
                map[yCor + 2][xCor + 5] = 11;

                map[yCor + 3][xCor] = 11;
                map[yCor + 3][xCor + 3] = 11;
                map[yCor + 3][xCor + 4] = 11;
                map[yCor + 3][xCor + 5] = 11;
                map[yCor + 3][xCor + 6] = 11;
                map[yCor + 3][xCor + 7] = 11;
            }
        }
    }

    public static int check(int a, int b)
    {
        int result = 1;

        if (map[a - 1][b - 1] > 10 && map[a - 1][b - 1] < 20 &&
            map[a - 1][b] > 10 && map[a - 1][b] < 20 &&
            map[a - 1][b + 1] > 10 && map[a - 1][b + 1] < 20 &&
            map[a][b - 1] > 10 && map[a][b - 1] < 20 &&
            map[a][b + 1] > 10 && map[a][b + 1] < 20 &&
            map[a + 1][b - 1] > 10 && map[a + 1][b - 1] < 20 &&
            map[a + 1][b] > 10 && map[a + 1][b] < 20 &&
            map[a + 1][b + 1] > 10 && map[a + 1][b + 1] < 20)
        {
            result = 0;
        }

        return result;
    }

    public static void mobGen()
    {
        int helper = 1;

        while (helper == 1)
        {
            int a = (rand.nextInt(27) + 2);
            int b = (rand.nextInt(27) + 2);

            int solution = check(a, b);

            if (solution == 1)
            {
                playerX = a;
                playerY = b;

                map[playerY][playerX] = 21;

                helper = 0;
            }
        }
        helper = 1;

        /*while (helper == 1)
        {
            int a = (rand.nextInt(28) + 2);
            int b = (rand.nextInt(28) + 2);

            int solution = check(a, b);

            if (solution == 1)
            {
                peshkaX = a;
                peshkaY = b;

                map[peshkaY][peshkaY] = 22;

                helper = 0;
            }
        }
        helper = 1;

        while (helper == 1)
        {
            int a = (rand.nextInt(28) + 2);
            int b = (rand.nextInt(28) + 2);

            int solution = check(a, b);

            if (solution == 1)
            {
                slonX = a;
                slonY = b;

                map[slonY][slonY] = 23;

                helper = 0;
            }
        }
        helper = 1;

        while (helper == 1)
        {
            int a = (rand.nextInt(28) + 2);
            int b = (rand.nextInt(28) + 2);

            int solution = check(a, b);

            if (solution == 1)
            {
                sKorolX = a;
                sKorolY = b;

                map[sKorolY][sKorolX] = 24;

                helper = 0;
            }
        }
        helper = 1;

        while (helper == 1)
        {
            int a = (rand.nextInt(28) + 2);
            int b = (rand.nextInt(28) + 2);

            int solution = check(a, b);

            if (solution == 1)
            {
                bratX = a;
                bratY = b;

                map[bratY][bratX] = 25;

                helper = 0;
            }
        }
        helper = 1;

        while (helper == 1)
        {
            int a = (rand.nextInt(28) + 2);
            int b = (rand.nextInt(28) + 2);

            int solution = check(a, b);

            if (solution == 1)
            {
                krotX = a;
                krotY = b;

                map[krotY][krotX] = 26;

                helper = 0;
            }
        }
        helper = 1;

        while (helper == 1)
        {
            int a = (rand.nextInt(28) + 2);
            int b = (rand.nextInt(28) + 2);

            int solution = check(a, b);

            if (solution == 1)
            {
                medvedX = a;
                medvedY = b;

                map[medvedY][medvedX] = 27;

                helper = 0;
            }
        }
        helper = 1;*/
    }

    public static void extrGen()
    {
        int helper = 1;

        while (helper == 1)
        {
            int a = (rand.nextInt(27) + 2);
            int b = (rand.nextInt(27) + 2);

            int solution = check(a, b);

            if (solution == 1)
            {
                extrY = a;
                extrX = b;

                map[extrY][extrY] = 31;

                helper = 0;
            }
        }
        helper = 1;

        while (helper == 1)
        {
            int a = (rand.nextInt(28) + 2);
            int b = (rand.nextInt(28) + 2);

            int solution = check(a, b);
            int solution2 = 1;

            if (abs(extrY - a) < 10 || abs(extrX - b) < 10)
            {
                solution2 = 0;
            }

            if (solution == 1 && solution2 == 1)
            {
                leverY = a;
                leverX = b;

                map[leverY][leverX] = 32;

                helper = 0;
            }

            solution2 = 1;
        }
        helper = 1;
    }

    public static void testDraw(int[][] a)
    {
        for(int i = 0; i < 32; i++)
        {
            for (int j = 0; j < 32; j++)
            {
                if (a[i][j] == 0)
                {
                    System.out.print(a[i][j] + "0");
                }

                else
                {
                    System.out.print(a[i][j]);
                }
            }
            System.out.println();
        }
    }
}