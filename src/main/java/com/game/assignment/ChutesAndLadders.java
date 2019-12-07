package com.game.assignment;

import java.util.Scanner;

public class ChutesAndLadders {

    public static void main(String args[]) {

        char repeat = 'Y';

        // Option for the players to continue to play once the game is over.
        while ('Y' == repeat || 'y' == repeat) {

            //Get inputs (player names) from the user
            Scanner sc = new Scanner(System.in);
            String[] players;

            System.out.println("------------------------------------------------\n" +
                    "        WELCOME TO CHUTES AND LADDER!\n" +
                    "-------------------------------------------------");
            System.out.print("Enter the name of players in comma-separated values [2 or more]: ");

            String playersStr = sc.nextLine();

            if (playersStr != null && !playersStr.isBlank()) {
                players = playersStr.split(",");
            }
            else{
                continue;
            }

            //Creates a game and play begins
            Game game = new Game(players);
            game.play();

            System.out.print("\nGAME OVER!\n" +
                    "Wish to play again? [Y / N]:");

            repeat = sc.next().charAt(0);
        }
    }
}
