package com.example.connect4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    
    @Test
    public void TestcountVertically(){
        Model game = new Model();
        //Position[][] testBoard = game.board;
        game.updateBoard(5, 0, "AI");
        game.updateBoard(4, 0, "Player");
        game.updateBoard(3, 0, "AI");
        game.updateBoard(2, 0, "AI");
        game.updateBoard(1, 0, "AI");

        int count = game.countConsecutivePlayerSpotsVertically("AI");
        assertEquals(count, 4);
    }

    @Test
    public void TestcountHorizontally(){
        Model game = new Model();
        Position[][] testBoard = new Position[5][5];
        testBoard[4][0] = new Position(4, 0, "AI");
        testBoard[4][1] = new Position(4, 0, "AI");
        testBoard[4][2] = new Position(4, 0, "AI");
        testBoard[4][3] = new Position(4, 0, "AI");
        game.board = testBoard;

        int count = game.countConsecutivePlayerSpotsHorizontally("AI");
        assertEquals(count, 4);
    }

    @Test
    public void TestcountLeftDiagonally(){
        Model game = new Model();
        Position[][] testBoard = new Position[5][5];
        testBoard[4][3] = new Position(4, 0, "AI");
        testBoard[3][2] = new Position(4, 0, "AI");
        testBoard[2][1] = new Position(4, 0, "AI");
        testBoard[1][0] = new Position(4, 0, "AI");
        game.board = testBoard;

        int count = game.countConsecutivePlayerSpotsHorizontally("AI");
        assertEquals(count, 4);
    }

    @Test
    public void TestcountRightDiagonally(){
        Model game = new Model();
        Position[][] testBoard = new Position[5][5];
        testBoard[4][0] = new Position(4, 0, "AI");
        testBoard[3][1] = new Position(4, 0, "AI");
        testBoard[2][2] = new Position(4, 0, "AI");
        testBoard[1][3] = new Position(4, 0, "AI");
        game.board = testBoard;

        int count = game.countConsecutivePlayerSpotsHorizontally("AI");
        assertEquals(count, 4);
    }

}
    //Write test cases for all the count methods