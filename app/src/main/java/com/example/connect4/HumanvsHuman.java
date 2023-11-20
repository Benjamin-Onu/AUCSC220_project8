package com.example.connect4;

import java.util.Random;

public class HumanvsHuman {

    private Model game = new Model();
    private Position[][] board = game.board;
    private Random rand = new Random();
    int turnNum = rand.nextInt(2); //turnNum → 0/1 → player 1/2 goes first

    private String decideWhoGoesFirst(){
        if (turnNum == 0){
            game.currentTurn = "player1";
        }
        else{
            game.currentTurn = "player2";
        }
        return game.currentTurn;
    }

    private void showPiecesWherePlayersClicked(int row, String currentTurn){
        for (int col = game.COLUMNS - 1; col >= 0; col--) {
            if (board[row][col].getPlayer().equals(' ')) {
                board[row][col].setPlayer(currentTurn);
            }
        }
    }

    private void clickedByPlayers(int row){
        showPiecesWherePlayersClicked(row, changeTurns(decideWhoGoesFirst()));
    }

    private String changeTurns(String turn){
        if(decideWhoGoesFirst() == "player1"){
            turn = "player2";
            return turn;
        }
        else {
            turn = "player1";
            return turn;
        }
    }

    private void checkThreeConnects(String currentTurn){
        if (game.ifThreeConnects()) {
            giveThreeConnectsHints();
        }
    }

    protected String giveThreeConnectsHints(){
        return "The other player almost win.";
    }
}
