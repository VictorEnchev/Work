package com.onto.javacourse.intro.hangman;

import org.junit.jupiter.api.Test;
import org.onto.javacourse.intro.hangman.Runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {
    @Test
    void testGetRandomWordGivesRandomWordEachTime() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Runner runner = new Runner();
        Method m = Runner.class.getDeclaredMethod("getRandomWord");
        m.setAccessible(true);

        String word1 = (String) m.invoke(runner);
        String word2 = (String) m.invoke(runner);

        assertNotEquals(word1, word2);
    }
}
