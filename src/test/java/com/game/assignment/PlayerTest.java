package com.game.assignment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;

    @Test(expected = IllegalArgumentException.class)
    public void invalidCase_shouldThrowExceptionWhenInstantiatingPlayerWithEmptyName() {
        player = new Player(" ");
    }

    @Test
    public void validCase_InstantiatesPlayerWithName() {
        player = new Player("Player1");
        assertEquals("Player1", player.getName());
    }

}
