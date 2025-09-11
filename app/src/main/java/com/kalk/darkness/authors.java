package com.kalk.darkness;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

public class authors extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authros);
    }

    public void menuButton(View v)
    {
        Intent pip = new Intent(this, MainMenu.class);
        startActivity(pip);
    }
}