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

    public void countHorizontally(){


    }

    @Test
    public void TestcountVertically(){
        Model game = new Model();
        Position[][] testBoard = new Position[5][5];
        testBoard[4][0] = new Position(4, 0, "AI");
        testBoard[3][0] = new Position(4, 0, "AI");
        testBoard[2][0] = new Position(4, 0, "AI");
        testBoard[1][0] = new Position(4, 0, "AI");
        game.board = testBoard;

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