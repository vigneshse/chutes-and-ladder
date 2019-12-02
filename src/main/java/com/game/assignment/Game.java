package com.game.assignment;

import static com.game.assignment.Board.*;

public class Game {

    private Player[] players;
    private Spinner spinner;
    private LeaderBoard leaderBoard;
    private int turn = 1;

    Game(String[] playerNames) throws IllegalArgumentException {
        validatePlayers(playerNames);
        createPlayers(playerNames);
        spinner = new Spinner();
    }

    public void play() {

        // Make the first move with highest draw
        makeFirstMove();

        while (!leaderBoard.isWinner()) {
            for (Player player : players) {

                //Player spins
                int draw = spinner.spin();

                //Makes move
                makeMove(player, draw);

                //Maintain running leader of the game
                if (leaderBoard.getSquare() < player.getSquare()) {
                    updateLeaderBoard(player);
                }

                // Stop as soon as there is a winner
                if (leaderBoard.isWinner()) {
                    break;
                }

                //Increment Turn
                turn++;
            }
        }
        System.out.printf("The winner is %s", leaderBoard.getName());
    }

    private void makeFirstMove() {
        int highestPlayerIdx = electPlayerWithHighestDraw();

        //Rearrange players only if the highest is not the first index in the array
        if (highestPlayerIdx != 0) {
            updatePlayerSequenceByHighestDraw(highestPlayerIdx);
        }
        leaderBoard = new LeaderBoard();
        leaderBoard.setSquare(players[0].getSquare());
        leaderBoard.setName(players[0].getName());
    }

    private int electPlayerWithHighestDraw() {
        int highestDraw = Integer.MIN_VALUE;
        int highestIndex = -1;
        for (int i = 0; i < players.length; i++) {
            int draw = spinner.spin();
            if (highestDraw < draw) {
                highestIndex = i;
                highestDraw = draw;
            }
        }
        players[highestIndex].setSquare(highestDraw);
        return highestIndex;
    }

    private void updatePlayerSequenceByHighestDraw(int highestIndex) {
        int playersLength = players.length;
        for (int i = 0; i < highestIndex % playersLength; i++) {
            Player tempPlayer = players[playersLength - 1];
            for (int j = playersLength - 1; j > 0; j--) {
                players[j] = players[j - 1];
            }
            players[0] = tempPlayer;
        }
    }


    private void makeMove(Player player, int draw) {

        int prevSquare = player.getSquare();
        int newSquare = prevSquare + draw;
        int upOrDownSquare;

        if (newSquare <= WINNING_NUMBER) {

            // If the new score lands on Ladder Square
            if (isLadderSquare(newSquare)) {
                upOrDownSquare = getLadderValueByKey(newSquare);
                displayMove(player.getName(), prevSquare, newSquare, LADDER_LABEL, upOrDownSquare);
            }
            // If the new score lands on Chutes Square
            else if (isChuteSquare(newSquare)) {
                upOrDownSquare = getChuteValueByKey(newSquare);
                displayMove(player.getName(), prevSquare, newSquare, CHUTE_LABEL, upOrDownSquare);
            }
            // Default new score
            else {
                displayMove(player.getName(), prevSquare, newSquare);
            }
            player.setSquare(newSquare);
        }
    }

    private void updateLeaderBoard(Player player) {
        leaderBoard.setName(player.getName());
        leaderBoard.setSquare(player.getSquare());
        if (isWinningSquare(player.getSquare())) {
            leaderBoard.setWinner(true);
        }
    }

    private void displayMove(String playerName, int prevSquare, int tempSquare, String type, int newSquare) {
        System.out.println(turn + ": " + playerName + ": " + prevSquare + " --> " + tempSquare + " --" + type + "--> " + newSquare);
    }

    private void displayMove(String playerName, int prevSquare, int newSquare) {
        System.out.println(turn + ": " + playerName + ": " + prevSquare + " --> " + newSquare);
    }

    private void createPlayers(String[] playerNames) {
        this.players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            Player player = new Player(playerNames[i]);
            this.players[i] = player;
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
