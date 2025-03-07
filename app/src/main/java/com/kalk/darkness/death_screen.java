package com.kalk.darkness;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class death_screen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.death_screen);

        SharedPreferences settings = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        TextView highS = (TextView) findViewById(R.id.textViewHighScore);
        TextView sco = (TextView) findViewById(R.id.textViewScore);

        String h = settings.getString("highscore", "0");
        String s = settings.getString("score", "0");

        if (Double.parseDouble(h) < Double.parseDouble(s))
        {
            editor.putString("highscore", s);
            editor.apply();
        }

        highS.setText("Highscore is:" + h);
        sco.setText("Your score is:" + s);

        editor.remove("score");
        editor.remove("difficulty");
        editor.apply();
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
