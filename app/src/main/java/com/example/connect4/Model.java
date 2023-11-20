package com.example.connect4;

public class Model {

    Position[][] board;
    public int ROWS = 6;
    public int COLUMNS = 7;
    public Model() {
        this.board = new Position[ROWS][COLUMNS];
    }
    protected String currentTurn;

    public void updateBoard(int x_val, int y_val, String turn){
        Position spot = new Position(x_val, y_val, turn);
        board[x_val][y_val] = spot;
        //After updating the board there should be a call to check winner
    }

    /*
    These methods will cover both check three connects and check winner (four connects)
    Reason because we want to avoid code repetition, in the check three connects and check winner
    we can just call these methods and if the count is 3 then there's a possibility.
     */
    //----------------------------------------------------------------------------------------------
    public int countConsecutivePlayerSpotsVertically(String currentTurn){
        int rowLength = board.length;
        int columnLength = board[0].length;
        int count = 0;
        for(int col = 0; col < columnLength; col++){
            for(int row = rowLength - 1; row >= 0; row--){
                if(board[row][col].getPlayer().equals(currentTurn)){
                    count += 1;
                }
                else if (board[row][col].getPlayer().equals(" ")){
                    break;
                }
            }
        }
        return count;
    }

    public int countConsecutivePlayerSpotsRightDiag(String currentTurn){
        int rowLength = board.length;
        int columnLength = board[0].length;
        int count = 0;
        int col = 0;
        for(int row = rowLength - 1; row > 0; row--){
            if(board[row][col].getPlayer().equals(currentTurn)){
                count += 1;
                col++;
            }
            else if (board[row][col].getPlayer().equals(" ")){
                break;
            }
        }
        return count;
    }

    public int countConsecutivePlayerSpotsLeftDiag(String currentTurn){
        int rowLength = board.length;
        int columnLength = board[0].length;
        int count = 0;
        int col = 0;
        for(int row = rowLength - 1; row >= 0; row--){
            if(board[row][col].getPlayer().equals(currentTurn)){
                count += 1;
                col--;
            }
            else if (board[row][col].getPlayer().equals(" ")){
                break;
            }
        }
        return count;
    }

    public int countConsecutivePlayerSpotsHorizontally(String currentTurn){
        int rowLength = board.length;
        int columnLength = board[0].length;
        int count = 0;

        for (int row = rowLength; row >= 0; row--) {
            for (int col = 0; col < columnLength; col++) {
                if (board[row][col].getPlayer().equals(currentTurn)) {
                    count += 1;
                }
                else if (board[row][col].getPlayer().equals(" ")){
                    break;
                }
            }
        }
        return count;
    }
    //----------------------------------------------------------------------------------------------

    /*
        ifThreeConnects → if three connects exist, means a hint needed to tell players that one side
        almost wins.
        ifWinnerExist → if four connects exist, means winner exist.
        Can be used directly and c   onveniently.
     */
    //----------------------------------------------------------------------------------------------
    public boolean ifThreeConnects(){
        if (countConsecutivePlayerSpotsHorizontally(currentTurn) == 3 ||
                countConsecutivePlayerSpotsVertically(currentTurn) == 3 ||
                countConsecutivePlayerSpotsLeftDiag(currentTurn) == 3 ||
                countConsecutivePlayerSpotsRightDiag(currentTurn) == 3){
            return true;
        }
        return false;
    }

    public boolean ifWinnerExist(){
        if (countConsecutivePlayerSpotsHorizontally(currentTurn) == 4 ||
            countConsecutivePlayerSpotsVertically(currentTurn) == 4 ||
            countConsecutivePlayerSpotsLeftDiag(currentTurn) == 4 ||
            countConsecutivePlayerSpotsRightDiag(currentTurn) == 4){
            return true;
        }
        return false;
    }
    //----------------------------------------------------------------------------------------------
}
