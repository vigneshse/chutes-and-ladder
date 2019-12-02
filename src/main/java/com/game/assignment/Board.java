package com.game.assignment;

import java.util.HashMap;
import java.util.Map;

public class Board {

    public final static int WINNING_NUMBER = 100;
    public final static String CHUTE_LABEL = "CHUTE";
    public final static String LADDER_LABEL = "LADDER";

    private static final Map<Integer, Integer> laddersMap = new HashMap<>();
    private static final Map<Integer, Integer> chutesMap = new HashMap<>();

    static {
        populateChutesMap();
        populateLaddersMap();
    }

    public static int getLadderValueByKey(int key) {
        if (!laddersMap.containsKey(key)) {
            throw new IllegalArgumentException("Key not found");
        }
        return laddersMap.get(key);
    }

    public static int getChuteValueByKey(int key) {
        if (!chutesMap.containsKey(key)) {
            throw new IllegalArgumentException("Key not found");
        }
        return chutesMap.get(key);
    }

    public static boolean isChuteSquare(int square) {
        return chutesMap.containsKey(square);
    }

    public static boolean isLadderSquare(int square) {
        return laddersMap.containsKey(square);
    }

    public static boolean isWinningSquare(int square) {
        return WINNING_NUMBER == square;
    }

    private static void populateLaddersMap() {
        laddersMap.put(1, 38);
        laddersMap.put(4, 14);
        laddersMap.put(9, 31);
        laddersMap.put(21, 42);
        laddersMap.put(28, 84);
        laddersMap.put(36, 44);
        laddersMap.put(51, 67);
        laddersMap.put(71, 91);
        laddersMap.put(80, 100);
    }

    private static void populateChutesMap() {
        chutesMap.put(98, 78);
        chutesMap.put(95, 75);
        chutesMap.put(93, 73);
        chutesMap.put(87, 24);
        chutesMap.put(64, 60);
        chutesMap.put(62, 19);
        chutesMap.put(56, 53);
        chutesMap.put(49, 11);
        chutesMap.put(47, 26);
        chutesMap.put(16, 6);
    }
}
