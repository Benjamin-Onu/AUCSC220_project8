package com.example.connect4;

public class Model {

    Position[][] board;
    private int ROWS = 6;
    private int COLUMNS = 7;
    public Model() {
        this.board = new Position[COLUMNS][ROWS];
    }
    private HumanvsHuman humanVsHuman = new HumanvsHuman();

    public void updateBoard(int x_val, int y_val, String turn){
        Position spot = new Position(x_val, y_val, turn);
        board[x_val][y_val] = spot;
        //After updating the board there should be a call to check winner
    }

    public boolean horizontalCaseWinnerCheck(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j <= COLUMNS - 4; j++) {
                //why columns need to reduce 4 for limit the checking number of connected pieces
                //now we have 4 pieces only need to check
                if (board[i][j] == board[i][j + 1] == board[i][j + 2] == board[i][j + 3] == ) {   //error here is for a value which means the same 4 pieces
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verticalCaseWinnerCheck(){
        //Benjamin
        return true;
    }

    public boolean leftDiagonalCaseWinnerCheck(){
        for (int i = 0; i <= ROWS - 4; i++) {
            for (int j = 0; j <= COLUMNS - 4; j++) {
                //same thing with the horizontal case, but we need to limit the checking numbers
                //in both horizontal and vertical direction
                if (board[i][j] == board[i + 1][j + 1] == board[i + 2][j + 2] == board[i + 3][j + 3] == ) {  //error here is for a value which means the same 4 pieces
                    return true;
                }
            }
        }
        return true;
    }

    public boolean RightDiagonalCaseWinnerCheck(){
        //Benjamin
        return true;
    }

    public String checkWinner(){
        return winner;
    }
}
