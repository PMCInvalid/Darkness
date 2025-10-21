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

        Globals globals = (Globals) getApplicationContext();

        if (game == null)
        {
            game = new Game(settings, 0, this);
            game.init(0, globals.settings.getDifficulty());
        }

        TextView scores = findViewById(R.id.scoreText);
        scores.setText("Score: " + Globals.activeScore);

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

        drawMap();
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
        Globals globals = (Globals) getApplicationContext();

        game.player.tick(Direction.UP);
        game.tick(globals.settings.getDifficulty());
    }

    public void buttonUpRightAction(View v)
    {
        Globals globals = (Globals) getApplicationContext();

        game.player.tick(Direction.UPRIGHT);
        game.tick(globals.settings.getDifficulty());
    }

    public void buttonRightAction(View v)
    {
        Globals globals = (Globals) getApplicationContext();

        game.player.tick(Direction.RIGHT);
        game.tick(globals.settings.getDifficulty());
    }

    public void buttonDownRightAction(View v)
    {
        Globals globals = (Globals) getApplicationContext();

        game.player.tick(Direction.DOWNRIGHT);
        game.tick(globals.settings.getDifficulty());
    }

    public void buttonDownAction(View v)
    {
        Globals globals = (Globals) getApplicationContext();

        game.player.tick(Direction.DOWN);
        game.tick(globals.settings.getDifficulty());
    }

    public void buttonDownLeftAction(View v)
    {
        Globals globals = (Globals) getApplicationContext();

        game.player.tick(Direction.DOWNLEFT);
        game.tick(globals.settings.getDifficulty());
    }

    public void buttonLeftAction(View v)
    {
        Globals globals = (Globals) getApplicationContext();

        game.player.tick(Direction.LEFT);
        game.tick(globals.settings.getDifficulty());
    }

    public void buttonUpLeftAction(View v)
    {
        Globals globals = (Globals) getApplicationContext();

        game.player.tick(Direction.UPLEFT);
        game.tick(globals.settings.getDifficulty());
    }

    public void midButtonAction(View v)
    {
        Globals globals = (Globals) getApplicationContext();

        game.player.tick(Direction.NONE);
        game.tick(globals.settings.getDifficulty());
        test();
    }

    public void test()
    {
        System.out.println(game.player.position.getX() + " " + game.player.position.getY());
        System.out.println("-------");
        System.out.println(game.peshka.position.getX() + " " + game.peshka.position.getY());
    }

    public int tileToResId(String tile, int drawMode, int range)
    {
        if (drawMode == Constants.draw_mode_normal)
        {
            switch (tile)
            {
                case "empty_tile": return R.drawable.empty_tile;

                case "wall_tile": return R.drawable.wall_tile;

                case "player_tile": return R.drawable.player_tile;

                case "black_tile": return R.drawable.black_tile;

                case "lever_tile": return R.drawable.lever_tile;

                case "extraction_tile": return R.drawable.extraction_tile;

                case "peshka_tile": return R.drawable.peshka_tile;
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

        imageViews[4][4].setImageResource(R.drawable.player_tile);
    }
}