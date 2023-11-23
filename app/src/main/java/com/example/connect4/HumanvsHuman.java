package com.example.connect4;

import java.util.Random;

public class HumanvsHuman {

    private Model game = new Model();
    private Random rand = new Random();
    private Position[][] board = game.board;
    private int turnNum = rand.nextInt(2); //turnNum → 0/1 → player 1/2 goes first

    //Methods about turns changing------------------------------------------------------------------
    private String decideWhoGoesFirst(){
        if (turnNum == 0){
            game.currentTurn = "player1";
        }
        else{
            game.currentTurn = "player2";
        }
        return game.currentTurn;
    }

    private String changeTurns(String turn){
        if(game.currentTurn == "player1"){
            turn = "player2";
            return turn;
        }
        else {
            turn = "player1";
            return turn;
        }
    }
    //----------------------------------------------------------------------------------------------

    //Methods about humans' moves-------------------------------------------------------------------
    private void showPiecesWherePlayersClicked(int col, String currentTurn){
        for (int row = game.COLUMNS - 1; row >= 0; row--) {
            if (game.ifEqualToNull(row, col)) {
                board[row][col].setPlayer(currentTurn);
            }
        }
    }

    private void afterClickedByPlayers(int col){
        showPiecesWherePlayersClicked(col, changeTurns(decideWhoGoesFirst()));
    }
    //----------------------------------------------------------------------------------------------

    //Methods about three connects checking and hints giving----------------------------------------
    private void checkThreeConnects(String currentTurn){
        if (game.ifThreeConnects()) {
            giveThreeConnectsHints();
        }
    }

    private String giveThreeConnectsHints(){
        return "The other player almost win.";
    }

    private void undoPlayerOne(){

    }

    private void undoPlayerTwo(){

    }
    //----------------------------------------------------------------------------------------------
}
