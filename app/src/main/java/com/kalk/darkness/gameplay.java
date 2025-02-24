package com.kalk.darkness;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class gameplay extends map_generator
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);
        gameplayInit();
    }

    int opengate = 0;
    double score = 1;
    public static int gameIn = 0;
    static public int[][] map = new int[32][32];

    public void gameplayInit()
    {
        TextView scores = (TextView) findViewById(R.id.scoreText);

        if (gameIn == 0)
        {
            player.helper1 = 0;
            player.helper2 = 0;
            peshka.helper1 = 0;
            peshka.helper2 = 0;
            slon.helper1 = 0;
            slon.helper2 = 0;
            sKorol.helper1 = 0;
            sKorol.helper2 = 0;
            gameIn = 1;
            opengate = 0;

            map = map_generator.mapThrower(score);

            scores.setText("Score: " + score);
        }
    }

    public void gameLifeCheck(int a)
    {
        if(opengate == 1)
        {
            if (a == 31)
            {
                gameIn = 0;
                opengate = 0;
                score++;
                gameplayInit();
                mapDrawEmptyScreen();
            }
        }

        if (a == 33)
        {
            gameIn = 0;
            opengate = 0;
            score += 0.25;
            gameplayInit();
            mapDrawEmptyScreen();
        }

        if (peshka.corX == player.corX && peshka.corY == player.corY)
        {
            gameIn = 0;
            score = 0;
            Intent pip = new Intent(this, death_screen.class);
            startActivity(pip);
        }

        if (slon.corX == player.corX && slon.corY == player.corY)
        {
            gameIn = 0;
            score = 0;
            Intent pip = new Intent(this, death_screen.class);
            startActivity(pip);
        }

        if (sKorol.corX == player.corX && sKorol.corY == player.corY)
        {
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
        if (map[player.corY - 2][player.corX - 2] < 11) {
            im1_1.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY - 2][player.corX - 2] < 21) {
            im1_1.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY - 2][player.corX - 2] == 21) {
            im1_1.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY - 2][player.corX - 2] == 22) {
            im1_1.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY - 2][player.corX - 2] == 23) {
            im1_1.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY - 2][player.corX - 2] == 24) {
            im1_1.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY - 2][player.corX - 2] == 31) {
            im1_1.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY - 2][player.corX - 2] == 32) {
            im1_1.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY - 2][player.corX - 2] == 33) {
            im1_1.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY - 2][player.corX - 1] < 11) {
            im1_2.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY - 2][player.corX - 1] < 21) {
            im1_2.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY - 2][player.corX - 1] == 21) {
            im1_2.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY - 2][player.corX - 1] == 22) {
            im1_2.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY - 2][player.corX - 1] == 23) {
            im1_2.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY - 2][player.corX - 1] == 24) {
            im1_2.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY - 2][player.corX - 1] == 31) {
            im1_2.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY - 2][player.corX - 1] == 32) {
            im1_2.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY - 2][player.corX - 1] == 33) {
            im1_2.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY - 2][player.corX] < 11) {
            im1_3.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY - 2][player.corX] < 21) {
            im1_3.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY - 2][player.corX] == 21) {
            im1_3.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY - 2][player.corX] == 22) {
            im1_3.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY - 2][player.corX] == 23) {
            im1_3.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY - 2][player.corX] == 24) {
            im1_3.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY - 2][player.corX] == 31) {
            im1_3.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY - 2][player.corX] == 32) {
            im1_3.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY - 2][player.corX] == 33) {
            im1_3.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY - 2][player.corX + 1] < 11) {
            im1_4.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY - 2][player.corX + 1] < 21) {
            im1_4.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY - 2][player.corX + 1] == 21) {
            im1_4.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY - 2][player.corX + 1] == 22) {
            im1_4.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY - 2][player.corX + 1] == 23) {
            im1_4.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY - 2][player.corX + 1] == 24) {
            im1_4.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY - 2][player.corX + 1] == 31) {
            im1_4.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY - 2][player.corX + 1] == 32) {
            im1_4.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY - 2][player.corX + 1] == 33) {
            im1_4.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY - 2][player.corX + 2] < 11) {
            im1_5.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY - 2][player.corX + 2] < 21) {
            im1_5.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY - 2][player.corX + 2] == 21) {
            im1_5.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY - 2][player.corX + 2] == 22) {
            im1_5.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY - 2][player.corX + 2] == 23) {
            im1_5.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY - 2][player.corX + 2] == 24) {
            im1_5.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY - 2][player.corX + 2] == 31) {
            im1_5.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY - 2][player.corX + 2] == 32) {
            im1_5.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY - 2][player.corX + 2] == 33) {
            im1_5.setImageResource(R.drawable.door_tile);
        }

//-------------------------------------------------------------------------Second layer

        if (map[player.corY - 1][player.corX - 2] < 11) {
            im2_1.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY - 1][player.corX - 2] < 21) {
            im2_1.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY - 1][player.corX - 2] == 21) {
            im2_1.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY - 1][player.corX - 2] == 22) {
            im2_1.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY - 1][player.corX - 2] == 23) {
            im2_1.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY - 1][player.corX - 2] == 24) {
            im2_1.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY - 1][player.corX - 2] == 31) {
            im2_1.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY - 1][player.corX - 2] == 32) {
            im2_1.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY - 1][player.corX - 2] == 33) {
            im2_1.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY - 1][player.corX - 1] < 11) {
            im2_2.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY - 1][player.corX - 1] < 21) {
            im2_2.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY - 1][player.corX - 1] == 21) {
            im2_2.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY - 1][player.corX - 1] == 22) {
            im2_2.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY - 1][player.corX - 1] == 23) {
            im2_2.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY - 1][player.corX - 1] == 24) {
            im2_2.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY - 1][player.corX - 1] == 31) {
            im2_2.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY - 1][player.corX - 1] == 32) {
            im2_2.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY - 1][player.corX - 1] == 33) {
            im2_2.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY - 1][player.corX] < 11) {
            im2_3.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY - 1][player.corX] < 21) {
            im2_3.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY - 1][player.corX] == 21) {
            im2_3.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY - 1][player.corX] == 22) {
            im2_3.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY - 1][player.corX] == 23) {
            im2_3.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY - 1][player.corX] == 24) {
            im2_3.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY - 1][player.corX] == 31) {
            im2_3.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY - 1][player.corX] == 32) {
            im2_3.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY - 1][player.corX] == 33) {
            im2_3.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY - 1][player.corX + 1] < 11) {
            im2_4.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY - 1][player.corX + 1] < 21) {
            im2_4.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY - 1][player.corX + 1] == 21) {
            im2_4.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY - 1][player.corX + 1] == 22) {
            im2_4.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY - 1][player.corX + 1] == 23) {
            im2_4.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY - 1][player.corX + 1] == 24) {
            im2_4.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY - 1][player.corX + 1] == 31) {
            im2_4.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY - 1][player.corX + 1] == 32) {
            im2_4.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY - 1][player.corX + 1] == 33) {
            im2_4.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY - 1][player.corX + 2] < 11) {
            im2_5.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY - 1][player.corX + 2] < 21) {
            im2_5.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY - 1][player.corX + 2] == 21) {
            im2_5.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY - 1][player.corX + 2] == 22) {
            im2_5.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY - 1][player.corX + 2] == 23) {
            im2_5.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY - 1][player.corX + 2] == 24) {
            im2_5.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY - 1][player.corX + 2] == 31) {
            im2_5.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY - 1][player.corX + 2] == 32) {
            im2_5.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY - 1][player.corX + 2] == 33) {
            im2_5.setImageResource(R.drawable.door_tile);
        }

//-------------------------------------------------------------------------Third layer

        if (map[player.corY][player.corX - 2] < 11) {
            im3_1.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY][player.corX - 2] < 21) {
            im3_1.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY][player.corX - 2] == 21) {
            im3_1.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY][player.corX - 2] == 22) {
            im3_1.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY][player.corX - 2] == 23) {
            im3_1.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY][player.corX - 2] == 24) {
            im3_1.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY][player.corX - 2] == 31) {
            im3_1.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY][player.corX - 2] == 32) {
            im3_1.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY][player.corX - 2] == 33) {
            im3_1.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY][player.corX - 1] < 11) {
            im3_2.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY][player.corX - 1] < 21) {
            im3_2.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY][player.corX - 1] == 21) {
            im3_2.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY][player.corX - 1] == 22) {
            im3_2.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY][player.corX - 1] == 23) {
            im3_2.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY][player.corX - 1] == 24) {
            im3_2.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY][player.corX - 1] == 31) {
            im3_2.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY][player.corX - 1] == 32) {
            im3_2.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY][player.corX - 1] == 33) {
            im3_2.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY][player.corX] < 11) {
            im3_3.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY][player.corX] < 21) {
            im3_3.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY][player.corX] == 21) {
            im3_3.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY][player.corX] == 22) {
            im3_3.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY][player.corX] == 23) {
            im3_3.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY][player.corX] == 24) {
            im3_3.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY][player.corX] == 31) {
            im3_3.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY][player.corX] == 32) {
            im3_3.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY][player.corX] == 33) {
            im3_3.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY][player.corX + 1] < 11) {
            im3_4.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY][player.corX + 1] < 21) {
            im3_4.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY][player.corX + 1] == 21) {
            im3_4.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY][player.corX + 1] == 22) {
            im3_4.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY][player.corX + 1] == 23) {
            im3_4.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY][player.corX + 1] == 24) {
            im3_4.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY][player.corX + 1] == 31) {
            im3_4.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY][player.corX + 1] == 32) {
            im3_4.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY][player.corX + 1] == 33) {
            im3_4.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY][player.corX + 2] < 11) {
            im3_5.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY][player.corX + 2] < 21) {
            im3_5.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY][player.corX + 2] == 21) {
            im3_5.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY][player.corX + 2] == 22) {
            im3_5.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY][player.corX + 2] == 23) {
            im3_5.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY][player.corX + 2] == 24) {
            im3_5.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY][player.corX + 2] == 31) {
            im3_5.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY][player.corX + 2] == 32) {
            im3_5.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY][player.corX + 2] == 33) {
            im3_5.setImageResource(R.drawable.door_tile);
        }

//-------------------------------------------------------------------------Fourth layer

        if (map[player.corY + 1][player.corX - 2] < 11) {
            im4_1.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY + 1][player.corX - 2] < 21) {
            im4_1.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY + 1][player.corX - 2] == 21) {
            im4_1.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY + 1][player.corX - 2] == 22) {
            im4_1.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY + 1][player.corX - 2] == 23) {
            im4_1.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY + 1][player.corX - 2] == 24) {
            im4_1.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY + 1][player.corX - 2] == 31) {
            im4_1.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY + 1][player.corX - 2] == 32) {
            im4_1.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY + 1][player.corX - 2] == 33) {
            im4_1.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY + 1][player.corX - 1] < 11) {
            im4_2.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY + 1][player.corX - 1] < 21) {
            im4_2.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY + 1][player.corX - 1] == 21) {
            im4_2.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY + 1][player.corX - 1] == 22) {
            im4_2.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY + 1][player.corX - 1] == 23) {
            im4_2.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY + 1][player.corX - 1] == 24) {
            im4_2.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY + 1][player.corX - 1] == 31) {
            im4_2.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY + 1][player.corX - 1] == 32) {
            im4_2.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY + 1][player.corX - 1] == 33) {
            im4_2.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY + 1][player.corX] < 11) {
            im4_3.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY + 1][player.corX] < 21) {
            im4_3.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY + 1][player.corX] == 21) {
            im4_3.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY + 1][player.corX] == 22) {
            im4_3.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY + 1][player.corX] == 23) {
            im4_3.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY + 1][player.corX] == 24) {
            im4_3.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY + 1][player.corX] == 31) {
            im4_3.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY + 1][player.corX] == 32) {
            im4_3.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY + 1][player.corX] == 33) {
            im4_3.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY + 1][player.corX + 1] < 11) {
            im4_4.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY + 1][player.corX + 1] < 21) {
            im4_4.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY + 1][player.corX + 1] == 21) {
            im4_4.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY + 1][player.corX + 1] == 22) {
            im4_4.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY + 1][player.corX + 1] == 23) {
            im4_4.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY + 1][player.corX + 1] == 24) {
            im4_4.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY + 1][player.corX + 1] == 31) {
            im4_4.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY + 1][player.corX + 1] == 32) {
            im4_4.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY + 1][player.corX + 1] == 33) {
            im4_4.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY + 1][player.corX + 2] < 11) {
            im4_5.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY + 1][player.corX + 2] < 21) {
            im4_5.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY + 1][player.corX + 2] == 21) {
            im4_5.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY + 1][player.corX + 2] == 22) {
            im4_5.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY + 1][player.corX + 2] == 23) {
            im4_5.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY + 1][player.corX + 2] == 24) {
            im4_5.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY + 1][player.corX + 2] == 31) {
            im4_5.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY + 1][player.corX + 2] == 32) {
            im4_5.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY + 1][player.corX + 2] == 33) {
            im4_5.setImageResource(R.drawable.door_tile);
        }

//-------------------------------------------------------------------------Fifth layer

        if (map[player.corY + 2][player.corX - 2] < 11) {
            im5_1.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY + 2][player.corX - 2] < 21) {
            im5_1.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY + 2][player.corX - 2] == 21) {
            im5_1.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY + 2][player.corX - 2] == 22) {
            im5_1.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY + 2][player.corX - 2] == 23) {
            im5_1.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY + 2][player.corX - 2] == 24) {
            im5_1.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY + 2][player.corX - 2] == 31) {
            im5_1.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY + 2][player.corX - 2] == 32) {
            im5_1.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY + 2][player.corX - 2] == 33) {
            im5_1.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY + 2][player.corX - 1] < 11) {
            im5_2.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY + 2][player.corX - 1] < 21) {
            im5_2.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY + 2][player.corX - 1] == 21) {
            im5_2.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY + 2][player.corX - 1] == 22) {
            im5_2.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY + 2][player.corX - 1] == 23) {
            im5_2.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY + 2][player.corX - 1] == 24) {
            im5_2.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY + 2][player.corX - 1] == 31) {
            im5_2.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY + 2][player.corX - 1] == 32) {
            im5_2.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY + 2][player.corX - 1] == 33) {
            im5_2.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY + 2][player.corX] < 11) {
            im5_3.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY + 2][player.corX] < 21) {
            im5_3.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY + 2][player.corX] == 21) {
            im5_3.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY + 2][player.corX] == 22) {
            im5_3.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY + 2][player.corX] == 23) {
            im5_3.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY + 2][player.corX] == 24) {
            im5_3.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY + 2][player.corX] == 31) {
            im5_3.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY + 2][player.corX] == 32) {
            im5_3.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY + 2][player.corX] == 33) {
            im5_3.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY + 2][player.corX + 1] < 11) {
            im5_4.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY + 2][player.corX + 1] < 21) {
            im5_4.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY + 2][player.corX + 1] == 21) {
            im5_4.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY + 2][player.corX + 1] == 22) {
            im5_4.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY + 2][player.corX + 1] == 23) {
            im5_4.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY + 2][player.corX + 1] == 24) {
            im5_4.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY + 2][player.corX + 1] == 31) {
            im5_4.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY + 2][player.corX + 1] == 32) {
            im5_4.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY + 2][player.corX + 1] == 33) {
            im5_4.setImageResource(R.drawable.door_tile);
        }

        if (map[player.corY + 2][player.corX + 2] < 11) {
            im5_5.setImageResource(R.drawable.empty_tile);
        }

        else if (map[player.corY + 2][player.corX + 2] < 21) {
            im5_5.setImageResource(R.drawable.wall_tile);
        }

        else if (map[player.corY + 2][player.corX + 2] == 21) {
            im5_5.setImageResource(R.drawable.player_tile);
        }

        else if (map[player.corY + 2][player.corX + 2] == 22) {
            im5_5.setImageResource(R.drawable.peshka_tile);
        }

        else if (map[player.corY + 2][player.corX + 2] == 23) {
            im5_5.setImageResource(R.drawable.slon_tile);
        }

        else if (map[player.corY + 2][player.corX + 2] == 24) {
            im5_5.setImageResource(R.drawable.sking_tile);
        }

        else if (map[player.corY + 2][player.corX + 2] == 31) {
            im5_5.setImageResource(R.drawable.extraction_tile);
        }

        else if (map[player.corY + 2][player.corX + 2] == 32) {
            im5_5.setImageResource(R.drawable.lever_tile);
        }

        else if (map[player.corY + 2][player.corX + 2] == 33) {
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
            peshka.helper2 = map[peshka.corY - 1][peshka.corX];
            map[peshka.corY][peshka.corX] = peshka.helper1;
            peshka.corY -= 1;
            map[peshka.corY][peshka.corX] = 22;
        }

        else if (negr == 3)
        {
            peshka.helper1 = peshka.helper2;
            peshka.helper2 = map[peshka.corY][peshka.corX + 1];
            map[peshka.corY][peshka.corX] = peshka.helper1;
            peshka.corX += 1;
            map[peshka.corY][peshka.corX] = 22;
        }

        else if (negr == 5)
        {
            peshka.helper1 = peshka.helper2;
            peshka.helper2 = map[peshka.corY + 1][peshka.corX];
            map[peshka.corY][peshka.corX] = peshka.helper1;
            peshka.corY += 1;
            map[peshka.corY][peshka.corX] = 22;
        }

        else if (negr == 7)
        {
            peshka.helper1 = peshka.helper2;
            peshka.helper2 = map[peshka.corY][peshka.corX - 1];
            map[peshka.corY][peshka.corX] = peshka.helper1;
            peshka.corX -= 1;
            map[peshka.corY][peshka.corX] = 22;
        }

        else if (negr == 9)
        {
            int negrM = rand.nextInt(4) + 1;

            if (negrM == 1 && map[peshka.corY - 1][peshka.corX] < 11)
            {
                peshka.helper1 = peshka.helper2;
                peshka.helper2 = map[peshka.corY - 1][peshka.corX];
                map[peshka.corY][peshka.corX] = peshka.helper1;
                peshka.corY -= 1;
                map[peshka.corY][peshka.corX] = 22;
            }

            else if (negrM == 2 && map[peshka.corY][peshka.corX + 1] < 11)
            {
                peshka.helper1 = peshka.helper2;
                peshka.helper2 = map[peshka.corY][peshka.corX + 1];
                map[peshka.corY][peshka.corX] = peshka.helper1;
                peshka.corX += 1;
                map[peshka.corY][peshka.corX] = 22;
            }

            else if (negrM == 3 && map[peshka.corY + 1][peshka.corX] < 11)
            {
                peshka.helper1 = peshka.helper2;
                peshka.helper2 = map[peshka.corY + 1][peshka.corX];
                map[peshka.corY][peshka.corX] = peshka.helper1;
                peshka.corY += 1;
                map[peshka.corY][peshka.corX] = 22;
            }

            else if (negrM == 4 && map[peshka.corY][peshka.corX - 1] < 11)
            {
                peshka.helper1 = peshka.helper2;
                peshka.helper2 = map[peshka.corY][peshka.corX - 1];
                map[peshka.corY][peshka.corX] = peshka.helper1;
                peshka.corX -= 1;
                map[peshka.corY][peshka.corX] = 22;
            }

        }

        gameLifeCheck(opengate);
    }

    public void slonMove()
    {
        computeFlowField(map, player.corX, player.corY, 2);

        int negr = getDirection(slon.corX, slon.corY);

        System.out.println(negr);

        if (negr == 2)
        {
            slon.helper1 = slon.helper2;
            slon.helper2 = map[slon.corY - 1][slon.corX + 1];
            map[slon.corY][slon.corX] = slon.helper1;
            slon.corY -= 1;
            slon.corX += 1;
            map[slon.corY][slon.corX] = 23;
        }

        else if (negr == 4)
        {
            slon.helper1 = slon.helper2;
            slon.helper2 = map[slon.corY + 1][slon.corX + 1];
            map[slon.corY][slon.corX] = slon.helper1;
            slon.corY += 1;
            slon.corX += 1;
            map[slon.corY][slon.corX] = 23;
        }

        else if (negr == 6)
        {
            slon.helper1 = slon.helper2;
            slon.helper2 = map[slon.corY + 1][slon.corX - 1];
            map[slon.corY][slon.corX] = slon.helper1;
            slon.corY += 1;
            slon.corX -= 1;
            map[slon.corY][slon.corX] = 23;
        }

        else if (negr == 8)
        {
            slon.helper1 = slon.helper2;
            slon.helper2 = map[slon.corY - 1][slon.corX - 1];
            map[slon.corY][slon.corX] = slon.helper1;
            slon.corY -= 1;
            slon.corX -= 1;
            map[slon.corY][slon.corX] = 23;
        }

        else if(negr == 9)
        {
            int negrM = rand.nextInt(4) + 1;

            if (negrM == 1 && map[slon.corY - 1][slon.corX + 1] < 11)
            {
                slon.helper1 = slon.helper2;
                slon.helper2 = map[slon.corY - 1][slon.corX + 1];
                map[slon.corY][slon.corX] = slon.helper1;
                slon.corY -= 1;
                slon.corX += 1;
                map[slon.corY][slon.corX] = 23;
            }

            else if (negrM == 2 && map[slon.corY + 1][slon.corX + 1] < 11)
            {
                slon.helper1 = slon.helper2;
                slon.helper2 = map[slon.corY + 1][slon.corX + 1];
                map[slon.corY][slon.corX] = slon.helper1;
                slon.corY += 1;
                slon.corX += 1;
                map[slon.corY][slon.corX] = 23;
            }

            else if (negrM == 3 && map[slon.corY + 1][slon.corX - 1] < 11)
            {
                slon.helper1 = slon.helper2;
                slon.helper2 = map[slon.corY + 1][slon.corX - 1];
                map[slon.corY][slon.corX] = slon.helper1;
                slon.corY += 1;
                slon.corX -= 1;
                map[slon.corY][slon.corX] = 23;
            }

            else if (negrM == 4 && map[slon.corY - 1][slon.corX - 1] < 11)
            {
                slon.helper1 = slon.helper2;
                slon.helper2 = map[slon.corY - 1][slon.corX - 1];
                map[slon.corY][slon.corX] = slon.helper1;
                slon.corY -= 1;
                slon.corX -= 1;
                map[slon.corY][slon.corX] = 23;
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
            if (map[sKorol.corY - 1][sKorol.corX] < 11 || map[sKorol.corY - 1][sKorol.corX] == 21)
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY - 1][sKorol.corX];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corY -= 1;
                map[sKorol.corY][sKorol.corX] = 24;
            }
        }

        else if (r == 2)
        {
            if(map[sKorol.corY - 1][sKorol.corX + 1] < 11 || map[sKorol.corY - 1][sKorol.corX + 1] == 21)
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY - 1][sKorol.corX + 1];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corY -= 1;
                sKorol.corX += 1;
                map[sKorol.corY][sKorol.corX] = 24;
            }
        }

        else if (r == 3)
        {
            if(map[sKorol.corY][sKorol.corX + 1] < 11  || map[sKorol.corY][sKorol.corX + 1] == 21)
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY][sKorol.corX + 1];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corX += 1;
                map[sKorol.corY][sKorol.corX] = 24;
            }
        }

        else if (r == 4)
        {
            if(map[sKorol.corY + 1][sKorol.corX + 1] < 11 || map[sKorol.corY + 1][sKorol.corX + 1] == 21)
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY + 1][sKorol.corX + 1];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corY += 1;
                sKorol.corX += 1;
                map[sKorol.corY][sKorol.corX] = 24;
            }
        }

        else if (r == 5)
        {
            if (map[sKorol.corY + 1][sKorol.corX] < 11 || map[sKorol.corY + 1][sKorol.corX] == 32)
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY + 1][sKorol.corX];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corY += 1;
                map[sKorol.corY][sKorol.corX] = 24;
            }
        }

        else if (r == 6)
        {
            if (map[sKorol.corY + 1][sKorol.corX - 1] < 11 || map[sKorol.corY + 1][sKorol.corX - 1] == 21)
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY + 1][sKorol.corX - 1];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corY += 1;
                sKorol.corX -= 1;
                map[sKorol.corY][sKorol.corX] = 24;
            }
        }

        else if (r == 7)
        {
            if (map[sKorol.corY][sKorol.corX - 1] < 11 || map[sKorol.corY][sKorol.corX - 1] == 21)
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY][sKorol.corX - 1];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corX -= 1;
                map[sKorol.corY][sKorol.corX] = 24;
            }
        }

        else if (r == 8)
        {
            if(map[sKorol.corY - 1][sKorol.corX - 1] < 10 || map[sKorol.corY - 1][sKorol.corX - 1] == 21)
            {
                sKorol.helper1 = sKorol.helper2;
                sKorol.helper2 = map[sKorol.corY - 1][sKorol.corX - 1];
                map[sKorol.corY][sKorol.corX] = sKorol.helper1;
                sKorol.corY -= 1;
                sKorol.corX -= 1;
                map[sKorol.corY][sKorol.corX] = 24;
            }
        }
    }

    public void playerMove (int a)
    {
        int moveCheck = 0;

        if (a == 1)
        {
            if (map[player.corY - 1][player.corX] < 11 || map[player.corY - 1][player.corX] == 32 || map[player.corY - 1][player.corX] == 31 || map[player.corY - 1][player.corX] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY - 1][player.corX];
                map[player.corY][player.corX] = player.helper1;
                player.corY -= 1;
                map[player.corY][player.corX] = 21;

                moveCheck = 1;
            }
        }

        else if (a == 2)
        {
            if(map[player.corY - 1][player.corX + 1] < 11 || map[player.corY - 1][player.corX + 1] == 32 || map[player.corY - 1][player.corX + 1] == 31 || map[player.corY - 1][player.corX + 1] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY - 1][player.corX + 1];
                map[player.corY][player.corX] = player.helper1;
                player.corY -= 1;
                player.corX += 1;
                map[player.corY][player.corX] = 21;

                moveCheck = 1;
            }
        }

        else if (a == 3)
        {
            if(map[player.corY][player.corX + 1] < 11  || map[player.corY][player.corX + 1] == 32 || map[player.corY][player.corX + 1] == 31 || map[player.corY][player.corX + 1] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY][player.corX + 1];
                map[player.corY][player.corX] = player.helper1;
                player.corX += 1;
                map[player.corY][player.corX] = 21;

                moveCheck = 1;
            }
        }

        else if (a == 4)
        {
            if(map[player.corY + 1][player.corX + 1] < 11 || map[player.corY + 1][player.corX + 1] == 32 || map[player.corY + 1][player.corX + 1] == 31 || map[player.corY + 1][player.corX + 1] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY + 1][player.corX + 1];
                map[player.corY][player.corX] = player.helper1;
                player.corY += 1;
                player.corX += 1;
                map[player.corY][player.corX] = 21;

                moveCheck = 1;
            }
        }

        else if (a == 5)
        {
            if (map[player.corY + 1][player.corX] < 11 || map[player.corY + 1][player.corX] == 32 || map[player.corY][player.corX] == 31 || map[player.corY + 1][player.corX] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY + 1][player.corX];
                map[player.corY][player.corX] = player.helper1;
                player.corY += 1;
                map[player.corY][player.corX] = 21;

                moveCheck = 1;
            }
        }

        else if (a == 6)
        {
            if (map[player.corY + 1][player.corX - 1] < 11 || map[player.corY + 1][player.corX - 1] == 32 || map[player.corY + 1][player.corX - 1] == 31 || map[player.corY + 1][player.corX - 1] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY + 1][player.corX - 1];
                map[player.corY][player.corX] = player.helper1;
                player.corY += 1;
                player.corX -= 1;
                map[player.corY][player.corX] = 21;

                moveCheck = 1;
            }
        }

        else if (a == 7)
        {
            if (map[player.corY][player.corX - 1] < 11 || map[player.corY][player.corX - 1] == 32 || map[player.corY][player.corX - 1] == 31 || map[player.corY][player.corX - 1] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY][player.corX - 1];
                map[player.corY][player.corX] = player.helper1;
                player.corX -= 1;
                map[player.corY][player.corX] = 21;

                moveCheck = 1;
            }
        }

        else if (a == 8)
        {
            if(map[player.corY - 1][player.corX - 1] < 10 || map[player.corY - 1][player.corX - 1] == 32 || map[player.corY - 1][player.corX -1] == 31 || map[player.corY - 1][player.corX -1 ] == 33)
            {
                player.helper1 = player.helper2;
                player.helper2 = map[player.corY - 1][player.corX - 1];
                map[player.corY][player.corX] = player.helper1;
                player.corY -= 1;
                player.corX -= 1;
                map[player.corY][player.corX] = 21;

                moveCheck = 1;
            }
        }

        if (player.corY == extr.corY && player.corX == extr.corX)
            opengate = 1;

        if (moveCheck == 1)
        {
            if (peshka.isHere)
                peshkaSukaMove();

            if (slon.isHere)
                slonMove();

            if (sKorol.isHere)
                sKorolMove();

            gameLifeCheck(player.helper2);
        }
    }

    public void buttonUpAction(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String b = settings.getString("difficulty", "");

        playerMove(1);

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
        if (peshka.isHere)
            peshkaSukaMove();

        if (slon.isHere)
            slonMove();

        if (sKorol.isHere)
            sKorolMove();

        mapDrawScreen();
    }

    public void test(View v)
    {
        if (peshka.isHere)
            peshkaSukaMove();

        if (slon.isHere)
            slonMove();

        if (sKorol.isHere)
            sKorolMove();

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
        System.out.println("-----");
        System.out.println(sKorol.corY);
        System.out.println(sKorol.corX);
    }
}