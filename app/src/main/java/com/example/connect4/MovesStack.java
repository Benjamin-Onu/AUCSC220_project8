package com.example.connect4;

import java.util.Stack;

public class MovesStack {
    private static MovesStack instance;
    Stack<Integer> movesInRow = new Stack<>();
    Stack<Integer> movesInCol = new Stack<>();
    Stack<Integer> reverseRowStack = new Stack<>();
    Stack<Integer> reverseColStack = new Stack<>();

    private MovesStack() {
    }

    public static synchronized MovesStack getInstance() {
        if (instance == null) {
            synchronized (MovesStack.class) {
                if (instance == null) {
                    instance = new MovesStack();
                }
            }
        }
        return instance;
    }

    public void recordMove(int row, int col) {
        movesInRow.add(row);
        movesInCol.add(col);
    }

    public int[] deleteMove() {
        int[] deletedPosition = new int[2];
        int deletedRow = movesInRow.pop();
        int deletedCol = movesInCol.pop();
        deletedPosition[0] = deletedRow;
        deletedPosition[1] = deletedCol;
        return deletedPosition;
    }

    public Stack<Integer> getMovesInRow() {
        return movesInRow;
    }

    protected void reverseStack(){
        /*
        This is done in order not to clear the board and the previous game model object.
         */
        Stack<Integer> rowStackBridge = movesInRow;
        Stack<Integer> colStackBridge = movesInCol;
        while(!rowStackBridge.isEmpty()){
            reverseRowStack.push(rowStackBridge.pop());
            reverseColStack.push(colStackBridge.pop());
        }
        movesInRow = reverseRowStack;
        movesInCol = reverseColStack;
    }
}
