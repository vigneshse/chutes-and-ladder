package com.game.assignment;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;
    private Board board;
    private Dice dice;
    private LeaderBoard leaderBoard;
    private int maxScore = 0;
    private int round = 1;

    Game(String[] playerNames) throws IllegalArgumentException {
        validatePlayers(playerNames);
        createPlayers(playerNames);
        board = Board.load();
        dice = new Dice();
    }

    public void play() {
        leaderBoard = new LeaderBoard();
        while (maxScore < Board.WINNING_NUMBER) {
            for (Player player : players) {
                int prevScore = player.getScore();
                int faceValue = dice.roll();
                int intermediaryScore = prevScore + faceValue;
                int newScore = intermediaryScore;
                calculateScore(newScore);
                player.setScore(newScore);
                if (maxScore < newScore) {
                    leaderBoard.setName(player.getName());
                    leaderBoard.setScore(newScore);
                    maxScore = newScore;
                }
                if (isChute(intermediaryScore)) {
                    System.out.println(round + ": " + player.getName() + ": " + prevScore + " --> " + intermediaryScore + " --CHUTE--> " + newScore);
                } else if (isLadder(intermediaryScore)) {
                    System.out.println(round + ": " + player.getName() + ": " + prevScore + " --> " + intermediaryScore + " --LADDER--> " + newScore);
                } else {
                    System.out.println(round + ": " + player.getName() + ": " + prevScore + " --> " + newScore);
                }
                round++;
                if(maxScore >= Board.WINNING_NUMBER){
                    break;
                }
            }
        }
        System.out.printf("The winner is %s", leaderBoard.getName());
    }

    private void calculateScore(int newScore) {

        // If the new score lands on Ladder Square
        if (isLadder(newScore)) {
            newScore = board.getLaddersMap().get(newScore);
        }
        // If the new score lands on Chutes Square
        else if (isChute(newScore)) {
            newScore = board.getChutesMap().get(newScore);
        }
    }

    private boolean isChute(int score) {
        return board.getChutesMap().containsKey(score);
    }

    private boolean isLadder(int score) {
        return board.getLaddersMap().containsKey(score);
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
