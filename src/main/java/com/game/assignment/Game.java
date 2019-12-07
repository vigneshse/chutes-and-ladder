package com.game.assignment;

import static com.game.assignment.Board.CHUTE_LABEL;
import static com.game.assignment.Board.LADDER_LABEL;
import static com.game.assignment.Board.WINNING_NUMBER;
import static com.game.assignment.Board.getChuteValueByKey;
import static com.game.assignment.Board.getLadderValueByKey;
import static com.game.assignment.Board.isChuteSquare;
import static com.game.assignment.Board.isLadderSquare;
import static com.game.assignment.Board.isWinningSquare;

public class Game {

    private Player[] players;
    private Spinner spinner;
    private LeaderBoard leaderBoard;
    private int turn = 1; // Defaulting to 1, as turn starts from 1

    Game(Player[] players) throws IllegalArgumentException {
        validateMinimumNumberOfPlayers(players);
        this.players = players;
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

    //TODO Validate maximum number of players, currently no check on max players.
    private static void validateMinimumNumberOfPlayers(Player[] playerNames) {
        if (playerNames == null || playerNames.length <= 1) {
            throw new IllegalArgumentException("Invalid no. of players. Must be minimum 2 players");
        }
    }

    private void makeFirstMove() {
        int highestPlayerIdx = electPlayerWithHighestDraw();

        //Rearrange players only if the highest is not the first index in the array
        if (highestPlayerIdx != 0) {
            updatePlayerSequenceByHighestDraw(highestPlayerIdx);
        }
        leaderBoard = new LeaderBoard(players[0].getName());
        leaderBoard.setSquare(players[0].getSquare());
    }

    //Helper method to spin and pick the highest draw so that the game can start
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
        return highestIndex;
    }

    private void updatePlayerSequenceByHighestDraw(int highestIndex) {
        int playersLength = players.length;
        //Rotate the array to set the player sequence
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
        int upOrDownSquare = 0;

        if (newSquare <= WINNING_NUMBER) {

            // If the pawn lands on Ladder Square
            if (isLadderSquare(newSquare)) {
                upOrDownSquare = getLadderValueByKey(newSquare);
                displayMove(player.getName(), prevSquare, newSquare, LADDER_LABEL, upOrDownSquare);
            }
            // If the pawn lands on Chutes Square
            else if (isChuteSquare(newSquare)) {
                upOrDownSquare = getChuteValueByKey(newSquare);
                displayMove(player.getName(), prevSquare, newSquare, CHUTE_LABEL, upOrDownSquare);
            }
            // Default new move
            else {
                displayMove(player.getName(), prevSquare, newSquare);
            }

            //Update player's square based on move
            if (upOrDownSquare > 0) {
                player.setSquare(upOrDownSquare);
            } else {
                player.setSquare(newSquare);
            }
        }
    }

    //Maintain the current leading player as the game progresses
    private void updateLeaderBoard(Player player) {
        leaderBoard.setName(player.getName());
        leaderBoard.setSquare(player.getSquare());
        if (isWinningSquare(player.getSquare())) {
            leaderBoard.setWinner(true);
        }
    }

    //Display scores
    //TODO Replace SOPs with log statements - to be appended to a file.
    private void displayMove(String playerName, int prevSquare, int tempSquare, String type, int newSquare) {
        System.out.println(turn + ": " + playerName + ": " + prevSquare + " --> " + tempSquare + " --" + type + "--> " +
                           newSquare);
    }

    private void displayMove(String playerName, int prevSquare, int newSquare) {
        System.out.println(turn + ": " + playerName + ": " + prevSquare + " --> " + newSquare);
    }
}
