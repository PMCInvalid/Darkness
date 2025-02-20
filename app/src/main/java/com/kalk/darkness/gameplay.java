package com.kalk.darkness;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class gameplay extends map_generator
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);
        gameplayInit();
    }

    int[] locPlayerCor;
    int helper1 = 0;
    int helper2 = 0;
    int opengate = 0;
    int score = 0;
    public static int gameIn = 0;
    static public int[][] map = new int[32][32];

    public void gameplayInit()
    {
        if (gameIn == 0)
        {
            helper1 = 0;
            helper2 = 0;
            map = map_generator.mapThrower();
            locPlayerCor = map_generator.playerCorThrower();
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

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 2] == 31)
        {
            im1_1.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 2] == 32)
        {
            im1_1.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 1] == 31)
        {
            im1_2.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] - 1] == 32)
        {
            im1_2.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1]] == 31)
        {
            im1_3.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1]] == 32)
        {
            im1_3.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 1] == 31)
        {
            im1_4.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 1] == 32)
        {
            im1_4.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 2] == 31)
        {
            im1_5.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 2][locPlayerCor[1] + 2] == 32)
        {
            im1_5.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 2] == 31)
        {
            im2_1.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 2] == 32)
        {
            im2_1.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] == 31)
        {
            im2_2.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] == 32)
        {
            im2_2.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1]] == 31)
        {
            im2_3.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1]] == 32)
        {
            im2_3.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] == 31)
        {
            im2_4.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] == 32)
        {
            im2_4.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 2] == 31)
        {
            im2_5.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 2] == 32)
        {
            im2_5.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 2] == 31)
        {
            im3_1.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 2] == 32)
        {
            im3_1.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 1] == 31)
        {
            im3_2.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] - 1] == 32)
        {
            im3_2.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0]][locPlayerCor[1]] == 31)
        {
            im3_3.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1]] == 32)
        {
            im3_3.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 1] == 31)
        {
            im3_4.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 1] == 32)
        {
            im3_4.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 2] == 31)
        {
            im3_5.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0]][locPlayerCor[1] + 2] == 32)
        {
            im3_5.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 2] == 31)
        {
            im4_1.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 2] == 32)
        {
            im4_1.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] == 31)
        {
            im4_2.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] == 32)
        {
            im4_2.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1]] == 31)
        {
            im4_3.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1]] == 32)
        {
            im4_3.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] == 31)
        {
            im4_4.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] == 32)
        {
            im4_4.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 2] == 31)
        {
            im4_5.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 1][locPlayerCor[1] + 2] == 32)
        {
            im4_5.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 2] == 31)
        {
            im5_1.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 2] == 32)
        {
            im5_1.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 1] == 31)
        {
            im5_2.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] - 1] == 32)
        {
            im5_2.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1]] == 31)
        {
            im5_3.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1]] == 32)
        {
            im5_3.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 1] == 31)
        {
            im5_4.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 1] == 32)
        {
            im5_4.setImageResource(R.drawable.lever_tile);
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

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 2] == 31)
        {
            im5_5.setImageResource(R.drawable.extraction_tile);
        }

        else if(map[locPlayerCor[0] + 2][locPlayerCor[1] + 2] == 32)
        {
            im5_5.setImageResource(R.drawable.lever_tile);
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

    public void buttonUpAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String a = settings.getString("difficulty", "");

        if (map[locPlayerCor[0] - 1][locPlayerCor[1]] < 11 || map[locPlayerCor[0] - 1][locPlayerCor[1]] == 32 || map[locPlayerCor[0] - 1][locPlayerCor[1]] == 31)
        {
            helper1 = helper2;
            helper2 = map[locPlayerCor[0] - 1][locPlayerCor[1]];
            map[locPlayerCor[0]][locPlayerCor[1]] = helper1;
            locPlayerCor[0] -= 1;
            map[locPlayerCor[0]][locPlayerCor[1]] = 21;

            if (a.equals("easy"))
            {
                mapDrawScreen();
            }

            else
            {
                mapDrawEmptyScreen();
            }

            if (helper2 == 32)
                opengate = 1;

            gameLifeCheck(helper2);
        }
    }

    public void buttonUpLeftAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String a = settings.getString("difficulty", "");

        if(map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] < 10 || map[locPlayerCor[0] - 1][locPlayerCor[1] - 1] == 32 || map[locPlayerCor[0] - 1][locPlayerCor[1] -1] == 31)
        {
            helper1 = helper2;
            helper2 = map[locPlayerCor[0] - 1][locPlayerCor[1] - 1];
            map[locPlayerCor[0]][locPlayerCor[1]] = helper1;
            locPlayerCor[0] -= 1;
            locPlayerCor[1] -= 1;
            map[locPlayerCor[0]][locPlayerCor[1]] = 21;

            if (a.equals("easy"))
            {
                mapDrawScreen();
            }

            else
            {
                mapDrawEmptyScreen();
            }

            if (helper2 == 32)
                opengate = 1;

            gameLifeCheck(helper2);
        }
    }

    public void buttonUpRightAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String a = settings.getString("difficulty", "");

        if(map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] < 11 || map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] == 32 || map[locPlayerCor[0] - 1][locPlayerCor[1] + 1] == 31)
        {
            helper1 = helper2;
            helper2 = map[locPlayerCor[0] - 1][locPlayerCor[1] + 1];
            map[locPlayerCor[0]][locPlayerCor[1]] = helper1;
            locPlayerCor[0] -= 1;
            locPlayerCor[1] += 1;
            map[locPlayerCor[0]][locPlayerCor[1]] = 21;

            if (a.equals("easy"))
            {
                mapDrawScreen();
            }

            else
            {
                mapDrawEmptyScreen();
            }

            if (helper2 == 32)
                opengate = 1;

            gameLifeCheck(helper2);
        }
    }

    public void buttonRightAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String a = settings.getString("difficulty", "");

        if(map[locPlayerCor[0]][locPlayerCor[1] + 1] < 11  || map[locPlayerCor[0]][locPlayerCor[1] + 1] == 32 || map[locPlayerCor[0]][locPlayerCor[1] + 1] == 31)
        {
            helper1 = helper2;
            helper2 = map[locPlayerCor[0]][locPlayerCor[1] + 1];
            map[locPlayerCor[0]][locPlayerCor[1]] = helper1;
            locPlayerCor[1] += 1;
            map[locPlayerCor[0]][locPlayerCor[1]] = 21;

            if (a.equals("easy"))
            {
                mapDrawScreen();
            }

            else
            {
                mapDrawEmptyScreen();
            }

            if (helper2 == 32)
                opengate = 1;

            gameLifeCheck(helper2);
        }
    }

    public void buttonLeftAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String a = settings.getString("difficulty", "");

        if(map[locPlayerCor[0]][locPlayerCor[1] - 1] < 11 || map[locPlayerCor[0]][locPlayerCor[1] - 1] == 32 || map[locPlayerCor[0]][locPlayerCor[1] - 1] == 31)
        {
            helper1 = helper2;
            helper2 = map[locPlayerCor[0]][locPlayerCor[1] - 1];
            map[locPlayerCor[0]][locPlayerCor[1]] = helper1;
            locPlayerCor[1] -= 1;
            map[locPlayerCor[0]][locPlayerCor[1]] = 21;

            if (a.equals("easy"))
            {
                mapDrawScreen();
            }

            else
            {
                mapDrawEmptyScreen();
            }

            if (helper2 == 32)
                opengate = 1;

            gameLifeCheck(helper2);
        }
    }

    public void buttonDownRightAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String a = settings.getString("difficulty", "");

        if (map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] < 11 || map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] == 32 || map[locPlayerCor[0] + 1][locPlayerCor[1] + 1] == 31)
        {
            helper1 = helper2;
            helper2 = map[locPlayerCor[0] + 1][locPlayerCor[1] + 1];
            map[locPlayerCor[0]][locPlayerCor[1]] = helper1;
            locPlayerCor[0] += 1;
            locPlayerCor[1] += 1;
            map[locPlayerCor[0]][locPlayerCor[1]] = 21;

            if (a.equals("easy"))
            {
                mapDrawScreen();
            }

            else
            {
                mapDrawEmptyScreen();
            }

            if (helper2 == 32)
                opengate = 1;

            gameLifeCheck(helper2);
        }
    }

    public void buttonDownLeftAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String a = settings.getString("difficulty", "");

        if (map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] < 11 || map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] == 32 || map[locPlayerCor[0] + 1][locPlayerCor[1] - 1] == 31)
        {
            helper1 = helper2;
            helper2 = map[locPlayerCor[0] + 1][locPlayerCor[1] - 1];
            map[locPlayerCor[0]][locPlayerCor[1]] = helper1;
            locPlayerCor[0] += 1;
            locPlayerCor[1] -= 1;
            map[locPlayerCor[0]][locPlayerCor[1]] = 21;

            if (a.equals("easy"))
            {
                mapDrawScreen();
            }

            else
            {
                mapDrawEmptyScreen();
            }

            if (helper2 == 32)
                opengate = 1;

            gameLifeCheck(helper2);
        }
    }

    public void buttonDownAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String a = settings.getString("difficulty", "");

        if (map[locPlayerCor[0] + 1][locPlayerCor[1]] < 11 || map[locPlayerCor[0] + 1][locPlayerCor[1]] == 32 || map[locPlayerCor[0] + 1][locPlayerCor[1]] == 31)
        {
            helper1 = helper2;
            helper2 = map[locPlayerCor[0] + 1][locPlayerCor[1]];
            map[locPlayerCor[0]][locPlayerCor[1]] = helper1;
            locPlayerCor[0] += 1;
            map[locPlayerCor[0]][locPlayerCor[1]] = 21;

            if (a.equals("easy"))
            {
                mapDrawScreen();
            }

            else
            {
                mapDrawEmptyScreen();
            }

            if (helper2 == 32)
                opengate = 1;

            gameLifeCheck(helper2);
        }
    }

    public void midButtonAction(View v)
    {
        mapDrawScreen();
    }

    public void test(View v)
    {
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
    }
}