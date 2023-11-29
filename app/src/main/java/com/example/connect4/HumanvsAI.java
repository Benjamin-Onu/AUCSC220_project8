package com.example.connect4;

import java.util.Random;
import java.util.ArrayList;

public class HumanvsAI {

    Model game;
    private Position[][] board = game.board;
    String Human;
    String AI;
    String turn;
    Position bestMove;
    private Random rand = new Random();
    ArrayList aiClicked; //This list will contain the positions on the board that the AI has clicked
    int randomCol;
    public HumanvsAI(){
        game = new Model();
        aiClicked = new ArrayList<>();
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

    public Position checkNextAIMove(){
        /*
        This algorithm will work to pick the best move for the AI
        If the spot is occupied in the list then
         */


        return new Position(2, 0, "AI");
    }
    public Position countAISpotsHorizontally(String currentTurn){
        int count = 0;
        for (int row = board.length - 1; row >= 0; row--) {
            for (int col = 0; col < board[0].length; col++) {
                if (ifEqualToAI(row, col)) {
                    count += 1;
                    if(count > 2){
                        bestMove = new Position(row, col + 1, "AI");
                        aiClicked.add(bestMove);

                    }
                }
                else if (ifEqualToNull(row, col)){
                    break;
                }else{
                    break;
                }
            }
        }

        return bestMove;
    }

    public int countConsecutivePlayerSpotsVertically(String currentTurn){
        int count = 0;
        for(int col = 0; col < board[0].length; col++){
            for(int row = board.length - 1; row >= 0; row--){
                if(ifEqualToAI(row, col)){
                    count += 1;
                    if(count > 2){
                        bestMove = new Position(row + 1, col, "AI");
                        aiClicked.add(bestMove);

                    }
                }
                else if (ifEqualToNull(row, col)){
                    break;
                }else{
                    break;
                }
            }
        }
        return count;
    }

    public int countConsecutivePlayerSpotsLeftDiag(String currentTurn){
        int count = 0;
        int col = board[0].length;
        for(int row = board.length - 1; row >= 0; row--){
            if(ifEqualToAI(row, col)){
                count += 1;
                if(count > 2){
                    bestMove = new Position(row - 1, col - 1, "AI");
                    aiClicked.add(bestMove);
                }
                col--;
            }
            else if (ifEqualToNull(row, col)){
                break;
            }else{
                break;
            }
        }
        return count;
    }

    public int countConsecutivePlayerSpotsRightDiag(String currentTurn){
        int count = 0;
        int col = 0;
        for(int row = board.length - 1; row > 0; row--){
            if(ifEqualToAI(row, col)){
                count += 1;
                if(count > 2){
                    bestMove = new Position(row - 1, col + 1, "AI");
                    aiClicked.add(bestMove);

                }
                col++;
            }
            else if (ifEqualToNull(row, col)){
                break;
            }else{
                break;
            }
        }
        return count;
    }

    protected boolean ifEqualToAI(int row, int col){
        return board[row][col].getPlayer().equals("AI");
    }

    protected boolean ifEqualToNull(int row, int col){
        return board[row][col].getPlayer().equals(" ");
    }

    /*
    * The
    *
    *
    * */
//    public Position checkThreeConnects(String currentTurn){
//
//        int count =
//
//        return winPos;
//    }



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
