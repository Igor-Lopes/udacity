package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreCounterA;
    private int scoreCounterB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreCounterA = 0;
        scoreCounterB = 0;
    }

    public void threePointsA(View view) {
        scoreCounterA += 3;
        displayForTeamA();
    }

    public void twoPointsA(View view) {
        scoreCounterA += 2;
        displayForTeamA();
    }

    public void freeThrowA(View view) {
        scoreCounterA += 1;
        displayForTeamA();
    }

    public void threePointsB(View view) {
        scoreCounterB += 3;
        displayForTeamB();
    }

    public void twoPointsB(View view) {
        scoreCounterB += 2;
        displayForTeamB();
    }

    public void freeThrowB(View view) {
        scoreCounterB += 1;
        displayForTeamB();
    }

    public void resetScore(View view) {
        scoreCounterA = 0;
        scoreCounterB = 0;
        displayForTeamA();
        displayForTeamB();
    }

    /**
     * Displays the given score for Team A.
     */
    private void displayForTeamA() {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreCounterA));
    }

    /**
     * Displays the given score for Team b.
     */
    private void displayForTeamB() {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreCounterB));
    }
}
