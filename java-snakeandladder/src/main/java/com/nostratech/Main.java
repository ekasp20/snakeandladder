package com.nostratech;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of players:");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        Player[] players = new Player[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i+1) + ": ");
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName);
        }

        Game game = new Game(players);
        game.play();

        scanner.close();
    }
}