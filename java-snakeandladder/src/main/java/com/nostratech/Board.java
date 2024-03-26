package com.nostratech;

import java.util.Random;
import java.util.Scanner;

public class Board {
    private static final int BOARD_SIZE = 100;
    private int[] snakesAndLadders;

    public Board() {
        snakesAndLadders = new int[BOARD_SIZE + 1]; 
        initializeSnakesAndLadders();
    }

    private void initializeSnakesAndLadders() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of snakes:");
        int numSnakes = scanner.nextInt();
        for (int i = 0; i < numSnakes; i++) {
            System.out.println("Enter the start position and end position of snake " + (i+1) + ":");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            snakesAndLadders[start] = end;
        }

        System.out.println("Enter the number of ladders:");
        int numLadders = scanner.nextInt();
        for (int i = 0; i < numLadders; i++) {
            System.out.println("Enter the start position and end position of ladder " + (i+1) + ":");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            snakesAndLadders[start] = end;
        }

        scanner.close();
    }

    public int getNewPosition(int currentPosition) {
        if (currentPosition <= BOARD_SIZE) {
            return snakesAndLadders[currentPosition] != 0 ? snakesAndLadders[currentPosition] : currentPosition;
        } else {
            return currentPosition;
        }
    }

    public static int getSize() {
        return BOARD_SIZE;
    }
}