package com.game.assignment;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final Map<Integer, Integer> laddersMap = new HashMap<>();
    private final Map<Integer, Integer> chutesMap = new HashMap<>();
    public final static int WINNING_NUMBER = 100;

    private static Board board = null;

    public static Board load() {
        if (board == null) {
            board = new Board();
            board.populateLaddersMap();
            board.populateChutesMap();
        }
        return board;
    }

    public Map<Integer, Integer> getLaddersMap() {
        return laddersMap;
    }

    public Map<Integer, Integer> getChutesMap() {
        return chutesMap;
    }


    private void populateLaddersMap() {
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

    private void populateChutesMap() {
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
