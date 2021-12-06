package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Friend_Activity extends AppCompatActivity {

    Button restart, home, rock1, rock2, paper1, paper2, scissors1, scissors2;
    ImageView choice1, choice2;
    TextView winner;
    TextView counter1, counter2;

    int userScore1, userScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        restart = (Button) findViewById(R.id.restart_game);
        home = (Button) findViewById(R.id.home_page);
        rock1 = (Button) findViewById(R.id.rock_select1);
        rock2 = (Button) findViewById(R.id.rock_select2);
        paper1 = (Button) findViewById(R.id.paper_select1);
        paper2 = (Button) findViewById(R.id.paper_select2);
        scissors1 = (Button) findViewById(R.id.scissor_select1);
        scissors2 = (Button) findViewById(R.id.scissor_select2);
        choice1 = (ImageView) findViewById(R.id.playerChoice1);
        choice2 = (ImageView) findViewById(R.id.playerChoice2);
        winner = (TextView) findViewById(R.id.winner_tv);
        counter1 = (TextView) findViewById(R.id.count1);
        counter2 = (TextView) findViewById(R.id.count2);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Friend_Activity.this,GamePage.class);
                startActivity(intent);
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear_score();
            }
        });

        rock1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setImageResource(R.drawable.rock);
                String mess = play_turn("rock");
                winner.setText(mess);
            }
        });

        rock2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setImageResource(R.drawable.rock);
                String mess = play_turn("rock");
                winner.setText(mess);
            }
        });

        paper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setImageResource(R.drawable.p);
                String mess = play_turn("paper");
                winner.setText(mess);
            }
        });

        paper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setImageResource(R.drawable.p);
                String mess = play_turn("paper");
                winner.setText(mess);
            }
        });

        scissors1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setImageResource(R.drawable.csissors);
                String mes = play_turn("scissors");
                winner.setText(mes);
            }
        });

        scissors2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setImageResource(R.drawable.csissors);
                String mes = play_turn("scissors");
                winner.setText(mes);
            }
        });

    }

    private void clear_score() {

        winner.setText("0");
        counter1.setText("0");
        counter2.setText("0");
    }


    public String play_turn (String player_choice1) {
        String player_choice2 = "";
        int max = 3;
        int min = 1;
        int range = max - min + 2;
        int player_choice2_number = (int) (Math.random() * range) + min;


        if (player_choice2_number == 1) {
            player_choice2 = "rock";
        } else if (player_choice2_number == 2) {
            player_choice2 = "paper";
        } else if (player_choice2_number == 3) {
            player_choice2 = "scissors";
        }

        //set the computer image based on his choice
        if (player_choice1.equals("rock")) {
            choice1.setImageResource(R.drawable.rock);
        } else if (player_choice1.equals("paper")) {
            choice1.setImageResource(R.drawable.p);
        } else if (player_choice1.equals("scissors")) {
            choice1.setImageResource(R.drawable.csissors);
        }

        if (player_choice2.equals("rock")) {
            choice2.setImageResource(R.drawable.rock);
        } else if (player_choice2.equals("paper")) {
            choice2.setImageResource(R.drawable.p);
        } else if (player_choice2.equals("scissors")) {
            choice2.setImageResource(R.drawable.csissors);
        }

        //compare human and computer to determine who wins
            if (player_choice1.equals(player_choice2)){
                userScore1 ++;
                userScore2 ++;
                counter1.setText(userScore1);
                counter2.setText(userScore2);

                return "Match is draw";

        }
        else if (player_choice1.equals("rock") && player_choice2.equals("scissors")) {
            userScore1++;
            counter1.setText(userScore1);
            return "Player1 wins";
        }
        else if (player_choice1.equals("rock") && player_choice2.equals("paper")) {
            userScore2++;
            counter2.setText(userScore2);
            return "Player2 wins";
        }
        else if (player_choice1.equals("paper") && player_choice2.equals("scissors")) {
            userScore2++;
            counter2.setText(userScore2);
            return "Player2 wins";
        }
        else if (player_choice1.equals("scissors") && player_choice2.equals("rock")) {
            userScore2++;
            counter2.setText(userScore2);
            return "Player2 wins";
        }
        else if (player_choice1.equals("scissors") && player_choice2.equals("paper")) {
            userScore2++;
            counter2.setText(userScore2);
            return "Player1 wins";
        }
        else if (player_choice1.equals("paper") && player_choice2.equals("rock")) {
            userScore1++;
            counter1.setText(userScore1);
            return "Player1 wins";
        } else return "Not Sure";

    }

}