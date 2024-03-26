package com.nostratech;
import java.util.Random;

class Dice {
    private int sides;
    private Random random;

    public Dice(int sides) {
        this.sides = sides;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }
}