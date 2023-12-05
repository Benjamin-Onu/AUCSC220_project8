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

    //Methods about humans' moves-------------------------------------------------------------------
    private void showPiecesWherePlayersClicked(int col, String currentTurn){
        for (int row = game.COLUMNS - 1; row >= 0; row--) {
            if (game.ifEqualToNull(row, col)) {
                board[row][col].setPlayer(currentTurn);
            }
        }
    }

    private void afterClickedByPlayers(int col){
        showPiecesWherePlayersClicked(col, changeTurns(gameplay.decideWhoGoesFirst()));
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
    //----------------------------------------------------------------------------------------------
}
