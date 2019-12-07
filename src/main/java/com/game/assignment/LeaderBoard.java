package com.game.assignment;


public class LeaderBoard extends Player {

    private boolean winner = false;

    LeaderBoard(){ }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
