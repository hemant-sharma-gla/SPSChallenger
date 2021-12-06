package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ComputerActivity extends AppCompatActivity {

    Button restart;
    Button home;
    Button scissors;
    Button rock;
    Button paper;
    ImageView comText;
    ImageView plyText;
    //TextView choicePly;
    TextView finalWinner;

    int userScore;
    int computerScore;

    TextView counter1;
    TextView counter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        comText = (ImageView) findViewById(R.id.computerChoice);
        plyText = (ImageView) findViewById(R.id.playerChoice);
        finalWinner = (TextView) findViewById(R.id.winner_tv);
        rock = (Button) findViewById(R.id.rock_select);
        paper = (Button) findViewById(R.id.paper_select);
        scissors = (Button) findViewById(R.id.scissor_select);
        restart = (Button) findViewById(R.id.restart_game);
        home = (Button)findViewById(R.id.home_page);
//        choicePly = (TextView) findViewById(R.id.playerTxt);
        counter1 = (TextView)findViewById(R.id.count1_comp);
        counter2 = (TextView)findViewById(R.id.count2_comp);


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear_score();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComputerActivity.this,GamePage.class);
                startActivity(intent);
            }
        });

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plyText.setImageResource(R.drawable.rock);
                String mess = play_turn("Rock");
                finalWinner.setText(mess);
            }
        });


        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plyText.setImageResource(R.drawable.p);
                String message = play_turn("paper");

                finalWinner.setText(message);
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              plyText.setImageResource(R.drawable.csissors);
                String message = play_turn("scissors");

                finalWinner.setText(message);
            }
        });
    }

    // clear the score.
    private void clear_score() {
        finalWinner.setText("0");
        counter1.setText("0");
        counter2.setText("0");
    }

    public String play_turn (String player_choice) {
        String computer_choice = "";
        int max=3;
        int min=1;
        int range = max-min+2;
        int computer_choice_number = (int)(Math.random() * range)+min;

        if (computer_choice_number == 1) {
            computer_choice = "Rock";
        } else if (computer_choice_number == 2) {
            computer_choice = "paper";
        } else {
            computer_choice = "scissors";
        }

        //set the computer image based on his choice
        if (computer_choice.equals("Rock")) {
            comText.setImageResource(R.drawable.rock);
        } else if (computer_choice.equals("paper")) {
            comText.setImageResource(R.drawable.p);
        } else {
            comText.setImageResource(R.drawable.csissors);
        }

        //for rock

        if (player_choice.equals("Rock") && computer_choice.equals("scissors")) {
            userScore++;
            counter1.setText(userScore);

        }
        else if (player_choice.equals("Rock") && computer_choice.equals("paper")) {
            computerScore++;
            counter2.setText(computerScore);

        }
        else if (player_choice.equals(computer_choice)) {
            userScore++;
            computerScore++;
            counter2.setText(userScore);
            counter1.setText(computerScore);

        }
         // for paper
        else if (player_choice.equals("paper") && computer_choice.equals("scissors")) {
            computerScore++;
            counter1.setText(computerScore);

        }
        else if (player_choice.equals("paper") && computer_choice.equals("Rock")) {
            userScore++;
            counter2.setText(userScore);

        }


        //for scissors

        else if (player_choice.equals("scissors") && computer_choice.equals("paper")) {
            userScore++;
            counter1.setText(userScore);

        }
        else if (player_choice.equals("scissors") && computer_choice.equals("Rock")) {
            computerScore++;
            counter2.setText(computerScore);

        }

        // checking Winner according to their counter values.
        if(userScore==computerScore)
            return "Match drawn";
        else if(userScore > computerScore)
            return "user wins";
        else
            return "computer wins";

   }

}