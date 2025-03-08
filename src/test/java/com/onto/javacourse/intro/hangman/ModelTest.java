package com.onto.javacourse.intro.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private Model model;

    @BeforeEach
    void setUp(){
        model = new Model("cash");
    }

    @Test
    void testModelCorrectSettingComputerWord() throws NoSuchFieldException, IllegalAccessException {
        Field f = Model.class.getDeclaredField("COMPUTER_WORD");
        f.setAccessible(true);

        assertEquals("cash", f.get(model));
    }

    @Test
    void testDoesContainLetterCorrectFindingLetter(){
        assertTrue(model.doesContainLetter('a'));
    }

    @Test
    void testDoWordsMatchCorrectIsMatchingAWord(){
        assertTrue(model.doWordsMatch("cash"));
    }
}
