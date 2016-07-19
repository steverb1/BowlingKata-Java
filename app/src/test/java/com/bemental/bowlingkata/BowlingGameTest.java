package com.bemental.bowlingkata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest
{
    private Game game;

    @Before
    public void setUp()
    {
        game = new Game();
    }

    @Test
    public void testGutterGame()
    {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void testAllOnes()
    {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void testOneSpare()
    {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void testOneStrike()
    {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    public void testPerfectGame()
    {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    // Added this one to catch a potential bug.
    // This demonstrates that the original set of tests are insufficient.
    @Test
    public void testTwoSpares()
    {
        rollSpare();
        rollSpare();
        game.roll(3);
        rollMany(15, 0);
        assertEquals(31, game.score());
    }

    private void rollStrike()
    {
        game.roll(10);
    }

    private void rollSpare()
    {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int n, int pins)
    {
        for (int i = 0; i < n; i++)
        {
            game.roll(pins);
        }
    }
}
