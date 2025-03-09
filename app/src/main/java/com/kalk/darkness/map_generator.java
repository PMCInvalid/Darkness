package com.kalk.darkness;

import static java.lang.Math.*;

import androidx.annotation.NonNull;

import java.util.Random;

public class map_generator extends mob
{
    static Random rand = new Random();

    static public String[][] map = new String[32][32];

    static mob player = new mob();
    static mob extr = new mob();
    static mob lever = new mob();
    static mob door = new mob();
    static mob peshka = new mob();
    static mob slon = new mob();
    static mob sKorol = new mob();
    static mob medved = new mob();
    static mob bolshoj = new mob();
    static mob krot = new mob();
    static mob power = new mob();
    static mob gonchaja = new mob();
    static  int gonTer = 0;
    static int gonchajaBaseX = -1;
    static int gonchajaBaseY = -1;
    static mob[] portals;
    static mob[][] rivers = new mob[3][15];

    public static String[][] mapThrower(double points, String hard)
    {
        emptySetter();
        wallGen();
        objectsGen(points, hard);
        mobGen(points, hard);

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

    public static boolean check(int corYStart, int corXStart, int corYTarget, int corXTarget, int mobtype)
    {
        boolean result = false;

        computeFlowField(map, corYTarget, corXTarget, mobtype);

        int negr = getDirection(corYStart, corXStart);

        if (negr != 9)
            result = true;

        return result;
    }

    public boolean find(int y, int x, String target)
    {
        boolean sol = true;

        return sol;
    }

    public static void extractionGen()
    {
        int helper = 1;

        while (helper == 1) // Extraction
        {
            int a = (rand.nextInt(27) + 2);
            int b = (rand.nextInt(27) + 2);

            boolean solution = check(a, b, a + 1, b + 1, 3);

            if (solution)
            {
                extr.corY = a;
                extr.corX = b;

                map[extr.corY][extr.corX] = "extraction_tile";

                helper = 0;
            }
        }
    }

    public static void leverGen()
    {
        int a = (rand.nextInt(28) + 2);
        int b = (rand.nextInt(28) + 2);

        boolean solution = check(a, b, extr.corY, extr.corX, 3);

        if (solution)
        {
            lever.corY = a;
            lever.corX = b;

            map[lever.corY][lever.corX] = "lever_tile";
        }

        else
        {
            leverGen();
        }
    }

    public static void doorGen()
    {
        int a  = rand.nextInt(5);

        if (a == 1)
        {
            a = rand.nextInt(17) + 2;

            if (map[2][a].equals("empty_tile"))
            {
                door.corY = 1;
                door.corX = a;
                map[door.corY][door.corX] = "door_tile";
            }
        }

        else if (a == 2)
        {
            a = rand.nextInt(17) + 2;

            if (map[a][2].equals("empty_tile"))
            {
                door.corY = a;
                door.corX = 1;

                map[door.corY][door.corX] = "door_tile";
            }
        }

        else if (a == 3)
        {
            a = rand.nextInt(17) + 2;

            if (map[29][a].equals("empty_tile"))
            {
                door.corY = 30;
                door.corX = a;

                map[door.corY][door.corX] = "door_tile";
            }
        }

        if (a == 4)
        {
            a = rand.nextInt(17) + 2;

            if (map[a][29].equals("empty_tile"))
            {
                door.corY = a;
                door.corX = 30;

                map[door.corY][door.corX] = "door_tile";
            }
        }
    }

    public static void portalsGen(int amount)
    {
        int s = amount;

        while (s > 0)
        {
            int y = rand.nextInt(27) + 2;
            int x = rand.nextInt(27) + 2;

            boolean solution = check(y, x, y + 2, x + 2,  3);

            if (solution)
            {
                portals[s - 1].corY = y;
                portals[s - 1].corX = x;
                map[portals[s - 1].corY][portals[s - 1].corX] = "portal_tile";
                portals[s - 1].isHere = true;

                s--;
            }
        }
    }

    public static void powerGen()
    {
        int y = rand.nextInt(27) + 2;
        int x = rand.nextInt(27) + 2;

        boolean solution = check(y, x, y + 2, x + 2, 3);

        if (solution)
        {
            power.corY = y;
            power.corX = x;

            map[power.corY][power.corX] = "power_tile";
        }

        else
            powerGen();
    }

    public static void riverGen(int amount)
    {
        int corStartX = 0;
        int corStartY = 0;
        int leng = 0;

        for (int i = 0; i < amount; i++)
        {
            int helper = 1;
            while (helper == 1)
            {
                corStartY = rand.nextInt(28) + 2;
                corStartX = rand.nextInt(28) + 2;

                if (map[corStartY][corStartX].equals("wall_tile"))
                {
                    if (map[corStartY - 1][corStartX].equals("empty_tile"))
                    {
                        corStartY--;
                        helper--;
                        rivers[i][0].riverDir = 1;
                    }

                    else if (map[corStartY + 1][corStartX].equals("empty_tile"))
                    {
                        corStartY++;
                        helper--;
                        rivers[i][0].riverDir = 3;
                    }

                    else if (map[corStartY][corStartX - 1].equals("empty_tile"))
                    {
                        corStartX--;
                        helper--;
                        rivers[i][0].riverDir = 2;
                    }

                    else if (map[corStartY][corStartX + 1].equals("empty_tile"))
                    {
                        corStartX++;
                        helper--;
                        rivers[i][0].riverDir = 4;
                    }
                }
            }

            helper = 1;
            rivers[i][leng].corY = corStartY;
            rivers[i][leng].corX = corStartX;
            map[rivers[i][leng].corY][rivers[i][leng].corX] = "river_tile";

            while (helper == 1)
            {
                if (rivers[i][leng].riverDir == 1)
                {
                    if (map[rivers[i][leng].corY - 1][rivers[i][leng].corX].equals("empty_tile") && leng < 14 || map[rivers[i][leng].corY - 1][rivers[i][leng].corX].equals("gonchaja_territory_tile") && leng < 14)
                    {
                        rivers[i][leng + 1].corY = rivers[i][leng].corY - 1;
                        rivers[i][leng + 1].corX = rivers[i][leng].corX;
                        rivers[i][leng + 1].riverDir = rivers[i][leng].riverDir;
                        leng++;
                        map[rivers[i][leng].corY][rivers[i][leng].corX] = "river_tile";
                    }

                    else
                        break;
                }

                if (rivers[i][leng].riverDir == 2)
                {
                    if (map[rivers[i][leng].corY][rivers[i][leng].corX + 1].equals("empty_tile") && leng < 14 || map[rivers[i][leng].corY][rivers[i][leng].corX + 1].equals("gonchaja_territory_tile") && leng < 14)
                    {
                        rivers[i][leng + 1].corY = rivers[i][leng].corY;
                        rivers[i][leng + 1].corX = rivers[i][leng].corX + 1;
                        rivers[i][leng + 1].riverDir = rivers[i][leng].riverDir;
                        leng++;
                        map[rivers[i][leng].corY][rivers[i][leng].corX] = "river_tile";
                    }

                    else
                        break;
                }

                if (rivers[i][leng].riverDir == 3)
                {
                    if (map[rivers[i][leng].corY + 1][rivers[i][leng].corX].equals("empty_tile") && leng < 14 || map[rivers[i][leng].corY + 1][rivers[i][leng].corX].equals("gonchaja_territory_tile") && leng < 14)
                    {
                        rivers[i][leng + 1].corY = rivers[i][leng].corY + 1;
                        rivers[i][leng + 1].corX = rivers[i][leng].corX;
                        rivers[i][leng + 1].riverDir = rivers[i][leng].riverDir;
                        leng++;
                        map[rivers[i][leng].corY][rivers[i][leng].corX] = "river_tile";
                    }

                    else
                        break;
                }

                if (rivers[i][leng].riverDir == 4)
                {
                    if (map[rivers[i][leng].corY][rivers[i][leng].corX - 1].equals("empty_tile") && leng < 14 || map[rivers[i][leng].corY][rivers[i][leng].corX - 1].equals("gonchaja_territory_tile") && leng < 14)
                    {
                        rivers[i][leng + 1].corY = rivers[i][leng].corY;
                        rivers[i][leng + 1].corX = rivers[i][leng].corX - 1;
                        rivers[i][leng + 1].riverDir = rivers[i][leng].riverDir;
                        leng++;
                        map[rivers[i][leng].corY][rivers[i][leng].corX] = "river_tile";
                    }

                    else
                        break;
                }

                int chance = rand.nextInt(101);
                if (chance % 2 == 0)
                {
                    if (rivers[i][leng].riverDir == 1)
                        rivers[i][leng].riverDir++;

                    if (rivers[i][leng].riverDir == 4)
                        rivers[i][leng].riverDir--;

                    else
                    {
                        chance = rand.nextInt(2);

                        if (chance == 1)
                            rivers[i][leng].riverDir--;
                        else
                            rivers[i][leng].riverDir++;
                    }
                }
            }
        }
    }

    public static void objectsGen(double points, @NonNull String level)
    {
        Random rar = new Random();
        int s;

        extractionGen();

        leverGen();

        doorGen();

        s = rar.nextInt(5) + 2;
        portals = new mob[s];
        for (int i = 0; i < portals.length; i++)
        {
            portals[i] = new mob();
        }
        if (level.equals("easy"))
            if (points >= 3)
                portalsGen(s);

        else
            portalsGen(s);

        s = rar.nextInt(101);
        if (s % 5 == 0)
            powerGen();

        s = rar.nextInt(3) + 1;
        for (int i = 0; i < rivers.length; i++)
            for (int j = 0; j < 15; j++)
                rivers[i][j] = new mob();

        riverGen(s);
        System.out.println(s);
    }

    public static void playerSpawn()
    {
        int y = (rand.nextInt(27) + 2);
        int x = (rand.nextInt(27) + 2);

        boolean solution = check(y, x, extr.corY, extr.corY, 3);

        if (solution)
        {
            player.corX = x;
            player.corY = y;

            map[player.corY][player.corX] = "player_tile";

            player.isHere = true;
        }

        else
            playerSpawn();
    }

    public static void peshkaSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        boolean solution = check(y, x, player.corY, player.corX, 1);

        if (solution)
        {
            peshka.corY = y;
            peshka.corX = x;

            map[peshka.corY][peshka.corX] = "peshka_tile";

            peshka.isHere = true;
        }
        else
            peshkaSpawn();
    }

    public static void slonSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        boolean solution = check(y, x, player.corY, player.corX , 3);

        if (solution) {
            slon.corY = y;
            slon.corX = x;

            map[slon.corY][slon.corX] = "slon_tile";

            slon.isHere = true;
        }
        else
            slonSpawn();
    }

    public static void sKorolSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        boolean solution = check(y, x, player.corY, player.corX , 3);

        if (solution)
        {
            sKorol.corY = y;
            sKorol.corX = x;

            map[sKorol.corY][sKorol.corX] = "sking_tile";

            sKorol.isHere = true;
        }

        else
            sKorolSpawn();
    }

    public static void medvedSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        boolean solution = check(y, x, player.corY, player.corX , 3);

        if (solution) {
            medved.corY = y;
            medved.corX = x;

            map[medved.corY][medved.corX] = "medved_tile";

            medved.isHere = true;
        }
        else
            medvedSpawn();
    }

    public static void krotSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        krot.corY = y;
        krot.corX = x;

        map[krot.corY][krot.corX] = "krot_tile";

        krot.isHere = true;
    }

    public static void bolshojSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        boolean solution = check(y, x, player.corY, player.corX, 3);

        if (solution) {
            bolshoj.corY = y;
            bolshoj.corX = x;

            map[bolshoj.corY][bolshoj.corX] = "bolshoj_b_tile";

            bolshoj.isHere = true;
        }
        else
            bolshojSpawn();
    }

    public static void gonchajaSpawn()
    {
        gonTer = rand.nextInt(3) + 2;

        int y = rand.nextInt(25) + 4;
        int x = rand.nextInt(25) + 4;

        boolean solution = check(y, x, y + 2, x + 2, 3);

        if (solution)
        {
            gonchaja.corY = y;
            gonchaja.corX = x;

            for (int i = gonchaja.corY - gonTer; i <= gonchaja.corY + gonTer ;i++)
            {
                if (i >= map.length)
                    break;
                else
                {
                    for (int j = gonchaja.corX - gonTer; j <= gonchaja.corX + gonTer; j++)
                    {
                        if (j >= map.length)
                            break;
                        else
                        {
                            if (map[i][j] == "empty_tile")
                                map[i][j] = "gonchaja_territory_tile";
                        }
                    }
                }
            }

            map[gonchaja.corY][gonchaja.corX] = "gonchaja_tile";
            gonchajaBaseY = gonchaja.corY;
            gonchajaBaseX = gonchaja.corX;
            gonchaja.isHere = true;
            gonchaja.helper1 = "gonchaja_territory_tile";
            gonchaja.helper2 = "gonchaja_territory_tile";
        }

        else
            gonchajaSpawn();
    }

    public static void mobGen(double points, String level)
    {
        int helper = 1;
        int spawnChance = 0;
        spawnChance = rand.nextInt(101);

        mob[] mobs = {peshka, slon, sKorol, medved, bolshoj, krot};

        boolean isNearEnemy = false;
        for (mob m : mobs)
        {
            m.corX = -1;
            m.corY = -1;
            m.isHere = false;
        }

        playerSpawn();

        if (level.equals("easy"))
        {
            if (points >= 1)
                peshkaSpawn();

            if (points >= 1.5)
                slonSpawn();

            if (points >= 2.25)
                sKorolSpawn();

            if (points >= 3)
                medvedSpawn();

            if (points >= 3.5)
                if (spawnChance % 2 == 0)
                    krotSpawn();

            if (points >= 4)
                if (spawnChance % 2 == 0)
                    gonchajaSpawn();

            if (points >= 4.5)
                if (spawnChance % 3 == 0)
                    bolshojSpawn();
        }

        else
        {
            peshkaSpawn();

            slonSpawn();

            sKorolSpawn();

            medvedSpawn();

            if (spawnChance % 3 == 0)
                bolshojSpawn();

            if (spawnChance % 2 == 0)
                krotSpawn();

            if (spawnChance % 2 == 0)
                gonchajaSpawn();
        }
    }
}