package com.example.connect4;

public class Model {

    Position[][] board;
    public Model() {
        this.board = new Position[7][6];
    }



    public void updateBoard(int x_val, int y_val, String turn){
        Position spot = new Position(x_val, y_val, turn);
        board[x_val][y_val] = spot;
        //After updating the board there should be a call to check winner
    }

}
