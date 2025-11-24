package com.kalk.darkness;

import static com.kalk.darkness.Gameplay.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.kalk.darkness.entity.EntityBattery;
import com.kalk.darkness.entity.EntityBolshoj;
import com.kalk.darkness.entity.EntityBushes;
import com.kalk.darkness.entity.EntityDoor;
import com.kalk.darkness.entity.EntityExit;
import com.kalk.darkness.entity.EntityFKing;
import com.kalk.darkness.entity.EntityGonchaja;
import com.kalk.darkness.entity.EntityKrot;
import com.kalk.darkness.entity.EntityLever;
import com.kalk.darkness.entity.EntityMedved;
import com.kalk.darkness.entity.EntityPeshka;
import com.kalk.darkness.entity.EntityPlayer;
import com.kalk.darkness.entity.EntityPortals;
import com.kalk.darkness.entity.EntityPowerUp;
import com.kalk.darkness.entity.EntityRivers;
import com.kalk.darkness.entity.EntitySKorol;
import com.kalk.darkness.entity.EntitySlon;
import com.kalk.darkness.entity.FactoryPlayer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class Game extends AppCompatActivity
{
    private final WeakReference<Activity> hostRef;
    private final AtomicBoolean ended = new AtomicBoolean(false);

    //MediaPlayer sound = MediaPlayer.create(this, R.raw.bad_event_sound);
    private final Gameplay gameplayActivity;
    int event = 0;
    boolean gameIn = false;
    public Settings settings;
    Set<Entity> entitites;
    public int maxX;
    public int maxY;

    private int seed = 0;
    public Random random = new Random(seed);

    private String[][] map;
    private MapGenerator genchik;

    public EntityPlayer player;
    public EntityPeshka peshka;

    public EntityExit extr;
    public EntityLever lever;
    public EntityBattery battery;
    public EntityDoor door;
    public EntityPowerUp power;

    public EntityBushes[][] bushes = new EntityBushes[4][900];
    public EntityPortals[] portals = new EntityPortals[6];
    public EntityRivers[][] rivers = new EntityRivers[3][15];

    public String[][] getMap() {
        return map;
    }
    public void setMap(String[][] map) {
        this.map = map;
    }
    public void setSeed(int newSeed)
    {
        this.seed = newSeed;
    }
    public int getSeed()
    {
        return seed;
    }

    Game(Settings _settings, int _seed, Gameplay _gameplayActivity)
    {
        this.hostRef = new WeakReference<>(_gameplayActivity);

        maxX = 32;
        maxY = 32;

        this.settings = _settings;
        this.seed = _seed;
        this.gameplayActivity = _gameplayActivity;

        map = new String[maxY][maxX];

        if (seed == 0)
            seed = (new Random()).nextInt(10000);

        genchik = new MapGenerator(this, gameplayActivity);
    }

    public void addEntitty(Entity entity)
    {
        this.entitites.add(entity);
    }

    public String getMapTile(int x, int y)
    {
        if (x < 0 || y < 0 || x >= maxX || y >= maxY)
            return "black_tile";

        for (Entity entity:entitites)
        {
            if (GameVec.equals(entity.getPosition(), x, y))
            {
                return entity.tile;
            }
        }

        return this.getMap()[y][x];
    }

    public void portalsWork()
    {
        int needToTeleport = 1;

        if (portals.length > 1)
        {
            if (player.position.getY() == portals[0].position.getY() && player.position.getX() == portals[0].position.getX() && needToTeleport == 1)
            {
                map[player.position.getY()][player.position.getX()] = "portal_tile";

                player.position.setX(portals[1].position.getX());
                player.position.setY(portals[1].position.getY());

                map[player.position.getY()][player.position.getX()] = "portal_tile";

                needToTeleport = 0;
            }

            if (player.position.getY() == portals[1].position.getY() && player.position.getX() == portals[1].position.getX() && needToTeleport == 1)
            {
                map[player.position.getY()][player.position.getX()] = "portal_tile";

                if (portals.length > 2)
                {
                    player.position.setX(portals[2].position.getX());
                    player.position.setY(portals[2].position.getY());
                }

                else
                {
                    player.position.setX(portals[0].position.getX());
                    player.position.setY(portals[0].position.getY());
                }

                map[player.position.getY()][player.position.getX()] = "portal_tile";

                needToTeleport = 0;
            }
        }

        if (portals.length > 2)
        {
            if (player.position.getY() == portals[2].position.getY() && player.position.getX() == portals[2].position.getX() && needToTeleport == 1)
            {
                map[player.position.getY()][player.position.getX()] = "portal_tile";

                if (portals.length > 3)
                {
                    player.position.setX(portals[3].position.getX());
                    player.position.setY(portals[3].position.getY());
                }

                else
                {
                    player.position.setX(portals[0].position.getX());
                    player.position.setY(portals[0].position.getY());
                }

                map[player.position.getY()][player.position.getX()] = "portal_tile";

                needToTeleport = 0;
            }
        }

        if (portals.length > 3)
        {
            if (player.position.getY() == portals[3].position.getY() && player.position.getX() == portals[3].position.getX() && needToTeleport == 1)
            {
                map[player.position.getY()][player.position.getX()] = "portal_tile";

                if (portals.length > 4)
                {
                    player.position.setX(portals[4].position.getX());
                    player.position.setY(portals[4].position.getY());
                }

                else
                {
                    player.position.setX(portals[0].position.getX());
                    player.position.setY(portals[0].position.getY());
                }

                map[player.position.getY()][player.position.getX()] = "portal_tile";

                needToTeleport = 0;
            }
        }

        if (portals.length > 4)
        {
            if (player.position.getY() == portals[4].position.getY() && player.position.getX() == portals[4].position.getX() && needToTeleport == 1)
            {
                map[player.position.getY()][player.position.getX()] = "portal_tile";

                if (portals.length > 5)
                {
                    player.position.setX(portals[5].position.getX());
                    player.position.setY(portals[5].position.getY());
                }

                else
                {
                    player.position.setX(portals[0].position.getX());
                    player.position.setY(portals[0].position.getY());
                }

                map[player.position.getY()][player.position.getX()] = "portal_tile";

                needToTeleport = 0;
            }
        }

        if (portals.length > 5)
        {
            if (player.position.getY() == portals[5].position.getY() && player.position.getX() == portals[5].position.getX() && needToTeleport == 1)
            {
                map[player.position.getY()][player.position.getX()] = "portal_tile";


                player.position.setX(portals[0].position.getX());
                player.position.setY(portals[0].position.getY());


                map[player.position.getY()][player.position.getX()] = "portal_tile";

                needToTeleport = 0;
            }
        }
    }

    public void abiWork()
    {
        if (power.position.getY() == player.position.getY() && power.position.getX() == player.position.getX())
        {
            SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
            Random rar = new Random();

            if (settings.getString("difficulty", "").equals("easy"))
            {
                player.setAbility(2);
            }

            else if (settings.getString("difficulty", "").equals("hard"))
            {
                player.setAbility(rar.nextInt(2) + 1);
            }

            else
            {
                player.setAbility(rar.nextInt(3) + 1);
            }
        }
    }

    public void enemySence()
    {
        ImageView im3_3 = (ImageView) findViewById(R.id.mapDrawImage3_3);
        ImageView im3_4 = (ImageView) findViewById(R.id.mapDrawImage3_4);
        ImageView im3_5 = (ImageView) findViewById(R.id.mapDrawImage3_5);
        ImageView im3_6 = (ImageView) findViewById(R.id.mapDrawImage3_6);
        ImageView im3_7 = (ImageView) findViewById(R.id.mapDrawImage3_7);

        ImageView im4_3 = (ImageView) findViewById(R.id.mapDrawImage4_3);
        ImageView im4_4 = (ImageView) findViewById(R.id.mapDrawImage4_4);
        ImageView im4_5 = (ImageView) findViewById(R.id.mapDrawImage4_5);
        ImageView im4_6 = (ImageView) findViewById(R.id.mapDrawImage4_6);
        ImageView im4_7 = (ImageView) findViewById(R.id.mapDrawImage4_7);

        ImageView im5_3 = (ImageView) findViewById(R.id.mapDrawImage5_3);
        ImageView im5_4 = (ImageView) findViewById(R.id.mapDrawImage5_4);
        ImageView im5_5 = (ImageView) findViewById(R.id.mapDrawImage5_5);
        ImageView im5_6 = (ImageView) findViewById(R.id.mapDrawImage5_6);
        ImageView im5_7 = (ImageView) findViewById(R.id.mapDrawImage5_7);

        ImageView im6_3 = (ImageView) findViewById(R.id.mapDrawImage6_3);
        ImageView im6_4 = (ImageView) findViewById(R.id.mapDrawImage6_4);
        ImageView im6_5 = (ImageView) findViewById(R.id.mapDrawImage6_5);
        ImageView im6_6 = (ImageView) findViewById(R.id.mapDrawImage6_6);
        ImageView im6_7 = (ImageView) findViewById(R.id.mapDrawImage6_7);

        ImageView im7_3 = (ImageView) findViewById(R.id.mapDrawImage7_3);
        ImageView im7_4 = (ImageView) findViewById(R.id.mapDrawImage7_4);
        ImageView im7_5 = (ImageView) findViewById(R.id.mapDrawImage7_5);
        ImageView im7_6 = (ImageView) findViewById(R.id.mapDrawImage7_6);
        ImageView im7_7 = (ImageView) findViewById(R.id.mapDrawImage7_7);


        drawSence(im3_3, player.position.getY() - 2, player.position.getX() - 2);
        drawSence(im3_4, player.position.getY() - 2, player.position.getX() - 1);
        drawSence(im3_5, player.position.getY() - 2, player.position.getX());
        drawSence(im3_6, player.position.getY() - 2, player.position.getX() + 1);
        drawSence(im3_7, player.position.getY() - 2, player.position.getX() + 2);

        drawSence(im4_3, player.position.getY() - 1, player.position.getX() - 2);
        drawSence(im4_4, player.position.getY() - 1, player.position.getX() - 1);
        drawSence(im4_5, player.position.getY() - 1, player.position.getX());
        drawSence(im4_6, player.position.getY() - 1, player.position.getX() + 1);
        drawSence(im4_7, player.position.getY() - 1, player.position.getX() + 2);

        drawSence(im5_3, player.position.getY(), player.position.getX() - 2);
        drawSence(im5_4, player.position.getY(), player.position.getX() - 1);
        drawSence(im5_5, player.position.getY(), player.position.getX());
        drawSence(im5_6, player.position.getY(), player.position.getX() + 1);
        drawSence(im5_7, player.position.getY(), player.position.getX() + 2);

        drawSence(im6_3, player.position.getY() + 1, player.position.getX() - 2);
        drawSence(im6_4, player.position.getY() + 1, player.position.getX() - 1);
        drawSence(im6_5, player.position.getY() + 1, player.position.getX());
        drawSence(im6_6, player.position.getY() + 1, player.position.getX() + 1);
        drawSence(im6_7, player.position.getY() + 1, player.position.getX() + 2);

        drawSence(im7_3, player.position.getY() + 2, player.position.getX() - 2);
        drawSence(im7_4, player.position.getY() + 2, player.position.getX() - 1);
        drawSence(im7_5, player.position.getY() + 2, player.position.getX());
        drawSence(im7_6, player.position.getY() + 2, player.position.getX() + 1);
        drawSence(im7_7, player.position.getY() + 2, player.position.getX() + 2);
    }

    public void drawSence(@NonNull ImageView imka, int y, int x)
    {
        int color = Color.argb(128, 255, 0, 0);
        PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP);

        Drawable dr = imka.getDrawable().mutate();
        Random rar = new Random();
        dr.setColorFilter(colorFilter);

        boolean isNearEnemy = false;
        for (Entity entity:entitites)
        {
            if (entity == player)
                continue;

            if (Math.abs(entity.position.getY() - y) <= 1 && Math.abs(entity.position.getX() - x) <= 1) {
                isNearEnemy = true;
                break;
            }
        }

        if (isNearEnemy)
        {
            int ran = rar.nextInt(2);
            if (!map[y][x].equals("wall_tile") && ran == 1)
            {
                dr.setColorFilter(colorFilter);
                imka.setImageDrawable(dr);
            }
            else
            {
                dr.clearColorFilter();
                imka.setImageDrawable(dr);
            }
        }
        else
        {
            dr.clearColorFilter();
            imka.setImageDrawable(dr);
        }
    }

    public void sonar()
    {
        ImageView im4_4 = (ImageView) findViewById(R.id.mapDrawImage4_4);
        ImageView im4_5 = (ImageView) findViewById(R.id.mapDrawImage4_5);
        ImageView im4_6 = (ImageView) findViewById(R.id.mapDrawImage4_6);

        ImageView im5_4 = (ImageView) findViewById(R.id.mapDrawImage5_4);
        ImageView im5_6 = (ImageView) findViewById(R.id.mapDrawImage5_6);

        ImageView im6_4 = (ImageView) findViewById(R.id.mapDrawImage6_4);
        ImageView im6_5 = (ImageView) findViewById(R.id.mapDrawImage6_5);
        ImageView im6_6 = (ImageView) findViewById(R.id.mapDrawImage6_6);

        int color = Color.argb(75, 0, 255, 0);
        PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP);

        Drawable[] dr = {
                im4_4.getDrawable().mutate(),
                im4_5.getDrawable().mutate(),
                im4_6.getDrawable().mutate(),
                im5_4.getDrawable().mutate(),
                im5_6.getDrawable().mutate(),
                im6_4.getDrawable().mutate(),
                im6_5.getDrawable().mutate(),
                im6_6.getDrawable().mutate()
        };

        ImageView[] imageViews = {im4_4, im4_5, im4_6, im5_4, im5_6, im6_4, im6_5, im6_6};

        for (int i = 0; i < 8; i++)
        {
            dr[i] = imageViews[i].getDrawable().mutate();
        }

        for (int i = 0; i < 8; i++)
        {
            dr[i].clearColorFilter();
            imageViews[i].setImageDrawable(dr[i]);
        }

        if (lever.triggered)
        {
            if (player.position.getY() > extr.position.getY() && player.position.getX() == extr.position.getX())
            {
                dr[1].setColorFilter(colorFilter);
                im4_5.setImageDrawable(dr[1]);
            }
            else if (player.position.getY() > extr.position.getY() && player.position.getX() < extr.position.getX())
            {
                dr[2].setColorFilter(colorFilter);
                im4_6.setImageDrawable(dr[2]);
            }
            else if (player.position.getY() == extr.position.getY() && player.position.getX() < extr.position.getX())
            {
                dr[4].setColorFilter(colorFilter);
                im5_6.setImageDrawable(dr[4]);
            }
            else if (player.position.getY() < extr.position.getY() && player.position.getX() < extr.position.getX())
            {
                dr[7].setColorFilter(colorFilter);
                im6_6.setImageDrawable(dr[7]);
            }
            else if (player.position.getY() < extr.position.getY() && player.position.getX() == extr.position.getX())
            {
                dr[6].setColorFilter(colorFilter);
                im6_5.setImageDrawable(dr[6]);
            }
            else if (player.position.getY() < extr.position.getY() && player.position.getX() > extr.position.getX())
            {
                dr[5].setColorFilter(colorFilter);
                im6_4.setImageDrawable(dr[5]);
            }
            else if (player.position.getY() == extr.position.getY() && player.position.getX() > extr.position.getX())
            {
                dr[3].setColorFilter(colorFilter);
                im5_4.setImageDrawable(dr[3]);
            }
            else if (player.position.getY() > extr.position.getY() && player.position.getX() > extr.position.getX())
            {
                dr[0].setColorFilter(colorFilter);
                im4_4.setImageDrawable(dr[0]);
            }
        }

        else
        {
            if (player.position.getY() > lever.position.getY() && player.position.getX() == lever.position.getX()) // Up
            {
                dr[1].setColorFilter(colorFilter);
                im4_5.setImageDrawable(dr[1]);
            }
            else if (player.position.getY() > lever.position.getY() && player.position.getX() < lever.position.getX()) // Up right
            {
                dr[2].setColorFilter(colorFilter);
                im4_6.setImageDrawable(dr[2]);
            }
            else if (player.position.getY() == lever.position.getY() && player.position.getX() < lever.position.getX()) // Right
            {
                dr[4].setColorFilter(colorFilter);
                im5_6.setImageDrawable(dr[4]);
            }
            else if (player.position.getY() < lever.position.getY() && player.position.getX() < lever.position.getX()) // Down right
            {
                dr[7].setColorFilter(colorFilter);
                im6_6.setImageDrawable(dr[7]);
            }
            else if (player.position.getY() < lever.position.getY() && player.position.getX() == lever.position.getX()) // Down
            {
                dr[6].setColorFilter(colorFilter);
                im6_5.setImageDrawable(dr[6]);
            }
            else if (player.position.getY() < lever.position.getY() && player.position.getX() > lever.position.getX()) // Down left
            {
                dr[5].setColorFilter(colorFilter);
                im6_4.setImageDrawable(dr[5]);
            }
            else if (player.position.getY() == lever.position.getY() && player.position.getX() > lever.position.getX()) // Left
            {
                dr[3].setColorFilter(colorFilter);
                im5_4.setImageDrawable(dr[3]);
            }
            else if (player.position.getY() > lever.position.getY() && player.position.getX() > lever.position.getX()) // Up left
            {
                dr[0].setColorFilter(colorFilter);
                im4_4.setImageDrawable(dr[0]);
            }
        }
    }

    public void abi(int anum)
    {
        if (player.getEnergy() > 0)
            switch(anum)
            {
                case 1:
                    player.setEnergy(100);
                    break;

                case 2:
                    sonar();
                    player.setEnergy(player.getEnergy() - 2);
                    break;

                case 3:
                    enemySence();
                    player.setEnergy(player.getEnergy() - 2);
                    break;
            }
    }

    public void init(int forsedEv, String difficulty)
    {
        int ev = forsedEv == 0 ? MapGenerator.rand.nextInt(101): forsedEv;
        entitites = new HashSet<Entity>();

        /*if (ev <= 4)
            event = ev;

        else if (settings.getDifficulty().equals(Constants.difficulty_insane))
            event = 1;

        else
            event = 0;

        if (event == 1 || event == 3 || event == 4) {
            if (sound != null)
                sound.start();
        }*/

        event = 0;
        map = genchik.mapThrower(Globals.activeScore, difficulty, event);

        entitySpawn();

        gameIn = true;
    }

    public void entitySpawn()
    {
        player = genchik.playerSpawn();
        extr = genchik.extractionGen();
        lever = genchik.leverGen();
        door = genchik.doorGen();
        peshka = genchik.peshkaSpawn();
    }

    public void riverwork(Entity entity)
    {
        /*for (int i = 0; i < 3; i++)
            for (int j = 0; j < 15; j++)
            {
                if (rivers[i][j].position.getY() == entity.position.getY() && rivers[i][j].position.getX() == entity.position.getX())
                {
                    switch(rivers[i][j].riverDir)
                    {
                        case 1:
                            if (map[entity.position.getY() - 1][entity.position.getX()].equals("wall_tile"))
                                break;

                            entity.helper1 = entity.helper2;
                            entity.helper2 = map[entity.position.getY() - 1][entity.position.getX()];
                            map[entity.position.getY()][entity.position.getX()] = entity.helper1;
                            entity.position = entity.position.offSet(Direction.up, 1);
                            map[entity.position.getY()][entity.position.getX()] = entity.tile;
                            break;

                        case 2:
                            if (map[entity.position.getY()][entity.position.getX() + 1].equals("wall_tile"))
                                break;

                            entity.helper1 = entity.helper2;
                            entity.helper2 = map[entity.position.getY()][entity.position.getX() + 1];
                            map[entity.position.getY()][entity.position.getX()] = entity.helper1;
                            entity.position = entity.position.offSet(Direction.right, 1);
                            map[entity.position.getY()][entity.position.getX()] = entity.tile;
                            break;

                        case 3:
                            if (map[entity.position.getY() + 1][entity.position.getX()].equals("wall_tile"))
                                break;

                            entity.helper1 = entity.helper2;
                            entity.helper2 = map[entity.position.getY() + 1][entity.position.getX()];
                            map[entity.position.getY()][entity.position.getX()] = entity.helper1;
                            entity.position = entity.position.offSet(Direction.down, 1);
                            map[entity.position.getY()][entity.position.getX()] = entity.tile;
                            break;

                        case 4:
                            if (map[entity.position.getY()][entity.position.getX() - 1].equals("wall_tile"))
                                break;

                            entity.helper1 = entity.helper2;
                            entity.helper2 = map[entity.position.getY()][entity.position.getX() - 1];
                            map[entity.position.getY()][entity.position.getX()] = entity.helper1;
                            entity.position = entity.position.offSet(Direction.left, 1);
                            map[entity.position.getY()][entity.position.getX()] = entity.tile;
                            break;
                    }
                    break;
                }

            }*/
    }

    public void endGame()
    {

//        game.power.ability = 0;

        Activity a = hostRef.get();
        if (a == null || a.isFinishing() || a.isDestroyed())
        {
            Context ctx = Globals.app();
            Intent pip = new Intent(ctx, death_screen.class);
            pip.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            ctx.startActivity(pip);
            game = null;
            return;
        }

        a.runOnUiThread(() ->
        {
            Intent pip = new Intent(a, death_screen.class);
            pip.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            a.startActivity(pip);
            game = null;
            a.finish();
        });
    }

    public void tick(String difficulty)
    {
        player.hidden = false;

        for (Entity entity:entitites)
        {
            if (entity == player)
                continue;

            entity.tick();
            riverwork(entity);

            if (GameVec.equals(entity.position, player.position))
            {
                entity.onPlayerCollision(difficulty);
            }
        }

        if (game != null)
        {
            if (!player.hidden)
            {
                if (Globals.settings.getDifficulty().equals(Constants.difficulty_easy))
                {
                    gameplayActivity.drawMap();
                    game.abi(player.getAbility());
                }
                else if (Globals.settings.getDifficulty().equals(Constants.difficulty_hard) || player.getPlayerMoveRem() == 9)
                {
                    if (player.getFlashlight() == 1 && player.getEnergy() > 0)
                    {
                        gameplayActivity.drawMap();
                        player.setFlashlight(0);
                        player.setEnergy(player.getEnergy() - 3);
                    }
                    else
                    {
                        gameplayActivity.drawMap();
                        game.enemySence();
                        player.setEnergy(player.getEnergy() - 1);
                        game.abi(player.getAbility());
                    }
                }

                else
                {
                    if (player.getFlashlight() == 1 && player.getEnergy() > 0)
                    {
                        gameplayActivity.drawMap();
                        player.setFlashlight(0);
                        player.setEnergy(player.getEnergy() - 6);
                    }

                    else
                    {
                        gameplayActivity.drawMap();
                        player.setEnergy(player.getEnergy() - 2);
                        game.abi(player.getAbility());
                    }
                }
            }

            else
            {
                gameplayActivity.drawMap();
                game.abi(player.getAbility());
            }
        }
    }

    public boolean playerCanExit()
    {
        for (Entity entity:entitites)
        {
            if (!player.playerCanExit())
                return false;
        }

        return game.lever.playerCanExit();
    }

    public boolean isWalkable(GameVec a)
    {
        return a.getX() >= 0 && a.getY() >= 0 && a.getX() < map.length && a.getY() < map[0].length && !map[a.getX()][a.getY()].equals("wall_tile");
    }
}