package com.example.connect4;

public class Position {
    private int row;
    private int column;
    private String player;

    public Position(int row, int column, String player){
        this.row = row;
        this.column = column;
        this.player = player;
    }
    //Default Constructor
    public Position(){
        this.row = 6;
        this.column = 7;
        this.player = " ";
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getPlayer() {
        return player;
    }

    public void setRow(int val){
        this.row = val;
    }
    public void setColumn(int val){
        this.column = val;
    }

    public void setPlayer(String player) { this.player = player; }


    @Override
    public String toString(){
        String output = "(" + row + ", " +
                column + ", " + player + ")";
        return output;
    }
}
