package com.kalk.darkness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class death_screen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.death_screen);
    }

    public void goToMainMenuFromDeathScreen(View v)
    {
        Intent pip = new Intent(this, main_menu.class);
        startActivity(pip);
    }

    public void newGame(View v)
    {
        Intent pip = new Intent(this, dive_choise.class);
        startActivity(pip);
    }
}
