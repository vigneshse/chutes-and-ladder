package com.game.assignment;

import java.util.Random;

public class Spinner {

    private final int MAX_FACE_VALUE = 6;
    private final int MIN_FACE_VALUE = 1;

    private Random rand;

    Spinner() {
        rand = new Random();
    }

    public int spin() {
        return rand.nextInt((MAX_FACE_VALUE - MIN_FACE_VALUE) + 1) + MIN_FACE_VALUE ;
    }
}
