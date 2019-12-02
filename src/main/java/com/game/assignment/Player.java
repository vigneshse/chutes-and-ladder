package com.game.assignment;

public class Player {

    private String name;
    private int square;

    Player() { }

    Player(String name) {
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
}
