package com.example.connect4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class Gameplay extends AppCompatActivity {
    /*
     * The next field is keeping track of the row number after each column have been clicked
     * If column1 is clicked the first value will be
     * */
    protected int[] rowTrack = {5, 5, 5, 5, 5, 5, 5};
    protected Button[][] board;
    protected Random rand = new Random();
    protected MovesStack movesStack = new MovesStack();
    Model game;
    Button instructions;
    String turn;
    Button undo;
    Button restart;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //Call decide who goes first to initialize the current turn
        decideWhoGoesFirst();
        game = new Model(turn);
        Button backToHomepage = findViewById(R.id.home);
        Button column1BTN = findViewById(R.id.column1);
        Button column2BTN = findViewById(R.id.column2);
        Button column3BTN = findViewById(R.id.column3);
        Button column4BTN = findViewById(R.id.column4);
        Button column5BTN = findViewById(R.id.column5);
        Button column6BTN = findViewById(R.id.column6);
        Button column7BTN = findViewById(R.id.column7);
        createButtons();
        column1BTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                columnOne();
                if(game.ifWinnerExist()){
                    displayWinner();
                }
                changeTurns();
            }
          }
        );

        column2BTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                columnTwo();
                if(game.ifWinnerExist()){
                    displayWinner();
                }
                changeTurns();
            }
        }
        );

        column3BTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                columnThree();
                if(game.ifWinnerExist()){
                    displayWinner();
                }
                changeTurns();
            }
        }
        );

        column4BTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                columnFour();
                if(game.ifWinnerExist()){
                    displayWinner();
                }
                changeTurns();
            }
        }
        );

        column5BTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                columnFive();
                if(game.ifWinnerExist()){
                    displayWinner();
                }
                changeTurns();
            }
        }
        );

        column6BTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                columnSix();
                if(game.ifWinnerExist()){
                    displayWinner();
                }
                changeTurns();
            }
        }
        );

        column7BTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                columnSeven();
                if(game.ifWinnerExist()){
                    displayWinner();
                }
                changeTurns();
            }
        }
        );

        /**
         * Disable all the buttons from the second bottom row to the very top row
         */
        for(int row = 5;row >= 0;row--){
            for(int col = 0; col < 6; col++){
                board[row][col].setEnabled(false);
            }
        }
        instructions = (Button) findViewById(R.id.instructions);
        onRestart();
        instructions.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                openInstructions();
            }
        });

        undo = (Button) findViewById(R.id.undo);
        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                undoLastMove();
            }
        });

        backToHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHomePage();
            }
        });

        restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame();
            }
        });
        //Main loop of the game
    }



    /*
  We have 42 buttons to implement and in order to keep this file readable without having
  to add 42 lines of initializing buttons, I created a buttons class to initialize all
  the buttons.
   */
    public void createButtons(){
        board = new Button[6][7];
        Button b00 = findViewById(R.id.b00);
        Button b01 = findViewById(R.id.b01);
        Button b02 = findViewById(R.id.b02);
        Button b03 = findViewById(R.id.b03);
        Button b04 = findViewById(R.id.b04);
        Button b05 = findViewById(R.id.b05);
        Button b06 = findViewById(R.id.b06);

        Button b10 = findViewById(R.id.b10);
        Button b11 = findViewById(R.id.b11);
        Button b12 = findViewById(R.id.b12);
        Button b13 = findViewById(R.id.b13);
        Button b14 = findViewById(R.id.b14);
        Button b15 = findViewById(R.id.b15);
        Button b16 = findViewById(R.id.b16);

        Button b20 = findViewById(R.id.b20);
        Button b21 = findViewById(R.id.b21);
        Button b22 = findViewById(R.id.b22);
        Button b23 = findViewById(R.id.b23);
        Button b24 = findViewById(R.id.b24);
        Button b25 = findViewById(R.id.b25);
        Button b26 = findViewById(R.id.b26);

        Button b30 = findViewById(R.id.b30);
        Button b31 = findViewById(R.id.b31);
        Button b32 = findViewById(R.id.b32);
        Button b33 = findViewById(R.id.b33);
        Button b34 = findViewById(R.id.b34);
        Button b35 = findViewById(R.id.b35);
        Button b36 = findViewById(R.id.b36);

        Button b40 = findViewById(R.id.b40);
        Button b41 = findViewById(R.id.b41);
        Button b42 = findViewById(R.id.b42);
        Button b43 = findViewById(R.id.b43);
        Button b44 = findViewById(R.id.b44);
        Button b45 = findViewById(R.id.b45);
        Button b46 = findViewById(R.id.b46);

        Button b50 = findViewById(R.id.b50);
        Button b51 = findViewById(R.id.b51);
        Button b52 = findViewById(R.id.b52);
        Button b53 = findViewById(R.id.b53);
        Button b54 = findViewById(R.id.b54);
        Button b55 = findViewById(R.id.b55);
        Button b56 = findViewById(R.id.b56);

        board = new Button[][]{
                {b00, b01, b02, b03, b04, b05, b06},
                {b10, b11, b12, b13, b14, b15, b16},
                {b20, b21, b22, b23, b24, b25, b26},
                {b30, b31, b32, b33, b34, b35, b36},
                {b40, b41, b42, b43, b44, b45, b46},
                {b50, b51, b52, b53, b54, b55, b56}
        };
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


    protected String decideWhoGoesFirst(){
        int turnNum = rand.nextInt(2);
        if (turnNum == 0){
            turn = "left";
        }
        else{
            turn = "right";
        }
        return turn;
    }

    protected void changeTurns(){
        if(game.getCurrentTurn().equals("player1")){//currentTurn == "player1"){
            game.setCurrentTurn("player2");
        }
        else {
            game.setCurrentTurn("player1");
        }
    }
    public void displayWinner(){}
    /**
     * If there is a winner, go to the display winner page
     */


    /**
     * These functions are for the buttons that are being used to select a position
     */
    int color1=Color.parseColor("#FF000000");
    int color2=Color.parseColor("#FFFFFFFF");
    int color3=Color.parseColor("#e1ba6c");

    public void changeButtonColor(Button myButton){
        ColorDrawable buttonColor = (ColorDrawable) myButton.getBackground();
        int currentColor = buttonColor.getColor();
        /**
         * If its the first player's turn , change the button color to black
         */
        if(currentColor == color3 && game.getCurrentTurn().equals("player1")){
            myButton.setBackgroundColor(color1);
        }/**
         * If its the second player's turn , change the button color to white
         */
        else if (currentColor == color3 && game.getCurrentTurn().equals("player2")){
            myButton.setBackgroundColor(color2);
        }
    }

    public void changeButtonColorUNDO(Button myButton){
        myButton.setBackgroundColor(color3);
    }
    public void columnOne(){
        //If column one is clicked, what should happen
        changeButtonColor(board[rowTrack[0]][0]);
        game.updateBoard(rowTrack[0], 0, game.getCurrentTurn());
        movesStack.recordMove(rowTrack[0], 0);
        rowTrack[0]--;
    }

    public void columnTwo(){
        changeButtonColor(board[rowTrack[1]][1]);
        game.updateBoard(rowTrack[1], 1, game.getCurrentTurn());
        movesStack.recordMove(rowTrack[1], 1);
        rowTrack[1]--;
    }

    public void columnThree(){
        changeButtonColor(board[rowTrack[2]][2]);
        game.updateBoard(rowTrack[2], 2, game.getCurrentTurn());
        movesStack.recordMove(rowTrack[2], 2);
        rowTrack[2]--;
    }

    public void columnFour(){
        changeButtonColor(board[rowTrack[3]][3]);
        game.updateBoard(rowTrack[3], 3, game.getCurrentTurn());
        movesStack.recordMove(rowTrack[3], 3);
        rowTrack[3]--;
    }

    public void columnFive(){
        changeButtonColor(board[rowTrack[4]][4]);
        game.updateBoard(rowTrack[4], 4, game.getCurrentTurn());
        movesStack.recordMove(rowTrack[4], 4);
        rowTrack[4]--;
    }

    public void columnSix(){
        changeButtonColor(board[rowTrack[5]][5]);
        game.updateBoard(rowTrack[5], 5, game.getCurrentTurn());
        movesStack.recordMove(rowTrack[5], 5);
        rowTrack[5]--;
    }

    public void columnSeven() {
        changeButtonColor(board[rowTrack[6]][6]);
        game.updateBoard(rowTrack[6], 6, game.getCurrentTurn());
        movesStack.recordMove(rowTrack[6], 6);
        rowTrack[6]--;
    }

    protected void undoLastMove(){
        int[] deletedPiecesPosition = movesStack.deleteMove();
        int deletedRow = deletedPiecesPosition[0];
        int deletedCol = deletedPiecesPosition[1];
        game.updateBoard(deletedRow, deletedCol, " ");
        changeButtonColorUNDO(board[deletedRow][deletedCol]);
        rowTrack[deletedCol]++;
    }

    protected  void restartGame(){
        while(!movesStack.movesInRow.isEmpty()){
            undoLastMove();
        }
        game.setCurrentTurn("player1");
        decideWhoGoesFirst();
    }
}
