package collections.hashdice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashDiceTest {
    @Test
    void testRollIsRandomRolling(){
        HashDice dice = new HashDice(12);

        int result1 = dice.roll();
        int result2 = dice.roll();

        assertNotEquals(result1, result2);
    }
}
