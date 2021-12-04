package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ComputerActivity extends AppCompatActivity {

    ImageView restart;
    ImageButton home;

    TextView comText;
    TextView plyText;
    TextView winner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        comText = (TextView) findViewById(R.id.computerPly);
        plyText = (TextView) findViewById(R.id.player1);
        winner = (TextView) findViewById(R.id.winner_tv);
        restart = (ImageView) findViewById(R.id.restart_game);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear_score();
            }
        });

    }
    private void clear_score() {
        comText.setText("0");
        plyText.setText("0");
        winner.setText("");

        restart.requestFocus();
    }

}