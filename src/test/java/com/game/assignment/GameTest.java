package com.game.assignment;

import org.junit.Test;

public class GameTest {

    private Game game;
    private Player[] players;

    @Test(expected = IllegalArgumentException.class)
    public void invalidCase_ShouldThrowExceptionWhenNullPlayersPassed() {
        game = new Game(players);
    }


    @Test(expected = IllegalArgumentException.class)
    public void invalidCase_ShouldThrowExceptionWhenBlankPlayersPassed() {
        players = new Player[2];
        players[0] = new Player(" ");
        players[1] = new Player("Player2");
        game = new Game(players);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCase_ShouldThrowExceptionWhenOnePlayerPassed() {
        players = new Player[1];
        players[0] = new Player("Player1");
        game = new Game(players);
    }

    @Test
    public void validCase_CreateGameWithTwoPlayers() {
        players = new Player[2];
        players[0] = new Player("Player1");
        players[1] = new Player("Player2");
        game = new Game(players);
    }


}
