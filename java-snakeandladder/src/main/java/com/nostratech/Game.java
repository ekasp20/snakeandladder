package com.nostratech;
import java.util.Random;

class Game {
    private Board board;
    private Dice dice;
    private Player[] players;

    public Game(Player[] players) {
        this.board = new Board();
        this.dice = new Dice(6);
        this.players = players;
    }

    public void play() {
        int currentPlayerIndex = 0;

        while (true) {
            Player currentPlayer = players[currentPlayerIndex];
            int currentPosition = currentPlayer.getPosition();
            int diceRoll = dice.roll();
            System.out.print(currentPlayer.getName() + " rolled a " + diceRoll + " and moved from " + currentPosition + " to ");

            int newPosition = currentPosition + diceRoll;

            if (newPosition <= Board.getSize()) {
                int updatedPosition = board.getNewPosition(newPosition);
                currentPlayer.setPosition(updatedPosition);
            }

            System.out.println(currentPlayer.getPosition() + ".");

            if (currentPlayer.getPosition() == Board.getSize()) {
                System.out.println(currentPlayer.getName() + " wins the game!");
                break;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }
    }
}
