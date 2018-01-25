package com.example.android.footballscoring;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner collegeOneSpinner;
    Spinner collegeTwoSpinner;
    int scoreForTeamA = 0;
    int scoreForTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collegeOneSpinner = (Spinner) findViewById(R.id.spinner1);
        collegeOneSpinner.setOnItemSelectedListener(this);

        collegeTwoSpinner = (Spinner) findViewById(R.id.spinner2);
        collegeTwoSpinner.setOnItemSelectedListener(this);

        if (savedInstanceState != null) {
            scoreForTeamA = savedInstanceState.getInt("score_for_team_A_state");
            scoreForTeamB = savedInstanceState.getInt("score_for_team_B_state");
        } else {
            scoreForTeamA = 0; scoreForTeamB = 0;
        }

        displayForTeamA(scoreForTeamA);
        displayForTeamB(scoreForTeamB);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("score_for_team_A_state", scoreForTeamA);
        savedInstanceState.putInt("score_for_team_B_state", scoreForTeamB);
        super.onSaveInstanceState(savedInstanceState);
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
     * This method is called when the Safety or Two Point Conversion button is clicked for Team A.
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
     * This method is called when the Touchdown button is clicked for Team B.
     */
    public void plusSixPointsForTeamB(View view) {
        scoreForTeamB = scoreForTeamB + 6;
        displayForTeamB(scoreForTeamB);
    }

    /**
     * This method is called when the Field Goal button is clicked for Team B.
     */
    public void plusThreePointsForTeamB(View view) {
        scoreForTeamB = scoreForTeamB + 3;
        displayForTeamB(scoreForTeamB);
    }

    /**
     * This method is called when the Safety or Two Point Conversion button is clicked for Team B.
     */
    public void plusTwoPointsForTeamB(View view) {
        scoreForTeamB = scoreForTeamB + 2;
        displayForTeamB(scoreForTeamB);
    }

    /**
     * This method is called when the Extra Point button is clicked for Team B.
     */
    public void plusOnePointForTeamB(View view) {
        scoreForTeamB = scoreForTeamB + 1;
        displayForTeamB(scoreForTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Changes the background color, button color, button text color and logo on the appropriate side to match the selected team.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String teamOne = (String) collegeOneSpinner.getSelectedItem();
        String teamTwo = (String) collegeTwoSpinner.getSelectedItem();

        if (teamOne.equals("Pick a college")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.Pick_a_team_black_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.choose_a_team_home));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.PickATeam_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.PickATeam_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.PickATeam_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.PickATeam_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.PickATeam_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Albany")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.Albany_purple_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.albany_logo));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.Albany_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.Albany_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.Albany_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.Albany_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.Albany_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Delaware")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.delaware_blue_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.delaware_logo));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.Delaware_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.Delaware_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.Delaware_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.Delaware_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.Delaware_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Elon")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.elon_red_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.elon_logo));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.Elon_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.Elon_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.Elon_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.Elon_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.Elon_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("James Madison")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.jmu_purple_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.jmu_logo));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.JMU_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.JMU_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.JMU_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.JMU_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.JMU_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);
        }

            if (teamOne.equals("Maine")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.maine_black_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.maine_logo));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.Maine_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.Maine_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.Maine_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.Maine_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.Maine_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("New Hampshire")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.nh_blue_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.new_hampshire_logo));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.New_Hampshire_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.New_Hampshire_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.New_Hampshire_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.New_Hampshire_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.New_Hampshire_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Rhode Island")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.ri_dark_blue_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.rhode_island_logo));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.Rhode_Island_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.Rhode_Island_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.Rhode_Island_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.Rhode_Island_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.Rhode_Island_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Richmond")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.richmond_dark_blue_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.richmond_logo));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.Richmond_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.Richmond_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.Richmond_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.Richmond_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.Richmond_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Stony Brook")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.sb_dark_blue_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.stony_brook_logo));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.Stony_Brook_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.Stony_Brook_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.Stony_Brook_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.Stony_Brook_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.Stony_Brook_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Towson")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.towson_black_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.towson_logo));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.Towson_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.Towson_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.Towson_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.Towson_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.Towson_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Villanova")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.villanova_dark_blue_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.villanova_logo));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.Villanova_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.Villanova_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.Villanova_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.Villanova_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.Villanova_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("William & Mary")) {
            View background = findViewById(R.id.team_a_background);
            background.setBackgroundResource(R.color.WM_green_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_a_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.wm_logo));
            Button b1 = (Button) findViewById(R.id.team_a_touchdown);
            b1.setTextAppearance(this, R.style.WM_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_a_extra_point);
            b2.setTextAppearance(this, R.style.WM_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_a_field_goal);
            b3.setTextAppearance(this, R.style.WM_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_a_safety);
            b4.setTextAppearance(this, R.style.WM_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_a_conversion);
            b5.setTextAppearance(this, R.style.WM_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Pick a college")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.Pick_a_team_black_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.choose_a_team_away));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.PickATeam_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.PickATeam_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.PickATeam_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.PickATeam_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.PickATeam_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Albany")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.Albany_purple_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.albany_logo));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.Albany_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.Albany_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.Albany_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.Albany_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.Albany_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Delaware")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.delaware_blue_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.delaware_logo));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.Delaware_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.Delaware_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.Delaware_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.Delaware_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.Delaware_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Elon")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.elon_red_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.elon_logo));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.Elon_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.Elon_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.Elon_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.Elon_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.Elon_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("James Madison")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.jmu_purple_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.jmu_logo));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.JMU_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.JMU_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.JMU_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.JMU_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.JMU_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Maine")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.maine_black_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.maine_logo));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.Maine_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.Maine_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.Maine_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.Maine_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.Maine_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("New Hampshire")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.nh_blue_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.new_hampshire_logo));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.New_Hampshire_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.New_Hampshire_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.New_Hampshire_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.New_Hampshire_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.New_Hampshire_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Rhode Island")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.ri_dark_blue_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.rhode_island_logo));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.Rhode_Island_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.Rhode_Island_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.Rhode_Island_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.Rhode_Island_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.Rhode_Island_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Richmond")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.richmond_dark_blue_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.richmond_logo));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.Richmond_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.Richmond_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.Richmond_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.Richmond_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.Richmond_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Stony Brook")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.sb_dark_blue_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.stony_brook_logo));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.Stony_Brook_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.Stony_Brook_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.Stony_Brook_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.Stony_Brook_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.Stony_Brook_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Towson")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.towson_black_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.towson_logo));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.Towson_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.Towson_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.Towson_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.Towson_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.Towson_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Villanova")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.villanova_dark_blue_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.villanova_logo));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.Villanova_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.Villanova_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.Villanova_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.Villanova_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.Villanova_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("William & Mary")) {
            View background = findViewById(R.id.team_b_background);
            background.setBackgroundResource(R.color.WM_green_background);
            ImageView iv1 = (ImageView) findViewById(R.id.team_b_logo);
            iv1.setImageDrawable(getResources().getDrawable(R.drawable.wm_logo));
            Button b1 = (Button) findViewById(R.id.team_b_touchdown);
            b1.setTextAppearance(this, R.style.WM_Button);
            b1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);
            Button b2 = (Button) findViewById(R.id.team_b_extra_point);
            b2.setTextAppearance(this, R.style.WM_Button);
            b2.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);
            Button b3 = (Button) findViewById(R.id.team_b_field_goal);
            b3.setTextAppearance(this, R.style.WM_Button);
            b3.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);
            Button b4 = (Button) findViewById(R.id.team_b_safety);
            b4.setTextAppearance(this, R.style.WM_Button);
            b4.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);
            Button b5 = (Button) findViewById(R.id.team_b_conversion);
            b5.setTextAppearance(this, R.style.WM_Button);
            b5.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}


