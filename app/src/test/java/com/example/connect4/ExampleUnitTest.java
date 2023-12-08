package com.example.connect4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Model game = new Model("Player");
    private MovesStack movesStack = new MovesStack();
    private Gameplay gameplay = new Gameplay();
    private  Position[][] board;
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void TestUpdateBoard(){
        game.updateBoard(0, 0, "AI");
        Position result = game.board[0][0];

        assertEquals("(0, 0, AI)", result.toString());
    }

    //VerticalTest----------------------------------------------------------------------------------
    @Test
    public void TestcountVertically1(){
        game.updateBoard(5, 0, "AI");
        game.updateBoard(4, 0, "Player");
        game.updateBoard(3, 0, "AI");
        game.updateBoard(2, 0, "AI");
        game.updateBoard(1, 0, "AI");
        game.updateBoard(0, 0, "AI");

        String result = game.countConsecutivePlayerSpotsVertically("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountVertically2(){
        game.updateBoard(5, 0, "AI");
        game.updateBoard(4, 0, "Player");
        game.updateBoard(3, 0, "Player");
        game.updateBoard(2, 0, "AI");
        game.updateBoard(1, 0, "AI");
        game.updateBoard(0, 0, "AI");

        String result = game.countConsecutivePlayerSpotsVertically("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountVertically3(){
        game.updateBoard(5, 0, "AI");
        game.updateBoard(4, 0, "Player");
        game.updateBoard(3, 0, "AI");
        game.updateBoard(2, 0, "Player");
        game.updateBoard(1, 0, "AI");
        game.updateBoard(0, 0, "AI");

        String result = game.countConsecutivePlayerSpotsVertically("AI");
        assertEquals(result, "nothingHappen");
    }
    //----------------------------------------------------------------------------------------------

    //HorizontalTest--------------------------------------------------------------------------------
    @Test
    public void TestcountHorizontally1(){
        game.updateBoard(4, 0, "AI");
        game.updateBoard(4, 1, "Player");
        game.updateBoard(4, 2, "AI");
        game.updateBoard(4, 3, "AI");
        game.updateBoard(4, 4, "AI");
        game.updateBoard(4, 5, "AI");

        String result = game.countConsecutivePlayerSpotsHorizontally("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountHorizontally2(){
        game.updateBoard(4, 0, "AI");
        game.updateBoard(4, 1, "Player");
        game.updateBoard(4, 2, "Player");
        game.updateBoard(4, 3, "AI");
        game.updateBoard(4, 4, "AI");
        game.updateBoard(4, 5, "AI");

        String result = game.countConsecutivePlayerSpotsHorizontally("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountHorizontally3(){
        game.updateBoard(4, 0, "AI");
        game.updateBoard(4, 1, "Player");
        game.updateBoard(4, 2, "AI");
        game.updateBoard(4, 3, "Player");
        game.updateBoard(4, 4, "AI");
        game.updateBoard(4, 5, "AI");

        String result = game.countConsecutivePlayerSpotsHorizontally("AI");
        assertEquals(result, "nothingHappen");
    }
    //----------------------------------------------------------------------------------------------

    //LeftDiagonalTest------------------------------------------------------------------------------
    @Test
    public void TestcountLowerTriLeftDiagonally1_1(){
        game.updateBoard(5, 5, "AI");
        game.updateBoard(4, 4, "Player");
        game.updateBoard(3, 3, "AI");
        game.updateBoard(2, 2, "AI");
        game.updateBoard(1, 1, "AI");
        game.updateBoard(0, 0, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountLowerTriLeftDiagonally1_2(){
        game.updateBoard(5, 5, "AI");
        game.updateBoard(4, 4, "Player");
        game.updateBoard(3, 3, "Player");
        game.updateBoard(2, 2, "AI");
        game.updateBoard(1, 1, "AI");
        game.updateBoard(0, 0, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountLowerTriLeftDiagonally1_3(){
        game.updateBoard(5, 5, "AI");
        game.updateBoard(4, 4, "Player");
        game.updateBoard(3, 3, "AI");
        game.updateBoard(2, 2, "Player");
        game.updateBoard(1, 1, "AI");
        game.updateBoard(0, 0, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountLowerTriLeftDiagonally2_1(){
        game.updateBoard(5, 4, "Player");
        game.updateBoard(4, 3, "AI");
        game.updateBoard(3, 2, "AI");
        game.updateBoard(2, 1, "AI");
        game.updateBoard(1, 0, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountLowerTriLeftDiagonally2_2(){
        game.updateBoard(5, 4, "AI");
        game.updateBoard(4, 3, "Player");
        game.updateBoard(3, 2, "AI");
        game.updateBoard(2, 1, "AI");
        game.updateBoard(1, 0, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountLowerTriLeftDiagonally2_3(){
        game.updateBoard(5, 4, "AI");
        game.updateBoard(4, 3, "Player");
        game.updateBoard(3, 2, "Player");
        game.updateBoard(2, 1, "AI");
        game.updateBoard(1, 0, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountLowerTriLeftDiagonally3_1() {
        game.updateBoard(5, 3, "AI");
        game.updateBoard(4, 2, "AI");
        game.updateBoard(3, 1, "AI");
        game.updateBoard(2, 0, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountLowerTriLeftDiagonally3_2() {
        game.updateBoard(5, 3, "Player");
        game.updateBoard(4, 2, "AI");
        game.updateBoard(3, 1, "AI");
        game.updateBoard(2, 0, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountLowerTriLeftDiagonally3_3() {
        game.updateBoard(5, 3, "AI");
        game.updateBoard(4, 2, "Player");
        game.updateBoard(3, 1, "AI");
        game.updateBoard(2, 0, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountLowerTriLeftDiagonally4_1(){
        game.updateBoard(5, 2, "AI");
        game.updateBoard(4, 1, "AI");
        game.updateBoard(3, 0, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountLowerTriLeftDiagonally4_2(){
        game.updateBoard(5, 2, "Player");
        game.updateBoard(4, 1, "AI");
        game.updateBoard(3, 0, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountUpperTriLeftDiagonally1_1(){
        game.updateBoard(5, 6, "AI");
        game.updateBoard(4, 5, "Player");
        game.updateBoard(3, 4, "AI");
        game.updateBoard(2, 3, "AI");
        game.updateBoard(1, 2, "AI");
        game.updateBoard(0, 1, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountUpperTriLeftDiagonally1_2(){
        game.updateBoard(5, 6, "AI");
        game.updateBoard(4, 5, "Player");
        game.updateBoard(3, 4, "Player");
        game.updateBoard(2, 3, "AI");
        game.updateBoard(1, 2, "AI");
        game.updateBoard(0, 1, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountUpperTriLeftDiagonally1_3(){
        game.updateBoard(5, 6, "AI");
        game.updateBoard(4, 5, "Player");
        game.updateBoard(3, 4, "AI");
        game.updateBoard(2, 3, "Player");
        game.updateBoard(1, 2, "AI");
        game.updateBoard(0, 1, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountUpperTriLeftDiagonally2_1(){
        game.updateBoard(4, 6, "Player");
        game.updateBoard(3, 5, "AI");
        game.updateBoard(2, 4, "AI");
        game.updateBoard(1, 3, "AI");
        game.updateBoard(0, 2, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountUpperTriLeftDiagonally2_2(){
        game.updateBoard(4, 6, "AI");
        game.updateBoard(3, 5, "Player");
        game.updateBoard(2, 4, "AI");
        game.updateBoard(1, 3, "AI");
        game.updateBoard(0, 2, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountUpperTriLeftDiagonally2_3(){
        game.updateBoard(4, 6, "AI");
        game.updateBoard(3, 5, "Player");
        game.updateBoard(2, 4, "AI");
        game.updateBoard(1, 3, "Player");
        game.updateBoard(0, 2, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountUpperTriLeftDiagonally3_1(){
        game.updateBoard(3, 6, "AI");
        game.updateBoard(2, 5, "AI");
        game.updateBoard(1, 4, "AI");
        game.updateBoard(0, 3, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountUpperTriLeftDiagonally3_2(){
        game.updateBoard(3, 6, "Player");
        game.updateBoard(2, 5, "AI");
        game.updateBoard(1, 4, "AI");
        game.updateBoard(0, 3, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountUpperTriLeftDiagonally3_3(){
        game.updateBoard(3, 6, "AI");
        game.updateBoard(2, 5, "Player");
        game.updateBoard(1, 4, "AI");
        game.updateBoard(0, 3, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountUpperTriLeftDiagonally4_1(){
        game.updateBoard(2, 6, "AI");
        game.updateBoard(1, 5, "AI");
        game.updateBoard(0, 4, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountUpperTriLeftDiagonally4_2(){
        game.updateBoard(2, 6, "AI");
        game.updateBoard(1, 5, "Player");
        game.updateBoard(0, 4, "AI");

        String result = game.countConsecutivePlayerSpotsLeftDiag("AI");
        assertEquals(result, "nothingHappen");
    }
    //----------------------------------------------------------------------------------------------

    //RightDiagonalTest-----------------------------------------------------------------------------
    @Test
    public void TestcountLowerTriRightDiagonally1_1(){
        game.updateBoard(5, 1, "AI");
        game.updateBoard(4, 2, "Player");
        game.updateBoard(3, 3, "AI");
        game.updateBoard(2, 4, "AI");
        game.updateBoard(1, 5, "AI");
        game.updateBoard(0, 6, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountLowerTriRightDiagonally1_2(){
        game.updateBoard(5, 1, "AI");
        game.updateBoard(4, 2, "Player");
        game.updateBoard(3, 3, "Player");
        game.updateBoard(2, 4, "AI");
        game.updateBoard(1, 5, "AI");
        game.updateBoard(0, 6, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountLowerTriRightDiagonally1_3(){
        game.updateBoard(5, 1, "AI");
        game.updateBoard(4, 2, "Player");
        game.updateBoard(3, 3, "AI");
        game.updateBoard(2, 4, "Player");
        game.updateBoard(1, 5, "AI");
        game.updateBoard(0, 6, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountLowerTriRightDiagonally2_1(){
        game.updateBoard(5, 2, "Player");
        game.updateBoard(4, 3, "AI");
        game.updateBoard(3, 4, "AI");
        game.updateBoard(2, 5, "AI");
        game.updateBoard(1, 6, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountLowerTriRightDiagonally2_2(){
        game.updateBoard(5, 2, "AI");
        game.updateBoard(4, 3, "Player");
        game.updateBoard(3, 4, "AI");
        game.updateBoard(2, 5, "AI");
        game.updateBoard(1, 6, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountLowerTriRightDiagonally2_3(){
        game.updateBoard(5, 2, "AI");
        game.updateBoard(4, 3, "Player");
        game.updateBoard(3, 4, "Player");
        game.updateBoard(2, 5, "AI");
        game.updateBoard(1, 6, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountLowerTriRightDiagonally3_1() {
        game.updateBoard(5, 3, "AI");
        game.updateBoard(4, 4, "AI");
        game.updateBoard(3, 5, "AI");
        game.updateBoard(2, 6, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountLowerTriRightDiagonally3_2() {
        game.updateBoard(5, 3, "Player");
        game.updateBoard(4, 4, "AI");
        game.updateBoard(3, 5, "AI");
        game.updateBoard(2, 6, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountLowerTriRightDiagonally3_3() {
        game.updateBoard(5, 3, "AI");
        game.updateBoard(4, 4, "Player");
        game.updateBoard(3, 5, "AI");
        game.updateBoard(2, 6, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountLowerTriRightDiagonally4_1(){
        game.updateBoard(5, 4, "AI");
        game.updateBoard(4, 5, "AI");
        game.updateBoard(3, 6, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountLowerTriRightDiagonally4_2(){
        game.updateBoard(5, 4, "Player");
        game.updateBoard(4, 5, "AI");
        game.updateBoard(3, 6, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountUpperTriRightDiagonally1_1(){
        game.updateBoard(5, 0, "AI");
        game.updateBoard(4, 1, "Player");
        game.updateBoard(3, 2, "AI");
        game.updateBoard(2, 3, "AI");
        game.updateBoard(1, 4, "AI");
        game.updateBoard(0, 5, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountUpperTriRightDiagonally1_2(){
        game.updateBoard(5, 0, "AI");
        game.updateBoard(4, 1, "Player");
        game.updateBoard(3, 2, "Player");
        game.updateBoard(2, 3, "AI");
        game.updateBoard(1, 4, "AI");
        game.updateBoard(0, 5, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountUpperTriRightDiagonally1_3(){
        game.updateBoard(5, 0, "AI");
        game.updateBoard(4, 1, "Player");
        game.updateBoard(3, 2, "AI");
        game.updateBoard(2, 3, "Player");
        game.updateBoard(1, 4, "AI");
        game.updateBoard(0, 5, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountUpperTriRightDiagonally2_1(){
        game.updateBoard(4, 0, "Player");
        game.updateBoard(3, 1, "AI");
        game.updateBoard(2, 2, "AI");
        game.updateBoard(1, 3, "AI");
        game.updateBoard(0, 4, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountUpperTriRightDiagonally2_2(){
        game.updateBoard(4, 0, "AI");
        game.updateBoard(3, 1, "Player");
        game.updateBoard(2, 2, "AI");
        game.updateBoard(1, 3, "AI");
        game.updateBoard(0, 4, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountUpperTriRightDiagonally2_3(){
        game.updateBoard(4, 0, "AI");
        game.updateBoard(3, 1, "Player");
        game.updateBoard(2, 2, "AI");
        game.updateBoard(1, 3, "Player");
        game.updateBoard(0, 4, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountUpperTriRightDiagonally3_1(){
        game.updateBoard(3, 0, "AI");
        game.updateBoard(2, 1, "AI");
        game.updateBoard(1, 2, "AI");
        game.updateBoard(0, 3, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "winnerExist");
    }

    @Test
    public void TestcountUpperTriRightDiagonally3_2(){
        game.updateBoard(3, 0, "Player");
        game.updateBoard(2, 1, "AI");
        game.updateBoard(1, 2, "AI");
        game.updateBoard(0, 3, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountUpperTriRightDiagonally3_3(){
        game.updateBoard(3, 0, "AI");
        game.updateBoard(2, 1, "Player");
        game.updateBoard(1, 2, "AI");
        game.updateBoard(0, 3, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "nothingHappen");
    }

    @Test
    public void TestcountUpperTriRightDiagonally4_1(){
        game.updateBoard(2, 0, "AI");
        game.updateBoard(1, 1, "AI");
        game.updateBoard(0, 2, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "threeConnects");
    }

    @Test
    public void TestcountUpperTriRightDiagonally4_2(){
        game.updateBoard(2, 0, "AI");
        game.updateBoard(1, 1, "Player");
        game.updateBoard(0, 2, "AI");

        String result = game.countConsecutivePlayerSpotsRightDiag("AI");
        assertEquals(result, "nothingHappen");
    }
    //----------------------------------------------------------------------------------------------

    @Test
    public void TestRecordMove(){
        gameplay.columnOne();
        String result = movesStack.movesInRow.toString() + movesStack.movesInCol.toString();

        assertEquals(result, "[5][0]");
    }

    @Test
    public void TestDeleteMove(){
        movesStack.recordMove(5, 0);
        movesStack.recordMove(5, 1);
        movesStack.deleteMove();
        String result = movesStack.movesInRow.toString() + movesStack.movesInCol.toString();

        assertEquals(result, "[5][0]");
    }
}