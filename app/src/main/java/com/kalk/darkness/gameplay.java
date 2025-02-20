package com.kalk.darkness;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class gameplay extends map_generator
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);
        gameplayInit();
    }

    ExecutorService executor = Executors.newSingleThreadExecutor();

    int[] locPlayerCor;
    int[] locPeshkaCor;
    int opengate = 0;
    int score = 0;
    public static int gameIn = 0;
    static public int[][] map = new int[32][32];

    public void gameplayInit()
    {
        if (gameIn == 0)
        {
            player.helper1 = 0;
            player.helper2 = 0;
            peshka.helper1 = 0;
            peshka.helper2 = 0;
            map = map_generator.mapThrower();
            locPlayerCor = map_generator.playerCorThrower();
            locPeshkaCor = map_generator.peshkaCorThrower();
            gameIn = 1;
            opengate = 0;
            score++;
        }
    }

    public void gameLifeCheck(int a)
    {
        if(opengate == 1)
        {
            if (a == 31)
            {
                gameIn = 0;
                gameplayInit();
                mapDrawEmptyScreen();
            }
        }

        if ( a == 33)
        {
            gameIn = 0;
            gameplayInit();
            mapDrawEmptyScreen();
        }

        if (peshka.corX == player.corX && peshka.corY == player.corY)
        {
            gameIn = 0;
            score = 0;
            gameplayInit();
            mapDrawEmptyScreen();
        }
    }

    public void mapDrawScreen()
    {
        ImageView im1_1 = (ImageView) findViewById(R.id.mapDrawImage1_1);
        ImageView im1_2 = (ImageView) findViewById(R.id.mapDrawImage1_2);
        ImageView im1_3 = (ImageView) findViewById(R.id.mapDrawImage1_3);
        ImageView im1_4 = (ImageView) findViewById(R.id.mapDrawImage1_4);
        ImageView im1_5 = (ImageView) findViewById(R.id.mapDrawImage1_5);

        ImageView im2_1 = (ImageView) findViewById(R.id.mapDrawImage2_1);
        ImageView im2_2 = (ImageView) findViewById(R.id.mapDrawImage2_2);
        ImageView im2_3 = (ImageView) findViewById(R.id.mapDrawImage2_3);
        ImageView im2_4 = (ImageView) findViewById(R.id.mapDrawImage2_4);
        ImageView im2_5 = (ImageView) findViewById(R.id.mapDrawImage2_5);

        ImageView im3_1 = (ImageView) findViewById(R.id.mapDrawImage3_1);
        ImageView im3_2 = (ImageView) findViewById(R.id.mapDrawImage3_2);
        ImageView im3_3 = (ImageView) findViewById(R.id.mapDrawImage3_3);
        ImageView im3_4 = (ImageView) findViewById(R.id.mapDrawImage3_4);
        ImageView im3_5 = (ImageView) findViewById(R.id.mapDrawImage3_5);

        ImageView im4_1 = (ImageView) findViewById(R.id.mapDrawImage4_1);
        ImageView im4_2 = (ImageView) findViewById(R.id.mapDrawImage4_2);
        ImageView im4_3 = (ImageView) findViewById(R.id.mapDrawImage4_3);
        ImageView im4_4 = (ImageView) findViewById(R.id.mapDrawImage4_4);
        ImageView im4_5 = (ImageView) findViewById(R.id.mapDrawImage4_5);

        ImageView im5_1 = (ImageView) findViewById(R.id.mapDrawImage5_1);
        ImageView im5_2 = (ImageView) findViewById(R.id.mapDrawImage5_2);
        ImageView im5_3 = (ImageView) findViewById(R.id.mapDrawImage5_3);
        ImageView im5_4 = (ImageView) findViewById(R.id.mapDrawImage5_4);
        ImageView im5_5 = (ImageView) findViewById(R.id.mapDrawImage5_5);

        //-------------------------------------------------------------------------First layer

        if (map[locPlayerCor[0] - 2][locPlayerCor[1] - 2] < 11)
        {
            im1_1.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] - 2][locPlayerCor[1] - 2] < 21)
        {
            im1_1.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 2] == 21)
        {
            im1_1.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 2] == 22)
        {
            im1_1.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 2] == 31)
        {
            im1_1.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 2] == 32)
        {
            im1_1.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 2] == 33)
        {
            im1_1.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] - 2][locPlayerCor[1] - 1] < 11)
        {
            im1_2.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] - 2][locPlayerCor[1] - 1] < 21)
        {
            im1_2.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 1] == 21)
        {
            im1_2.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 1] == 22)
        {
            im1_2.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 1] == 31)
        {
            im1_2.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 1] == 32)
        {
            im1_2.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 1] == 33)
        {
            im1_2.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] - 2][locPlayerCor[1]] < 11)
        {
            im1_3.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] - 2][locPlayerCor[1]] < 21)
        {
            im1_3.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1]] == 21)
        {
            im1_3.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1]] == 22)
        {
            im1_3.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1]] == 31)
        {
            im1_3.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1]] == 32)
        {
            im1_3.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1]] == 33)
        {
            im1_3.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] - 2][locPlayerCor[1] + 1] < 11)
        {
            im1_4.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] - 2][locPlayerCor[1]  + 1] < 21)
        {
            im1_4.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 1] == 21)
        {
            im1_4.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 1] == 22)
        {
            im1_4.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 1] == 31)
        {
            im1_4.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 1] == 32)
        {
            im1_4.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 1] == 33)
        {
            im1_4.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] - 2][locPlayerCor[1] + 2] < 11)
        {
            im1_5.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] - 2][locPlayerCor[1]  + 2] < 21)
        {
            im1_5.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 2] == 21)
        {
            im1_5.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 2] == 22)
        {
            im1_5.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 2] == 31)
        {
            im1_5.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 2] == 32)
        {
            im1_5.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 2] == 33)
        {
            im1_5.setImageResource(R.drawable.door_tile);
        }

        //-------------------------------------------------------------------------Second layer

        if (map[locPlayerCor[0] - 1][locPlayerCor[1] - 2] < 11)
        {
            im2_1.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] - 1][locPlayerCor[1] - 2] < 21)
        {
            im2_1.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 2] == 21)
        {
            im2_1.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 2] == 22)
        {
            im2_1.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 2] == 31)
        {
            im2_1.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 2] == 32)
        {
            im2_1.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 2] == 33)
        {
            im2_1.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] < 11)
        {
            im2_2.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] < 21)
        {
            im2_2.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] == 21)
        {
            im2_2.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] == 22)
        {
            im2_2.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] == 31)
        {
            im2_2.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] == 32)
        {
            im2_2.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] == 33)
        {
            im2_2.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] - 1][locPlayerCor[1]] < 11)
        {
            im2_3.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] - 1][locPlayerCor[1]] < 21)
        {
            im2_3.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1]] == 21)
        {
            im2_3.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1]] == 22)
        {
            im2_3.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1]] == 31)
        {
            im2_3.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1]] == 32)
        {
            im2_3.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1]] == 33)
        {
            im2_3.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] < 11)
        {
            im2_4.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] - 1][locPlayerCor[1]  + 1] < 21)
        {
            im2_4.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] == 21)
        {
            im2_4.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] == 22)
        {
            im2_4.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] == 31)
        {
            im2_4.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] == 32)
        {
            im2_4.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] == 33)
        {
            im2_4.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] - 1][locPlayerCor[1] + 2] < 11)
        {
            im2_5.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] - 1][locPlayerCor[1]  + 2] < 21)
        {
            im2_5.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 2] == 21)
        {
            im2_5.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 2] == 22)
        {
            im2_5.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 2] == 31)
        {
            im2_5.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 2] == 32)
        {
            im2_5.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 2] == 33)
        {
            im2_5.setImageResource(R.drawable.door_tile);
        }

        //-------------------------------------------------------------------------Third layer

        if (map[locPlayerCor[0]][locPlayerCor[1] - 2] < 11)
        {
            im3_1.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0]][locPlayerCor[1] - 2] < 21)
        {
            im3_1.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 2] == 21)
        {
            im3_1.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 2] == 22)
        {
            im3_1.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 2] == 31)
        {
            im3_1.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 2] == 32)
        {
            im3_1.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 2] == 33)
        {
            im3_1.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0]][locPlayerCor[1] - 1] < 11)
        {
            im3_2.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0]][locPlayerCor[1] - 1] < 21)
        {
            im3_2.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 1] == 21)
        {
            im3_2.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 1] == 22)
        {
            im3_2.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 1] == 31)
        {
            im3_2.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 1] == 32)
        {
            im3_2.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 1] == 33)
        {
            im3_2.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0]][locPlayerCor[1]] < 11)
        {
            im3_3.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0]][locPlayerCor[1]] < 21)
        {
            im3_3.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1]] == 21)
        {
            im3_3.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1]] == 22)
        {
            im3_3.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1]] == 31)
        {
            im3_3.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1]] == 32)
        {
            im3_3.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1]] == 33)
        {
            im3_3.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0]][locPlayerCor[1] + 1] < 11)
        {
            im3_4.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0]][locPlayerCor[1]  + 1] < 21)
        {
            im3_4.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 1] == 21)
        {
            im3_4.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 1] == 22)
        {
            im3_4.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 1] == 31)
        {
            im3_4.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 1] == 32)
        {
            im3_4.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 1] == 33)
        {
            im3_4.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0]][locPlayerCor[1] + 2] < 11)
        {
            im3_5.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0]][locPlayerCor[1]  + 2] < 21)
        {
            im3_5.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 2] == 21)
        {
            im3_5.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 2] == 22)
        {
            im3_5.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 2] == 31)
        {
            im3_5.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 2] == 32)
        {
            im3_5.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 2] == 33)
        {
            im3_5.setImageResource(R.drawable.door_tile);
        }

        //-------------------------------------------------------------------------Fourth layer

        if (map[locPlayerCor[0] + 1][locPlayerCor[1] - 2] < 11)
        {
            im4_1.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] + 1][locPlayerCor[1] - 2] < 21)
        {
            im4_1.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 2] == 21)
        {
            im4_1.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 2] == 22)
        {
            im4_1.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 2] == 31)
        {
            im4_1.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 2] == 32)
        {
            im4_1.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 2] == 33)
        {
            im4_1.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] < 11)
        {
            im4_2.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] < 21)
        {
            im4_2.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] == 21)
        {
            im4_2.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] == 22)
        {
            im4_2.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] == 31)
        {
            im4_2.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] == 32)
        {
            im4_2.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] == 33)
        {
            im4_2.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] + 1][locPlayerCor[1]] < 11)
        {
            im4_3.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] + 1][locPlayerCor[1]] < 21)
        {
            im4_3.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1]] == 21)
        {
            im4_3.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1]] == 22)
        {
            im4_3.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1]] == 31)
        {
            im4_3.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1]] == 32)
        {
            im4_3.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1]] == 33)
        {
            im4_3.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] < 11)
        {
            im4_4.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] + 1][locPlayerCor[1]  + 1] < 21)
        {
            im4_4.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] == 21)
        {
            im4_4.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] == 22)
        {
            im4_4.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] == 31)
        {
            im4_4.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] == 32)
        {
            im4_4.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] == 33)
        {
            im4_4.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] + 1][locPlayerCor[1] + 2] < 11)
        {
            im4_5.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] + 1][locPlayerCor[1]  + 2] < 21)
        {
            im4_5.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 2] == 21)
        {
            im4_5.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 2] == 22)
        {
            im4_5.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 2] == 31)
        {
            im4_5.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 2] == 32)
        {
            im4_5.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 2] == 33)
        {
            im4_5.setImageResource(R.drawable.door_tile);
        }

        //-------------------------------------------------------------------------Fifth layer

        if (map[locPlayerCor[0] + 2][locPlayerCor[1] - 2] < 11)
        {
            im5_1.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] + 2][locPlayerCor[1] - 2] < 21)
        {
            im5_1.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 2] == 21)
        {
            im5_1.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 2] == 22)
        {
            im5_1.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 2] == 31)
        {
            im5_1.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 2] == 32)
        {
            im5_1.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 2] == 33)
        {
            im5_1.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] + 2][locPlayerCor[1] - 1] < 11)
        {
            im5_2.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] + 2][locPlayerCor[1] - 1] < 21)
        {
            im5_2.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 1] == 21)
        {
            im5_2.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 1] == 22)
        {
            im5_2.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 1] == 31)
        {
            im5_2.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 1] == 32)
        {
            im5_2.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 1] == 33)
        {
            im5_2.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] + 2][locPlayerCor[1]] < 11)
        {
            im5_3.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] + 2][locPlayerCor[1]] < 21)
        {
            im5_3.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1]] == 21)
        {
            im5_3.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1]] == 22)
        {
            im5_3.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1]] == 31)
        {
            im5_3.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1]] == 32)
        {
            im5_3.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1]] == 33)
        {
            im5_3.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] + 2][locPlayerCor[1] + 1] < 11)
        {
            im5_4.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] + 2][locPlayerCor[1]  + 1] < 21)
        {
            im5_4.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 1] == 21)
        {
            im5_4.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 1] == 22)
        {
            im5_4.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 1] == 31)
        {
            im5_4.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 1] == 32)
        {
            im5_4.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 1] == 33)
        {
            im5_4.setImageResource(R.drawable.door_tile);
        }

        if (map[locPlayerCor[0] + 2][locPlayerCor[1] + 2] < 11)
        {
            im5_5.setImageResource(R.drawable.empty_tile);
        }

        else if (map[locPlayerCor[0] + 2][locPlayerCor[1]  + 2] < 21)
        {
            im5_5.setImageResource(R.drawable.wall_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 2] == 21)
        {
            im5_5.setImageResource(R.drawable.player_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 2] == 22)
        {
            im5_5.setImageResource(R.drawable.peshka_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 2] == 31)
        {
            im5_5.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 2] == 32)
        {
            im5_5.setImageResource(R.drawable.lever_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 2] == 33)
        {
            im5_5.setImageResource(R.drawable.door_tile);
        }
    }

    public void mapDrawEmptyScreen()
    {
        ImageView im1_1 = (ImageView) findViewById(R.id.mapDrawImage1_1);
        ImageView im1_2 = (ImageView) findViewById(R.id.mapDrawImage1_2);
        ImageView im1_3 = (ImageView) findViewById(R.id.mapDrawImage1_3);
        ImageView im1_4 = (ImageView) findViewById(R.id.mapDrawImage1_4);
        ImageView im1_5 = (ImageView) findViewById(R.id.mapDrawImage1_5);

        ImageView im2_1 = (ImageView) findViewById(R.id.mapDrawImage2_1);
        ImageView im2_2 = (ImageView) findViewById(R.id.mapDrawImage2_2);
        ImageView im2_3 = (ImageView) findViewById(R.id.mapDrawImage2_3);
        ImageView im2_4 = (ImageView) findViewById(R.id.mapDrawImage2_4);
        ImageView im2_5 = (ImageView) findViewById(R.id.mapDrawImage2_5);

        ImageView im3_1 = (ImageView) findViewById(R.id.mapDrawImage3_1);
        ImageView im3_2 = (ImageView) findViewById(R.id.mapDrawImage3_2);
        ImageView im3_3 = (ImageView) findViewById(R.id.mapDrawImage3_3);
        ImageView im3_4 = (ImageView) findViewById(R.id.mapDrawImage3_4);
        ImageView im3_5 = (ImageView) findViewById(R.id.mapDrawImage3_5);

        ImageView im4_1 = (ImageView) findViewById(R.id.mapDrawImage4_1);
        ImageView im4_2 = (ImageView) findViewById(R.id.mapDrawImage4_2);
        ImageView im4_3 = (ImageView) findViewById(R.id.mapDrawImage4_3);
        ImageView im4_4 = (ImageView) findViewById(R.id.mapDrawImage4_4);
        ImageView im4_5 = (ImageView) findViewById(R.id.mapDrawImage4_5);

        ImageView im5_1 = (ImageView) findViewById(R.id.mapDrawImage5_1);
        ImageView im5_2 = (ImageView) findViewById(R.id.mapDrawImage5_2);
        ImageView im5_3 = (ImageView) findViewById(R.id.mapDrawImage5_3);
        ImageView im5_4 = (ImageView) findViewById(R.id.mapDrawImage5_4);
        ImageView im5_5 = (ImageView) findViewById(R.id.mapDrawImage5_5);

        im1_1.setImageResource(R.drawable.empty_tile);
        im1_2.setImageResource(R.drawable.empty_tile);
        im1_3.setImageResource(R.drawable.empty_tile);
        im1_4.setImageResource(R.drawable.empty_tile);
        im1_5.setImageResource(R.drawable.empty_tile);

        im2_1.setImageResource(R.drawable.empty_tile);
        im2_2.setImageResource(R.drawable.empty_tile);
        im2_3.setImageResource(R.drawable.empty_tile);
        im2_4.setImageResource(R.drawable.empty_tile);
        im2_5.setImageResource(R.drawable.empty_tile);

        im3_1.setImageResource(R.drawable.empty_tile);
        im3_2.setImageResource(R.drawable.empty_tile);
        im3_3.setImageResource(R.drawable.empty_tile);
        im3_4.setImageResource(R.drawable.empty_tile);
        im3_5.setImageResource(R.drawable.empty_tile);

        im4_1.setImageResource(R.drawable.empty_tile);
        im4_2.setImageResource(R.drawable.empty_tile);
        im4_3.setImageResource(R.drawable.empty_tile);
        im4_4.setImageResource(R.drawable.empty_tile);
        im4_5.setImageResource(R.drawable.empty_tile);

        im5_1.setImageResource(R.drawable.empty_tile);
        im5_2.setImageResource(R.drawable.empty_tile);
        im5_3.setImageResource(R.drawable.empty_tile);
        im5_4.setImageResource(R.drawable.empty_tile);
        im5_5.setImageResource(R.drawable.empty_tile);
    }

    public void peshkaSukaMove()
    {
        computeFlowField(map, player.corX, player.corY, 1);

        int negr = getDirection(peshka.corX, peshka.corY);

        if (negr == 1)
        {
            peshka.helper1 = peshka.helper2;
            peshka.helper2 = map[locPeshkaCor[0] - 1][locPeshkaCor[1]];
            map[locPeshkaCor[0]][locPeshkaCor[1]] = peshka.helper1;
            locPeshkaCor[0] -= 1;
            peshka.corY -= 1;
            map[locPeshkaCor[0]][locPeshkaCor[1]] = 22;
        }

        else if (negr == 3)
        {
            peshka.helper1 = peshka.helper2;
            peshka.helper2 = map[locPeshkaCor[0]][locPeshkaCor[1] + 1];
            map[locPeshkaCor[0]][locPeshkaCor[1]] = peshka.helper1;
            locPeshkaCor[1] += 1;
            peshka.corX += 1;
            map[locPeshkaCor[0]][locPeshkaCor[1]] = 22;
        }

        else if (negr == 5)
        {
            peshka.helper1 = peshka.helper2;
            peshka.helper2 = map[locPeshkaCor[0] + 1][locPeshkaCor[1]];
            map[locPeshkaCor[0]][locPeshkaCor[1]] = peshka.helper1;
            locPeshkaCor[0] += 1;
            peshka.corY += 1;
            map[locPeshkaCor[0]][locPeshkaCor[1]] = 22;
        }

        else if (negr == 7)
        {
            peshka.helper1 = peshka.helper2;
            peshka.helper2 = map[locPeshkaCor[0]][locPeshkaCor[1] - 1];
            map[locPeshkaCor[0]][locPeshkaCor[1]] = peshka.helper1;
            locPeshkaCor[1] -= 1;
            peshka.corX -= 1;
            map[locPeshkaCor[0]][locPeshkaCor[1]] = 22;
        }

        else if (negr == 9)
        {

        }

        gameLifeCheck(opengate);
    }

    public void playerMove (int a)
    {
        if (a == 1)
        {
            if (map[locPlayerCor[0] - 1][locPlayerCor[1]] < 11 || map[locPlayerCor[0] - 1][locPlayerCor[1]] == 32 || map[locPlayerCor[0] - 1][locPlayerCor[1]] == 31 || map[locPlayerCor[0] - 1][locPlayerCor[1]] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[locPlayerCor[0] - 1][locPlayerCor[1]];
                map[locPlayerCor[0]][locPlayerCor[1]] = player.helper1;
                locPlayerCor[0] -= 1;
                player.corY -= 1;
                map[locPlayerCor[0]][locPlayerCor[1]] = 21;



                if (player.helper2 == 32)
                    opengate = 1;

                gameLifeCheck(helper2);
            }
        }

        else if (a == 2)
        {
            if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] < 11 || map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] == 32 || map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] == 31 || map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[locPlayerCor[0] - 1][locPlayerCor[1] + 1];
                map[locPlayerCor[0]][locPlayerCor[1]] = player.helper1;
                locPlayerCor[0] -= 1;
                locPlayerCor[1] += 1;
                player.corY -= 1;
                player.corX += 1;
                map[locPlayerCor[0]][locPlayerCor[1]] = 21;

                if (player.helper2 == 32)
                    opengate = 1;

                gameLifeCheck(helper2);
            }
        }

        else if (a == 3)
        {
            if(map[locPlayerCor[0]][locPlayerCor[1] + 1] < 11  || map[locPlayerCor[0]][locPlayerCor[1] + 1] == 32 || map[locPlayerCor[0]][locPlayerCor[1] + 1] == 31 || map[locPlayerCor[0]][locPlayerCor[1] + 1] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[locPlayerCor[0]][locPlayerCor[1] + 1];
                map[locPlayerCor[0]][locPlayerCor[1]] = player.helper1;
                locPlayerCor[1] += 1;
                player.corX += 1;
                map[locPlayerCor[0]][locPlayerCor[1]] = 21;

                if (player.helper2 == 32)
                    opengate = 1;

                gameLifeCheck(helper2);
            }
        }

        else if (a == 4)
        {
            if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] < 11 || map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] == 32 || map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] == 31 || map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[locPlayerCor[0] + 1][locPlayerCor[1] + 1];
                map[locPlayerCor[0]][locPlayerCor[1]] = player.helper1;
                locPlayerCor[0] += 1;
                locPlayerCor[1] += 1;
                player.corY += 1;
                player.corX += 1;
                map[locPlayerCor[0]][locPlayerCor[1]] = 21;

                if (player.helper2 == 32)
                    opengate = 1;

                gameLifeCheck(helper2);
                /**/
            }
        }

        else if (a == 5)
        {
            if (map[locPlayerCor[0] + 1][locPlayerCor[1]] < 11 || map[locPlayerCor[0] + 1][locPlayerCor[1]] == 32 || map[locPlayerCor[0]][locPlayerCor[1]] == 31 || map[locPlayerCor[0] + 1][locPlayerCor[1]] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[locPlayerCor[0] + 1][locPlayerCor[1]];
                map[locPlayerCor[0]][locPlayerCor[1]] = player.helper1;
                locPlayerCor[0] += 1;
                player.corY += 1;
                map[locPlayerCor[0]][locPlayerCor[1]] = 21;

                if (player.helper2 == 32)
                    opengate = 1;

                gameLifeCheck(helper2);

                /**/
            }
        }

        else if (a == 6)
        {
            if (map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] < 11 || map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] == 32 || map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] == 31 || map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[locPlayerCor[0] + 1][locPlayerCor[1] - 1];
                map[locPlayerCor[0]][locPlayerCor[1]] = player.helper1;
                locPlayerCor[0] += 1;
                locPlayerCor[1] -= 1;
                player.corY += 1;
                player.corX -= 1;
                map[locPlayerCor[0]][locPlayerCor[1]] = 21;

                if (player.helper2 == 32)
                    opengate = 1;

                gameLifeCheck(helper2);
            }
        }

        else if (a == 7)
        {
            if (map[locPlayerCor[0]][locPlayerCor[1] - 1] < 11 || map[locPlayerCor[0]][locPlayerCor[1] - 1] == 32 || map[locPlayerCor[0]][locPlayerCor[1] - 1] == 31 || map[locPlayerCor[0]][locPlayerCor[1] - 1] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[locPlayerCor[0]][locPlayerCor[1] - 1];
                map[locPlayerCor[0]][locPlayerCor[1]] = player.helper1;
                locPlayerCor[1] -= 1;
                player.corX -= 1;
                map[locPlayerCor[0]][locPlayerCor[1]] = 21;

                if (player.helper2 == 32)
                    opengate = 1;

                gameLifeCheck(helper2);
            }
        }

        else if (a == 8)
        {
            if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] < 10 || map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] == 32 || map[locPlayerCor[0] - 1][locPlayerCor[1] -1] == 31 || map[locPlayerCor[0] - 1][locPlayerCor[1] -1] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[locPlayerCor[0] - 1][locPlayerCor[1] - 1];
                map[locPlayerCor[0]][locPlayerCor[1]] = player.helper1;
                locPlayerCor[0] -= 1;
                locPlayerCor[1] -= 1;
                player.corY -= 1;
                player.corX -= 1;
                map[locPlayerCor[0]][locPlayerCor[1]] = 21;

                if (player.helper2 == 32)
                    opengate = 1;

                gameLifeCheck(helper2);
            }
        }
    }

    public void buttonUpAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String b = settings.getString("difficulty", "");

        playerMove(1);
        peshkaSukaMove();

        if (b.equals("easy"))
        {
            mapDrawScreen();
        }

        else
        {
            mapDrawEmptyScreen();
        }
    }

    public void buttonUpRightAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String b = settings.getString("difficulty", "");

        playerMove(2);
        peshkaSukaMove();

        if (b.equals("easy"))
        {
            mapDrawScreen();
        }

        else
        {
            mapDrawEmptyScreen();
        }
    }

    public void buttonRightAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String b = settings.getString("difficulty", "");

        playerMove(3);
        peshkaSukaMove();

        if (b.equals("easy"))
        {
            mapDrawScreen();
        }

        else
        {
            mapDrawEmptyScreen();
        }
    }

    public void buttonDownRightAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String b = settings.getString("difficulty", "");

        playerMove(4);
        peshkaSukaMove();

        if (b.equals("easy"))
        {
            mapDrawScreen();
        }

        else
        {
            mapDrawEmptyScreen();
        }
    }

    public void buttonDownAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String b = settings.getString("difficulty", "");

        playerMove(5);
        peshkaSukaMove();

        if (b.equals("easy"))
        {
            mapDrawScreen();
        }

        else
        {
            mapDrawEmptyScreen();
        }
    }

    public void buttonDownLeftAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String b = settings.getString("difficulty", "");

        playerMove(6);
        peshkaSukaMove();

        if (b.equals("easy"))
        {
            mapDrawScreen();
        }

        else
        {
            mapDrawEmptyScreen();
        }
    }

    public void buttonLeftAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String b = settings.getString("difficulty", "");

        playerMove(7);
        peshkaSukaMove();

        if (b.equals("easy"))
        {
            mapDrawScreen();
        }

        else
        {
            mapDrawEmptyScreen();
        }
    }

    public void buttonUpLeftAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String b = settings.getString("difficulty", "");

        playerMove(8);
        peshkaSukaMove();

        if (b.equals("easy"))
        {
            mapDrawScreen();
        }

        else
        {
            mapDrawEmptyScreen();
        }
    }


    public void midButtonAction(View v)
    {
        mapDrawScreen();
    }

    public void test(View v)
    {
        peshkaSukaMove();
        mapDrawScreen();
        for(int i = 0; i < 32; i++)
        {
            for (int j = 0; j < 32; j++)
            {
                if(map[i][j] == 0)
                {
                    System.out.print("00");
                }

                else if (map[i][j] == 21)
                {
                    System.out.print("##");
                }

                else
                {
                    System.out.print(map[i][j]);
                }
            }

            System.out.println();
        }
        
        System.out.println(score);
        System.out.println(player.corY);
        System.out.println(player.corX);
        System.out.println(peshka.corY);
        System.out.println(peshka.corX);
    }
}