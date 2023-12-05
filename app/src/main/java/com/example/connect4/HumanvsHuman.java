package com.example.connect4;

public class HumanvsHuman {
    private Model game = new Model();
    private Position[][] board = game.board;
    private Gameplay gameplay = new Gameplay();

    //Methods about turns changing------------------------------------------------------------------
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

    //Methods about three connects checking and hints giving----------------------------------------
    private void checkThreeConnects(){
        if (game.ifThreeConnects()) {
            giveThreeConnectsHints();
        }
    }

    private String giveThreeConnectsHints(){
        return "The other player almost wins.";
    }
    //----------------------------------------------------------------------------------------------
}
