package com.game.assignment;

import java.util.Random;

public class Dice {

    private final int MAX_FACE_VALUE = 7;
    private final int MIN_FACE_VALUE = 1;

    private Random rand;

    Dice() {
        rand = new Random();
    }

    public int roll() {
        return rand.nextInt((MAX_FACE_VALUE - MIN_FACE_VALUE) + 1) + MIN_FACE_VALUE ;
    }
}
