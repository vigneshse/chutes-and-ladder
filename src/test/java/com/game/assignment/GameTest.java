package com.game.assignment;

import org.junit.Test;

public class GameTest {

    private Game game;
    private String[] players;

    @Test(expected = IllegalArgumentException.class)
    public void invalidCase_ShouldThrowExceptionWhenNullPlayersPassed() {
        game = new Game(players);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCase_ShouldThrowExceptionWhenOnePlayersPassed() {
        players = new String[]{"Player1"};
        game = new Game(players);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCase_ShouldThrowExceptionWhenBlankPlayersPassed() {
        players = new String[]{" ", " "};
        game = new Game(players);
    }
}