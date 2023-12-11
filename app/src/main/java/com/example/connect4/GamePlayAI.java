package com.example.connect4;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class GamePlayAI extends AppCompatActivity {
    /*
       rowTrack Explanation:
       The next field is keeping track of the row number after each column have been clicked
       If column1 is clicked the first value will be 4 because the next availale row is the one
       above it.
     */
    protected int[] rowTrack = {5, 5, 5, 5, 5, 5, 5};
    protected Button[][] board;
    protected MovesStack movesStack = MovesStack.getInstance();
    private Random rand = new Random();
    Button instructions;
    Button undo;
    Button restart;
    Model game;
    String turn;
    int AIcolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        game = new Model();
        decideWhoGoesFirst();

        Button backToHomepage = findViewById(R.id.home);
        Button column1BTN = findViewById(R.id.column1);
        Button column2BTN = findViewById(R.id.column2);
        Button column3BTN = findViewById(R.id.column3);
        Button column4BTN = findViewById(R.id.column4);
        Button column5BTN = findViewById(R.id.column5);
        Button column6BTN = findViewById(R.id.column6);
        Button column7BTN = findViewById(R.id.column7);
        createButtons();

        //Disable all the buttons from the second bottom row to the very top row
        for(int row = 5;row >= 0;row--){
            for(int col = 0; col < 6; col++){
                board[row][col].setEnabled(false);
            }
        }

        //If AI goes first, set it to be player1
        if(turn.equals("AI")){
            game.setCurrentTurn("player1");
            AIcolor = color1;
            AITurn();
        }

        //------------------------------------------------------------------------------------------
        //region **Seven ColumnBTNs OnClickListener**
        column1BTN.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  columnOne();
                  if(game.ifWinnerExist()){
                      displayWinner(game.getWinner());
                  }
                  if(game.ifFullColumn(0)){
                      //disableColumnBTN(column1BTN);
                  };
                  changeTurns();
                  AITurn();
              }
          }
        );

        column2BTN.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    columnTwo();
                    if(game.ifWinnerExist()){
                        displayWinner(game.getWinner());
                    }
                    if(game.ifFullColumn(1)){
                        //disableColumnBTN(1);
                    };
                    changeTurns();
                    AITurn();
                }
            }
        );

        column3BTN.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    columnThree();
                    if(game.ifWinnerExist()){
                        displayWinner(game.getWinner());
                    }
                    if(game.ifFullColumn(2)){
                        //disableColumnBTN(2);
                    };
                    changeTurns();
                    AITurn();
                }
            }
        );

        column4BTN.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    columnFour();
                    if(game.ifWinnerExist()){
                        displayWinner(game.getWinner());
                    }
                    if(game.ifFullColumn(3)){
                        //disableColumnBTN(3);
                    };
                    changeTurns();
                    AITurn();
                }
            }
        );

        column5BTN.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    columnFive();
                    if(game.ifWinnerExist()){
                        displayWinner(game.getWinner());
                    }
                    if(game.ifFullColumn(4)){
                        //disableColumnBTN(4);
                    };
                    changeTurns();
                    AITurn();
                }
            }
        );

        column6BTN.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    columnSix();
                    if(game.ifWinnerExist()){
                        displayWinner(game.getWinner());
                    }
                    if(game.ifFullColumn(5)){
                        //disableColumnBTN(5);
                    };
                    changeTurns();
                    AITurn();
                }
            }
        );

        column7BTN.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    columnSeven();
                    if(game.ifWinnerExist()){
                        displayWinner(game.getWinner());
                    }
                    if(game.ifFullColumn(6)){
                        //disableColumnBTN(6);
                    };
                    changeTurns();
                    AITurn();
                }
            }
        );
        //endregion
        //------------------------------------------------------------------------------------------

        //------------------------------------------------------------------------------------------
        //region **Bottom Buttons' OnClickListener**
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
        //endregion
        //------------------------------------------------------------------------------------------

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

    protected String decideWhoGoesFirst(){
        int turnNum = rand.nextInt(2);
        if (turnNum == 0){
            turn = "AI";
        }
        else{
            turn = "Player";
            AIcolor = color2;
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

    public void AITurn(){
        ArrayList<Position> availableSpots = new ArrayList<>();
        availableSpots = generateAvailableSpots();
        Position chosenSpot = pickAIspot(availableSpots);
        game.updateBoard(chosenSpot.getRow(), chosenSpot.getColumn(),
        game.getCurrentTurn());
        switch (chosenSpot.getColumn()){
            case 0:
                columnOne();
                break;
            case 1:
                columnTwo();
                break;
            case 2:
                columnThree();
                break;
            case 3:
                columnFour();
                break;
            case 4:
                columnFive();
                break;
            case 5:
                columnSix();
                break;
            case 6:
                columnSeven();
                break;
        }
        changeTurns();
    }

    /*
    * IT generates all the spots
    * it checks for the last spot
    * */
    public Position pickAIspot(ArrayList<Position> availableSpots){
        ArrayList<Position> optimizedSpots = new ArrayList<>();
        int rowT;
        for(int indx= 0; indx<availableSpots.size(); indx++){
            if(rowTrack[indx] == 5){
                optimizedSpots.add(availableSpots.get(indx));
            }else {
                rowT = rowTrack[indx] + 1;
                Button myButton = board[rowT][indx];
                ColorDrawable buttonColor = (ColorDrawable) myButton.getBackground();
                int currentColor = buttonColor.getColor();
                if (currentColor == AIcolor) {
                    optimizedSpots.add(availableSpots.get(indx));
                }
            }
        }
        int randomSpotIndex = rand.nextInt(optimizedSpots.size()-1);
        Position randomSpot = optimizedSpots.get(randomSpotIndex);

        return randomSpot;
    }

    public ArrayList<Position> generateAvailableSpots(){
        ArrayList<Position> availableSpots = new ArrayList<>();
        for(int col = 0; col <= 6; col++){
            Position newSpot = new Position(rowTrack[col], col, " ");
            availableSpots.add(newSpot);
        }
        return availableSpots;
    }

    public void displayWinner(String winner){
        if(game.getWinner().equals("player1")){
            //go to this page if player 1 has won the game
            Intent P1Win = new Intent(GamePlayAI.this, P1Win.class);
            startActivity(P1Win);
        }else if(game.getWinner().equals("player2")) {
            //go to this page if player 2 has won the game
            Intent P2Win = new Intent(GamePlayAI.this, P2Win.class);
            startActivity(P2Win);
        }//If the board is full there is no winner
        else if(game.getCurrentTurn().equals("noWinner")) {
            //go to this page if there is not a winner of the game
            Intent ResultMessage = new Intent(GamePlayAI.this, DefaultMessage.class);
            startActivity(ResultMessage);
        }
    }
    public void displayWinner2(String winner){
         /*
            Select the winner textview
             */
        if(game.getWinner().equals("player1")){

            //go to this page if player 1 has won the game
            /**
             * Set the text to
             * "    PLAYER ONE WIN
             * CLICK RESTART or HOME to Start a New Game
             * "
             * disable undo, column buttons , leave only restart and home buttons
             *
             */

            //WE ARE NO LONGER DISPLAYING WINNER ON A NEW PAGE
            //Intent P1Win = new Intent(Gameplay.this, P2Win.class);
            //startActivity(P1Win);
        }else if(game.getWinner().equals("player2")) {
            //go to this page if player 2 has won the game

            /**
             * Set the text to
             * "    PLAYER TWO WIN
             * CLICK RESTART or HOME to Start a New Game
             * "
             * disable undo, column buttons , leave only restart and home buttons
             *
             */
            //Intent P2Win = new Intent(Gameplay.this, P2Win.class);
            //startActivity(P2Win);
        }//If the board is full there is no winner
        else if(game.getCurrentTurn().equals("noWinner")){
            //go to this page if there is not a winner of the game
            /**
             * Set the text to
             * "    NO ONE WIN
             * CLICK RESTART or HOME to Start a New Game
             * "
             * disable undo, column buttons , leave only restart and home buttons
             *
             */
            //Intent ResultMessage = new Intent(Gameplay.this, P2Win.class);
            //startActivity(ResultMessage);
        }
    }

    public void saveWinner(){
        File filename;
        //BUG- Writing into winners winners.txt not working
        try{
            filename = new File("app/src/main/java/com/example/connect4/winners.txt");
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);

            String winner = game.getWinner();
            bw.write(winner);
        }
        catch (FileNotFoundException e){
            System.out.println("ERROR - File not found");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        These functions are for the buttons that are being used to select a position
    */
    //----------------------------------------------------------------------------------------------
    //region **Change Color**
    int color1= Color.parseColor("#FF000000");
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
    //endregion
    //----------------------------------------------------------------------------------------------

    /*
        What happen once player click Seven ColumnBTNs
    */
    //----------------------------------------------------------------------------------------------
    //region **Columns' Actions**
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
    //endregion
    //----------------------------------------------------------------------------------------------

    /*
        undoLastMove → change the last pieces the other player moved to be origin color
        restartGame → clean the board and implement decideWhoGoesFirst again
        openInstructions → show another page that is about the instructions of the game
        backToHomepage → go back to the homepage
     */
    //----------------------------------------------------------------------------------------------
    //region **Bottom Buttons' Actions**
    protected void undoLastMove(){
        int[] deletedPiecesPosition = movesStack.deleteMove();
        int deletedRow = deletedPiecesPosition[0];
        int deletedCol = deletedPiecesPosition[1];
        game.updateBoard(deletedRow, deletedCol, " ");
        changeButtonColorUNDO(board[deletedRow][deletedCol]);
        rowTrack[deletedCol]++;
    }

    protected void restartGame(){
        while(!movesStack.getMovesInRow().isEmpty()){
            undoLastMove();
        }
        game.setCurrentTurn("player1");
        decideWhoGoesFirst();
    }

    private void openInstructions() {
        Intent popupInstructions = new Intent(GamePlayAI.this, PopUpInstructions.class);
        startActivity(popupInstructions);
    }

    public void backToHomePage() {
        Intent myIntent;
        myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
    //endregion
    //----------------------------------------------------------------------------------------------
}



