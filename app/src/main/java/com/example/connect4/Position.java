package com.example.connect4;

public class Position {
    private int row;
    private int column;
    private String player;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) { this.player = player; }

    public Position(int row, int column, String player){
        this.row = row;
        this.column = column;
        this.player = player;
    }

    @Override
    public String toString(){
        String output = "(" + row + "," +
                column + "," + player + ")";
        return output;
    }
}
