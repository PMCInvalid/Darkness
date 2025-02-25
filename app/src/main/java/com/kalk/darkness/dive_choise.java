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

public class dive_choise extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_choice);
    }

    public void surfaceWalk(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("difficulty","easy");
        editor.apply();

        Intent pip = new Intent(this, gameplay.class);
        startActivity(pip);
    }

    public void deepDive(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("difficulty","hard");
        editor.apply();

        Intent pip = new Intent(this, gameplay.class);
        startActivity(pip);
    }

    public void blackout(View v)
    {
        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("difficulty","insane");
        editor.apply();

        Intent pip = new Intent(this, gameplay.class);
        startActivity(pip);
    }

    public void gotoMainMenu(View v)
    {
        Intent pip = new Intent(this, main_menu.class);
        startActivity(pip);
    }
}
