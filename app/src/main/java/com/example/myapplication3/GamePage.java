package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GamePage extends AppCompatActivity {


    Button playFriend;
    Button playComputer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        playFriend = (Button) findViewById(R.id.friendBtn);

        playComputer = (Button) findViewById(R.id.computerBtn);

        playFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(GamePage.this,Friend_Activity.class);
                startActivity(intent1);
            }
        });
        playComputer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(GamePage.this,ComputerActivity.class);
                        startActivity(intent);

                    }
                }
        );
    }
}