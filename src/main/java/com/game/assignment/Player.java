package com.game.assignment;

public class Player {

    private String name;
    private int square;

    Player(String name) {
        validatePlayerNames(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return "Player{" +
               "name='" + name + '\'' +
               ", square=" + square +
               '}';
    }

    // Validate the minimum number of players and the player names
    //TODO Deeper Name Validation - only allow Alphabets and Accentuated characters, no digits allowed
    private void validatePlayerNames(String player) throws IllegalArgumentException {
        if (player == null || player.isBlank()) {
            throw new IllegalArgumentException("Player name(s) cannot be blank");

        }
    }
}
