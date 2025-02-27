package com.kalk.darkness;

import static java.lang.Math.*;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class map_generator extends mob
{
    static Random rand = new Random();


    static public String[][] map = new String[32][32];

    static mob player = new mob();
    static mob extr = new mob();
    static mob lever = new mob();
    static mob peshka = new mob();
    static mob slon = new mob();
    static mob sKorol = new mob();
    static mob medved = new mob();
    static mob bolshoj = new mob();

    public static String[][] mapThrower(double points, String hard)
    {
        emptySetter();
        wallGen();
        mobGen(points, hard);
        extrGen();

        return map;
    }

    public static void emptySetter()
    {
        for (int i = 0; i < 32; i++)
        {
            map[0][i] = "wall_tile";
            map[1][i] = "wall_tile";
            map[31][i] = "wall_tile";
            map[30][i] = "wall_tile";
            map[i][0] = "wall_tile";
            map[i][1] = "wall_tile";
            map[i][31] = "wall_tile";
            map[i][30] = "wall_tile";
        }

        for(int i = 2; i < 30; i++)
        {
            for(int j = 2; j < 30; j++)
            {
                map[i][j] = "empty_tile";
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
                map[yCor][xCor] = "wall_tile";
                map[yCor + 1][xCor] = "wall_tile";
                map[yCor][xCor + 1] = "wall_tile";
                map[yCor + 1][xCor + 1] = "wall_tile";

                i++;
            }

            if (a == 2 && yCor + 3 < 32 && xCor + 3 < 32)
            {
                map[yCor][xCor] = "wall_tile";
                map[yCor + 1][xCor] = "wall_tile";
                map[yCor][xCor + 1] = "wall_tile";
                map[yCor + 1][xCor + 1] = "wall_tile";
                map[yCor + 2][xCor] = "wall_tile";
                map[yCor][xCor + 2] = "wall_tile";
                map[yCor + 1][xCor + 2] = "wall_tile";
                map[yCor + 2][xCor + 1] = "wall_tile";
                map[yCor + 2][xCor + 2] = "wall_tile";

                i++;
            }

            if (a == 3 && yCor + 4 < 32 && xCor + 3 < 32)
            {
                map[yCor][xCor] = "wall_tile";
                map[yCor + 1][xCor] = "wall_tile";
                map[yCor + 2][xCor] = "wall_tile";
                map[yCor + 3][xCor] = "wall_tile";
                map[yCor + 4][xCor] = "wall_tile";
                map[yCor + 2][xCor + 1] = "wall_tile";
                map[yCor + 3][xCor + 1] = "wall_tile";
                map[yCor + 3][xCor + 2] = "wall_tile";

                i++;
            }

            if (a == 4 && yCor + 3 < 32 && xCor + 3 < 32)
            {
                map[yCor][xCor] = "wall_tile";
                map[yCor + 2][xCor] = "wall_tile";
                map[yCor + 3][xCor] = "wall_tile";
                map[yCor][xCor + 1] = "wall_tile";
                map[yCor + 2][xCor + 1] = "wall_tile";
                map[yCor + 3][xCor + 1] = "wall_tile";
                map[yCor][xCor + 2] = "wall_tile";
                map[yCor + 2][xCor + 2] = "wall_tile";
                map[yCor + 3][xCor + 2] = "wall_tile";

                i++;
            }

            if (a == 5 && yCor + 1 < 32 && xCor + 2 < 32)
            {
                map[yCor][xCor + 1] = "wall_tile";

                map[yCor + 1][xCor] = "wall_tile";
                map[yCor + 1][xCor + 1] = "wall_tile";
                map[yCor + 1][xCor + 2] = "wall_tile";
                i++;
            }

            if (a == 6 && yCor + 4 < 32 && xCor + 4 < 32)
            {
                map[yCor][xCor] = "wall_tile";
                map[yCor][xCor + 1] = "wall_tile";
                map[yCor][xCor + 3] = "wall_tile";
                map[yCor][xCor + 4] = "wall_tile";

                map[yCor + 1][xCor] = "wall_tile";
                map[yCor + 1][xCor + 4] = "wall_tile";

                map[yCor + 3][xCor] = "wall_tile";
                map[yCor + 3][xCor + 4] = "wall_tile";

                map[yCor  + 4][xCor] = "wall_tile";
                map[yCor  + 4][xCor + 1] = "wall_tile";
                map[yCor  + 4][xCor + 3] = "wall_tile";
                map[yCor  + 4][xCor + 4] = "wall_tile";
                i++;
            }

            if (a == 7 && yCor + 4 < 32 && xCor + 4 < 32)
            {
                map[yCor][xCor + 2] = "wall_tile";

                map[yCor + 1][xCor + 1] = "wall_tile";
                map[yCor + 1][xCor + 2] = "wall_tile";
                map[yCor + 1][xCor + 3] = "wall_tile";

                map[yCor + 2][xCor] = "wall_tile";
                map[yCor + 2][xCor + 1] = "wall_tile";
                map[yCor + 2][xCor + 2] = "wall_tile";
                map[yCor + 2][xCor + 3] = "wall_tile";
                map[yCor + 2][xCor + 4] = "wall_tile";

                map[yCor + 3][xCor + 1] = "wall_tile";
                map[yCor + 3][xCor + 2] = "wall_tile";
                map[yCor + 3][xCor + 3] = "wall_tile";
                map[yCor + 4][xCor + 2] = "wall_tile";

                i++;
            }

            if (a == 8&& yCor + 4 < 32)
            {
                map[yCor][xCor] = "wall_tile";
                map[yCor + 1][xCor] = "wall_tile";
                map[yCor + 2][xCor] = "wall_tile";
                map[yCor + 3][xCor] = "wall_tile";
                map[yCor + 4][xCor] = "wall_tile";

                i++;
            }

            if (a == 9 && xCor + 4 < 32)
            {
                map[yCor][xCor] = "wall_tile";
                map[yCor][xCor + 1] = "wall_tile";
                map[yCor][xCor + 2] = "wall_tile";
                map[yCor][xCor + 3] = "wall_tile";
                map[yCor][xCor + 4] = "wall_tile";

                i++;
            }

            if (a == 10 && yCor + 7 < 32 && xCor + 7 < 32)
            {
                i++;

                map[yCor][xCor] = "wall_tile";
                map[yCor][xCor + 1] = "wall_tile";
                map[yCor][xCor + 2] = "wall_tile";
                map[yCor][xCor + 3] = "wall_tile";
                map[yCor][xCor + 6] = "wall_tile";
                map[yCor][xCor + 7] = "wall_tile";

                map[yCor + 1][xCor + 2] = "wall_tile";
                map[yCor + 1][xCor + 3] = "wall_tile";
                map[yCor + 1][xCor + 4] = "wall_tile";
                map[yCor + 1][xCor + 5] = "wall_tile";
                map[yCor + 1][xCor + 7] = "wall_tile";

                map[yCor + 2][xCor] = "wall_tile";
                map[yCor + 2][xCor + 1] = "wall_tile";
                map[yCor + 2][xCor + 2] = "wall_tile";
                map[yCor + 2][xCor + 3] = "wall_tile";
                map[yCor + 2][xCor + 4] = "wall_tile";
                map[yCor + 2][xCor + 5] = "wall_tile";

                map[yCor + 3][xCor] = "wall_tile";
                map[yCor + 3][xCor + 3] = "wall_tile";
                map[yCor + 3][xCor + 4] = "wall_tile";
                map[yCor + 3][xCor + 5] = "wall_tile";
                map[yCor + 3][xCor + 6] = "wall_tile";
                map[yCor + 3][xCor + 7] = "wall_tile";
            }
        }
    }

    public static int check(int a, int b)
    {
        int result = 1;

        if (map[a - 1][b - 1].equals("wall_tile") && map[a - 1][b - 1].equals("wall_tile") &&
            map[a - 1][b].equals("wall_tile") && map[a - 1][b].equals("wall_tile") &&
            map[a - 1][b + 1].equals("wall_tile") && map[a - 1][b + 1].equals("wall_tile") &&
            map[a][b - 1].equals("wall_tile") && map[a][b - 1].equals("wall_tile") &&
            map[a][b + 1].equals("wall_tile") && map[a][b + 1].equals("wall_tile") &&
            map[a + 1][b - 1].equals("wall_tile") && map[a + 1][b - 1].equals("wall_tile") &&
            map[a + 1][b].equals("wall_tile") && map[a + 1][b].equals("wall_tile") &&
            map[a + 1][b + 1].equals("wall_tile") && map[a + 1][b + 1].equals("wall_tile"))
        {
            result = 0;
        }

        return result;
    }

    public static void mobGen(double points, String level)
    {
        int helper = 1;

        if (level.equals("easy"))
        {
            while (helper == 1) // Player
            {
                int a = (rand.nextInt(27) + 2);
                int b = (rand.nextInt(27) + 2);

                int solution = check(a, b);

                if (solution == 1) {
                    player.corX = a;
                    player.corY = b;

                    map[player.corY][player.corX] = "player_tile";

                    player.isHere = true;

                    helper = 0;
                }
            }
            helper = 1;

            if (points >= 1) // Peshka
            {
                while (helper == 1) {
                    int a = (rand.nextInt(28) + 2);
                    int b = (rand.nextInt(28) + 2);

                    int solution = check(a, b);

                    if (solution == 1) {
                        peshka.corY = a;
                        peshka.corX = b;

                        map[peshka.corY][peshka.corX] = "peshka_tile";

                        peshka.isHere = true;

                        helper = 0;
                    }
                }
                helper = 1;
            }

            if (points >= 2) // Slon
            {
                while (helper == 1) {
                    int a = (rand.nextInt(28) + 2);
                    int b = (rand.nextInt(28) + 2);

                    int solution = check(a, b);

                    if (solution == 1) {
                        slon.corY = a;
                        slon.corX = b;

                        map[slon.corY][slon.corX] = "slon_tile";

                        slon.isHere = true;

                        helper = 0;
                    }
                }
                helper = 1;
            }

            if (points >= 3) // Skorol
            {
                while (helper == 1) {
                    int a = (rand.nextInt(28) + 2);
                    int b = (rand.nextInt(28) + 2);

                    int solution = check(a, b);

                    if (solution == 1) {
                        sKorol.corY = a;
                        sKorol.corX = b;

                        map[sKorol.corY][sKorol.corX] = "sking_tile";

                        sKorol.isHere = true;

                        helper = 0;
                    }
                }
                helper = 1;
            }

            if (points >= 4) // Medved
            {
                while (helper == 1) {
                    int a = (rand.nextInt(28) + 2);
                    int b = (rand.nextInt(28) + 2);

                    int solution = check(a, b);

                    if (solution == 1) {
                        medved.corY = a;
                        medved.corX = b;

                        map[medved.corY][medved.corX] = "medved_tile";

                        medved.isHere = true;

                        helper = 0;
                    }
                }
                helper = 1;
            }
            if (points >= 7)
            {
                while (helper == 1) // Bolshoj brat
                {
                    int a = (rand.nextInt(28) + 2);
                    int b = (rand.nextInt(28) + 2);

                    int solution = check(a, b);

                    if (solution == 1)
                    {
                        bolshoj.corY = a;
                        bolshoj.corX = b;

                        map[bolshoj.corY][bolshoj.corX] = "bolshoj_b_tile";

                        bolshoj.isHere = true;

                        helper = 0;
                    }
                }
                helper = 1;
            }

        /*while (helper == 1)
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

        else
        {
            while (helper == 1) // Player
            {
                int a = (rand.nextInt(27) + 2);
                int b = (rand.nextInt(27) + 2);

                int solution = check(a, b);

                if (solution == 1) {
                    player.corX = a;
                    player.corY = b;

                    map[player.corY][player.corX] = "player_tile";

                    player.isHere = true;

                    helper = 0;
                }
            }
            helper = 1;

            while (helper == 1) // Peshka
            {
                int a = (rand.nextInt(28) + 2);
                int b = (rand.nextInt(28) + 2);

                int solution = check(a, b);

                if (solution == 1)
                {
                    peshka.corY = a;
                    peshka.corX = b;

                    map[peshka.corY][peshka.corX] = "peshka_tile";

                    peshka.isHere = true;

                    helper = 0;
                }
            }
            helper = 1;

            while (helper == 1) // Slon
            {
                int a = (rand.nextInt(28) + 2);
                int b = (rand.nextInt(28) + 2);

                int solution = check(a, b);

                if (solution == 1)
                {
                    slon.corY = a;
                    slon.corX = b;

                    map[slon.corY][slon.corX] = "slon_tile";

                    slon.isHere = true;

                    helper = 0;
                }
            }
            helper = 1;


            while (helper == 1) // Korol
            {
                int a = (rand.nextInt(28) + 2);
                int b = (rand.nextInt(28) + 2);

                int solution = check(a, b);

                if (solution == 1)
                {
                    sKorol.corY = a;
                    sKorol.corX = b;

                    map[sKorol.corY][sKorol.corX] = "sking_tile";

                    sKorol.isHere = true;

                    helper = 0;
                }
            }
            helper = 1;

            while (helper == 1) //Medved
            {
                int a = (rand.nextInt(28) + 2);
                int b = (rand.nextInt(28) + 2);

                int solution = check(a, b);

                if (solution == 1) {
                    medved.corY = a;
                    medved.corX = b;

                    map[medved.corY][medved.corX] = "medved_tile";

                    medved.isHere = true;

                    helper = 0;
                }
            }
            helper = 1;

            while (helper == 1) // Bolshoj brat
            {
                int a = (rand.nextInt(28) + 2);
                int b = (rand.nextInt(28) + 2);

                int solution = check(a, b);

                if (solution == 1)
                {
                    bolshoj.corY = a;
                    bolshoj.corX = b;

                    map[bolshoj.corY][bolshoj.corX] = "bolshoj_b_tile";

                    bolshoj.isHere = true;

                    helper = 0;
                }
            }
            helper = 1;
        }
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
                extr.corY = a;
                extr.corX = b;

                map[extr.corY][extr.corX] = "extraction_tile";

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

            if (abs(extr.corY - a) < 10 || abs(extr.corX - b) < 10)
            {
                solution2 = 0;
            }

            if (solution == 1 && solution2 == 1)
            {
                lever.corY = a;
                lever.corX = b;

                map[lever.corY][lever.corX] = "lever_tile";

                helper = 0;
            }

            solution2 = 1;
        }
        helper = 1;

        while (helper == 1)
        {
            int a  = rand.nextInt(5);

            if (a == 1)
            {
                a = rand.nextInt(17) + 2;

                if (map[2][a].equals("empty_tile"))
                {
                    map[1][a] = "door_tile";
                    helper = 0;
                }
            }

            else if (a == 2)
            {
                a = rand.nextInt(17) + 2;

                if (map[a][2].equals("empty_tile"))
                {
                    map[a][1] = "door_tile";
                    helper = 0;
                }
            }

            else if (a == 3)
            {
                a = rand.nextInt(17) + 2;

                if (map[29][a].equals("empty_tile"))
                {
                    map[30][a] = "door_tile";
                    helper = 0;
                }
            }

            if (a == 4)
            {
                a = rand.nextInt(17) + 2;

                if (map[a][29].equals("empty_tile"))
                {
                    map[a][30] = "door_tile";
                    helper = 0;
                }
            }
        }
    }
}