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

    private String decideWhoGoesFirst(){
        int turnNum = rand.nextInt(2); //turnNum → 0/1 → player 1/2 goes first
        if (turnNum == 0){
            turn = "player 1";
        }
        else{
            turn = "player 2";
        }
        return turn;
    }

    private boolean checkThreeConnects(){
        boolean threeConnected;

        return threeConnected;
    }
}
