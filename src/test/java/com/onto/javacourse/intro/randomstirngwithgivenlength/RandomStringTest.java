package com.onto.javacourse.intro.randomstirngwithgivenlength;

import com.onto.javacourse.intro.randomstringswithgivenlegth.RandomString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomStringTest {
    @Test
    void test_getRandomString_Throws_WhenLengthNotPositive() {
        assertThrows(IllegalStateException.class, () -> RandomString.getRandomString(-2));
    }

    @Test
    void test_getRandomString_DifferentEachTime() {
        String string1 = RandomString.getRandomString(7);
        String string2 = RandomString.getRandomString(7);

        assertNotEquals(string1, string2);
    }
}
