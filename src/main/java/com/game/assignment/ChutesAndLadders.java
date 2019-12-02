package com.game.assignment;

public class ChutesAndLadders {

    public static void main(String args[]) {

        // Two Players
        String[] players = {"Eric", "Paul"};
        Game game = new Game(players);
        game.play();

/*      Four Players
        String[] players = {"Eric", "Paul", "Katy", "Carrie"};
        Game game = new Game(players);
        game.play();
*/
    }
}
