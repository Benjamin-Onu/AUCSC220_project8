package com.example.connect4;

import java.util.Random;

public class HumanvsAI {

    Model game;
    private Position[][] board = game.board;
    String Human;
    String AI;
    String turn;
    private Random rand = new Random();
    Position[][] aiClicked; //This list will contain the positions on the board that the AI has clicked
    int randomCol;
    public HumanvsAI(){
        game = new Model();
    }

    public String decideWhoGoesFirst(){
        int turnNum = rand.nextInt(2); //turnNum → 0/1 → player 1/2 goes first
        if (turnNum == 0){
            turn = "player 1";
        }
        else{
            turn = "player 2";
        }
        return turn;
    }

    public Position checkThreeConnectsHorizontally(String currentTurn){
        int rowLength = board.length;
        int columnLength = board[0].length;
        //the column size is
        Position[][] possibilities = new Position[5][3];
        Position winPos;
        //horizontally - same row different columns
        //Starting from the bottom of the board makes
        for(int row = rowLength; row >=0; row--){
            for(int col = 0; col < columnLength; col++){
                if(board[row][col].getPlayer().equals(currentTurn) &&
                        board[row][col + 1].getPlayer().equals(currentTurn) &&
                        board[row][col + 2].getPlayer().equals(currentTurn)){
                    winPos =  board[row][col + 3];
                }
            }
        }

        return winPos;
    }

    public Position checkThreeConnectsVertically(String currentTurn){
        int rowLength = board.length;
        int columnLength = board[0].length;
        //the column size is
        Position[][] possibilities = new Position[5][3];
        Position winPos;
        //vertically - same column differnet rows
        for(int col = 0; col < columnLength; col++){
            for(int row = 0; row < rowLength; row--){
                if(board[row][col].getPlayer().equals(currentTurn) &&
                        board[row + 1][col].getPlayer().equals(currentTurn) &&
                        board[row + 2][col].getPlayer().equals(currentTurn)){
                    winPos =  board[row + 3][col];
                }
            }
        }

        return winPos;
    }

    /*
    *Things to think about
    * The method that checks both winner and three connect are the same thing so it can be in a
    * single method that returns a count
    *
    *If I keep writing these methods it will lead to so much code.
    * */
}


/*This class will be the model that is specific to a human player and AI . This is also a subclass of the Model Class.
        Its attributes are :-
        Game : Model object
        Player : String
        AI : String
        Int randomCol
        aiClicked : Position[][]
        This list will contain the positions on the board that the AI has clicked
*/
