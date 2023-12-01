package com.example.connect4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gameplay extends AppCompatActivity {
    Button instructions;
    Model game;
    /*
    We have 42 buttons to implement and in order to keep this file readable without having
    to add 42 lines of initializing buttons, I created a buttons class to initialize all
    the buttons.
     */
    Buttons gamePieces = new Buttons();
    Button[][] gameBoard = gamePieces.getBoard();
    Button column1BTN = findViewById(R.id.column1);
    Button column2BTN = findViewById(R.id.column2);
    Button column3BTN = findViewById(R.id.column3);
    Button column4BTN = findViewById(R.id.column4);
    Button column5BTN = findViewById(R.id.column5);
    Button column6BTN = findViewById(R.id.column6);
    Button column7BTN = findViewById(R.id.column7);

    /*
     * The next field is keeping track of the row number after each column have been clicked
     * If column1 is clicked the first value will be
     * */
    int[] rowTrack = {5, 5, 5, 5, 5, 5};
    Button backToHomepage = findViewById(R.id.home);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        game = new Model();
        /**
         * Disable all the buttons from the second bottom row to the very top row
         */
        for(int row = 5;row >= 0;row--){
            for(int col = 0; col < 6; col++){
                gameBoard[row][col].setEnabled(false);
            }
        }
        instructions = (Button) findViewById(R.id.instructions);
        instructions.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                openInstructions();
            }

//        backToHomepage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Model.class, Homepage.class);
//                startActivity(Intent intent);
//            }
//        });


        });
        backToHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHomePage();
            }
        });

        //Main loop of the game.
        while(!game.ifWinnerExist()){




        }


    }

    private void enableNextCell(int previousRow, int buttonNumber){
        int row = previousRow + 1;
        gameBoard[row][buttonNumber].setEnabled(true);
    }

    private void openInstructions() {
        Intent popupInstructions = new Intent(Gameplay.this, PopUpInstructions.class);
        startActivity(popupInstructions);
    }

    public void backToHomePage() {
        Intent myIntent;
        myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void displayWinner(){

    }


    /**
     * These functions are for the buttons that are being used to select a position
     */
    public void columnOne(){
        //If column one is clicked, what should happen


    }

    public void columnTwo(){}

    public void columnThree(){}

    public void columnFour(){}

    public void columnFive(){}

    public void columnSix(){}

}
