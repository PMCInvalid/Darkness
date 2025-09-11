package com.kalk.darkness;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class dive_choise extends AppCompatActivity
{
    public dive_choise()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_choice);

        TextView sWalk = (TextView) findViewById(R.id.textViewRecordSurfaceWalk);
        TextView dDive = (TextView) findViewById(R.id.textViewRecordDeepDIve);
        TextView bOut = (TextView) findViewById(R.id.textViewRecordBlackout);

        if (Globals.statistics != null)
        {
            sWalk.setText("Highscore: " + Globals.statistics.getScore(Constants.difficulty_easy));
            dDive.setText("Highscore: " + Globals.statistics.getScore(Constants.difficulty_hard));
            bOut.setText("Highscore: " + Globals.statistics.getScore(Constants.difficulty_insane));
        }
        else {
            sWalk.setText("Highscore: 0");
            dDive.setText("Highscore: 0");
            bOut.setText("Highscore: 0");
        }
    }

    public void surfaceWalk(View v)
    {
        Globals.settings.setDifficulty(Constants.difficulty_easy);

        Intent pip = new Intent(this, Gameplay.class);
        startActivity(pip);
    }

    public void deepDive(View v)
    {
        Globals.settings.setDifficulty(Constants.difficulty_hard);

        Intent pip = new Intent(this, Gameplay.class);
        startActivity(pip);
    }

    public void blackout(View v)
    {
        Globals.settings.setDifficulty(Constants.difficulty_insane);

        Intent pip = new Intent(this, Gameplay.class);
        startActivity(pip);
    }

    public void gotoMainMenu(View v)
    {
        Intent pip = new Intent(this, MainMenu.class);
        startActivity(pip);
    }
}
