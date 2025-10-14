package com.kalk.darkness;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainMenu extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);
    }

    public void dive(View v)
    {
        Intent pip = new Intent(this, dive_choise.class);
        startActivity(pip);
    }

    public void rules(View v)
    {
        Intent pip = new Intent(this, MainMenu.class);
        startActivity(pip);
    }

    public void authors(View v)
    {
        Intent pip = new Intent(this, authors.class);
        startActivity(pip);
    }

    public void exit(View v)
    {
        Globals.statistics.save();

        finishAffinity();
    }
}