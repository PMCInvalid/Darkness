package com.kalk.darkness;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.TextView;

public class movement_logic extends map_generator
{
    int opengate = 0;
    int playerMoveRem = 9;
    double score = 1;
    public static int gameIn = 0;
    static public String[][] map = new String[32][32];

    public void gameplayInit()
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);

        String hard = settings.getString("difficulty", "");

        TextView scores = (TextView) findViewById(R.id.scoreText);

        if (gameIn == 0)
        {
            player.helper1 = "empty_tile";
            player.helper2 = "empty_tile";
            peshka.helper1 = "empty_tile";
            peshka.helper2 = "empty_tile";
            slon.helper1 = "empty_tile";
            slon.helper2 = "empty_tile";
            sKorol.helper1 = "empty_tile";
            sKorol.helper2 = "empty_tile";
            gameIn = 1;
            opengate = 0;

            map = map_generator.mapThrower(score, hard);

            scores.setText("Score: " + score);
        }
    }

    public void gameLifeCheck(String a)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        if(opengate == 1)
        {
            if (a.equals("extraction_tile"))
            {
                gameIn = 0;
                opengate = 0;
                score++;
                gameplayInit();
                mapDrawScreen();
            }
        }

        if (a.equals("door_tile"))
        {
            gameIn = 0;
            opengate = 0;
            score += 0.25;
            gameplayInit();
            mapDrawScreen();
        }

        if (peshka.corX == player.corX && peshka.corY == player.corY)
        {
            editor.putString("score", String.valueOf(score));
            System.out.println("Score live - " + String.valueOf(score));
            editor.apply();

            gameIn = 0;
            score = 0;
            Intent pip = new Intent(this, death_screen.class);
            startActivity(pip);
        }

        if (slon.corX == player.corX && slon.corY == player.corY)
        {
            editor.putString("score", String.valueOf(score));
            editor.apply();

            gameIn = 0;
            score = 0;
            Intent pip = new Intent(this, death_screen.class);
            startActivity(pip);
        }

        if (sKorol.corX == player.corX && sKorol.corY == player.corY)
        {
            editor.putString("score", String.valueOf(score));
            editor.apply();

            gameIn = 0;
            score = 0;
            Intent pip = new Intent(this, death_screen.class);
            startActivity(pip);
        }

        if (bolshoj.corX == player.corX && bolshoj.corY == player.corY)
        {
            editor.putString("score", String.valueOf(score));
            editor.apply();

            gameIn = 0;
            score = 0;
            Intent pip = new Intent(this, death_screen.class);
            startActivity(pip);
        }
    }

    public void mapDrawScreen()
    {
        ImageView im1_1 = (ImageView) findViewById(R.id.mapDrawImage1_1);
        ImageView im1_2 = (ImageView) findViewById(R.id.mapDrawImage1_2);
        ImageView im1_3 = (ImageView) findViewById(R.id.mapDrawImage1_3);
        ImageView im1_4 = (ImageView) findViewById(R.id.mapDrawImage1_4);
        ImageView im1_5 = (ImageView) findViewById(R.id.mapDrawImage1_5);
        ImageView im1_6 = (ImageView) findViewById(R.id.mapDrawImage1_6);
        ImageView im1_7 = (ImageView) findViewById(R.id.mapDrawImage1_7);
        ImageView im1_8 = (ImageView) findViewById(R.id.mapDrawImage1_8);
        ImageView im1_9 = (ImageView) findViewById(R.id.mapDrawImage1_9);

        ImageView im2_1 = (ImageView) findViewById(R.id.mapDrawImage2_1);
        ImageView im2_2 = (ImageView) findViewById(R.id.mapDrawImage2_2);
        ImageView im2_3 = (ImageView) findViewById(R.id.mapDrawImage2_3);
        ImageView im2_4 = (ImageView) findViewById(R.id.mapDrawImage2_4);
        ImageView im2_5 = (ImageView) findViewById(R.id.mapDrawImage2_5);
        ImageView im2_6 = (ImageView) findViewById(R.id.mapDrawImage2_6);
        ImageView im2_7 = (ImageView) findViewById(R.id.mapDrawImage2_7);
        ImageView im2_8 = (ImageView) findViewById(R.id.mapDrawImage2_8);
        ImageView im2_9 = (ImageView) findViewById(R.id.mapDrawImage2_9);

        ImageView im3_1 = (ImageView) findViewById(R.id.mapDrawImage3_1);
        ImageView im3_2 = (ImageView) findViewById(R.id.mapDrawImage3_2);
        ImageView im3_3 = (ImageView) findViewById(R.id.mapDrawImage3_3);
        ImageView im3_4 = (ImageView) findViewById(R.id.mapDrawImage3_4);
        ImageView im3_5 = (ImageView) findViewById(R.id.mapDrawImage3_5);
        ImageView im3_6 = (ImageView) findViewById(R.id.mapDrawImage3_6);
        ImageView im3_7 = (ImageView) findViewById(R.id.mapDrawImage3_7);
        ImageView im3_8 = (ImageView) findViewById(R.id.mapDrawImage3_8);
        ImageView im3_9 = (ImageView) findViewById(R.id.mapDrawImage3_9);

        ImageView im4_1 = (ImageView) findViewById(R.id.mapDrawImage4_1);
        ImageView im4_2 = (ImageView) findViewById(R.id.mapDrawImage4_2);
        ImageView im4_3 = (ImageView) findViewById(R.id.mapDrawImage4_3);
        ImageView im4_4 = (ImageView) findViewById(R.id.mapDrawImage4_4);
        ImageView im4_5 = (ImageView) findViewById(R.id.mapDrawImage4_5);
        ImageView im4_6 = (ImageView) findViewById(R.id.mapDrawImage4_6);
        ImageView im4_7 = (ImageView) findViewById(R.id.mapDrawImage4_7);
        ImageView im4_8 = (ImageView) findViewById(R.id.mapDrawImage4_8);
        ImageView im4_9 = (ImageView) findViewById(R.id.mapDrawImage4_9);

        ImageView im5_1 = (ImageView) findViewById(R.id.mapDrawImage5_1);
        ImageView im5_2 = (ImageView) findViewById(R.id.mapDrawImage5_2);
        ImageView im5_3 = (ImageView) findViewById(R.id.mapDrawImage5_3);
        ImageView im5_4 = (ImageView) findViewById(R.id.mapDrawImage5_4);
        ImageView im5_5 = (ImageView) findViewById(R.id.mapDrawImage5_5);
        ImageView im5_6 = (ImageView) findViewById(R.id.mapDrawImage5_6);
        ImageView im5_7 = (ImageView) findViewById(R.id.mapDrawImage5_7);
        ImageView im5_8 = (ImageView) findViewById(R.id.mapDrawImage5_8);
        ImageView im5_9 = (ImageView) findViewById(R.id.mapDrawImage5_9);

        ImageView im6_1 = (ImageView) findViewById(R.id.mapDrawImage6_1);
        ImageView im6_2 = (ImageView) findViewById(R.id.mapDrawImage6_2);
        ImageView im6_3 = (ImageView) findViewById(R.id.mapDrawImage6_3);
        ImageView im6_4 = (ImageView) findViewById(R.id.mapDrawImage6_4);
        ImageView im6_5 = (ImageView) findViewById(R.id.mapDrawImage6_5);
        ImageView im6_6 = (ImageView) findViewById(R.id.mapDrawImage6_6);
        ImageView im6_7 = (ImageView) findViewById(R.id.mapDrawImage6_7);
        ImageView im6_8 = (ImageView) findViewById(R.id.mapDrawImage6_8);
        ImageView im6_9 = (ImageView) findViewById(R.id.mapDrawImage6_9);

        ImageView im7_1 = (ImageView) findViewById(R.id.mapDrawImage7_1);
        ImageView im7_2 = (ImageView) findViewById(R.id.mapDrawImage7_2);
        ImageView im7_3 = (ImageView) findViewById(R.id.mapDrawImage7_3);
        ImageView im7_4 = (ImageView) findViewById(R.id.mapDrawImage7_4);
        ImageView im7_5 = (ImageView) findViewById(R.id.mapDrawImage7_5);
        ImageView im7_6 = (ImageView) findViewById(R.id.mapDrawImage7_6);
        ImageView im7_7 = (ImageView) findViewById(R.id.mapDrawImage7_7);
        ImageView im7_8 = (ImageView) findViewById(R.id.mapDrawImage7_8);
        ImageView im7_9 = (ImageView) findViewById(R.id.mapDrawImage7_9);

        ImageView im8_1 = (ImageView) findViewById(R.id.mapDrawImage8_1);
        ImageView im8_2 = (ImageView) findViewById(R.id.mapDrawImage8_2);
        ImageView im8_3 = (ImageView) findViewById(R.id.mapDrawImage8_3);
        ImageView im8_4 = (ImageView) findViewById(R.id.mapDrawImage8_4);
        ImageView im8_5 = (ImageView) findViewById(R.id.mapDrawImage8_5);
        ImageView im8_6 = (ImageView) findViewById(R.id.mapDrawImage8_6);
        ImageView im8_7 = (ImageView) findViewById(R.id.mapDrawImage8_7);
        ImageView im8_8 = (ImageView) findViewById(R.id.mapDrawImage8_8);
        ImageView im8_9 = (ImageView) findViewById(R.id.mapDrawImage8_9);

        ImageView im9_1 = (ImageView) findViewById(R.id.mapDrawImage9_1);
        ImageView im9_2 = (ImageView) findViewById(R.id.mapDrawImage9_2);
        ImageView im9_3 = (ImageView) findViewById(R.id.mapDrawImage9_3);
        ImageView im9_4 = (ImageView) findViewById(R.id.mapDrawImage9_4);
        ImageView im9_5 = (ImageView) findViewById(R.id.mapDrawImage9_5);
        ImageView im9_6 = (ImageView) findViewById(R.id.mapDrawImage9_6);
        ImageView im9_7 = (ImageView) findViewById(R.id.mapDrawImage9_7);
        ImageView im9_8 = (ImageView) findViewById(R.id.mapDrawImage9_8);
        ImageView im9_9 = (ImageView) findViewById(R.id.mapDrawImage9_9);

        int resId;


        if (player.corY - 4 < 0 || player.corX - 4 < 0)
            im1_1.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 4][player.corX - 4], "drawable", getPackageName());
            im1_1.setImageResource(resId);
        }
        if (player.corY - 4 < 0 || player.corX - 3 < 0)
            im1_2.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 4][player.corX - 3], "drawable", getPackageName());
            im1_2.setImageResource(resId);
        }
        if (player.corY - 4 < 0 || player.corX - 2 < 0)
            im1_3.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 4][player.corX - 2], "drawable", getPackageName());
            im1_3.setImageResource(resId);
        }
        if (player.corY - 4 < 0 || player.corX - 1 < 0)
            im1_4.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 4][player.corX - 1], "drawable", getPackageName());
            im1_4.setImageResource(resId);
        }
        if (player.corY - 4 < 0)
            im1_5.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 4][player.corX], "drawable", getPackageName());
            im1_5.setImageResource(resId);
        }
        if (player.corY - 4 < 0 || player.corX + 1 >= map[0].length)
            im1_6.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 4][player.corX + 1], "drawable", getPackageName());
            im1_6.setImageResource(resId);
        }
        if (player.corY - 4 < 0 || player.corX + 2 >= map[0].length)
            im1_7.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 4][player.corX + 2], "drawable", getPackageName());
            im1_7.setImageResource(resId);
        }
        if (player.corY - 4 < 0 || player.corX + 3 >= map[0].length)
            im1_8.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 4][player.corX + 3], "drawable", getPackageName());
            im1_8.setImageResource(resId);
        }
        if (player.corY - 4 < 0 || player.corX + 4 >= map[0].length)
            im1_9.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 4][player.corX + 4], "drawable", getPackageName());
            im1_9.setImageResource(resId);
        }



        if (player.corY - 3 < 0 || player.corX - 4 < 0)
            im2_1.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 3][player.corX - 4], "drawable", getPackageName());
            im2_1.setImageResource(resId);
        }
        if (player.corY - 3 < 0 || player.corX - 3 < 0)
            im2_2.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 3][player.corX - 3], "drawable", getPackageName());
            im2_2.setImageResource(resId);
        }
        if (player.corY - 3 < 0 || player.corX - 2 < 0)
            im2_3.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 3][player.corX - 2], "drawable", getPackageName());
            im2_3.setImageResource(resId);
        }
        if (player.corY - 3 < 0 || player.corX - 1 < 0)
            im2_4.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 3][player.corX - 1], "drawable", getPackageName());
            im2_4.setImageResource(resId);
        }
        if (player.corY - 3 < 0)
            im2_5.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 3][player.corX], "drawable", getPackageName());
            im2_5.setImageResource(resId);
        }
        if (player.corY - 3 < 0 || player.corX + 1 >= map[0].length)
            im2_6.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 3][player.corX + 1], "drawable", getPackageName());
            im2_6.setImageResource(resId);
        }
        if (player.corY - 3 < 0 || player.corX + 2 >= map[0].length)
            im2_7.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 3][player.corX + 2], "drawable", getPackageName());
            im2_7.setImageResource(resId);
        }
        if (player.corY - 3 < 0 || player.corX + 3 >= map[0].length)
            im2_8.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 3][player.corX + 3], "drawable", getPackageName());
            im2_8.setImageResource(resId);
        }
        if (player.corY - 3 < 0 || player.corX + 4 >= map[0].length)
            im2_9.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 3][player.corX + 4], "drawable", getPackageName());
            im2_9.setImageResource(resId);
        }



        if(player.corY - 2 < 0 || player.corX - 4 < 0)
            im3_1.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 2][player.corX - 4], "drawable", getPackageName());
            im3_1.setImageResource(resId);
        }

        if(player.corY - 2 < 0 || player.corX - 3 < 0)
            im3_2.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 2][player.corX - 3], "drawable", getPackageName());
            im3_2.setImageResource(resId);
        }

        resId = getResources().getIdentifier(map[player.corY - 2][player.corX - 2], "drawable", getPackageName());
        im3_3.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY - 2][player.corX - 1], "drawable", getPackageName());
        im3_4.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY - 2][player.corX], "drawable", getPackageName());
        im3_5.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY - 2][player.corX + 1], "drawable", getPackageName());
        im3_6.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY - 2][player.corX + 2], "drawable", getPackageName());
        im3_7.setImageResource(resId);

        if(player.corY - 2 < 0 || player.corX + 3 > 31)
            im3_8.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 2][player.corX + 3], "drawable", getPackageName());
            im3_8.setImageResource(resId);
        }

        if(player.corY - 2 < 0 || player.corX + 4 > 31)
            im3_9.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 2][player.corX + 4], "drawable", getPackageName());
            im3_9.setImageResource(resId);
        }



        if(player.corY - 1 < 0 || player.corX - 4 < 0)
            im4_1.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 1][player.corX - 4], "drawable", getPackageName());
            im4_1.setImageResource(resId);
        }

        if(player.corY - 1 < 0 || player.corX - 3 < 0)
            im4_2.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 1][player.corX - 3], "drawable", getPackageName());
            im4_2.setImageResource(resId);
        }

        resId = getResources().getIdentifier(map[player.corY - 1][player.corX - 2], "drawable", getPackageName());
        im4_3.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY - 1][player.corX - 1], "drawable", getPackageName());
        im4_4.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY - 1][player.corX], "drawable", getPackageName());
        im4_5.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY - 1][player.corX + 1], "drawable", getPackageName());
        im4_6.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY - 1][player.corX + 2], "drawable", getPackageName());
        im4_7.setImageResource(resId);

        if(player.corY - 1 < 0 || player.corX + 3 > 31)
            im4_8.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 1][player.corX + 3], "drawable", getPackageName());
            im4_8.setImageResource(resId);
        }

        if(player.corY - 1 < 0 || player.corX + 4 > 31)
            im4_9.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY - 1][player.corX + 4], "drawable", getPackageName());
            im4_9.setImageResource(resId);
        }



        if(player.corX - 4 < 0)
            im5_1.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY][player.corX - 4], "drawable", getPackageName());
            im5_1.setImageResource(resId);
        }

        if(player.corX - 3 < 0)
            im5_2.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY][player.corX - 3], "drawable", getPackageName());
            im5_2.setImageResource(resId);
        }

        resId = getResources().getIdentifier(map[player.corY][player.corX - 2], "drawable", getPackageName());
        im5_3.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY][player.corX - 1], "drawable", getPackageName());
        im5_4.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY][player.corX], "drawable", getPackageName());
        im5_5.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY][player.corX + 1], "drawable", getPackageName());
        im5_6.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY][player.corX + 2], "drawable", getPackageName());
        im5_7.setImageResource(resId);

        if(player.corX + 3 > 31)
            im5_8.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY][player.corX + 3], "drawable", getPackageName());
            im5_8.setImageResource(resId);
        }

        if(player.corX + 4 > 31)
            im5_9.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY][player.corX + 4], "drawable", getPackageName());
            im5_9.setImageResource(resId);
        }



        if(player.corX - 4 < 0)
            im6_1.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 1][player.corX - 4], "drawable", getPackageName());
            im6_1.setImageResource(resId);
        }

        if(player.corX - 3 < 0)
            im6_2.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 1][player.corX - 3], "drawable", getPackageName());
            im6_2.setImageResource(resId);
        }

        resId = getResources().getIdentifier(map[player.corY + 1][player.corX - 2], "drawable", getPackageName());
        im6_3.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY + 1][player.corX - 1], "drawable", getPackageName());
        im6_4.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY + 1][player.corX], "drawable", getPackageName());
        im6_5.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY + 1][player.corX + 1], "drawable", getPackageName());
        im6_6.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY + 1][player.corX + 2], "drawable", getPackageName());
        im6_7.setImageResource(resId);

        if(player.corX + 3 > 31)
            im6_8.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 1][player.corX + 3], "drawable", getPackageName());
            im6_8.setImageResource(resId);
        }

        if(player.corX + 4 > 31)
            im6_9.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 1][player.corX + 4], "drawable", getPackageName());
            im6_9.setImageResource(resId);
        }



        if(player.corX - 4 < 0)
            im7_1.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 2][player.corX - 4], "drawable", getPackageName());
            im7_1.setImageResource(resId);
        }

        if(player.corX - 3 < 0)
            im7_2.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 2][player.corX - 3], "drawable", getPackageName());
            im7_2.setImageResource(resId);
        }
        resId = getResources().getIdentifier(map[player.corY + 2][player.corX - 2], "drawable", getPackageName());
        im7_3.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY + 2][player.corX - 1], "drawable", getPackageName());
        im7_4.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY + 2][player.corX], "drawable", getPackageName());
        im7_5.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY + 2][player.corX + 1], "drawable", getPackageName());
        im7_6.setImageResource(resId);
        resId = getResources().getIdentifier(map[player.corY + 2][player.corX + 2], "drawable", getPackageName());
        im7_7.setImageResource(resId);
        if(player.corX + 3 > 31)
            im7_8.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 2][player.corX + 3], "drawable", getPackageName());
            im7_8.setImageResource(resId);
        }

        if(player.corX + 4 > 31)
            im7_9.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 2][player.corX + 4], "drawable", getPackageName());
            im7_9.setImageResource(resId);
        }



        if (player.corY + 3 > 31 || player.corX - 4 < 0)
            im8_1.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 3][player.corX - 4], "drawable", getPackageName());
            im8_1.setImageResource(resId);
        }

        if (player.corY + 3 > 31 || player.corX - 4 < 0)
            im8_1.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 3][player.corX - 4], "drawable", getPackageName());
            im8_1.setImageResource(resId);
        }
        if (player.corY + 3 > 31 || player.corX - 3 < 0)
            im8_2.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 3][player.corX - 3], "drawable", getPackageName());
            im8_2.setImageResource(resId);
        }
        if (player.corY + 3 > 31 || player.corX - 2 < 0)
            im8_3.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 3][player.corX - 2], "drawable", getPackageName());
            im8_3.setImageResource(resId);
        }
        if (player.corY + 3 > 31 || player.corX - 1 < 0)
            im8_4.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 3][player.corX - 1], "drawable", getPackageName());
            im8_4.setImageResource(resId);
        }
        if (player.corY + 3 > 31)
            im8_5.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 3][player.corX], "drawable", getPackageName());
            im8_5.setImageResource(resId);
        }
        if (player.corY + 3 > 31 || player.corX + 1 >= map[0].length)
            im8_6.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 3][player.corX + 1], "drawable", getPackageName());
            im8_6.setImageResource(resId);
        }
        if (player.corY + 3 > 31 || player.corX + 2 >= map[0].length)
            im8_7.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 3][player.corX + 2], "drawable", getPackageName());
            im8_7.setImageResource(resId);
        }
        if (player.corY + 3 > 31 || player.corX + 3 >= map[0].length)
            im8_8.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 3][player.corX + 3], "drawable", getPackageName());
            im8_8.setImageResource(resId);
        }
        if (player.corY + 3 > 31 || player.corX + 4 >= map[0].length)
            im8_9.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 3][player.corX + 4], "drawable", getPackageName());
            im8_9.setImageResource(resId);
        }



        if (player.corY + 4 > 31 || player.corX - 4 < 0)
            im9_1.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 4][player.corX - 4], "drawable", getPackageName());
            im9_1.setImageResource(resId);
        }
        if (player.corY + 4 > 31 || player.corX - 3 < 0)
            im9_2.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 4][player.corX - 3], "drawable", getPackageName());
            im9_2.setImageResource(resId);
        }
        if (player.corY + 4 > 31 || player.corX - 2 < 0)
            im9_3.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 4][player.corX - 2], "drawable", getPackageName());
            im9_3.setImageResource(resId);
        }
        if (player.corY + 4 > 31 || player.corX - 1 < 0)
            im9_4.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 4][player.corX - 1], "drawable", getPackageName());
            im9_4.setImageResource(resId);
        }
        if (player.corY + 4 > 31)
            im9_5.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 4][player.corX], "drawable", getPackageName());
            im9_5.setImageResource(resId);
        }
        if (player.corY + 4 > 31 || player.corX + 1 >= map[0].length)
            im9_6.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 4][player.corX + 1], "drawable", getPackageName());
            im9_6.setImageResource(resId);
        }
        if (player.corY + 4 > 31 || player.corX + 2 >= map[0].length)
            im9_7.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 4][player.corX + 2], "drawable", getPackageName());
            im9_7.setImageResource(resId);
        }
        if (player.corY + 4 > 31 || player.corX + 3 >= map[0].length)
            im9_8.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 4][player.corX + 3], "drawable", getPackageName());
            im9_8.setImageResource(resId);
        }
        if (player.corY + 4 > 31 || player.corX + 4 >= map[0].length)
            im9_9.setImageResource(R.drawable.empty_tile);
        else {
            resId = getResources().getIdentifier(map[player.corY + 4][player.corX + 4], "drawable", getPackageName());
            im9_9.setImageResource(resId);
        }

    }

    public void mapDrawEmptyScreen()
    {
        /*ImageView im1_1 = (ImageView) findViewById(R.id.mapDrawImage1_1);
        ImageView im1_2 = (ImageView) findViewById(R.id.mapDrawImage1_2);
        ImageView im1_3 = (ImageView) findViewById(R.id.mapDrawImage1_3);
        ImageView im1_4 = (ImageView) findViewById(R.id.mapDrawImage1_4);
        ImageView im1_5 = (ImageView) findViewById(R.id.mapDrawImage1_5);
        ImageView im1_6 = (ImageView) findViewById(R.id.mapDrawImage1_6);
        ImageView im1_7 = (ImageView) findViewById(R.id.mapDrawImage1_7);
        ImageView im1_8 = (ImageView) findViewById(R.id.mapDrawImage1_8);
        ImageView im1_9 = (ImageView) findViewById(R.id.mapDrawImage1_9);

        ImageView im2_1 = (ImageView) findViewById(R.id.mapDrawImage2_1);
        ImageView im2_2 = (ImageView) findViewById(R.id.mapDrawImage2_2);
        ImageView im2_3 = (ImageView) findViewById(R.id.mapDrawImage2_3);
        ImageView im2_4 = (ImageView) findViewById(R.id.mapDrawImage2_4);
        ImageView im2_5 = (ImageView) findViewById(R.id.mapDrawImage2_5);
        ImageView im2_6 = (ImageView) findViewById(R.id.mapDrawImage2_6);
        ImageView im2_7 = (ImageView) findViewById(R.id.mapDrawImage2_7);
        ImageView im2_8 = (ImageView) findViewById(R.id.mapDrawImage2_8);
        ImageView im2_9 = (ImageView) findViewById(R.id.mapDrawImage2_9);

        ImageView im3_1 = (ImageView) findViewById(R.id.mapDrawImage3_1);
        ImageView im3_2 = (ImageView) findViewById(R.id.mapDrawImage3_2);
        ImageView im3_3 = (ImageView) findViewById(R.id.mapDrawImage3_3);
        ImageView im3_4 = (ImageView) findViewById(R.id.mapDrawImage3_4);
        ImageView im3_5 = (ImageView) findViewById(R.id.mapDrawImage3_5);
        ImageView im3_6 = (ImageView) findViewById(R.id.mapDrawImage3_6);
        ImageView im3_7 = (ImageView) findViewById(R.id.mapDrawImage3_7);
        ImageView im3_8 = (ImageView) findViewById(R.id.mapDrawImage3_8);
        ImageView im3_9 = (ImageView) findViewById(R.id.mapDrawImage3_9);

        ImageView im4_1 = (ImageView) findViewById(R.id.mapDrawImage4_1);
        ImageView im4_2 = (ImageView) findViewById(R.id.mapDrawImage4_2);
        ImageView im4_3 = (ImageView) findViewById(R.id.mapDrawImage4_3);
        ImageView im4_4 = (ImageView) findViewById(R.id.mapDrawImage4_4);
        ImageView im4_5 = (ImageView) findViewById(R.id.mapDrawImage4_5);
        ImageView im4_6 = (ImageView) findViewById(R.id.mapDrawImage4_6);
        ImageView im4_7 = (ImageView) findViewById(R.id.mapDrawImage4_7);
        ImageView im4_8 = (ImageView) findViewById(R.id.mapDrawImage4_8);
        ImageView im4_9 = (ImageView) findViewById(R.id.mapDrawImage4_9);

        ImageView im5_1 = (ImageView) findViewById(R.id.mapDrawImage5_1);
        ImageView im5_2 = (ImageView) findViewById(R.id.mapDrawImage5_2);
        ImageView im5_3 = (ImageView) findViewById(R.id.mapDrawImage5_3);
        ImageView im5_4 = (ImageView) findViewById(R.id.mapDrawImage5_4);
        ImageView im5_5 = (ImageView) findViewById(R.id.mapDrawImage5_5);
        ImageView im5_6 = (ImageView) findViewById(R.id.mapDrawImage5_6);
        ImageView im5_7 = (ImageView) findViewById(R.id.mapDrawImage5_7);
        ImageView im5_8 = (ImageView) findViewById(R.id.mapDrawImage5_8);
        ImageView im5_9 = (ImageView) findViewById(R.id.mapDrawImage5_9);

        ImageView im6_1 = (ImageView) findViewById(R.id.mapDrawImage6_1);
        ImageView im6_2 = (ImageView) findViewById(R.id.mapDrawImage6_2);
        ImageView im6_3 = (ImageView) findViewById(R.id.mapDrawImage6_3);
        ImageView im6_4 = (ImageView) findViewById(R.id.mapDrawImage6_4);
        ImageView im6_5 = (ImageView) findViewById(R.id.mapDrawImage6_5);
        ImageView im6_6 = (ImageView) findViewById(R.id.mapDrawImage6_6);
        ImageView im6_7 = (ImageView) findViewById(R.id.mapDrawImage6_7);
        ImageView im6_8 = (ImageView) findViewById(R.id.mapDrawImage6_8);
        ImageView im6_9 = (ImageView) findViewById(R.id.mapDrawImage6_9);

        ImageView im7_1 = (ImageView) findViewById(R.id.mapDrawImage7_1);
        ImageView im7_2 = (ImageView) findViewById(R.id.mapDrawImage7_2);
        ImageView im7_3 = (ImageView) findViewById(R.id.mapDrawImage7_3);
        ImageView im7_4 = (ImageView) findViewById(R.id.mapDrawImage7_4);
        ImageView im7_5 = (ImageView) findViewById(R.id.mapDrawImage7_5);
        ImageView im7_6 = (ImageView) findViewById(R.id.mapDrawImage7_6);
        ImageView im7_7 = (ImageView) findViewById(R.id.mapDrawImage7_7);
        ImageView im7_8 = (ImageView) findViewById(R.id.mapDrawImage7_8);
        ImageView im7_9 = (ImageView) findViewById(R.id.mapDrawImage7_9);

        ImageView im8_1 = (ImageView) findViewById(R.id.mapDrawImage8_1);
        ImageView im8_2 = (ImageView) findViewById(R.id.mapDrawImage8_2);
        ImageView im8_3 = (ImageView) findViewById(R.id.mapDrawImage8_3);
        ImageView im8_4 = (ImageView) findViewById(R.id.mapDrawImage8_4);
        ImageView im8_5 = (ImageView) findViewById(R.id.mapDrawImage8_5);
        ImageView im8_6 = (ImageView) findViewById(R.id.mapDrawImage8_6);
        ImageView im8_7 = (ImageView) findViewById(R.id.mapDrawImage8_7);
        ImageView im8_8 = (ImageView) findViewById(R.id.mapDrawImage8_8);
        ImageView im8_9 = (ImageView) findViewById(R.id.mapDrawImage8_9);

        ImageView im9_1 = (ImageView) findViewById(R.id.mapDrawImage9_1);
        ImageView im9_2 = (ImageView) findViewById(R.id.mapDrawImage9_2);
        ImageView im9_3 = (ImageView) findViewById(R.id.mapDrawImage9_3);
        ImageView im9_4 = (ImageView) findViewById(R.id.mapDrawImage9_4);
        ImageView im9_5 = (ImageView) findViewById(R.id.mapDrawImage9_5);
        ImageView im9_6 = (ImageView) findViewById(R.id.mapDrawImage9_6);
        ImageView im9_7 = (ImageView) findViewById(R.id.mapDrawImage9_7);
        ImageView im9_8 = (ImageView) findViewById(R.id.mapDrawImage9_8);
        ImageView im9_9 = (ImageView) findViewById(R.id.mapDrawImage9_9);*/
    }

    public void peshkaSukaMove()
    {
        computeFlowField(map, player.corX, player.corY, 1);

        int negr = getDirection(peshka.corX, peshka.corY);

        if (negr == 1)
        {
            peshka.helper1 = peshka.helper2;
            peshka.helper2 = map[peshka.corY - 1][peshka.corX];
            map[peshka.corY][peshka.corX] = peshka.helper1;
            peshka.corY -= 1;
            map[peshka.corY][peshka.corX] = "peshka_tile";
        }

        else if (negr == 3)
        {
            peshka.helper1 = peshka.helper2;
            peshka.helper2 = map[peshka.corY][peshka.corX + 1];
            map[peshka.corY][peshka.corX] = peshka.helper1;
            peshka.corX += 1;
            map[peshka.corY][peshka.corX] = "peshka_tile";
        }

        else if (negr == 5)
        {
            peshka.helper1 = peshka.helper2;
            peshka.helper2 = map[peshka.corY + 1][peshka.corX];
            map[peshka.corY][peshka.corX] = peshka.helper1;
            peshka.corY += 1;
            map[peshka.corY][peshka.corX] = "peshka_tile";
        }

        else if (negr == 7)
        {
            peshka.helper1 = peshka.helper2;
            peshka.helper2 = map[peshka.corY][peshka.corX - 1];
            map[peshka.corY][peshka.corX] = peshka.helper1;
            peshka.corX -= 1;
            map[peshka.corY][peshka.corX] = "peshka_tile";
        }

        else if (negr == 9)
        {
            int negrM = rand.nextInt(4) + 1;

            if (negrM == 1 && map[peshka.corY - 1][peshka.corX].equals("empty_tile"))
            {
                peshka.helper1 = peshka.helper2;
                peshka.helper2 = map[peshka.corY - 1][peshka.corX];
                map[peshka.corY][peshka.corX] = peshka.helper1;
                peshka.corY -= 1;
                map[peshka.corY][peshka.corX] = "peshka_tile";
            }

            else if (negrM == 2 && map[peshka.corY][peshka.corX + 1].equals("empty_tile"))
            {
                peshka.helper1 = peshka.helper2;
                peshka.helper2 = map[peshka.corY][peshka.corX + 1];
                map[peshka.corY][peshka.corX] = peshka.helper1;
                peshka.corX += 1;
                map[peshka.corY][peshka.corX] = "peshka_tile";
            }

            else if (negrM == 3 && map[peshka.corY + 1][peshka.corX].equals("empty_tile"))
            {
                peshka.helper1 = peshka.helper2;
                peshka.helper2 = map[peshka.corY + 1][peshka.corX];
                map[peshka.corY][peshka.corX] = peshka.helper1;
                peshka.corY += 1;
                map[peshka.corY][peshka.corX] = "peshka_tile";
            }

            else if (negrM == 4 && map[peshka.corY][peshka.corX - 1].equals("empty_tile"))
            {
                peshka.helper1 = peshka.helper2;
                peshka.helper2 = map[peshka.corY][peshka.corX - 1];
                map[peshka.corY][peshka.corX] = peshka.helper1;
                peshka.corX -= 1;
                map[peshka.corY][peshka.corX] = "peshka_tile";
            }

        }
    }

    public void slonMove()
    {
        computeFlowField(map, player.corX, player.corY, 2);

        int negr = getDirection(slon.corX, slon.corY);

        if (negr == 2)
        {
            slon.helper1 = slon.helper2;
            slon.helper2 = map[slon.corY - 1][slon.corX + 1];
            map[slon.corY][slon.corX] = slon.helper1;
            slon.corY -= 1;
            slon.corX += 1;
            map[slon.corY][slon.corX] = "slon_tile";
        }

        else if (negr == 4)
        {
            slon.helper1 = slon.helper2;
            slon.helper2 = map[slon.corY + 1][slon.corX + 1];
            map[slon.corY][slon.corX] = slon.helper1;
            slon.corY += 1;
            slon.corX += 1;
            map[slon.corY][slon.corX] = "slon_tile";
        }

        else if (negr == 6)
        {
            slon.helper1 = slon.helper2;
            slon.helper2 = map[slon.corY + 1][slon.corX - 1];
            map[slon.corY][slon.corX] = slon.helper1;
            slon.corY += 1;
            slon.corX -= 1;
            map[slon.corY][slon.corX] = "slon_tile";
        }

        else if (negr == 8)
        {
            slon.helper1 = slon.helper2;
            slon.helper2 = map[slon.corY - 1][slon.corX - 1];
            map[slon.corY][slon.corX] = slon.helper1;
            slon.corY -= 1;
            slon.corX -= 1;
            map[slon.corY][slon.corX] = "slon_tile";
        }

        else if(negr == 9)
        {
            int negrM = rand.nextInt(4) + 1;

            if (negrM == 1 && map[slon.corY - 1][slon.corX + 1].equals("empty_tile"))
            {
                slon.helper1 = slon.helper2;
                slon.helper2 = map[slon.corY - 1][slon.corX + 1];
                map[slon.corY][slon.corX] = slon.helper1;
                slon.corY -= 1;
                slon.corX += 1;
                map[slon.corY][slon.corX] = "slon_tile";
            }

            else if (negrM == 2 && map[slon.corY + 1][slon.corX + 1].equals("empty_tile"))
            {
                slon.helper1 = slon.helper2;
                slon.helper2 = map[slon.corY + 1][slon.corX + 1];
                map[slon.corY][slon.corX] = slon.helper1;
                slon.corY += 1;
                slon.corX += 1;
                map[slon.corY][slon.corX] = "slon_tile";
            }

            else if (negrM == 3 && map[slon.corY + 1][slon.corX - 1].equals("empty_tile"))
            {
                slon.helper1 = slon.helper2;
                slon.helper2 = map[slon.corY + 1][slon.corX - 1];
                map[slon.corY][slon.corX] = slon.helper1;
                slon.corY += 1;
                slon.corX -= 1;
                map[slon.corY][slon.corX] = "slon_tile";
            }

            else if (negrM == 4 && map[slon.corY - 1][slon.corX - 1].equals("empty_tile"))
            {
                slon.helper1 = slon.helper2;
                slon.helper2 = map[slon.corY - 1][slon.corX - 1];
                map[slon.corY][slon.corX] = slon.helper1;
                slon.corY -= 1;
                slon.corX -= 1;
                map[slon.corY][slon.corX] = "slon_tile";
            }
        }
    }

    public void sKorolMove()
    {
        int r = rand.nextInt(9) + 1;

        if (sKorol.corY - 1 == player.corY)
            r = 1;

        if (sKorol.corY - 1 == player.corY && sKorol.corX + 1 == player.corX)
            r = 2;

        if (sKorol.corX + 1 == player.corX)
            r = 3;

        if (sKorol.corY + 1 == player.corY && sKorol.corX + 1 == player.corX)
            r = 4;

        if (sKorol.corY + 1 == player.corY)
            r = 5;

        if (sKorol.corY + 1 == player.corY && sKorol.corX - 1 == player.corX)
            r = 6;

        if (sKorol.corX - 1 == player.corX)
            r = 7;

        if (sKorol.corY - 1 == player.corY && sKorol.corX - 1 == player.corX)
            r = 8;

        if (r == 1)
        {
            if (!map[sKorol.corY - 1][sKorol.corX].equals("wall_tile"))
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY - 1][sKorol.corX];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corY -= 1;
                map[sKorol.corY][sKorol.corX] = "sking_tile";
            }
        }

        else if (r == 2)
        {
            if(!map[sKorol.corY - 1][sKorol.corX + 1].equals("wall_tile"))
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY - 1][sKorol.corX + 1];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corY -= 1;
                sKorol.corX += 1;
                map[sKorol.corY][sKorol.corX] = "sking_tile";
            }
        }

        else if (r == 3)
        {
            if(!map[sKorol.corY][sKorol.corX + 1].equals("wall_tile"))
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY][sKorol.corX + 1];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corX += 1;
                map[sKorol.corY][sKorol.corX] = "sking_tile";
            }
        }

        else if (r == 4)
        {
            if(!map[sKorol.corY + 1][sKorol.corX + 1].equals("wall_tile"))
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY + 1][sKorol.corX + 1];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corY += 1;
                sKorol.corX += 1;
                map[sKorol.corY][sKorol.corX] = "sking_tile";
            }
        }

        else if (r == 5)
        {
            if (!map[sKorol.corY + 1][sKorol.corX].equals("wall_tile"))
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY + 1][sKorol.corX];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corY += 1;
                map[sKorol.corY][sKorol.corX] = "sking_tile";
            }
        }

        else if (r == 6)
        {
            if (!map[sKorol.corY + 1][sKorol.corX - 1].equals("wall_tile"))
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY + 1][sKorol.corX - 1];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corY += 1;
                sKorol.corX -= 1;
                map[sKorol.corY][sKorol.corX] = "sking_tile";
            }
        }

        else if (r == 7)
        {
            if (!map[sKorol.corY][sKorol.corX - 1].equals("wall_tile"))
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY][sKorol.corX - 1];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corX -= 1;
                map[sKorol.corY][sKorol.corX] = "sking_tile";
            }
        }

        else if (r == 8)
        {
            if(!map[sKorol.corY - 1][sKorol.corX - 1].equals("wall_tile"))
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY - 1][sKorol.corX - 1];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corY -= 1;
                sKorol.corX -= 1;
                map[sKorol.corY][sKorol.corX] = "sking_tile";
            }
        }
    }

    public void medvedMove()
    {
        if (playerMoveRem == 1)
        {
            if (!map[medved.corY - 1][medved.corX].equals("wall_tile"))
            {
                medved.helper1 = medved.helper2;
                medved.helper2 = map[medved.corY - 1][medved.corX];
                map[medved.corY][medved.corX] = medved.helper1;
                medved.corY -= 1;
                map[medved.corY][medved.corX] = "medved_tile";
            }
        }

        else if (playerMoveRem == 2)
        {
            if(!map[medved.corY - 1][medved.corX + 1].equals("wall_tile"))
            {
                medved.helper1 = medved.helper2;
                medved.helper2 = map[medved.corY - 1][medved.corX + 1];
                map[medved.corY][medved.corX] = medved.helper1;
                medved.corY -= 1;
                medved.corX += 1;
                map[medved.corY][medved.corX] = "medved_tile";
            }
        }

        else if (playerMoveRem == 3)
        {
            if(!map[medved.corY][medved.corX + 1].equals("wall_tile"))
            {
                medved.helper1 = medved.helper2;
                medved.helper2 = map[medved.corY][medved.corX + 1];
                map[medved.corY][medved.corX] = medved.helper1;
                medved.corX += 1;
                map[medved.corY][medved.corX] = "medved_tile";
            }
        }

        else if (playerMoveRem == 4)
        {
            if(!map[medved.corY + 1][medved.corX + 1].equals("wall_tile"))
            {
                medved.helper1 = medved.helper2;
                medved.helper2 = map[medved.corY + 1][medved.corX + 1];
                map[medved.corY][medved.corX] = medved.helper1;
                medved.corY += 1;
                medved.corX += 1;
                map[medved.corY][medved.corX] = "medved_tile";
            }
        }

        else if (playerMoveRem == 5)
        {
            if (!map[medved.corY + 1][medved.corX].equals("wall_tile"))
            {
                medved.helper1 = medved.helper2;
                medved.helper2 = map[medved.corY + 1][medved.corX];
                map[medved.corY][medved.corX] = medved.helper1;
                medved.corY += 1;
                map[medved.corY][medved.corX] = "medved_tile";
            }
        }

        else if (playerMoveRem == 6)
        {
            if (!map[medved.corY + 1][medved.corX - 1].equals("wall_tile"))
            {
                medved.helper1 = medved.helper2;
                medved.helper2 = map[medved.corY + 1][medved.corX - 1];
                map[medved.corY][medved.corX] = medved.helper1;
                medved.corY += 1;
                medved.corX -= 1;
                map[medved.corY][medved.corX] = "medved_tile";
            }
        }

        else if (playerMoveRem == 7)
        {
            if (!map[medved.corY][medved.corX - 1].equals("wall_tile"))
            {
                medved.helper1 = medved.helper2;
                medved.helper2 = map[medved.corY][medved.corX - 1];
                map[medved.corY][medved.corX] = medved.helper1;
                medved.corX -= 1;
                map[medved.corY][medved.corX] = "medved_tile";
            }
        }

        else if (playerMoveRem == 8)
        {
            if(!map[medved.corY - 1][medved.corX - 1].equals("wall_tile"))
            {
                medved.helper1 = medved.helper2;
                medved.helper2 = map[medved.corY - 1][medved.corX - 1];
                map[medved.corY][medved.corX] = medved.helper1;
                medved.corY -= 1;
                medved.corX -= 1;
                map[medved.corY][medved.corX] = "medved_tile";
            }
        }

        else if (playerMoveRem == 9)
        {
            int rar = rand.nextInt(9) + 1;

            if (rar == 1)
            {
                if (!map[medved.corY - 1][medved.corX].equals("wall_tile"))
                {
                    medved.helper1 = medved.helper2;
                    medved.helper2 = map[medved.corY - 1][medved.corX];
                    map[medved.corY][medved.corX] = medved.helper1;
                    medved.corY -= 1;
                    map[medved.corY][medved.corX] = "medved_tile";
                }
            }

            else if (rar == 2)
            {
                if(!map[medved.corY - 1][medved.corX + 1].equals("wall_tile"))
                {
                    medved.helper1 = medved.helper2;
                    medved.helper2 = map[medved.corY - 1][medved.corX + 1];
                    map[medved.corY][medved.corX] = medved.helper1;
                    medved.corY -= 1;
                    medved.corX += 1;
                    map[medved.corY][medved.corX] = "medved_tile";
                }
            }

            else if (rar == 3)
            {
                if(!map[medved.corY][medved.corX + 1].equals("wall_tile"))
                {
                    medved.helper1 = medved.helper2;
                    medved.helper2 = map[medved.corY][medved.corX + 1];
                    map[medved.corY][medved.corX] = medved.helper1;
                    medved.corX += 1;
                    map[medved.corY][medved.corX] = "medved_tile";
                }
            }

            else if (rar == 4)
            {
                if(!map[medved.corY + 1][medved.corX + 1].equals("wall_tile"))
                {
                    medved.helper1 = medved.helper2;
                    medved.helper2 = map[medved.corY + 1][medved.corX + 1];
                    map[medved.corY][medved.corX] = medved.helper1;
                    medved.corY += 1;
                    medved.corX += 1;
                    map[medved.corY][medved.corX] = "medved_tile";
                }
            }

            else if (rar == 5)
            {
                if (!map[medved.corY + 1][medved.corX].equals("wall_tile"))
                {
                    medved.helper1 = medved.helper2;
                    medved.helper2 = map[medved.corY + 1][medved.corX];
                    map[medved.corY][medved.corX] = medved.helper1;
                    medved.corY += 1;
                    map[medved.corY][medved.corX] = "medved_tile";
                }
            }

            else if (rar == 6)
            {
                if (!map[medved.corY + 1][medved.corX - 1].equals("wall_tile"))
                {
                    medved.helper1 = medved.helper2;
                    medved.helper2 = map[medved.corY + 1][medved.corX - 1];
                    map[medved.corY][medved.corX] = medved.helper1;
                    medved.corY += 1;
                    medved.corX -= 1;
                    map[medved.corY][medved.corX] = "medved_tile";
                }
            }

            else if (rar == 7)
            {
                if (!map[medved.corY][medved.corX - 1].equals("wall_tile"))
                {
                    medved.helper1 = medved.helper2;
                    medved.helper2 = map[medved.corY][medved.corX - 1];
                    map[medved.corY][medved.corX] = medved.helper1;
                    medved.corX -= 1;
                    map[medved.corY][medved.corX] = "medved_tile";
                }
            }

            else if (rar == 8)
            {
                if(!map[medved.corY - 1][medved.corX - 1].equals("wall_tile"))
                {
                    medved.helper1 = medved.helper2;
                    medved.helper2 = map[medved.corY - 1][medved.corX - 1];
                    map[medved.corY][medved.corX] = medved.helper1;
                    medved.corY -= 1;
                    medved.corX -= 1;
                    map[medved.corY][medved.corX] = "medved_tile";
                }
            }
        }
    }

    public void bolshojMove()
    {
        int negr = 9;
        int needMove = 1;

        if (bolshoj.corY - player.corY < 2 && bolshoj.corX - player.corX < 2 && bolshoj.corY - player.corY > -2 && bolshoj.corX - player.corX > -2)
        {
            negr = 9;

            needMove = 0;
        }

        else
        {
            computeFlowField(map, player.corX, player.corY, 1);
            negr = getDirection(bolshoj.corX, bolshoj.corY);

            if (player.corY - 1 == bolshoj.corY || (player.corY + 1) == bolshoj.corY && player.corX < bolshoj.corX)
                negr = 7;

            else if (player.corY - 1 == bolshoj.corY || (player.corY + 1) == bolshoj.corY && player.corX > bolshoj.corX)
                negr = 3;

            needMove = 0;
        }

        if (negr == 1)
        {
            bolshoj.helper1 = bolshoj.helper2;
            bolshoj.helper2 = map[bolshoj.corY - 2][bolshoj.corX];
            map[bolshoj.corY][bolshoj.corX] = bolshoj.helper1;
            bolshoj.corY -= 2;
            map[bolshoj.corY][bolshoj.corX] = "bolshoj_b_tile";
        }

        if (negr == 5)
        {
            bolshoj.helper1 = bolshoj.helper2;
            bolshoj.helper2 = map[bolshoj.corY + 2][bolshoj.corX];
            map[bolshoj.corY][bolshoj.corX] = bolshoj.helper1;
            bolshoj.corY += 2;
            map[bolshoj.corY][bolshoj.corX] = "bolshoj_b_tile";
        }

        if (negr == 3)
        {
            bolshoj.helper1 = bolshoj.helper2;
            bolshoj.helper2 = map[bolshoj.corY][bolshoj.corX + 2];
            map[bolshoj.corY][bolshoj.corX] = bolshoj.helper1;
            bolshoj.corX += 2;
            map[bolshoj.corY][bolshoj.corX] = "bolshoj_b_tile";
        }

        if (negr == 7)
        {
            bolshoj.helper1 = bolshoj.helper2;
            bolshoj.helper2 = map[bolshoj.corY][bolshoj.corX - 2];
            map[bolshoj.corY][bolshoj.corX] = bolshoj.helper1;
            bolshoj.corX -= 2;
            map[bolshoj.corY][bolshoj.corX] = "bolshoj_b_tile";
        }

        else if (negr == 9)
        {
            int negrM = 0;

            if (player.corY < bolshoj.corY && needMove == 1)
                negrM = 1;

            if (player.corY > bolshoj.corY && needMove == 1)
                negrM = 5;

            if (negrM == 1 && needMove == 1)
            {
                if ((player.corY + 1) == bolshoj.corY && player.corX < bolshoj.corX)
                    negrM = 7;

                else if ((player.corY + 1) == bolshoj.corY && player.corX > bolshoj.corX)
                    negrM = 3;

                else
                {
                    bolshoj.helper1 = bolshoj.helper2;
                    bolshoj.helper2 = map[bolshoj.corY - 2][bolshoj.corX];
                    map[bolshoj.corY][bolshoj.corX] = bolshoj.helper1;
                    bolshoj.corY -= 2;
                    map[bolshoj.corY][bolshoj.corX] = "bolshoj_b_tile";
                }
            }

            if (negrM == 5 && needMove == 1)
            {
                if ((player.corY - 1) == bolshoj.corY && player.corX < bolshoj.corX)
                    negrM = 7;

                else if ((player.corY - 1) == bolshoj.corY && player.corX > bolshoj.corX)
                    negrM = 3;

                else
                {
                    bolshoj.helper1 = bolshoj.helper2;
                    bolshoj.helper2 = map[bolshoj.corY + 2][bolshoj.corX];
                    map[bolshoj.corY][bolshoj.corX] = bolshoj.helper1;
                    bolshoj.corY += 2;
                    map[bolshoj.corY][bolshoj.corX] = "bolshoj_b_tile";
                }
            }

            if (negrM == 3 && needMove == 1)
            {
                bolshoj.helper1 = bolshoj.helper2;
                bolshoj.helper2 = map[bolshoj.corY][bolshoj.corX + 2];
                map[bolshoj.corY][bolshoj.corX] = bolshoj.helper1;
                bolshoj.corX += 2;
                map[bolshoj.corY][bolshoj.corX] = "bolshoj_b_tile";
            }

            if (negrM == 7 && needMove == 1)
            {
                bolshoj.helper1 = bolshoj.helper2;
                bolshoj.helper2 = map[bolshoj.corY][bolshoj.corX - 2];
                map[bolshoj.corY][bolshoj.corX] = bolshoj.helper1;
                bolshoj.corX -= 2;
                map[bolshoj.corY][bolshoj.corX] = "bolshoj_b_tile";
            }
        }
    }

    public void playerMove (int a)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);

        String b = settings.getString("difficulty", "");

        int moveCheck = 0;

        if (a == 1)
        {
            if (!map[player.corY - 1][player.corX].equals("wall_tile"))
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY - 1][player.corX];
                map[player.corY][player.corX] = player.helper1;
                player.corY -= 1;
                map[player.corY][player.corX] = "player_tile";

                moveCheck = 1;

                playerMoveRem = 1;
            }
        }

        else if (a == 2)
        {
            if(!map[player.corY - 1][player.corX + 1].equals("wall_tile"))
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY - 1][player.corX + 1];
                map[player.corY][player.corX] = player.helper1;
                player.corY -= 1;
                player.corX += 1;
                map[player.corY][player.corX] = "player_tile";

                moveCheck = 1;

                playerMoveRem = 2;
            }
        }

        else if (a == 3)
        {
            if(!map[player.corY][player.corX + 1].equals("wall_tile"))
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY][player.corX + 1];
                map[player.corY][player.corX] = player.helper1;
                player.corX += 1;
                map[player.corY][player.corX] = "player_tile";

                moveCheck = 1;

                playerMoveRem = 3;
            }
        }

        else if (a == 4)
        {
            if(!map[player.corY + 1][player.corX + 1].equals("wall_tile"))
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY + 1][player.corX + 1];
                map[player.corY][player.corX] = player.helper1;
                player.corY += 1;
                player.corX += 1;
                map[player.corY][player.corX] = "player_tile";

                moveCheck = 1;

                playerMoveRem = 4;
            }
        }

        else if (a == 5)
        {
            if (!map[player.corY + 1][player.corX].equals("wall_tile"))
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY + 1][player.corX];
                map[player.corY][player.corX] = player.helper1;
                player.corY += 1;
                map[player.corY][player.corX] = "player_tile";

                moveCheck = 1;

                playerMoveRem = 5;
            }
        }

        else if (a == 6)
        {
            if (!map[player.corY + 1][player.corX - 1].equals("wall_tile"))
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY + 1][player.corX - 1];
                map[player.corY][player.corX] = player.helper1;
                player.corY += 1;
                player.corX -= 1;
                map[player.corY][player.corX] = "player_tile";

                moveCheck = 1;

                playerMoveRem = 6;
            }
        }

        else if (a == 7)
        {
            if (!map[player.corY][player.corX - 1].equals("wall_tile"))
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY][player.corX - 1];
                map[player.corY][player.corX] = player.helper1;
                player.corX -= 1;
                map[player.corY][player.corX] = "player_tile";

                moveCheck = 1;

                playerMoveRem = 7;
            }
        }

        else if (a == 8)
        {
            if(!map[player.corY - 1][player.corX - 1].equals("wall_tile"))
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY - 1][player.corX - 1];
                map[player.corY][player.corX] = player.helper1;
                player.corY -= 1;
                player.corX -= 1;
                map[player.corY][player.corX] = "player_tile";

                moveCheck = 1;

                playerMoveRem = 8;
            }
        }

        else if (a == 9)
        {
            moveCheck = 1;

            playerMoveRem = 9;
        }

        if (player.corY == lever.corY && player.corX == lever.corX)
            opengate = 1;

        if (moveCheck == 1)
        {
            if (peshka.isHere)
                peshkaSukaMove();

            if (slon.isHere)
                slonMove();

            if (sKorol.isHere)
                sKorolMove();

            if(medved.isHere)
                medvedMove();

            if (bolshoj.isHere)
                bolshojMove();

            gameLifeCheck(player.helper2);

            if (b.equals("easy") || b.equals("hard") || a == 9)
            {
                mapDrawScreen();
            }

            else
            {
                mapDrawScreen();
            }
        }
    }
}