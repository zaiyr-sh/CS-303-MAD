package com.example.scoreboard;

import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int countForHomeTeam = 0;
    private int countForGuestTeam = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button homeButtonScore = (Button) findViewById(R.id.homeButtonScore);
        homeButtonScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView homeScore = (TextView) findViewById(R.id.homeScore);
                countForHomeTeam++;
                homeScore.setText(String.valueOf(countForHomeTeam));
            }
        });

        Button guestButtonScore = (Button) findViewById(R.id.guestButtonScore);
        guestButtonScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView guestScore = (TextView) findViewById(R.id.guestScore);
                countForGuestTeam++;
                guestScore.setText(String.valueOf(countForGuestTeam));
            }
        });

        Button resetScore = (Button) findViewById(R.id.resetScore);
        resetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView homeScore = (TextView) findViewById(R.id.homeScore);
                TextView guestScore = (TextView) findViewById(R.id.guestScore);
                countForHomeTeam = 0;
                countForGuestTeam = 0;
                homeScore.setText(String.valueOf(countForHomeTeam));
                guestScore.setText(String.valueOf(countForGuestTeam));
            }
        });

    }
}