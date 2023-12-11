package com.example.connect4;

import java.util.Stack;

public class MovesStack {
    private static MovesStack instance;

    private Stack<Integer> movesInRow = new Stack<>();
    private Stack<Integer> movesInCol = new Stack<>();

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

    public Stack<Integer> getMovesInCol() {
        return movesInCol;
    }
}
