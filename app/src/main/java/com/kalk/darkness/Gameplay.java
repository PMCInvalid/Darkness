package com.kalk.darkness;

import static java.lang.Integer.parseInt;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Gameplay extends AppCompatActivity
{
    Settings settings;
    public static Game game = null;
    static int energy = 100;
    static double score = 1;
    ImageView[][] imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);

        SharedPreferences settingsSharedPreferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
        settings = new Settings(settingsSharedPreferences);

        if (game == null)
        {
            game = new Game(settings, 0, this);
            game.init(0, settingsSharedPreferences);
        }

        TextView scores = findViewById(R.id.scoreText);
        scores.setText("Score: " + Gameplay.score);

        ImageView[][] imageViews0 =
                {
                        {
                                (ImageView) findViewById(R.id.mapDrawImage1_1),
                                (ImageView) findViewById(R.id.mapDrawImage1_2),
                                (ImageView) findViewById(R.id.mapDrawImage1_3),
                                (ImageView) findViewById(R.id.mapDrawImage1_4),
                                (ImageView) findViewById(R.id.mapDrawImage1_5),
                                (ImageView) findViewById(R.id.mapDrawImage1_6),
                                (ImageView) findViewById(R.id.mapDrawImage1_7),
                                (ImageView) findViewById(R.id.mapDrawImage1_8),
                                (ImageView) findViewById(R.id.mapDrawImage1_9)
                        },
                        {
                                (ImageView) findViewById(R.id.mapDrawImage2_1),
                                (ImageView) findViewById(R.id.mapDrawImage2_2),
                                (ImageView) findViewById(R.id.mapDrawImage2_3),
                                (ImageView) findViewById(R.id.mapDrawImage2_4),
                                (ImageView) findViewById(R.id.mapDrawImage2_5),
                                (ImageView) findViewById(R.id.mapDrawImage2_6),
                                (ImageView) findViewById(R.id.mapDrawImage2_7),
                                (ImageView) findViewById(R.id.mapDrawImage2_8),
                                (ImageView) findViewById(R.id.mapDrawImage2_9)
                        },
                        {
                                (ImageView) findViewById(R.id.mapDrawImage3_1),
                                (ImageView) findViewById(R.id.mapDrawImage3_2),
                                (ImageView) findViewById(R.id.mapDrawImage3_3),
                                (ImageView) findViewById(R.id.mapDrawImage3_4),
                                (ImageView) findViewById(R.id.mapDrawImage3_5),
                                (ImageView) findViewById(R.id.mapDrawImage3_6),
                                (ImageView) findViewById(R.id.mapDrawImage3_7),
                                (ImageView) findViewById(R.id.mapDrawImage3_8),
                                (ImageView) findViewById(R.id.mapDrawImage3_9)
                        },
                        {
                                (ImageView) findViewById(R.id.mapDrawImage4_1),
                                (ImageView) findViewById(R.id.mapDrawImage4_2),
                                (ImageView) findViewById(R.id.mapDrawImage4_3),
                                (ImageView) findViewById(R.id.mapDrawImage4_4),
                                (ImageView) findViewById(R.id.mapDrawImage4_5),
                                (ImageView) findViewById(R.id.mapDrawImage4_6),
                                (ImageView) findViewById(R.id.mapDrawImage4_7),
                                (ImageView) findViewById(R.id.mapDrawImage4_8),
                                (ImageView) findViewById(R.id.mapDrawImage4_9)
                        },
                        {
                                (ImageView) findViewById(R.id.mapDrawImage5_1),
                                (ImageView) findViewById(R.id.mapDrawImage5_2),
                                (ImageView) findViewById(R.id.mapDrawImage5_3),
                                (ImageView) findViewById(R.id.mapDrawImage5_4),
                                (ImageView) findViewById(R.id.mapDrawImage5_5),
                                (ImageView) findViewById(R.id.mapDrawImage5_6),
                                (ImageView) findViewById(R.id.mapDrawImage5_7),
                                (ImageView) findViewById(R.id.mapDrawImage5_8),
                                (ImageView) findViewById(R.id.mapDrawImage5_9)
                        },
                        {
                                (ImageView) findViewById(R.id.mapDrawImage6_1),
                                (ImageView) findViewById(R.id.mapDrawImage6_2),
                                (ImageView) findViewById(R.id.mapDrawImage6_3),
                                (ImageView) findViewById(R.id.mapDrawImage6_4),
                                (ImageView) findViewById(R.id.mapDrawImage6_5),
                                (ImageView) findViewById(R.id.mapDrawImage6_6),
                                (ImageView) findViewById(R.id.mapDrawImage6_7),
                                (ImageView) findViewById(R.id.mapDrawImage6_8),
                                (ImageView) findViewById(R.id.mapDrawImage6_9)
                        },
                        {
                                (ImageView) findViewById(R.id.mapDrawImage7_1),
                                (ImageView) findViewById(R.id.mapDrawImage7_2),
                                (ImageView) findViewById(R.id.mapDrawImage7_3),
                                (ImageView) findViewById(R.id.mapDrawImage7_4),
                                (ImageView) findViewById(R.id.mapDrawImage7_5),
                                (ImageView) findViewById(R.id.mapDrawImage7_6),
                                (ImageView) findViewById(R.id.mapDrawImage7_7),
                                (ImageView) findViewById(R.id.mapDrawImage7_8),
                                (ImageView) findViewById(R.id.mapDrawImage7_9)
                        },
                        {
                                (ImageView) findViewById(R.id.mapDrawImage8_1),
                                (ImageView) findViewById(R.id.mapDrawImage8_2),
                                (ImageView) findViewById(R.id.mapDrawImage8_3),
                                (ImageView) findViewById(R.id.mapDrawImage8_4),
                                (ImageView) findViewById(R.id.mapDrawImage8_5),
                                (ImageView) findViewById(R.id.mapDrawImage8_6),
                                (ImageView) findViewById(R.id.mapDrawImage8_7),
                                (ImageView) findViewById(R.id.mapDrawImage8_8),
                                (ImageView) findViewById(R.id.mapDrawImage8_9)
                        },
                        {
                                (ImageView) findViewById(R.id.mapDrawImage9_1),
                                (ImageView) findViewById(R.id.mapDrawImage9_2),
                                (ImageView) findViewById(R.id.mapDrawImage9_3),
                                (ImageView) findViewById(R.id.mapDrawImage9_4),
                                (ImageView) findViewById(R.id.mapDrawImage9_5),
                                (ImageView) findViewById(R.id.mapDrawImage9_6),
                                (ImageView) findViewById(R.id.mapDrawImage9_7),
                                (ImageView) findViewById(R.id.mapDrawImage9_8),
                                (ImageView) findViewById(R.id.mapDrawImage9_9)
                        },
                };

        imageViews = imageViews0;
    }

    public void busheWork()
    {
        boolean flag = false;
        for (int i = 0; i < game.bushes.length; i++)
        {
            for (int j = 0; j < game.bushes[i].length; j++)
            {
                if (game.bushes[i][j].getPosition().getY() == game.player.getPosition().getY() && game.bushes[i][j].getPosition().getX() == game.player.getPosition().getX())
                    flag = true;
            }
        }

        if (flag)
            game.player.hidden = true;

        else
            game.player.hidden = false;
    }

    public void enWork()
    {
        TextView ener = (TextView) findViewById(R.id.powerText);

        if (energy < 0)
            energy = 0;

        if (energy > 50)
            ener.setTextColor(ContextCompat.getColor(this, R.color.green));

        if (energy < 50)
            ener.setTextColor(ContextCompat.getColor(this, R.color.yellow));

        if (energy < 25)
            ener.setTextColor(ContextCompat.getColor(this, R.color.blood));

        if (energy == 0)
            ener.setTextColor(ContextCompat.getColor(this, R.color.gray));

        ener.setText("Battery: " + energy + "%");
    }

    public void buttonUpAction(View v)
    {
        game.player.tick(1);
        game.tick();
        test();
    }

    public void buttonUpRightAction(View v)
    {
        game.player.tick(2);
        game.tick();
        test();
    }

    public void buttonRightAction(View v)
    {
        game.player.tick(3);
        game.tick();
        test();
    }

    public void buttonDownRightAction(View v)
    {
        game.player.tick(4);
        game.tick();
        test();
    }

    public void buttonDownAction(View v)
    {
        game.player.tick(5);
        game.tick();
        test();
    }

    public void buttonDownLeftAction(View v)
    {
        game.player.tick(6);
        game.tick();
        test();
    }

    public void buttonLeftAction(View v)
    {
        game.player.tick(7);
        game.tick();
        test();
    }

    public void buttonUpLeftAction(View v)
    {
        game.player.tick(8);
        game.tick();
        test();
    }

    public void midButtonAction(View v)
    {
        game.player.tick(9);
        game.tick();
        test();
    }

    public void test()
    {
        System.out.println(game.player.position.getX() + " " + game.player.position.getY());
        System.out.println("-------");
//        System.out.println(game.peshka.corY + " " + game.peshka.corX);
    }

    public int tileToResId(String tile, int drawMode, int range)
    {
        if (drawMode == Constants.draw_mode_normal)
        {
            switch (tile)
            {
                case "empty_tile":
                    return R.drawable.empty_tile;

                case "wall_tile":
                    return R.drawable.wall_tile;

                case "player_tile":
                    return R.drawable.player_tile;

                case "black_tile":
                    return R.drawable.black_tile;
            }
        }

        else // if (drawMode == Constants.draw_mode_dark)
        {
            if ((drawMode == Constants.draw_mode_bushes) && (range > 2))
            {
                return R.drawable.nigger_tile;
            }

            switch (tile)
            {
                case "empty_tile":
                    return R.drawable.dark_empty_tile;

                case "wall_tile":
                    return R.drawable.dark_wall_tile;

                case "player_tile":
                    return R.drawable.player_tile;
            }
        }

        return R.drawable.empty_tile;
    }

    public void drawMap()
    {
        int drawMode = Constants.draw_mode_normal;
        Globals globals = (Globals) getApplicationContext();

        if (!globals.settings.getDifficulty().equals(Constants.difficulty_easy))
            drawMode = Constants.draw_mode_dark;

        if (game.player.hidden)
            drawMode = Constants.draw_mode_bushes;

        for (int y = -Constants.FOVSize; y <= Constants.FOVSize; y++)
        {
            for (int x = -Constants.FOVSize; x <= Constants.FOVSize; x++)
            {
                int pX = x + game.player.getPosition().getX();
                int pY = y + game.player.getPosition().getY();
                String mapTile = game.getMapTile(pX, pY);
                int resId = this.tileToResId(mapTile, drawMode, Math.min(Math.abs(x), Math.abs(y)));
                imageViews[y + Constants.FOVSize][x + Constants.FOVSize].setImageResource(resId);
            }
        }
    }

/*    public void mapDrawScreen()
    {
        drawMap();
    }

    public void mapDrawDarkScreen()
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

        setDarkTileImage(im1_1, game.player.position.getY() - 4, game.player.position.getX() - 4, true);
        setDarkTileImage(im1_2, game.player.position.getY() - 4, game.player.position.getX() - 3, true);
        setDarkTileImage(im1_3, game.player.position.getY() - 4, game.player.position.getX() - 2, true);
        setDarkTileImage(im1_4, game.player.position.getY() - 4, game.player.position.getX() - 1, true);
        setDarkTileImage(im1_5, game.player.position.getY() - 4, game.player.position.getX(), true);
        setDarkTileImage(im1_6, game.player.position.getY() - 4, game.player.position.getX() + 1, true);
        setDarkTileImage(im1_7, game.player.position.getY() - 4, game.player.position.getX() + 2, true);
        setDarkTileImage(im1_8, game.player.position.getY() - 4, game.player.position.getX() + 3, true);
        setDarkTileImage(im1_9, game.player.position.getY() - 4, game.player.position.getX() + 4, true);

        setDarkTileImage(im2_1, game.player.position.getY() - 3, game.player.position.getX() - 4, true);
        setDarkTileImage(im2_2, game.player.position.getY() - 3, game.player.position.getX() - 3, true);
        setDarkTileImage(im2_3, game.player.position.getY() - 3, game.player.position.getX() - 2, true);
        setDarkTileImage(im2_4, game.player.position.getY() - 3, game.player.position.getX() - 1, true);
        setDarkTileImage(im2_5, game.player.position.getY() - 3, game.player.position.getX(), true);
        setDarkTileImage(im2_6, game.player.position.getY() - 3, game.player.position.getX() + 1, true);
        setDarkTileImage(im2_7, game.player.position.getY() - 3, game.player.position.getX() + 2, true);
        setDarkTileImage(im2_8, game.player.position.getY() - 3, game.player.position.getX() + 3, true);
        setDarkTileImage(im2_9, game.player.position.getY() - 3, game.player.position.getX() + 4, true);

        setDarkTileImage(im3_1, game.player.position.getY() - 2, game.player.position.getX() - 4, true);
        setDarkTileImage(im3_2, game.player.position.getY() - 2, game.player.position.getX() - 3, true);
        setDarkTileImage(im3_3, game.player.position.getY() - 2, game.player.position.getX() - 2, true);
        setDarkTileImage(im3_4, game.player.position.getY() - 2, game.player.position.getX() - 1, true);
        setDarkTileImage(im3_5, game.player.position.getY() - 2, game.player.position.getX(), true);
        setDarkTileImage(im3_6, game.player.position.getY() - 2, game.player.position.getX() + 1, true);
        setDarkTileImage(im3_7, game.player.position.getY() - 2, game.player.position.getX() + 2, true);
        setDarkTileImage(im3_8, game.player.position.getY() - 2, game.player.position.getX() + 3, true);
        setDarkTileImage(im3_9, game.player.position.getY() - 2, game.player.position.getX() + 4, true);

        setDarkTileImage(im4_1, game.player.position.getY() - 1, game.player.position.getX() - 4, true);
        setDarkTileImage(im4_2, game.player.position.getY() - 1, game.player.position.getX() - 3, true);
        setDarkTileImage(im4_3, game.player.position.getY() - 1, game.player.position.getX() - 2, true);
        setDarkTileImage(im4_4, game.player.position.getY() - 1, game.player.position.getX() - 1, true);
        setDarkTileImage(im4_5, game.player.position.getY() - 1, game.player.position.getX(), true);
        setDarkTileImage(im4_6, game.player.position.getY() - 1, game.player.position.getX() + 1, true);
        setDarkTileImage(im4_7, game.player.position.getY() - 1, game.player.position.getX() + 2, true);
        setDarkTileImage(im4_8, game.player.position.getY() - 1, game.player.position.getX() + 3, true);
        setDarkTileImage(im4_9, game.player.position.getY() - 1, game.player.position.getX() + 4, true);

        setDarkTileImage(im5_1, game.player.position.getY(), game.player.position.getX() - 4, true);
        setDarkTileImage(im5_2, game.player.position.getY(), game.player.position.getX() - 3, true);
        setDarkTileImage(im5_3, game.player.position.getY(), game.player.position.getX() - 2, true);
        setDarkTileImage(im5_4, game.player.position.getY(), game.player.position.getX() - 1, true);
        im5_5.setImageResource(R.drawable.player_tile);
        setDarkTileImage(im5_6, game.player.position.getY(), game.player.position.getX() + 1, true);
        setDarkTileImage(im5_7, game.player.position.getY(), game.player.position.getX() + 2, true);
        setDarkTileImage(im5_8, game.player.position.getY(), game.player.position.getX() + 3, true);
        setDarkTileImage(im5_9, game.player.position.getY(), game.player.position.getX() + 4, true);

        setDarkTileImage(im6_1, game.player.position.getY() + 1, game.player.position.getX() - 4, true);
        setDarkTileImage(im6_2, game.player.position.getY() + 1, game.player.position.getX() - 3, true);
        setDarkTileImage(im6_3, game.player.position.getY() + 1, game.player.position.getX() - 2, true);
        setDarkTileImage(im6_4, game.player.position.getY() + 1, game.player.position.getX() - 1, true);
        setDarkTileImage(im6_5, game.player.position.getY() + 1, game.player.position.getX(), true);
        setDarkTileImage(im6_6, game.player.position.getY() + 1, game.player.position.getX() + 1, true);
        setDarkTileImage(im6_7, game.player.position.getY() + 1, game.player.position.getX() + 2, true);
        setDarkTileImage(im6_8, game.player.position.getY() + 1, game.player.position.getX() + 3, true);
        setDarkTileImage(im6_9, game.player.position.getY() + 1, game.player.position.getX() + 4, true);

        setDarkTileImage(im7_1, game.player.position.getY() + 2, game.player.position.getX() - 4, true);
        setDarkTileImage(im7_2, game.player.position.getY() + 2, game.player.position.getX() - 3, true);
        setDarkTileImage(im7_3, game.player.position.getY() + 2, game.player.position.getX() - 2, true);
        setDarkTileImage(im7_4, game.player.position.getY() + 2, game.player.position.getX() - 1, true);
        setDarkTileImage(im7_5, game.player.position.getY() + 2, game.player.position.getX(), true);
        setDarkTileImage(im7_6, game.player.position.getY() + 2, game.player.position.getX() + 1, true);
        setDarkTileImage(im7_7, game.player.position.getY() + 2, game.player.position.getX() + 2, true);
        setDarkTileImage(im7_8, game.player.position.getY() + 2, game.player.position.getX() + 3, true);
        setDarkTileImage(im7_9, game.player.position.getY() + 2, game.player.position.getX() + 4, true);

        setDarkTileImage(im8_1, game.player.position.getY() + 3, game.player.position.getX() - 4, true);
        setDarkTileImage(im8_2, game.player.position.getY() + 3, game.player.position.getX() - 3, true);
        setDarkTileImage(im8_3, game.player.position.getY() + 3, game.player.position.getX() - 2, true);
        setDarkTileImage(im8_4, game.player.position.getY() + 3, game.player.position.getX() - 1, true);
        setDarkTileImage(im8_5, game.player.position.getY() + 3, game.player.position.getX(), true);
        setDarkTileImage(im8_6, game.player.position.getY() + 3, game.player.position.getX() + 1, true);
        setDarkTileImage(im8_7, game.player.position.getY() + 3, game.player.position.getX() + 2, true);
        setDarkTileImage(im8_8, game.player.position.getY() + 3, game.player.position.getX() + 3, true);
        setDarkTileImage(im8_9, game.player.position.getY() + 3, game.player.position.getX() + 4, true);

        setDarkTileImage(im9_1, game.player.position.getY() + 4, game.player.position.getX() - 4, true);
        setDarkTileImage(im9_2, game.player.position.getY() + 4, game.player.position.getX() - 3, true);
        setDarkTileImage(im9_3, game.player.position.getY() + 4, game.player.position.getX() - 2, true);
        setDarkTileImage(im9_4, game.player.position.getY() + 4, game.player.position.getX() - 1, true);
        setDarkTileImage(im9_5, game.player.position.getY() + 4, game.player.position.getX(), true);
        setDarkTileImage(im9_6, game.player.position.getY() + 4, game.player.position.getX() + 1, true);
        setDarkTileImage(im9_7, game.player.position.getY() + 4, game.player.position.getX() + 2, true);
        setDarkTileImage(im9_8, game.player.position.getY() + 4, game.player.position.getX() + 3, true);
        setDarkTileImage(im9_9, game.player.position.getY() + 4, game.player.position.getX() + 4, true);
    }

    public void mapDrawBushesScreen()
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

        im1_1.setImageResource(R.drawable.nigger_tile);
        im1_2.setImageResource(R.drawable.nigger_tile);
        im1_3.setImageResource(R.drawable.nigger_tile);
        im1_4.setImageResource(R.drawable.nigger_tile);
        im1_5.setImageResource(R.drawable.nigger_tile);
        im1_6.setImageResource(R.drawable.nigger_tile);
        im1_7.setImageResource(R.drawable.nigger_tile);
        im1_8.setImageResource(R.drawable.nigger_tile);
        im1_9.setImageResource(R.drawable.nigger_tile);

        im2_1.setImageResource(R.drawable.nigger_tile);
        im2_2.setImageResource(R.drawable.nigger_tile);
        im2_3.setImageResource(R.drawable.nigger_tile);
        im2_4.setImageResource(R.drawable.nigger_tile);
        im2_5.setImageResource(R.drawable.nigger_tile);
        im2_6.setImageResource(R.drawable.nigger_tile);
        im2_7.setImageResource(R.drawable.nigger_tile);
        im2_8.setImageResource(R.drawable.nigger_tile);
        im2_9.setImageResource(R.drawable.nigger_tile);


        im3_1.setImageResource(R.drawable.nigger_tile);
        im3_2.setImageResource(R.drawable.nigger_tile);
        setDarkTileImage(im3_3, game.player.position.getY() - 2, game.player.position.getX() - 2, true);
        setDarkTileImage(im3_4, game.player.position.getY() - 2, game.player.position.getX() - 1, true);
        setDarkTileImage(im3_5, game.player.position.getY() - 2, game.player.position.getX(), true);
        setDarkTileImage(im3_6, game.player.position.getY() - 2, game.player.position.getX() + 1, true);
        setDarkTileImage(im3_7, game.player.position.getY() - 2, game.player.position.getX() + 2, true);
        im3_8.setImageResource(R.drawable.nigger_tile);
        im3_9.setImageResource(R.drawable.nigger_tile);

        im4_1.setImageResource(R.drawable.nigger_tile);
        im4_2.setImageResource(R.drawable.nigger_tile);
        setDarkTileImage(im4_3, game.player.position.getY() - 1, game.player.position.getX() - 2, true);
        resId = getResources().getIdentifier(game.getMap()[game.player.position.getY() - 1][game.player.position.getX() - 1], "drawable", getPackageName());
        im4_4.setImageResource(resId);
        resId = getResources().getIdentifier(game.getMap()[game.player.position.getY() - 1][game.player.position.getX()], "drawable", getPackageName());
        im4_5.setImageResource(resId);
        resId = getResources().getIdentifier(game.getMap()[game.player.position.getY() - 1][game.player.position.getX() + 1], "drawable", getPackageName());
        im4_6.setImageResource(resId);
        setDarkTileImage(im4_7, game.player.position.getY() - 1, game.player.position.getX() + 2, true);
        im4_8.setImageResource(R.drawable.nigger_tile);
        im4_9.setImageResource(R.drawable.nigger_tile);

        im5_1.setImageResource(R.drawable.nigger_tile);
        im5_2.setImageResource(R.drawable.nigger_tile);
        setDarkTileImage(im5_3, game.player.position.getY(), game.player.position.getX() - 2, true);
        resId = getResources().getIdentifier(game.getMap()[game.player.position.getY()][game.player.position.getX() - 1], "drawable", getPackageName());
        im5_4.setImageResource(resId);
        im5_5.setImageResource(R.drawable.player_tile);
        resId = getResources().getIdentifier(game.getMap()[game.player.position.getY()][game.player.position.getX() + 1], "drawable", getPackageName());
        im5_6.setImageResource(resId);
        setDarkTileImage(im5_7, game.player.position.getY(), game.player.position.getX() + 2, true);
        im5_8.setImageResource(R.drawable.nigger_tile);
        im5_9.setImageResource(R.drawable.nigger_tile);

        im6_1.setImageResource(R.drawable.nigger_tile);
        im6_2.setImageResource(R.drawable.nigger_tile);
        setDarkTileImage(im6_3, game.player.position.getY() + 1, game.player.position.getX() - 2, true);
        resId = getResources().getIdentifier(game.getMap()[game.player.position.getY() + 1][game.player.position.getX() - 1], "drawable", getPackageName());
        im6_4.setImageResource(resId);
        resId = getResources().getIdentifier(game.getMap()[game.player.position.getY() + 1][game.player.position.getX()], "drawable", getPackageName());
        im6_5.setImageResource(resId);
        resId = getResources().getIdentifier(game.getMap()[game.player.position.getY() + 1][game.player.position.getX() + 1], "drawable", getPackageName());
        im6_6.setImageResource(resId);
        setDarkTileImage(im6_7, game.player.position.getY() + 1, game.player.position.getX() + 2, true);
        im6_8.setImageResource(R.drawable.nigger_tile);
        im6_9.setImageResource(R.drawable.nigger_tile);

        im7_1.setImageResource(R.drawable.nigger_tile);
        im7_2.setImageResource(R.drawable.nigger_tile);
        setDarkTileImage(im7_3, game.player.position.getY() + 2, game.player.position.getX() - 2, true);
        setDarkTileImage(im7_4, game.player.position.getY() + 2, game.player.position.getX() - 1, true);
        setDarkTileImage(im7_5, game.player.position.getY() + 2, game.player.position.getX(), true);
        setDarkTileImage(im7_6, game.player.position.getY() + 2, game.player.position.getX() + 1, true);
        setDarkTileImage(im7_7, game.player.position.getY() + 2, game.player.position.getX() + 2, true);
        im7_8.setImageResource(R.drawable.nigger_tile);
        im7_9.setImageResource(R.drawable.nigger_tile);

        im8_1.setImageResource(R.drawable.nigger_tile);
        im8_2.setImageResource(R.drawable.nigger_tile);
        im8_3.setImageResource(R.drawable.nigger_tile);
        im8_4.setImageResource(R.drawable.nigger_tile);
        im8_5.setImageResource(R.drawable.nigger_tile);
        im8_6.setImageResource(R.drawable.nigger_tile);
        im8_7.setImageResource(R.drawable.nigger_tile);
        im8_8.setImageResource(R.drawable.nigger_tile);
        im8_9.setImageResource(R.drawable.nigger_tile);

        im9_1.setImageResource(R.drawable.nigger_tile);
        im9_2.setImageResource(R.drawable.nigger_tile);
        im9_3.setImageResource(R.drawable.nigger_tile);
        im9_4.setImageResource(R.drawable.nigger_tile);
        im9_5.setImageResource(R.drawable.nigger_tile);
        im9_6.setImageResource(R.drawable.nigger_tile);
        im9_7.setImageResource(R.drawable.nigger_tile);
        im9_8.setImageResource(R.drawable.nigger_tile);
        im9_9.setImageResource(R.drawable.nigger_tile);
    }

    private void setDarkTileImage(ImageView imageView, int y, int x, boolean task)
    {
        if (y < 0 || x < 0 || y >= game.getMap().length || x >= game.getMap()[0].length)
        {
            imageView.setImageResource(R.drawable.nigger_tile);
        }

        else
        {
            if (game.getMap()[y][x].equals("wall_tile"))
                imageView.setImageResource(R.drawable.dark_wall_tile);

            else if (game.getMap()[y][x].equals("battery_tile"))
                imageView.setImageResource(R.drawable.battery_tile);

            else if (game.getMap()[y][x].equals("bushes_tile"))
                imageView.setImageResource(R.drawable.dark_bushes_tile);

            else if (task)
                imageView.setImageResource(R.drawable.dark_empty_tile);

            else
                imageView.setImageResource(R.drawable.empty_tile);
        }
    }*/
}