package com.onto.javacourse.intro.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.onto.javacourse.intro.hangman.View;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest {
    private View view;

    @BeforeEach
    void setUp(){
        view = new View("cash");
    }

    @Test
    void testViewCorrectSettingComputerWord() throws NoSuchFieldException, IllegalAccessException {
        Field f = View.class.getDeclaredField("COMPUTER_WORD");
        f.setAccessible(true);

        assertEquals("cash", f.get(view));
    }

    @Test
    void testViewCorrectSettingEmptySkeletonOfTheWord() throws NoSuchFieldException, IllegalAccessException {
        Field f = View.class.getDeclaredField("currGuessedLetters");
        f.setAccessible(true);

        assertEquals("_ _ _ _ ", f.get(view).toString());
    }

    @Test
    void testContainsLetterRevealsGuessedLetter(){
        assertEquals("This word contains the letter a: _ a _ _ ", view.containsLetter('a'));
    }

    @Test
    void testContainsLetterGlobalVariableIsBeingUpdated() throws NoSuchFieldException, IllegalAccessException {
        view.containsLetter('a');

        Field f = View.class.getDeclaredField("currGuessedLetters");
        f.setAccessible(true);

        assertEquals("_ a _ _ ", f.get(view).toString());
    }

    @Test
    void testWordsMatchesCorrectMessage(){
        assertEquals("You guessed the word!!!" , view.wordsMatch());
    }
}
