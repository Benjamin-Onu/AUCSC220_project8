package com.example.connect4;

import java.util.Random;

public class HumanvsHuman {
    private String player1;
    private String player2;
    private String winner;
    private String turn;
    private Model game = new Model();
    private Position[][] board = game.board;
    private Random rand = new Random();
    int turnNum = rand.nextInt(2); //turnNum → 0/1 → player 1/2 goes first

    private String decideWhoGoesFirst(){
        if (turnNum == 0){
            turn = "player1";
        }
        else{
            turn = "player2";
        }
        return turn;
    }

    private boolean checkThreeConnects(Position board[][], int xval, int yval){
        boolean threeConnected;
        switch (board[xval][yval])
            case board[xval][yval].getPlayer() == turn && board[xval][yval + 1].getPlayer() == turn && board[xval][yval + 2].getPlayer() == turn
        return threeConnected;
    }
}
