package com.example.connect4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;


import androidx.appcompat.app.AppCompatActivity;

public class Gameplay extends AppCompatActivity {
    /*
     * The next field is keeping track of the row number after each column have been clicked
     * If column1 is clicked the first value will be
     * */
    protected int[] rowTrack = {5, 5, 5, 5, 5, 5, 5};
    protected Button[][] board;
    protected Random rand = new Random();
    protected MovesStack movesStack = MovesStack.getInstance();
    private Model game;
    private Button instructions;
    private String turn;
    private Button undo;
    private Button restart;
    private Button save; //save game button
    private Button[] columnButtons = new Button[7];

    protected void onCreate(Bundle savedInstanceState) {
        //Call decide who goes first to initialize the current turn
        //decideWhoGoesFirst();
        Context context = getApplicationContext();
        StringBuilder stringBuilder = new StringBuilder();;
        File file = new File(context.getFilesDir(), "loadGameCheck.txt");
        try {
            // Open a FileInputStream for the file
            FileInputStream fis = new FileInputStream(file);
            // Wrap the FileInputStream in an InputStreamReader
            InputStreamReader isr = new InputStreamReader(fis);
            // Wrap the InputStreamReader in a BufferedReader
            BufferedReader br = new BufferedReader(isr);
            // Read the contents of the file line by line
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            // Close the BufferedReader
            br.close();
        } catch (IOException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        game = new Model();

        Button backToHomepage = findViewById(R.id.home);
        Button column1BTN = findViewById(R.id.column1);
        columnButtons[0] = column1BTN;
        Button column2BTN = findViewById(R.id.column2);
        columnButtons[1] = column2BTN;
        Button column3BTN = findViewById(R.id.column3);
        columnButtons[2] = column3BTN;
        Button column4BTN = findViewById(R.id.column4);
        columnButtons[3] = column4BTN;
        Button column5BTN = findViewById(R.id.column5);
        columnButtons[4] = column5BTN;
        Button column6BTN = findViewById(R.id.column6);
        columnButtons[5] = column6BTN;
        Button column7BTN = findViewById(R.id.column7);
        columnButtons[6] = column7BTN;

        createButtons();

        //Disable all the buttons from the second bottom row to the very top row
        for(int row = 5;row >= 0;row--){
            for(int col = 0; col < 6; col++){
                board[row][col].setEnabled(false);
            }
        }
        boolean checker = stringBuilder.toString().equals("true\n");
        if(checker){
            readDataFromInternalStorage(getApplicationContext());
            //continue the previous game by setting the next turn
            Context newContext = getApplicationContext();
            File file2 = new File(newContext.getFilesDir(), "loadGameCheck.txt");
            try {
                FileOutputStream fos = new FileOutputStream(file2);
                String previousGame = "false";
                // Convert the string to bytes and write to the file
                fos.write(previousGame.getBytes());
                // Close the FileOutputStream
                fos.close();
                //Determine the next turn from the previous game
                if(game.determineNextTurnprevGAME() == 1){
                    game.setCurrentTurn("player1");
                }else{
                    game.setCurrentTurn("player2");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

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
                    //disableColumnBTN(0);
                    column1BTN.setEnabled(false);
                };
                changeTurns();
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
                    column2BTN.setEnabled(false);
                };
                changeTurns();
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
                    column3BTN.setEnabled(false);
                };
                changeTurns();
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
                    column4BTN.setEnabled(false);
                };
                changeTurns();
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
                    column5BTN.setEnabled(false);
                };
                changeTurns();
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
                    column6BTN.setEnabled(false);
                };
                changeTurns();
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
                    column7BTN.setEnabled(false);
                };
                changeTurns();
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
                String deletedTurn;
                if(game.getCurrentTurn().equals("player1")){
                    deletedTurn = "player2";
                }else{
                    deletedTurn = "player1";
                }
                undoLastMove();
                game.setCurrentTurn(deletedTurn);
            }
        });
        //This will prevent the user from reversing a move when it's just the start of a new game
        //or a previous game.
        undo.setEnabled(false);

        backToHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHomePage();
            }
        });

        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveGame();
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
            turn = "Left";
        }
        else{
            turn = "Right";
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

    public void displayWinner(String winner){
        if(game.getWinner().equals("player1")){
            //go to this page if player 1 has won the game
            Intent P1Win = new Intent(Gameplay.this, P1Win.class);
            startActivity(P1Win);
        }else if(game.getWinner().equals("player2")) {
            //go to this page if player 2 has won the game
            Intent P2Win = new Intent(Gameplay.this, P2Win.class);
            startActivity(P2Win);
        }//If the board is full there is no winner
        else if(game.getCurrentTurn().equals("noWinner")) {
            //go to this page if there is not a winner of the game
            Intent ResultMessage = new Intent(Gameplay.this, DefaultMessage.class);
            startActivity(ResultMessage);
        }
    }

    /*
        These functions are for the buttons that are being used to select a position
     */
    //----------------------------------------------------------------------------------------------
    //region **Change Color**
    int color1 = Color.parseColor("#FF000000");
    int color2 = Color.parseColor("#FFFFFFFF");
    int color3 = Color.parseColor("#e1ba6c");

    public void changeButtonColor(Button myButton){
        ColorDrawable buttonColor = (ColorDrawable) myButton.getBackground();
        int currentColor = buttonColor.getColor();

        //If its the first player's turn , change the button color to black
        if(currentColor == color3 && game.getCurrentTurn().equals("player1")){
            myButton.setBackgroundColor(color1);
        }
        //If its the second player's turn , change the button color to white
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
        if(!game.ifFullColumn(0)){
            //disableColumnBTN(0);
            undo.setEnabled(true);
            changeButtonColor(board[rowTrack[0]][0]);
            game.updateBoard(rowTrack[0], 0, game.getCurrentTurn());
            movesStack.recordMove(rowTrack[0], 0);
            rowTrack[0]--;
        }
    }

    public void columnTwo(){
        if(!game.ifFullColumn(1)){
            undo.setEnabled(true);
            changeButtonColor(board[rowTrack[1]][1]);
            game.updateBoard(rowTrack[1], 1, game.getCurrentTurn());
            movesStack.recordMove(rowTrack[1], 1);
            rowTrack[1]--;
        }
    }

    public void columnThree(){
        if(!game.ifFullColumn(2)){
            undo.setEnabled(true);
            changeButtonColor(board[rowTrack[2]][2]);
            game.updateBoard(rowTrack[2], 2, game.getCurrentTurn());
            movesStack.recordMove(rowTrack[2], 2);
            rowTrack[2]--;
        }
    }

    public void columnFour(){
        if(!game.ifFullColumn(3)){
            undo.setEnabled(true);
            changeButtonColor(board[rowTrack[3]][3]);
            game.updateBoard(rowTrack[3], 3, game.getCurrentTurn());
            movesStack.recordMove(rowTrack[3], 3);
            rowTrack[3]--;
        }
    }

    public void columnFive(){
        if(!game.ifFullColumn(4)){
            undo.setEnabled(true);
            changeButtonColor(board[rowTrack[4]][4]);
            game.updateBoard(rowTrack[4], 4, game.getCurrentTurn());
            movesStack.recordMove(rowTrack[4], 4);
            rowTrack[4]--;
        }
    }

    public void columnSix(){
        if(!game.ifFullColumn(5)){
            undo.setEnabled(true);
            changeButtonColor(board[rowTrack[5]][5]);
            game.updateBoard(rowTrack[5], 5, game.getCurrentTurn());
            movesStack.recordMove(rowTrack[5], 5);
            rowTrack[5]--;
        }
    }

    public void columnSeven() {
        if(!game.ifFullColumn(6)){
            undo.setEnabled(true);
            changeButtonColor(board[rowTrack[6]][6]);
            game.updateBoard(rowTrack[6], 6, game.getCurrentTurn());
            movesStack.recordMove(rowTrack[6], 6);
            rowTrack[6]--;
        }
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
        if(movesStack.movesInCol.isEmpty()){
            undo.setEnabled(false);
        }else{
            int[] deletedPiecesPosition = movesStack.deleteMove();
            int deletedRow = deletedPiecesPosition[0];
            int deletedCol = deletedPiecesPosition[1];
            game.updateBoard(deletedRow, deletedCol, " ");
            //This is to ensure that the buttons that were disabled as a result of a full column will
            //be enabled after the undo button is clicked
            columnButtons[deletedCol].setEnabled(true);
            changeButtonColorUNDO(board[deletedRow][deletedCol]);
            rowTrack[deletedCol]++;
        }
    }

    protected void restartGame(){
        while(!movesStack.getMovesInRow().isEmpty()){
            undoLastMove();
        }
        game.setCurrentTurn("player1");
        decideWhoGoesFirst();
        rowTrack = new int[]{5, 5, 5, 5, 5, 5, 5};
    }

    protected void saveGame(){
      game.saveGameState();
      writeLastGameIntoFile();
    }
    protected void writeLastGameIntoFile(){
        Context context = getApplicationContext();
        File file = new File(context.getFilesDir(), "GameState.txt");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            String previousGame = game.getLastGame();
            // Convert the string to bytes and write to the file
            fos.write(previousGame.getBytes());
            // Close the FileOutputStream
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readDataFromInternalStorage(Context context) {
        // File object pointing to the "GameState.txt" file in internal storage
        File file = new File(context.getFilesDir(), "GameState.txt");

        try {
            // Open a FileInputStream for the file
            FileInputStream fis = new FileInputStream(file);
            // Wrap the FileInputStream in an InputStreamReader
            InputStreamReader isr = new InputStreamReader(fis);
            // Wrap the InputStreamReader in a BufferedReader
            BufferedReader br = new BufferedReader(isr);
            // Read the contents of the file line by line
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            // Close the BufferedReader
            br.close();

            String previousGame = stringBuilder.toString();
            String[] rows = previousGame.split("\n");
            //rows contains a list of rows in the previous game
            for(int indx = 0; indx < rows.length; indx++){
                String eachRow = rows[indx];
                String[] eachSpot = eachRow.split(" ");
                for (int col = 0; col < board[indx].length; col++) {
                    if(eachSpot[col].equals("1")){
                        game.updateBoard(indx, col, "player1");
                        rowTrack[col]--;
                        movesStack.recordMove(indx, col);
                        Button myButton = board[indx][col];
                        myButton.setBackgroundColor(color1);
                    }else if (eachSpot[col].equals("2")){
                        game.updateBoard(indx, col, "player2");
                        rowTrack[col]--;
                        movesStack.recordMove(indx, col);
                        Button myButton = board[indx][col];
                        myButton.setBackgroundColor(color2);
                    }
                }
            }
            movesStack.reverseStack();
            //Since the file was read from top to bottom, the most recent moves are at the
            //bottom of the stack, so to make it normal we reverse the stack
        } catch (IOException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }
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
    //endregion
    //----------------------------------------------------------------------------------------------
}
