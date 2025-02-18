package com.kalk.darkness;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class main_menu extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);
    }

    public void dive(View v)
    {
        Intent pip = new Intent(this, main_menu.class);
        startActivity(pip);
    }

    public void rules(View v)
    {
        Intent pip = new Intent(this, main_menu.class);
        startActivity(pip);
    }

    public void authors(View v)
    {
        Intent pip = new Intent(this, main_menu.class);
        startActivity(pip);
    }

    public void onDestroy()
    {
        moveTaskToBack(true);

        super.onDestroy();

        System.runFinalizersOnExit(true);
        System.exit(0);
    }
}


/*
Intent pip = new Intent(this, mainMenu.class);
startActivity(pip);
*/