package com.example.android.footballscoring;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreForTeamA = 0;
    int scoreForTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreForTeamA);
    }

    /**
     * This method is called when Reset button is clicked and resets both scores to 0.
     */
    public void resetScoreForBothTeams(View view) {
        scoreForTeamA = 0;
        scoreForTeamB = 0;
        displayForTeamA(scoreForTeamA);
        displayForTeamB(scoreForTeamB);
    }

    /**
     * This method is called when the Touchdown button is clicked for Team A.
     */
    public void plusSixPointsForTeamA(View view) {
        scoreForTeamA = scoreForTeamA + 6;
        displayForTeamA(scoreForTeamA);
    }

    /**
     * This method is called when the Field Goal button is clicked for Team A.
     */
    public void plusThreePointsForTeamA(View view) {
        scoreForTeamA = scoreForTeamA + 3;
        displayForTeamA(scoreForTeamA);
    }

    /**
     * This method is called when the Safety button is clicked for Team A.
     */
    public void plusTwoPointsForTeamA(View view) {
        scoreForTeamA = scoreForTeamA + 2;
        displayForTeamA(scoreForTeamA);
    }

    /**
     * This method is called when the Extra Point button is clicked for Team A.
     */
    public void plusOnePointForTeamA(View view) {
        scoreForTeamA = scoreForTeamA + 1;
        displayForTeamA(scoreForTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method is called when the +3 Points button is clicked for Team B.
     */
    public void plusSixPointsForTeamB(View view) {
        scoreForTeamB = scoreForTeamB + 6;
        displayForTeamB(scoreForTeamB);
    }

    /**
     * This method is called when the +3 Points button is clicked for Team B.
     */
    public void plusThreePointsForTeamB(View view) {
        scoreForTeamB = scoreForTeamB + 3;
        displayForTeamB(scoreForTeamB);
    }

    /**
     * This method is called when the +2 Points button is clicked for Team B.
     */
    public void plusTwoPointsForTeamB(View view) {
        scoreForTeamB = scoreForTeamB + 2;
        displayForTeamB(scoreForTeamB);
    }

    /**
     * This method is called when the Free Throw button is clicked for Team B.
     */
    public void plusOnePointForTeamB(View view) {
        scoreForTeamB = scoreForTeamB + 1;
        displayForTeamB(scoreForTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
