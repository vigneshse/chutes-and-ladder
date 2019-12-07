package com.game.assignment;

import java.util.Scanner;

public class ChutesAndLadders {

    private static Player[] playersArray;

    public static void main(String[] args) {

        char repeat = 'Y';

        // Option for the players to continue to play once the game is over.
        while ('Y' == repeat || 'y' == repeat) {

            //Get inputs (player names) from the user
            Scanner sc = new Scanner(System.in);
            String[] playerNamesArray;

            System.out.println("------------------------------------------------\n" +
                               "        WELCOME TO CHUTES AND LADDER!\n" +
                               "-------------------------------------------------");
            System.out.print("Enter the name of players in comma-separated values [2 or more]: ");

            String playersInputStr = sc.nextLine();

            if (playersInputStr != null && !playersInputStr.isBlank()) {
                playerNamesArray = playersInputStr.split(",");
            } else {
                continue;
            }

            //Create player objects from players input
            playersArray = createPlayersFromInputStr(playerNamesArray);

            //Creates a game and play begins
            Game game = new Game(playersArray);
            game.play();

            System.out.print("\nGAME OVER!\n" +
                             "Wish to play again? [Y / N]:");

            repeat = sc.next().charAt(0);
        }
    }

    //Creates players
    private static Player[] createPlayersFromInputStr(String[] playerNamesArray) {

        Player[] playersArray = new Player[playerNamesArray.length];
        for (int i = 0; i < playerNamesArray.length; i++) {
            playersArray[i] = new Player(playerNamesArray[i]);
        }
        return playersArray;
    }
}
