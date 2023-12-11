package com.example.connect4;

public class Model {
    protected Position[][] board;
    protected int ROWS = 6;
    protected int COLUMNS = 7;
    protected String currentTurn;
    protected String winner;

    protected Model() {
        this.board = new Position[ROWS][COLUMNS];
        //Initialize all the spots in the board
        for (int row = board.length - 1; row >= 0; row--){
            for (int col = 0; col < board[0].length; col++) {
                Position iniSpot = new Position();
                this.board[row][col] = iniSpot;
            }
        }
        this.currentTurn = "player1";
    }

    public void updateBoard(int x_val, int y_val, String turn){
        Position spot = new Position(x_val, y_val, turn);
        this.board[x_val][y_val] = spot;
        //After updating the board there should be a call to check winner
    }

    /*
        Cover check winner in four steps
        Avoid code repetition, so that in the checking winner part we can call these methods
     */
    //----------------------------------------------------------------------------------------------
    //region **Checking Part**
    protected String countConsecutivePlayerSpotsHorizontally(String currentTurn){
        int count = 0;
        boolean winnerExist = false;
        for (int row = board.length - 1; row >= 0; row--) {
            if (count == 4) { break;}
            count = 0;
            for (int col = 0; col < board[0].length; col++) {
                if (ifEqualToCurrentturn(row, col)) {
                    count += 1;
                    if (count == 4) {
                        winnerExist = true;
                        break;
                    }
                }
                else if (ifEqualToNull(row, col)){
                    count = 0;
                }else{
                    count = 0;//If the next piece is an opponent stop counting
                }
            }
        }
        if (winnerExist) {
            return "winnerExist";
        }else {
            return "nothingHappen";
        }
    }

    protected String countConsecutivePlayerSpotsVertically(String currentTurn){
        int count = 0;
        boolean winnerExist = false;
        for(int col = 0; col < board[0].length; col++){
            if (count == 4) { break;}
            for(int row = board.length - 1; row >= 0; row--){
                if(ifEqualToCurrentturn(row, col)){
                    count += 1;
                    if (count == 4) {
                        winnerExist = true;
                        break;
                    }
                }
                else if (ifEqualToNull(row, col)){
                    break;
                }else{
                    count = 0;//If the next piece is an opponent stop counting
                }
            }
        }
        if (winnerExist) {
            return "winnerExist";
        }else {
            return "nothingHappen";
        }
    }

    protected String countConsecutivePlayerSpotsLeftDiag(String currentTurn){
        int count;
        boolean winnerExist = false;
        for(int startCol = board[0].length - 1; startCol >= 0; startCol --) {

            if (startCol == 6) {
                count = checkOneUpperTriangularLeftDiagLine();
                if (count == 4) {
                    winnerExist = true;
                    break;
                }
            } else {
                count = checkOneLowerTriangularLeftDiagLine(startCol);
                if (count == 4) {
                    winnerExist = true;
                    break;
                }
            }
        }
        if (winnerExist) {
            return "winnerExist";
        }else {
            return "nothingHappen";
        }
    }

    protected int checkOneLowerTriangularLeftDiagLine(int startCol){
        int lowCount = 0;
        int col = startCol;
        //the row should start counting from row - col
        //This is because in each diagonal we are checking different number of spots and the
        //formula for finding the number of spots to check is row - col(current startCol)
        //(board.length - 1 + startCol) - board.length
        /* We want to find the stopping condition for the row
         * Start Col = 1, row >= 0 (5 - 1 + 1) - 5
         * Start col = 2, row >= 1 (5 - 1 + 2) - 5
         * Start col = 3 row >= 2 (5 - 1 + 3) - 5
         * Start col = 4 row >= 3 (5 - 1 + 4) - 5
         * Start col = 5 row >= -1 (5 - 1 + 5) - 5 This will be checked in the for loop.
         * */
        for(int row = board.length - 1; row >= board.length - 1 - startCol; row--) {
            if (ifEqualToNull(row, col) || row < 0) {
                break;
            } else if (ifEqualToCurrentturn(row, col) && col >= 0) {
                lowCount += 1;
                col --;
            } else if (!(ifEqualToCurrentturn(row, col)) && col >= 0){
                lowCount = 0;//If the next piece is an opponent stop counting
                col --;
            }
        }
        return lowCount;
    }

    protected int checkOneUpperTriangularLeftDiagLine(){
        int upperCount = 0;
        int row = board.length - 1;
        for(int startRow = board.length - 1; startRow >= 2; startRow --){
            if (upperCount == 4){
                return upperCount;
            }
            upperCount = 0;
            row = startRow;//After the loop finish, row becomes -1, we reset it to the new startRow
            /**
             * In the case of upper triangular, starting row positions are different for
             * each case, so it is being tracked by the for loop outside. While it is being
             * tracked the column values are being tracked as well
             * 1st iteration:  (5,6),(4,5),(3,4).... startRow = 5
             * 2nd iteration: (4,6),(3,5),(2,4).....startRow = 4
             *
             * This is how we track the number of spots to check for each iteration
             *  We want to find the stopping condition for the row
             *  Start Row = 1, col >= 5 (6 - 1)
             *  Start Row = 2, row >= 4 (6 - 2)
             *  Start Row = 3 row >= 3 (6 - 3)
             *  Start Row = 4 row >= 2 (6 - 4)
             *  Start Row = 5 row >= 1 (6 - 5)
             *  A Start Row of -1 will be checked in the for loop since the
             */

            for (int col = board[0].length - 1; col >= col - row; col--) {
                if (ifEqualToNull(row, col) || row < 0) {
                    break;
                } else if (ifEqualToCurrentturn(row, col) && row >= 0) {
                    upperCount += 1;
                    row--;
                } else if (!ifEqualToCurrentturn(row, col) && row >= 0) {
                    upperCount = 0;
                    row--;
                }
            }
        }
        return upperCount;
    }

    protected String countConsecutivePlayerSpotsRightDiag(String currentTurn){

        int count = 0;
        boolean winnerExist = false;
        for(int startCol = 0; startCol < board[0].length; startCol ++) {
            if (startCol == 0) {
                count = checkOneUpperTriangularRightDiagLine();
                if (count == 4) {
                    winnerExist = true;
                    break;
                }
            } else {
                count = checkOneLowerTriangularRightDiagLine(startCol);
                if (count == 4) {
                    winnerExist = true;
                    break;
                }
            }
        }
        if (winnerExist) {
            return "winnerExist";
        }else {
            return "nothingHappen";
        }
    }

    protected int checkOneLowerTriangularRightDiagLine(int startCol){
        int lowCount = 0;
        int col = startCol;
        //the row should start counting from row - col
        //This is because in each diagonal we are checking different number of spots and the
        //formula for finding the number of spots to check is row - col(current startCol)


        //(board.length - 1 + startCol) - board.length
        /* We want to find the stopping condition for the row
        * Start Col = 1, row >= 0 (5 - 1 + 1) - 5
        * Start col = 2, row >= 1 (5 - 1 + 2) - 5
        * Start col = 3 row >= 1 (5 - 1 + 3) - 5
        * Start col = 4 row >= 1 (5 - 1 + 4) - 5
        * Start col = 5 row >= -1 (5 - 1 + 5) - 5 This will be checked in the for loop.
        * */
        for(int row = board.length - 1; row >= (board.length - 1 + startCol) - board.length; row--) {
            if (ifEqualToNull(row, col) || row < 0) {
                break;
            } else if (ifEqualToCurrentturn(row, col) && col < 7) {
                lowCount += 1;
                col ++;
            } else if (!(ifEqualToCurrentturn(row, col)) && col < 7){
                lowCount = 0;//If the next piece is an opponent stop counting
                col ++;
            }
        }
        return lowCount;
    }

    protected int checkOneUpperTriangularRightDiagLine(){
        int upperCount = 0;
        int row = board.length - 1;
        for(int startRow = board.length - 1; startRow >= 2; startRow --){
            if (upperCount == 4){
                return upperCount;
            }
            upperCount = 0;
            row = startRow;//After the loop finish, row becomes -1, we reset it to the new startRow
            /**
             * In the case of upper triangular, starting row positions are different for
             * each case, so it is being tracked by the for loop outside. While it is being
             * tracked the column values are being tracked as well
             * 1st iteration:  (5,6),(4,5),(3,4).... startRow = 5
             * 2nd iteration: (4,6),(3,5),(2,4).....startRow = 4
             *
             * This is how we track the number of spots to check for each iteration
             *  We want to find the stopping condition for the row
             *  Start Row = 1, col >= 5 (6 - 1)
             *  Start Row = 2, row >= 4 (6 - 2)
             *  Start Row = 3 row >= 3 (6 - 3)
             *  Start Row = 4 row >= 2 (6 - 4)
             *  Start Row = 5 row >= 1 (6 - 5)
             *  A Start Row of -1 will be checked in the for loop since the
             */
            for (int col = 0; col <= startRow; col++) {
                if (ifEqualToNull(row, col) || row < 0) {
                    break;
                } else if (ifEqualToCurrentturn(row, col) && row >= 0) {
                    upperCount += 1;
                    row--;
                } else if (!ifEqualToCurrentturn(row, col) && row >= 0) {
                    upperCount = 0;
                    row--;
                }
            }
        }
        return upperCount;
    }
    //endregion
    //----------------------------------------------------------------------------------------------

    /*
        Getters and Setters of winner and currentTurn
     */
    //----------------------------------------------------------------------------------------------
    //region **winner & currentTurn's Getters & Setters**
    protected String getCurrentTurn(){
        return this.currentTurn;
    }
    protected String getWinner() {
        return winner;
    }
    protected void setCurrentTurn(String turn){
        this.currentTurn = turn;
    }
    protected void setWinner(String winner) {
        this.winner = winner;
    }
    //endregion
    //----------------------------------------------------------------------------------------------

    /*
        ifWinnerExist → if four connects exist, means winner exist.
        ifEqualToCurrentTurn → if the piece in this box equals to currentTurn(piece)
        ifEqualToNull → if there is a piece in this box
        ifFullBoard → if the board is full, output true
        ifFullColumn → if the current column is full, output true
    */
    //----------------------------------------------------------------------------------------------
    //region **ifWinnerExist & ifEqualToCurrentTurn & ifEqualToNull & ifFullBoard & ifFullColumn**
    protected boolean ifWinnerExist(){
        if (countConsecutivePlayerSpotsHorizontally(currentTurn).equals("winnerExist") ||
            countConsecutivePlayerSpotsVertically(currentTurn).equals("winnerExist") ||
            countConsecutivePlayerSpotsLeftDiag(currentTurn).equals("winnerExist") ||
            countConsecutivePlayerSpotsRightDiag(currentTurn).equals("winnerExist")){
            setWinner(getCurrentTurn());
            return true;
        }
        return false;
    }

    protected boolean ifEqualToCurrentturn(int row, int col){
        String currentPlayer = this.board[row][col].getPlayer();
        return currentPlayer.equals(currentTurn);
    }

    protected boolean ifEqualToNull(int row, int col){
        return this.board[row][col].getPlayer().equals(" ");
    }

    protected boolean ifFullBoard(){
        if(ifWinnerExist()){
            return false;
        }
        boolean boardIsFull = true;
        for(int topCol = 0; topCol <= 6; topCol++){
            if(board[0][topCol].equals(" ")){
                boardIsFull = false;
            }
        }
        return boardIsFull;
    }

    protected boolean ifFullColumn(int checkColIndex){
        boolean columnIsFull = false;
        if(!board[0][checkColIndex].getPlayer().equals(" ")){
            columnIsFull = true;
        }
        return columnIsFull;
    }
    //endregion
    //----------------------------------------------------------------------------------------------
}