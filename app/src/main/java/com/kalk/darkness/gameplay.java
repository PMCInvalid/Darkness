package com.kalk.darkness;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class gameplay extends movement_logic
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);
        gameplayInit();
    }

    public void buttonUpAction(View v)
    {
        playerMove(1);
    }

    public void buttonUpRightAction(View v)
    {
        playerMove(2);
    }

    public void buttonRightAction(View v)
    {
        playerMove(3);
    }

    public void buttonDownRightAction(View v)
    {
        playerMove(4);
    }

    public void buttonDownAction(View v)
    {
        playerMove(5);
    }

    public void buttonDownLeftAction(View v)
    {
        playerMove(6);
    }

    public void buttonLeftAction(View v)
    {
        playerMove(7);
    }

    public void buttonUpLeftAction(View v)
    {
        playerMove(8);
    }

    public void midButtonAction(View v)
    {
        playerMove(9);
        test();
    }

    public void test()
    {
        System.out.println(player.corY + " " + player.corX);
        System.out.println("-------");
        System.out.println(battery.corY + " " + battery.corX);
    }
}