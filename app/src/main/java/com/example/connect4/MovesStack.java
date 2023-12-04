package com.example.connect4;

import java.util.Stack;

public class MovesStack {
    Stack<Integer> movesInRow = new Stack<>();
    Stack<Integer> movesInCol = new Stack<>();

    public void recordMove(int row, int col){
        movesInRow.add(row);
        movesInCol.add(col);
    }

    public int[] deleteMove(){
        int[] deletedPosition = new int[2];
        int deletedRow = movesInRow.pop();
        int deletedCol = movesInCol.pop();
        deletedPosition[0] = deletedRow;
        deletedPosition[1] = deletedCol;
        return deletedPosition;
    }

}
