package com.kalk.darkness;

import static com.kalk.darkness.Gameplay.game;

import com.kalk.darkness.entity.EntityDoor;
import com.kalk.darkness.entity.EntityExit;
import com.kalk.darkness.entity.EntityLever;
import com.kalk.darkness.entity.EntityPeshka;
import com.kalk.darkness.entity.EntityPlayer;
import com.kalk.darkness.entity.FactoryDoor;
import com.kalk.darkness.entity.FactoryExit;
import com.kalk.darkness.entity.FactoryLever;
import com.kalk.darkness.entity.FactoryPeshka;
import com.kalk.darkness.entity.FactoryPlayer;

import java.util.Random;

public class MapGenerator
{
    FactoryPlayer factoryPlayer = new FactoryPlayer();
    FactoryLever factoryLever = new FactoryLever();
    FactoryExit factoryExit = new FactoryExit();
    FactoryPeshka factoryPeshka = new FactoryPeshka();
    FactoryDoor factoryDoor = new FactoryDoor();

    protected String[][] gamemap;
    protected Gameplay gameplayActivity;

    public static Random rand = new Random();

    public MapGenerator(Game game, Gameplay _gameplayActivity)
    {
        this.gamemap = game.getMap();
        this.gameplayActivity = _gameplayActivity;
    }

    public static GameVec getRandomCords()
    {
        GameVec cords = new GameVec();

        cords.setX(rand.nextInt(28) + 2);
        cords.setY(rand.nextInt(28) + 2);

        return cords;
    }

    public String[][] mapThrower(double points, String hard, int event)
    {
        emptySetter();
        wallGen(event);

        return gamemap;
    }

    public void emptySetter()
    {
        for (int i = 0; i < 32; i++)
        {
            gamemap[0][i] = "wall_tile";
            gamemap[1][i] = "wall_tile";
            gamemap[31][i] = "wall_tile";
            gamemap[30][i] = "wall_tile";
            gamemap[i][0] = "wall_tile";
            gamemap[i][1] = "wall_tile";
            gamemap[i][31] = "wall_tile";
            gamemap[i][30] = "wall_tile";
        }

        for(int i = 2; i < 30; i++)
        {
            for(int j = 2; j < 30; j++)
            {
                gamemap[i][j] = "empty_tile";
            }
        }
    }

    public void wallGen(int event)
    {
        for (int i = 0; i <= 25;)
        {
            int xCor = (rand.nextInt(27) + 2);
            int yCor = (rand.nextInt(27) + 2);
            int a = rand.nextInt(11);

            if (a == 1 && yCor + 2 < 32 && xCor + 2 < 32)
            {
                gamemap[yCor][xCor] = "wall_tile";
                gamemap[yCor + 1][xCor] = "wall_tile";
                gamemap[yCor][xCor + 1] = "wall_tile";
                gamemap[yCor + 1][xCor + 1] = "wall_tile";

                i++;
            }

            if (a == 2 && yCor + 3 < 32 && xCor + 3 < 32)
            {
                gamemap[yCor][xCor] = "wall_tile";
                gamemap[yCor + 1][xCor] = "wall_tile";
                gamemap[yCor][xCor + 1] = "wall_tile";
                gamemap[yCor + 1][xCor + 1] = "wall_tile";
                gamemap[yCor + 2][xCor] = "wall_tile";
                gamemap[yCor][xCor + 2] = "wall_tile";
                gamemap[yCor + 1][xCor + 2] = "wall_tile";
                gamemap[yCor + 2][xCor + 1] = "wall_tile";
                gamemap[yCor + 2][xCor + 2] = "wall_tile";

                i++;
            }

            if (a == 3 && yCor + 4 < 32 && xCor + 3 < 32)
            {
                gamemap[yCor][xCor] = "wall_tile";
                gamemap[yCor + 1][xCor] = "wall_tile";
                gamemap[yCor + 2][xCor] = "wall_tile";
                gamemap[yCor + 3][xCor] = "wall_tile";
                gamemap[yCor + 4][xCor] = "wall_tile";
                gamemap[yCor + 2][xCor + 1] = "wall_tile";
                gamemap[yCor + 3][xCor + 1] = "wall_tile";
                gamemap[yCor + 3][xCor + 2] = "wall_tile";

                i++;
            }

            if (a == 4 && yCor + 3 < 32 && xCor + 3 < 32)
            {
                gamemap[yCor][xCor] = "wall_tile";
                gamemap[yCor + 2][xCor] = "wall_tile";
                gamemap[yCor + 3][xCor] = "wall_tile";
                gamemap[yCor][xCor + 1] = "wall_tile";
                gamemap[yCor + 2][xCor + 1] = "wall_tile";
                gamemap[yCor + 3][xCor + 1] = "wall_tile";
                gamemap[yCor][xCor + 2] = "wall_tile";
                gamemap[yCor + 2][xCor + 2] = "wall_tile";
                gamemap[yCor + 3][xCor + 2] = "wall_tile";

                i++;
            }

            if (a == 5 && yCor + 1 < 32 && xCor + 2 < 32)
            {
                gamemap[yCor][xCor + 1] = "wall_tile";

                gamemap[yCor + 1][xCor] = "wall_tile";
                gamemap[yCor + 1][xCor + 1] = "wall_tile";
                gamemap[yCor + 1][xCor + 2] = "wall_tile";
                i++;
            }

            if (a == 6 && yCor + 4 < 32 && xCor + 4 < 32)
            {
                gamemap[yCor][xCor] = "wall_tile";
                gamemap[yCor][xCor + 1] = "wall_tile";
                gamemap[yCor][xCor + 3] = "wall_tile";
                gamemap[yCor][xCor + 4] = "wall_tile";

                gamemap[yCor + 1][xCor] = "wall_tile";
                gamemap[yCor + 1][xCor + 4] = "wall_tile";

                gamemap[yCor + 3][xCor] = "wall_tile";
                gamemap[yCor + 3][xCor + 4] = "wall_tile";

                gamemap[yCor  + 4][xCor] = "wall_tile";
                gamemap[yCor  + 4][xCor + 1] = "wall_tile";
                gamemap[yCor  + 4][xCor + 3] = "wall_tile";
                gamemap[yCor  + 4][xCor + 4] = "wall_tile";
                i++;
            }

            if (a == 7 && yCor + 4 < 32 && xCor + 4 < 32)
            {
                gamemap[yCor][xCor + 2] = "wall_tile";

                gamemap[yCor + 1][xCor + 1] = "wall_tile";
                gamemap[yCor + 1][xCor + 2] = "wall_tile";
                gamemap[yCor + 1][xCor + 3] = "wall_tile";

                gamemap[yCor + 2][xCor] = "wall_tile";
                gamemap[yCor + 2][xCor + 1] = "wall_tile";
                gamemap[yCor + 2][xCor + 2] = "wall_tile";
                gamemap[yCor + 2][xCor + 3] = "wall_tile";
                gamemap[yCor + 2][xCor + 4] = "wall_tile";

                gamemap[yCor + 3][xCor + 1] = "wall_tile";
                gamemap[yCor + 3][xCor + 2] = "wall_tile";
                gamemap[yCor + 3][xCor + 3] = "wall_tile";
                gamemap[yCor + 4][xCor + 2] = "wall_tile";

                i++;
            }

            if (a == 8&& yCor + 4 < 32)
            {
                gamemap[yCor][xCor] = "wall_tile";
                gamemap[yCor + 1][xCor] = "wall_tile";
                gamemap[yCor + 2][xCor] = "wall_tile";
                gamemap[yCor + 3][xCor] = "wall_tile";
                gamemap[yCor + 4][xCor] = "wall_tile";

                i++;
            }

            if (a == 9 && xCor + 4 < 32)
            {
                gamemap[yCor][xCor] = "wall_tile";
                gamemap[yCor][xCor + 1] = "wall_tile";
                gamemap[yCor][xCor + 2] = "wall_tile";
                gamemap[yCor][xCor + 3] = "wall_tile";
                gamemap[yCor][xCor + 4] = "wall_tile";

                i++;
            }

            if (a == 10 && yCor + 7 < 32 && xCor + 7 < 32)
            {
                i++;

                gamemap[yCor][xCor] = "wall_tile";
                gamemap[yCor][xCor + 1] = "wall_tile";
                gamemap[yCor][xCor + 2] = "wall_tile";
                gamemap[yCor][xCor + 3] = "wall_tile";
                gamemap[yCor][xCor + 6] = "wall_tile";
                gamemap[yCor][xCor + 7] = "wall_tile";

                gamemap[yCor + 1][xCor + 2] = "wall_tile";
                gamemap[yCor + 1][xCor + 3] = "wall_tile";
                gamemap[yCor + 1][xCor + 4] = "wall_tile";
                gamemap[yCor + 1][xCor + 5] = "wall_tile";
                gamemap[yCor + 1][xCor + 7] = "wall_tile";

                gamemap[yCor + 2][xCor] = "wall_tile";
                gamemap[yCor + 2][xCor + 1] = "wall_tile";
                gamemap[yCor + 2][xCor + 2] = "wall_tile";
                gamemap[yCor + 2][xCor + 3] = "wall_tile";
                gamemap[yCor + 2][xCor + 4] = "wall_tile";
                gamemap[yCor + 2][xCor + 5] = "wall_tile";

                gamemap[yCor + 3][xCor] = "wall_tile";
                gamemap[yCor + 3][xCor + 3] = "wall_tile";
                gamemap[yCor + 3][xCor + 4] = "wall_tile";
                gamemap[yCor + 3][xCor + 5] = "wall_tile";
                gamemap[yCor + 3][xCor + 6] = "wall_tile";
                gamemap[yCor + 3][xCor + 7] = "wall_tile";
            }
        }

        if (event == 4)
        {
            for (int i = 0; i < 28; i++)
                for (int j = 0; j < 28; j++)
                    if (gamemap[i + 2][j + 2].equals("wall_tile"))
                        gamemap[i + 2][j + 2] = "empty_tile";
        }
    }

    public EntityExit extractionGen()
    {
        return factoryExit.spawn(game, gameplayActivity, gamemap);
    }

    public EntityLever leverGen()
    {
        return factoryLever.spawn(game, gameplayActivity, gamemap);
    }

    public EntityDoor doorGen()
    {
        return factoryDoor.spawn(game, gameplayActivity, gamemap);
    }

/*  public static void doorGen()
    {
        int a  = rand.nextInt(4) + 1;

        if (a == 1)
        {
            a = rand.nextInt(17) + 2;

            if (map[2][a].equals("empty_tile"))
            {
                game.door.corY = 1;
                game.door.corX = a;
                map[game.door.corY][game.door.corX] = "door_tile";
            }
        }

        else if (a == 2)
        {
            a = rand.nextInt(17) + 2;

            if (map[a][2].equals("empty_tile"))
            {
                game.door.corY = a;
                game.door.corX = 1;

                map[game.door.corY][game.door.corX] = "door_tile";
            }
        }

        else if (a == 3)
        {
            a = rand.nextInt(17) + 2;

            if (map[29][a].equals("empty_tile"))
            {
                game.door.corY = 30;
                game.door.corX = a;

                map[game.door.corY][game.door.corX] = "door_tile";
            }
        }

        if (a == 4)
        {
            a = rand.nextInt(17) + 2;

            if (map[a][29].equals("empty_tile"))
            {
                game.door.corY = a;
                game.door.corX = 30;

                map[game.door.corY][game.door.corX] = "door_tile";
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

            boolean solution = check(y, x, y + 2, x + 2);

            if (solution)
            {
                game.portals[s - 1].corY = y;
                game.portals[s - 1].corX = x;
                map[game.portals[s - 1].corY][game.portals[s - 1].corX] = "portal_tile";
                game.portals[s - 1].isHere = true;

                s--;
            }
        }
    }

    public static void powerGen()
    {
        int y = rand.nextInt(27) + 2;
        int x = rand.nextInt(27) + 2;

        boolean solution = check(y, x, game.extr.corY, game.extr.corX);

        if (solution)
        {
            game.power.corY = y;
            game.power.corX = x;

            map[game.power.corY][game.power.corX] = "power_tile";
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
                        game.rivers[i][0].riverDir = 1;
                    }

                    else if (map[corStartY + 1][corStartX].equals("empty_tile"))
                    {
                        corStartY++;
                        helper--;
                        game.rivers[i][0].riverDir = 3;
                    }

                    else if (map[corStartY][corStartX - 1].equals("empty_tile"))
                    {
                        corStartX--;
                        helper--;
                        game.rivers[i][0].riverDir = 2;
                    }

                    else if (map[corStartY][corStartX + 1].equals("empty_tile"))
                    {
                        corStartX++;
                        helper--;
                        game.rivers[i][0].riverDir = 4;
                    }
                }
            }

            helper = 1;
            game.rivers[i][leng].corY = corStartY;
            game.rivers[i][leng].corX = corStartX;
            map[game.rivers[i][leng].corY][game.rivers[i][leng].corX] = "river_tile";

            while (helper == 1)
            {
                if (game.rivers[i][leng].riverDir == 1)
                {
                    if (map[game.rivers[i][leng].corY - 1][game.rivers[i][leng].corX].equals("empty_tile") && leng < 14 || map[game.rivers[i][leng].corY - 1][game.rivers[i][leng].corX].equals("gonchaja_territory_tile") && leng < 14)
                    {
                        game.rivers[i][leng + 1].corY = game.rivers[i][leng].corY - 1;
                        game.rivers[i][leng + 1].corX = game.rivers[i][leng].corX;
                        game.rivers[i][leng + 1].riverDir = game.rivers[i][leng].riverDir;
                        leng++;
                        map[game.rivers[i][leng].corY][game.rivers[i][leng].corX] = "river_tile";
                    }

                    else
                        break;
                }

                if (game.rivers[i][leng].riverDir == 2)
                {
                    if (map[game.rivers[i][leng].corY][game.rivers[i][leng].corX + 1].equals("empty_tile") && leng < 14 || map[game.rivers[i][leng].corY][game.rivers[i][leng].corX + 1].equals("gonchaja_territory_tile") && leng < 14)
                    {
                        game.rivers[i][leng + 1].corY = game.rivers[i][leng].corY;
                        game.rivers[i][leng + 1].corX = game.rivers[i][leng].corX + 1;
                        game.rivers[i][leng + 1].riverDir = game.rivers[i][leng].riverDir;
                        leng++;
                        map[game.rivers[i][leng].corY][game.rivers[i][leng].corX] = "river_tile";
                    }

                    else
                        break;
                }

                if (game.rivers[i][leng].riverDir == 3)
                {
                    if (map[game.rivers[i][leng].corY + 1][game.rivers[i][leng].corX].equals("empty_tile") && leng < 14 || map[game.rivers[i][leng].corY + 1][game.rivers[i][leng].corX].equals("gonchaja_territory_tile") && leng < 14)
                    {
                        game.rivers[i][leng + 1].corY = game.rivers[i][leng].corY + 1;
                        game.rivers[i][leng + 1].corX = game.rivers[i][leng].corX;
                        game.rivers[i][leng + 1].riverDir = game.rivers[i][leng].riverDir;
                        leng++;
                        map[game.rivers[i][leng].corY][game.rivers[i][leng].corX] = "river_tile";
                    }

                    else
                        break;
                }

                if (game.rivers[i][leng].riverDir == 4)
                {
                    if (map[game.rivers[i][leng].corY][game.rivers[i][leng].corX - 1].equals("empty_tile") && leng < 14 || map[game.rivers[i][leng].corY][game.rivers[i][leng].corX - 1].equals("gonchaja_territory_tile") && leng < 14)
                    {
                        game.rivers[i][leng + 1].corY = game.rivers[i][leng].corY;
                        game.rivers[i][leng + 1].corX = game.rivers[i][leng].corX - 1;
                        game.rivers[i][leng + 1].riverDir = game.rivers[i][leng].riverDir;
                        leng++;
                        map[game.rivers[i][leng].corY][game.rivers[i][leng].corX] = "river_tile";
                    }

                    else
                        break;
                }

                int chance = rand.nextInt(101);
                if (chance % 2 == 0)
                {
                    if (game.rivers[i][leng].riverDir == 1)
                        game.rivers[i][leng].riverDir++;

                    if (game.rivers[i][leng].riverDir == 4)
                        game.rivers[i][leng].riverDir--;

                    else
                    {
                        chance = rand.nextInt(2);

                        if (chance == 1)
                            game.rivers[i][leng].riverDir--;
                        else
                            game.rivers[i][leng].riverDir++;
                    }
                }
            }
        }
    }

    public static void batteryGen()
    {
        int y = rand.nextInt(27) + 2;
        int x = rand.nextInt(27) + 2;

        boolean solution = check(y, x, game.extr.corY, game.extr.corX);

        if (solution)
        {
            game.battery.corY = y;
            game.battery.corX = x;

            map[game.battery.corY][game.battery.corX] = "battery_tile";
        }

        else
            batteryGen();
    }

    public static void bushesGen(int amount)
    {
        int x = -1;
        int y = -1;

        for (int i = 0; i < amount; i++)
        {
            int helper = 1;
            int counter = 1;
            int size = rand.nextInt(2);

            while (helper == 1)
            {
                x = rand.nextInt(27) + 2;
                y = rand.nextInt(27) + 2;

                if (map[y][x].equals("empty_tile"))
                    helper--;
            }

            game.bushes[i][0].corX = x;
            game.bushes[i][0].corY = y;

            for (int j = game.bushes[i][0].corY - size; j <= game.bushes[i][0].corY + size; j++)
            {
                for (int k = game.bushes[i][0].corX - size; k <= game.bushes[i][0].corX + size; k++)
                {
                    if (map[j][k].equals("empty_tile"))
                    {
                        game.bushes[i][counter].corY = j;
                        game.bushes[i][counter].corX = k;
                        map[j][k] = "bushes_tile";
                        counter++;
                    }

                }
            }

            for (int j = game.bushes[i][0].corY - size - 2; j <= game.bushes[i][0].corY + size + 2; j++)
            {
                for (int k = game.bushes[i][0].corX - size - 2; k <= game.bushes[i][0].corX + size + 2; k++)
                {
                    if (game.bushes[i][0].corY - size - 2 < 0) {
                        j++;
                        continue;
                    }
                    if (game.bushes[i][0].corY - size - 1 < 0) {
                        j++;
                        continue;
                    }

                    if (game.bushes[i][0].corY + size + 2 > 32) {
                        continue;
                    }
                    if (game.bushes[i][0].corY + size + 1 > 32) {
                        continue;
                    }

                    if (game.bushes[i][0].corX - size - 2 < 0) {
                        k++;
                        continue;
                    }
                    if (game.bushes[i][0].corX - size - 1 < 0) {
                        k++;
                        continue;
                    }

                    if (game.bushes[i][0].corX + size + 2 > 32) {
                        continue;
                    }
                    if (game.bushes[i][0].corX + size + 1 > 32) {
                        continue;
                    }

                    if (j == game.bushes[i][0].corY - size - 2)
                        if (rand.nextInt(101) % 2 == 0)
                        {
                            if (map[j][k].equals("empty_tile"))
                            {
                                game.bushes[i][counter].corY = j;
                                game.bushes[i][counter].corX = k;
                                map[j][k] = "bushes_tile";
                                counter++;
                            }
                        }

                    if (k == game.bushes[i][0].corX - size - 2)
                        if (rand.nextInt(101) % 2 == 0)
                        {
                            if (map[j][k].equals("empty_tile"))
                            {
                                game.bushes[i][counter].corY = j;
                                game.bushes[i][counter].corX = k;
                                map[j][k] = "bushes_tile";
                                counter++;
                            }
                        }

                    if (j == game.bushes[i][0].corY + size + 2)
                        if (rand.nextInt(101) % 2 == 0)
                        {
                            if (map[j][k].equals("empty_tile"))
                            {
                                game.bushes[i][counter].corY = j;
                                game.bushes[i][counter].corX = k;
                                map[j][k] = "bushes_tile";
                                counter++;
                            }
                        }

                    if (k == game.bushes[i][0].corX + size + 2)
                        if (rand.nextInt(101) % 2 == 0)
                        {
                            if (map[j][k].equals("empty_tile"))
                            {
                                game.bushes[i][counter].corY = j;
                                game.bushes[i][counter].corX = k;
                                map[j][k] = "bushes_tile";
                                counter++;
                            }
                        }

                    if (j == game.bushes[i][0].corY - size - 1)
                        if (rand.nextInt(101) % 3 != 0)
                        {
                            if (map[j][k].equals("empty_tile"))
                            {
                                game.bushes[i][counter].corY = j;
                                game.bushes[i][counter].corX = k;
                                map[j][k] = "bushes_tile";
                                counter++;
                            }
                        }

                    if (k == game.bushes[i][0].corX - size - 1)
                        if (rand.nextInt(101) % 3 != 0)
                        {
                            if (map[j][k].equals("empty_tile"))
                            {
                                game.bushes[i][counter].corY = j;
                                game.bushes[i][counter].corX = k;
                                map[j][k] = "bushes_tile";
                                counter++;
                            }
                        }

                    if (j == game.bushes[i][0].corY + size + 1)
                        if (rand.nextInt(101) % 3 != 0)
                        {
                            if (map[j][k].equals("empty_tile"))
                            {
                                game.bushes[i][counter].corY = j;
                                game.bushes[i][counter].corX = k;
                                map[j][k] = "bushes_tile";
                                counter++;
                            }
                        }

                    if (k == game.bushes[i][0].corX + size + 1)
                        if (rand.nextInt(101) % 3 != 0)
                        {
                            if (map[j][k].equals("empty_tile"))
                            {
                                game.bushes[i][counter].corY = j;
                                game.bushes[i][counter].corX = k;
                                map[j][k] = "bushes_tile";
                                counter++;
                            }
                        }
                }
            }
        }

    }

    public static void bushesEvent()
    {
        int counter = 0;
        for (int i = 0; i < 32; i++)
            for (int j = 0; j < 32; j++)
                if (map[i][j].equals("empty_tile"))
                {
                    map[i][j] = "bushes_tile";
                    game.bushes[3][counter].corY = i;
                    game.bushes[3][counter].corX = j;
                    counter++;
                }
    }

    public static void objectsGen(double points, @NonNull String level, int event)
    {
        Random rar = new Random();
        int s;

        extractionGen();

        leverGen();

        doorGen();

        s = rar.nextInt(5) + 2;
        game.portals = new EntityPortals[s];
        for (int i = 0; i < game.portals.length; i++)
        {
            game.portals[i] = new EntityPortals(game, "portal_tile");
        }
        if (level.equals(Constants.difficulty_easy))
            if (points >= 3)
                portalsGen(s);

        else
            portalsGen(s);

        s = rar.nextInt(101);
        if (s % 5 == 0)
            powerGen();

        s = rar.nextInt(3) + 1;
        for (int i = 0; i < game.rivers.length; i++)
            for (int j = 0; j < 15; j++)
                game.rivers[i][j] = new EntityRivers(game);

        if (event != 4)
            riverGen(s);

        s = rar.nextInt(3) + 1;
        for (int i = 0; i < game.bushes.length; i++)
            for (int j = 0; j < game.bushes[0].length; j++)
                game.bushes[i][j] = new EntityBushes(game);

        bushesGen(s);

        batteryGen();

        if (event == 3)
            bushesEvent();
    }*/

    public EntityPlayer playerSpawn()
    {
        return factoryPlayer.spawn(game, gameplayActivity, gamemap);
    }

    public EntityPeshka peshkaSpawn()
    {
        return factoryPeshka.spawn(game, gameplayActivity, gamemap);
    }

    /*public static void peshkaBSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        boolean solution = check(y, x, game.player.corY, game.player.corX);

        if (abs(y - game.player.corY) < 3 && abs(x - game.player.corX) < 3)
            solution = false;

        if (solution)
        {
            game.peshkaB.corY = y;
            game.peshkaB.corX = x;

            game.peshkaB.helper2 = map[game.peshkaB.corY][game.peshkaB.corX];

            map[game.peshkaB.corY][game.peshkaB.corX] = "peshka_tile";

            game.peshkaB.isHere = true;
        }
        else
            peshkaBSpawn();
    }

    public static void slonSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        boolean solution = check(y, x, game.player.corY, game.player.corX);

        if (abs(y - game.player.corY) < 3 && abs(x - game.player.corX) < 3)
            solution = false;

        if (solution)
        {
            game.slon.corY = y;
            game.slon.corX = x;

            game.slon.helper2 = map[game.slon.corY][game.slon.corX];

            map[game.slon.corY][game.slon.corX] = "slon_tile";

            game.slon.isHere = true;
        }

        else
            slonSpawn();
    }

    public static void sKorolSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        boolean solution = check(y, x, game.player.corY, game.player.corX);

        if (abs(y - game.player.corY) < 3 && abs(x - game.player.corX) < 3)
            solution = false;

        if (solution)
        {
            game.sKorol.corY = y;
            game.sKorol.corX = x;

            game.sKorol.helper2 = map[game.sKorol.corY][game.sKorol.corX];

            map[game.sKorol.corY][game.sKorol.corX] = "sking_tile";

            game.sKorol.isHere = true;
        }

        else
            sKorolSpawn();
    }

    public static void medvedSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        boolean solution = check(y, x, game.player.corY, game.player.corX);

        if (abs(y - game.player.corY) < 3 && abs(x - game.player.corX) < 3)
            solution = false;

        if (solution) {
            game.medved.corY = y;
            game.medved.corX = x;

            game.medved.helper2 = map[game.medved.corY][game.medved.corX];

            map[game.medved.corY][game.medved.corX] = "medved_tile";

            game.medved.isHere = true;
        }

        else
            medvedSpawn();
    }

    public static void krotSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        game.krot.corY = y;
        game.krot.corX = x;

        game.krot.helper2 = map[game.krot.corY][game.krot.corX];

        map[game.krot.corY][game.krot.corX] = "krot_tile";

        game.krot.isHere = true;
    }

    public static void bolshojSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        boolean solution = check(y, x, game.player.corY, game.player.corX);

        if (abs(y - game.player.corY) < 3 && abs(x - game.player.corX) < 3)
            solution = false;

        if (solution) {
            game.bolshoj.corY = y;
            game.bolshoj.corX = x;

            game.bolshoj.helper2 = map[game.bolshoj.corY][game.bolshoj.corX];

            map[game.bolshoj.corY][game.bolshoj.corX] = "bolshoj_b_tile";

            game.bolshoj.isHere = true;
        }

        else
            bolshojSpawn();
    }

    public static void gonchajaSpawn()
    {
        game.gonchaja.gonTer = rand.nextInt(3) + 2;

        int y = rand.nextInt(25) + 4;
        int x = rand.nextInt(25) + 4;

        boolean solution = check(y, x, y + 2, x + 2);

        if (abs(y - game.player.corY) < 3 && abs(x - game.player.corX) < 3)
            solution = false;

        if (solution)
        {
            game.gonchaja.corY = y;
            game.gonchaja.corX = x;

            for (int i = game.gonchaja.corY - game.gonchaja.gonTer; i <= game.gonchaja.corY + game.gonchaja.gonTer ;i++)
            {
                if (i >= map.length)
                    break;
                else
                {
                    for (int j = game.gonchaja.corX - game.gonchaja.gonTer; j <= game.gonchaja.corX + game.gonchaja.gonTer; j++)
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

            map[game.gonchaja.corY][game.gonchaja.corX] = "gonchaja_tile";
            game.gonchaja.gonchajaBaseY = game.gonchaja.corY;
            game.gonchaja.gonchajaBaseX = game.gonchaja.corX;
            game.gonchaja.isHere = true;
            game.gonchaja.helper1 = "gonchaja_territory_tile";
            game.gonchaja.helper2 = "gonchaja_territory_tile";
        }

        else
            gonchajaSpawn();
    }

    public static void furyKingSpawn()
    {
        int y = (rand.nextInt(28) + 2);
        int x = (rand.nextInt(28) + 2);

        boolean solution = check(y, x, game.player.corY, game.player.corX);

        if (solution)
        {
            game.fKing.corY = y;
            game.fKing.corX = x;

            game.fKing.helper2 = map[game.fKing.corY][game.fKing.corX];

            map[game.fKing.corY][game.fKing.corX] = "sking_tile";

            game.fKing.isHere = true;
        }

        else
            furyKingSpawn();
    }

    public static void killMob(@NonNull Entity Entity)
    {
        Entity.corX = -1;
        Entity.corY = -1;
        Entity.isHere = false;
        Entity.helper1 = "empty_tile";
        Entity.helper2 = "empty_tile";
    }

    public static void mapCleaner()
    {
        killMob(game.peshka);
        killMob(game.peshkaB);
        killMob(game.slon);
        killMob(game.sKorol);
        killMob(game.krot);
        killMob(game.bolshoj);
        killMob(game.fKing);
        killMob(game.medved);
        killMob(game.gonchaja);
        killMob(game.player);
        killMob(game.extr);
        killMob(game.lever);
        killMob(game.battery);
        killMob(game.power);
    }

    public static void mobGen(double points, String level, int event)
    {
        int helper = 1;
        int spawnChance = 0;
        spawnChance = rand.nextInt(101);

        playerSpawn();

        if (event != 1 && !level.equals("insane"))
        {
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
                {
                    if (spawnChance % 2 == 0)
                        gonchajaSpawn();

                    else
                        if (game.gonchaja.isHere)
                        {
                            map[game.gonchaja.corY][game.gonchaja.corX] = "empty_tile";
                            game.gonchaja.corY = -1;
                            game.gonchaja.corX = -1;
                            game.gonchaja.isHere = false;
                        }
                }

                if (points >= 4.5)
                    if (spawnChance % 3 == 0)
                        bolshojSpawn();

                if (points >= 6)
                    peshkaBSpawn();
            }

            else
            {
                peshkaSpawn();

                peshkaBSpawn();

                slonSpawn();

                sKorolSpawn();

                medvedSpawn();

                if (spawnChance % 3 == 0)
                    bolshojSpawn();

                if (spawnChance % 2 == 0)
                    krotSpawn();

                if (spawnChance % 2 == 0)
                    gonchajaSpawn();

                else
                    if (game.gonchaja.isHere)
                    {
                        map[game.gonchaja.corY][game.gonchaja.corX] = "empty_tile";
                        game.gonchaja.corY = -1;
                        game.gonchaja.corX = -1;
                        game.gonchaja.isHere = false;
                    }
            }
        }

        else if (event == 1)
            furyKingSpawn();
    }*/
}