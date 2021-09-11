package com.jiahao.tddjava.ch03tictactoe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TicTacToe ticTacToe;

    @Before
    public final void before(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void WhenXOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(5,2);
    }

    @Test
    public void WhenYOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,5);
    }

    @Test
    public void WhenOccupiedThenRuntimeException(){
        ticTacToe.play(1,2);
        exception.expect(RuntimeException.class);
        ticTacToe.play(1,2);
    }

    @Test
    public void givenFirstTurnThenNextPlayerThenX(){
        Assert.assertEquals('X',ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastTurnXThenNextPlayerThenO(){
        ticTacToe.play(1,2);
        Assert.assertEquals('O',ticTacToe.nextPlayer());

    }


    @Test
    public void whenPlayThenNoWinner(){
        String actual = ticTacToe.play(1,2);
        Assert.assertEquals("No Winner!",actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalThenWinner(){
        ticTacToe.play(1,1);
        ticTacToe.play(2,1);
        ticTacToe.play(1,2);
        ticTacToe.play(2,2);
        String actual = ticTacToe.play(1, 3);
        Assert.assertEquals("X is Winner!",actual);
    }

    @Test
    public void whenPlayAndWholeVerticalThenWinner(){
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        ticTacToe.play(2,1);
        ticTacToe.play(2,2);
        String actual = ticTacToe.play(3, 1);
        Assert.assertEquals("X is Winner!",actual);

    }

    // 左上角到右下角
    @Test
    public void whenPlayAndTopButtonDiagonalThenWinner(){
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        ticTacToe.play(2,2);
        ticTacToe.play(3,1);
        String actual = ticTacToe.play(3, 3);
        Assert.assertEquals("X is Winner!",actual);

    }


    // 左下角到右上角
    @Test
    public void whenPlayAndButtonTopDiagonalThenWinner(){
        ticTacToe.play(1,3);
        ticTacToe.play(2,1);
        ticTacToe.play(2,2);
        ticTacToe.play(2,3);
        String actual = ticTacToe.play(3, 1);
        Assert.assertEquals("X is Winner!",actual);
    }

    @Test
    public void whenAllBoxesAreFilledThenDraw(){
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        ticTacToe.play(1,3);
        ticTacToe.play(2,2);
        ticTacToe.play(2,1);
        ticTacToe.play(3,1);
        ticTacToe.play(3,2);
        ticTacToe.play(2,3);

        String actual = ticTacToe.play(3, 3);
        Assert.assertEquals("The result is Draw!",actual);

    }






}
