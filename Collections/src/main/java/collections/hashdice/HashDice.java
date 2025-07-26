package collections.hashdice;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class representation of a dice with custom number of sides
 */
public class HashDice {
    private final int sides;

    public HashDice(int sides) {
        this.sides = sides;
    }

    /**
     * Mocking a real random roll of the dice
     * @return a random number from 1 to the number of sides
     */
    public int roll(){
        return ThreadLocalRandom.current().nextInt(1, this.sides + 1);
    }
}
