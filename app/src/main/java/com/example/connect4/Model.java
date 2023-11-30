package com.example.connect4;

public class Model {
    protected Position[][] board;
    protected int ROWS = 6;
    protected int COLUMNS = 7;
    protected int rowLength = board.length;
    protected int columnLength = board[0].length;
    protected String currentTurn;
    protected Model() {
        this.board = new Position[ROWS][COLUMNS];
    }

    public void updateBoard(int x_val, int y_val, String turn){
        Position spot = new Position(x_val, y_val, turn);
        board[x_val][y_val] = spot;
        //After updating the board there should be a call to check winner
    }

    /*
    These methods will cover both check three connects and check winner (four connects)
    Avoiding code repetition, so that in the check three connects and check winner we can just call
    these methods when we need it.
     */
    //----------------------------------------------------------------------------------------------
    public int countConsecutivePlayerSpotsHorizontally(String currentTurn){
        int count = 0;
        for (int row = board.length - 1; row >= 0; row--) {
            for (int col = 0; col < board[0].length; col++) {
                if (ifEqualToCurrentturn(row, col)) {
                    count += 1;
                }
                else if (ifEqualToNull(row, col)){
                    break;
                }else{
                    break;//If the next piece is an opponent stop counting
                }
            }
        }
        return count;
    }

    public int countConsecutivePlayerSpotsVertically(String currentTurn){
        int count = 0;
        for(int col = 0; col < columnLength; col++){
            for(int row = rowLength - 1; row >= 0; row--){
                if(ifEqualToCurrentturn(row, col)){
                    count += 1;
                }
                else if (ifEqualToNull(row, col)){
                    break;
                }else{
                    break;//If the next piece is an opponent stop counting
                }
            }
        }
        return count;
    }

    public int countConsecutivePlayerSpotsLeftDiag(String currentTurn){
        int count = 0;
        int col = board[0].length;
        for(int row = rowLength - 1; row >= 0; row--){
            if(ifEqualToCurrentturn(row, col)){
                count += 1;
                col--;
            }
            else if (ifEqualToNull(row, col)){
                break;
            }else{
                break;//If the next piece is an opponent stop counting
            }
        }
        return count;
    }

    public int countConsecutivePlayerSpotsRightDiag(String currentTurn){
        int count = 0;
        int col = 0;
        for(int row = rowLength - 1; row > 0; row--){
            if(ifEqualToCurrentturn(row, col)){
                count += 1;
                col++;
            }
            else if (ifEqualToNull(row, col)){
                break;
            }else{
                break;//If the next piece is an opponent stop counting
            }
        }
        return count;
    }

    //----------------------------------------------------------------------------------------------

    /*
        ifThreeConnects → if three connects exist, means a hint needed to tell players that one side
        almost wins.
        ifWinnerExist → if four connects exist, means winner exist.
        ifEqualToCurrentturn → if the piece in this box equals to currentturn(piece)
        ifEqualToNull → if there is a piece in this box
     */
    //----------------------------------------------------------------------------------------------
    protected boolean ifThreeConnects(){
        if (countConsecutivePlayerSpotsHorizontally(currentTurn) == 3 ||
            countConsecutivePlayerSpotsVertically(currentTurn) == 3 ||
            countConsecutivePlayerSpotsLeftDiag(currentTurn) == 3 ||
            countConsecutivePlayerSpotsRightDiag(currentTurn) == 3){
            return true;
        }
        return false;
    }

    protected boolean ifWinnerExist(){
        if (countConsecutivePlayerSpotsHorizontally(currentTurn) == 4 ||
            countConsecutivePlayerSpotsVertically(currentTurn) == 4 ||
            countConsecutivePlayerSpotsLeftDiag(currentTurn) == 4 ||
            countConsecutivePlayerSpotsRightDiag(currentTurn) == 4){
            return true;
        }
        return false;
    }

    protected boolean ifEqualToCurrentturn(int row, int col){
        return board[row][col].getPlayer().equals(currentTurn);
    }

    protected boolean ifEqualToNull(int row, int col){
        return board[row][col].getPlayer().equals(" ");
    }
    //----------------------------------------------------------------------------------------------
}
