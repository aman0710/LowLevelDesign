package SnakesAndLadders;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int diceCount;
    private final int MAX = 6;
    private final int MIN = 1;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int count = 0;
        int totalSum = 0;
        while(count < diceCount) {
            totalSum += ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
            count++;
        }
        return totalSum;
    }
}
