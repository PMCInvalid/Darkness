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

        TextView highS = (TextView) findViewById(R.id.textViewHighScore);
        TextView sco = (TextView) findViewById(R.id.textViewScore);

        if (Globals.settings.getDifficulty().equals(Constants.difficulty_easy))
        {
            sco.setText("Your score is:" + Globals.activeScore);
            highS.setText("Highscore is:" + Globals.statistics.getScore(Constants.difficulty_easy));

            if (Globals.statistics.getScore(Constants.difficulty_easy) < Globals.activeScore)
                Globals.statistics.setScore();
        }

        if (Globals.settings.getDifficulty().equals(Constants.difficulty_hard))
        {
            sco.setText("Your score is:" + Globals.activeScore);
            highS.setText("Highscore is:" + Globals.statistics.getScore(Constants.difficulty_hard));

            if (Globals.statistics.getScore(Constants.difficulty_hard) < Globals.activeScore)
                Globals.statistics.setScore();
        }

        if (Globals.settings.getDifficulty().equals(Constants.difficulty_insane))
        {
            sco.setText("Your score is:" + Globals.activeScore);
            highS.setText("Highscore is:" + Globals.statistics.getScore(Constants.difficulty_insane));

            if (Globals.statistics.getScore(Constants.difficulty_insane) < Globals.activeScore)
                Globals.statistics.setScore();
        }
    }

    public void goToMainMenuFromDeathScreen(View v)
    {
        Intent pip = new Intent(this, MainMenu.class);
        startActivity(pip);
    }

    public void newGame(View v)
    {
        Intent pip = new Intent(this, dive_choise.class);
        startActivity(pip);
    }
}
