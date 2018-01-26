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
    View teamABackgroundView;
    View teamBBackgroundView;
    TextView teamAScoreView;
    TextView teamBScoreView;
    ImageView teamALogoView;
    ImageView teamBLogoView;
    Button teamATouchdownView;
    Button teamAExtraPointView;
    Button teamAConversionView;
    Button teamAFieldGoalView;
    Button teamASafetyView;
    Button teamBTouchdownView;
    Button teamBExtraPointView;
    Button teamBConversionView;
    Button teamBFieldGoalView;
    Button teamBSafetyView;
    int scoreForTeamA = 0;
    int scoreForTeamB = 0;
    
    final static String score_for_team_A_state="score_for_team_A_state";
    final static String score_for_team_B_state="score_for_team_B_state";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collegeOneSpinner = (Spinner) findViewById(R.id.spinner1);
        collegeOneSpinner.setOnItemSelectedListener(this);

        collegeTwoSpinner = (Spinner) findViewById(R.id.spinner2);
        collegeTwoSpinner.setOnItemSelectedListener(this);

        teamABackgroundView = findViewById(R.id.team_a_background);
        teamBBackgroundView = findViewById(R.id.team_b_background);
        teamAScoreView = (TextView) findViewById(R.id.team_a_score);
        teamBScoreView = (TextView) findViewById(R.id.team_b_score);
        teamALogoView = (ImageView) findViewById(R.id.team_a_logo);
        teamBLogoView = (ImageView) findViewById(R.id.team_b_logo);
        teamATouchdownView = (Button) findViewById(R.id.team_a_touchdown);
        teamAExtraPointView = (Button) findViewById((R.id.team_a_extra_point));
        teamAConversionView = (Button) findViewById((R.id.team_a_conversion));
        teamAFieldGoalView = (Button) findViewById(R.id.team_a_field_goal);
        teamASafetyView = (Button) findViewById(R.id.team_a_safety);
        teamBTouchdownView = (Button) findViewById(R.id.team_b_touchdown);
        teamBExtraPointView = (Button) findViewById((R.id.team_b_extra_point));
        teamBConversionView = (Button) findViewById((R.id.team_b_conversion));
        teamBFieldGoalView = (Button) findViewById(R.id.team_b_field_goal);
        teamBSafetyView = (Button) findViewById(R.id.team_b_safety);

        if (savedInstanceState != null) {
            scoreForTeamA = savedInstanceState.getInt(score_for_team_A_state);
            scoreForTeamB = savedInstanceState.getInt(score_for_team_B_state);
        } else {
            scoreForTeamA = 0; scoreForTeamB = 0;
        }

        displayForTeamA(scoreForTeamA);
        displayForTeamB(scoreForTeamB);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(score_for_team_A_state, scoreForTeamA);
        savedInstanceState.putInt(score_for_team_B_state, scoreForTeamB);
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
        teamAScoreView.setText(String.valueOf(score));
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
        teamBScoreView.setText(String.valueOf(score));
    }


    /**
     * Changes the background color, button color, button text color and logo on the appropriate side to match the selected team.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String teamOne = (String) collegeOneSpinner.getSelectedItem();
        String teamTwo = (String) collegeTwoSpinner.getSelectedItem();

        if (teamOne.equals("Pick a college")) {
            teamABackgroundView.setBackgroundResource(R.color.Pick_a_team_black_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.choose_a_team_home));

            teamATouchdownView.setTextAppearance(this, R.style.PickATeam_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.PickATeam_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.PickATeam_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.PickATeam_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.PickATeam_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Albany")) {
            teamABackgroundView.setBackgroundResource(R.color.Albany_purple_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.albany_logo));

            teamATouchdownView.setTextAppearance(this, R.style.Albany_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.Albany_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.Albany_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.Albany_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.Albany_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Delaware")) {
            teamABackgroundView.setBackgroundResource(R.color.delaware_blue_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.delaware_logo));

            teamATouchdownView.setTextAppearance(this, R.style.Delaware_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.Delaware_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.Delaware_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.Delaware_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.Delaware_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Elon")) {
            teamABackgroundView.setBackgroundResource(R.color.elon_red_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.elon_logo));

            teamATouchdownView.setTextAppearance(this, R.style.Elon_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.Elon_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.Elon_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.Elon_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.Elon_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("James Madison")) {
            teamABackgroundView.setBackgroundResource(R.color.jmu_purple_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.jmu_logo));

            teamATouchdownView.setTextAppearance(this, R.style.JMU_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.JMU_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.JMU_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.JMU_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.JMU_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);
        }

            if (teamOne.equals("Maine")) {
            teamABackgroundView.setBackgroundResource(R.color.maine_black_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.maine_logo));

            teamATouchdownView.setTextAppearance(this, R.style.Maine_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.Maine_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.Maine_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.Maine_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.Maine_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("New Hampshire")) {
            teamABackgroundView.setBackgroundResource(R.color.nh_blue_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.new_hampshire_logo));

            teamATouchdownView.setTextAppearance(this, R.style.New_Hampshire_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.New_Hampshire_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.New_Hampshire_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.New_Hampshire_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.New_Hampshire_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Rhode Island")) {
            teamABackgroundView.setBackgroundResource(R.color.ri_dark_blue_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.rhode_island_logo));

            teamATouchdownView.setTextAppearance(this, R.style.Rhode_Island_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.Rhode_Island_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.Rhode_Island_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.Rhode_Island_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.Rhode_Island_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Richmond")) {
            teamABackgroundView.setBackgroundResource(R.color.richmond_dark_blue_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.richmond_logo));

            teamATouchdownView.setTextAppearance(this, R.style.Richmond_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.Richmond_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.Richmond_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.Richmond_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.Richmond_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Stony Brook")) {
            teamABackgroundView.setBackgroundResource(R.color.sb_dark_blue_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.stony_brook_logo));

            teamATouchdownView.setTextAppearance(this, R.style.Stony_Brook_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.Stony_Brook_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.Stony_Brook_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.Stony_Brook_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.Stony_Brook_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Towson")) {
            teamABackgroundView.setBackgroundResource(R.color.towson_black_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.towson_logo));

            teamATouchdownView.setTextAppearance(this, R.style.Towson_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.Towson_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.Towson_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.Towson_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.Towson_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("Villanova")) {
            teamABackgroundView.setBackgroundResource(R.color.villanova_dark_blue_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.villanova_logo));

            teamATouchdownView.setTextAppearance(this, R.style.Villanova_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.Villanova_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.Villanova_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.Villanova_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.Villanova_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamOne.equals("William & Mary")) {
            teamABackgroundView.setBackgroundResource(R.color.WM_green_background);

            teamALogoView.setImageDrawable(getResources().getDrawable(R.drawable.wm_logo));

            teamATouchdownView.setTextAppearance(this, R.style.WM_Button);
            teamATouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);

            teamAExtraPointView.setTextAppearance(this, R.style.WM_Button);
            teamAExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);

            teamAFieldGoalView.setTextAppearance(this, R.style.WM_Button);
            teamAFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);

            teamASafetyView.setTextAppearance(this, R.style.WM_Button);
            teamASafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);

            teamAConversionView.setTextAppearance(this, R.style.WM_Button);
            teamAConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Pick a college")) {
            teamBBackgroundView.setBackgroundResource(R.color.Pick_a_team_black_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.choose_a_team_away));

            teamBTouchdownView.setTextAppearance(this, R.style.PickATeam_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.PickATeam_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.PickATeam_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.PickATeam_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.PickATeam_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Pick_a_team_black1), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Albany")) {
            teamBBackgroundView.setBackgroundResource(R.color.Albany_purple_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.albany_logo));

            teamBTouchdownView.setTextAppearance(this, R.style.Albany_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.Albany_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.Albany_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.Albany_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.Albany_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.Albany_purple1), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Delaware")) {
            teamBBackgroundView.setBackgroundResource(R.color.delaware_blue_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.delaware_logo));

            teamBTouchdownView.setTextAppearance(this, R.style.Delaware_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.Delaware_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.Delaware_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.Delaware_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.Delaware_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.delaware_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Elon")) {
            teamBBackgroundView.setBackgroundResource(R.color.elon_red_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.elon_logo));

            teamBTouchdownView.setTextAppearance(this, R.style.Elon_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.Elon_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.Elon_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.Elon_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.Elon_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.elon_red), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("James Madison")) {
            teamBBackgroundView.setBackgroundResource(R.color.jmu_purple_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.jmu_logo));

            teamBTouchdownView.setTextAppearance(this, R.style.JMU_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.JMU_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.JMU_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.JMU_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.JMU_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.jmu_purple), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Maine")) {
            teamBBackgroundView.setBackgroundResource(R.color.maine_black_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.maine_logo));

            teamBTouchdownView.setTextAppearance(this, R.style.Maine_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.Maine_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.Maine_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.Maine_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.Maine_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.maine_black), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("New Hampshire")) {
            teamBBackgroundView.setBackgroundResource(R.color.nh_blue_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.new_hampshire_logo));

            teamBTouchdownView.setTextAppearance(this, R.style.New_Hampshire_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.New_Hampshire_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.New_Hampshire_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.New_Hampshire_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.New_Hampshire_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.nh_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Rhode Island")) {
            teamBBackgroundView.setBackgroundResource(R.color.ri_dark_blue_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.rhode_island_logo));

            teamBTouchdownView.setTextAppearance(this, R.style.Rhode_Island_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.Rhode_Island_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.Rhode_Island_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.Rhode_Island_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.Rhode_Island_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.ri_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Richmond")) {
            teamBBackgroundView.setBackgroundResource(R.color.richmond_dark_blue_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.richmond_logo));

            teamBTouchdownView.setTextAppearance(this, R.style.Richmond_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.Richmond_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.Richmond_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.Richmond_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.Richmond_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.richmond_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Stony Brook")) {
            teamBBackgroundView.setBackgroundResource(R.color.sb_dark_blue_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.stony_brook_logo));

            teamBTouchdownView.setTextAppearance(this, R.style.Stony_Brook_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.Stony_Brook_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.Stony_Brook_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.Stony_Brook_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.Stony_Brook_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.sb_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Towson")) {
            teamBBackgroundView.setBackgroundResource(R.color.towson_black_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.towson_logo));

            teamBTouchdownView.setTextAppearance(this, R.style.Towson_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.Towson_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.Towson_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.Towson_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.Towson_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.towson_black), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("Villanova")) {
            teamBBackgroundView.setBackgroundResource(R.color.villanova_dark_blue_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.villanova_logo));

            teamBTouchdownView.setTextAppearance(this, R.style.Villanova_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.Villanova_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.Villanova_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.Villanova_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.Villanova_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.villanova_dark_blue), PorterDuff.Mode.MULTIPLY);
        }

        if (teamTwo.equals("William & Mary")) {
            teamBBackgroundView.setBackgroundResource(R.color.WM_green_background);

            teamBLogoView.setImageDrawable(getResources().getDrawable(R.drawable.wm_logo));

            teamBTouchdownView.setTextAppearance(this, R.style.WM_Button);
            teamBTouchdownView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);

            teamBExtraPointView.setTextAppearance(this, R.style.WM_Button);
            teamBExtraPointView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);

            teamBFieldGoalView.setTextAppearance(this, R.style.WM_Button);
            teamBFieldGoalView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);

            teamBSafetyView.setTextAppearance(this, R.style.WM_Button);
            teamBSafetyView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);

            teamBConversionView.setTextAppearance(this, R.style.WM_Button);
            teamBConversionView.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.WM_green1), PorterDuff.Mode.MULTIPLY);
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}


