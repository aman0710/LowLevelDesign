package LLDofSnakesAndLadders;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    private final int min = 1;
    private final int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int totalDice = 0;
        int netOutcome = 0;
        while(totalDice < this.diceCount) {
            netOutcome += ThreadLocalRandom.current().nextInt(min, max+1);
            totalDice++;
        }
        System.out.println("The dice outcome is: " + netOutcome);
        return netOutcome;
    }
}
