package com.example.connect4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.RadioButton;
import android.media.MediaPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    //Button settings;
    Button instructions;//was formerly the rules button
    Button startBTN;
    private Model game = new Model();
    Button loadBTN;
    MediaPlayer mediaPlayer;
    /*
    While the game is still running
    Track the moves in a stack
    get the peek value then
    get the buttons clicked, enable the next button


    change the color of the previous button (create a change color method, black for player 1,
    white for player 2.

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instructions = (Button) findViewById(R.id.instructions);


        instructions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openInstructions();
            }

        });

        startBTN = (Button) findViewById(R.id.button);
        startBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GameMode = new Intent(MainActivity.this, GameMode.class);
                startActivity(GameMode);
                mediaPlayer.start();
            }
        });

        loadBTN = (Button) findViewById(R.id.load);
        loadBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadGameState();
            }
        });
        // Initialize MediaPlayer with the audio file in the res/raw directory
        mediaPlayer = MediaPlayer.create(this, R.raw.music_file);
    }

    private void openInstructions() {
        Intent popupInstructions = new Intent(MainActivity.this, PopUpInstructions.class);
        startActivity(popupInstructions);
    }

    /*protected void loadGameState2(){
        ReverseStackGetter lastMoves = new ReverseStackGetter();
        lastMoves.getReverseRowStack();
        String previousGame; //previousGame = game.getLastGame()
        previousGame = "0 0 0 0 0 0 0 \n" +
                "0 0 0 0 0 0 0 \n" +
                "0 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0\n" +
                "0 1 2 2 0 1 1\n" +
                "1 1 2 2 0 1 2";
        String[] rows = previousGame.split("\n");
        int rowCount = 0;
        for (int rowCounter = 0; rowCounter < rows.length; rowCounter++){
            String[] eachSpot = rows[rowCounter].split(" ");
            for (int col = 0; col < board[rowCounter].length; col++) {
                if(eachSpot[col].equals("1")){
                    game.updateBoard(rowCounter, col, "player1");
                    Button myButton = board[rowCounter][col];
                    myButton.setBackgroundColor(color1);
                }else if (eachSpot[col].equals("2")){
                    game.updateBoard(rowCounter, col, "player2");
                    Button myButton = board[rowCounter][col];
                    myButton.setBackgroundColor(color2);
                }
            }
        }
        if(game.determineNextTurnprevGAME() == 1){
            game.setCurrentTurn("player1");
        }else{
            game.setCurrentTurn("player2");
        }
    }*/

    protected void loadGameState(){
        try {
            FileWriter myWriter = new FileWriter(" C:\\Users\\user\\Documents\\Android_Studio" +
                    "\\AUCSC220_project8\\app\\src\\main\\java\\com\\example\\connect4\\loadGame.txt");
            myWriter.write("true");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}