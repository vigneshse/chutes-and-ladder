package com.game.assignment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class DiceTest {

    private Dice dice;

    @Before
    public void setUp() {
        dice = new Dice();
    }

    @Test
    public void roll() {
        int roll;
        for (int i = 0; i < 20; i++) {
            roll = dice.roll();
            assertTrue(1 <= roll && roll <= 7);
        }
    }
}