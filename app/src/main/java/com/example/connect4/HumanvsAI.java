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

    public Position checkThreeConnects(String currentTurn){

        int count =

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
