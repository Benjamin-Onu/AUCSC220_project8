package com.example.connect4;

public class HumanvsHuman{
    protected Model game;
    private Position[][] board = game.board;
    protected String currentTurn;

    public HumanvsHuman(){
        game = new Model();
    }
    //Methods about turns changing------------------------------------------------------------------
    protected String changeTurns(String turn){
        if(game.getCurrentTurn() == "player1"){
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
        showPiecesWherePlayersClicked(col, changeTurns(game.getCurrentTurn()));
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
