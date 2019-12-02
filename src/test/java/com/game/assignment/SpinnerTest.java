package com.game.assignment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class SpinnerTest {

    private Spinner spinner;

    @Before
    public void setUp() {
        spinner = new Spinner();
    }

    @Test
    public void roll() {
        int roll;
        for (int i = 0; i < 20; i++) {
            roll = spinner.spin();
            assertTrue(1 <= roll && roll <= 7);
        }
    }
}