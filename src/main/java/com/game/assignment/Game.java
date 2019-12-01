package com.game.assignment;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;
    private Board board;
    private Dice dice;
    private int maxScore;
    private long round;
    private LeaderBoard leaderBoard;

    Game(String[] playerNames) throws IllegalArgumentException {
        validatePlayers(playerNames);
        createPlayers(playerNames);
        board = Board.load();
        dice = new Dice();
    }

    public void play() {
        leaderBoard = new LeaderBoard();
        while (maxScore < 100 || round < Long.MAX_VALUE - 1) {
            for (Player player : players) {
                int currentScore = player.getScore();
                int faceValue = dice.roll();
                int newScore = calculateScore(currentScore, faceValue);
                player.setScore(newScore);
                if (maxScore < newScore) {
                    leaderBoard.setName(player.getName());
                    leaderBoard.setScore(newScore);
                    maxScore = newScore;
                }
                System.out.printf(round + ":'%2s'" , player + ":'%2s'" , currentScore + "'%2s'-->" , newScore);
                round++;
            }
        }
    }

    private int calculateScore(int currentScore, int faceValue) {
        int newScore = currentScore + faceValue;

        // If the new score lands on Ladder Square
        if (board.getLaddersMap().containsKey(newScore)) {
            newScore += board.getLaddersMap().get(newScore);
        }
        // If the new score lands on Chutes Square
        else if (board.getChutesMap().containsKey(newScore)) {
            newScore -= board.getChutesMap().get(newScore);
        }

        return newScore;
    }

    private void createPlayers(String[] playerNames) {
        this.players = new ArrayList<>(playerNames.length);
        for (String playerName : playerNames) {
            Player player = new Player(playerName);
            this.players.add(player);
        }
    }

    private void validatePlayers(String[] players) throws IllegalArgumentException {
        if (players == null || players.length <= 1) {
            throw new IllegalArgumentException("Invalid no. of players. Must be minimum 2 players");
        }
        for (String player : players) {
            if (player == null || player.isBlank()) {
                throw new IllegalArgumentException("Player name(s) cannot be blank");
            }
        }
    }
}
