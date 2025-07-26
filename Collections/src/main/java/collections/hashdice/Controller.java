package collections.hashdice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements the main actions of the game
 */
public class Controller {
    private static final Logger LOG = LoggerFactory.getLogger(Controller.class);

    private final HashDice dice1;
    private final HashDice dice2;

    public Controller(int side) {
        this.dice1 = new HashDice(side);
        this.dice2 = new HashDice(side);
    }

    /**
     * The number of rolls and the combination of numbers are, after which on the console is logged every the number of every turn where the dices have landed in the specified way
     * @param diceGoal1 one of the two numbers in the combination
     * @param diceGoal2 one of the two numbers in the combination
     * @param rolls the number of rolls
     */
    public void play(int diceGoal1, int diceGoal2, int rolls){
        StringBuilder result = new StringBuilder();
        result.append(diceGoal1).append(", ").append(diceGoal2).append(" - ");

        for (int i = 1; i <= rolls; i++) {
            int number1 = dice1.roll();
            int number2 = dice2.roll();

            if((number1 == diceGoal1 && diceGoal2 == number2) || (number1 == diceGoal2 && number2 == diceGoal2)){
                result.append(i).append(" ");
            }
        }

        LOG.info(result.toString());
    }
}
