package intro.hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {
    private Controller controller;

    @BeforeEach
    void setUp(){
        controller = new Controller("cash");
    }

    @Test
    void testControllerCorrectSettingVariableWringTries() throws NoSuchFieldException, IllegalAccessException {
        Field f = Controller.class.getDeclaredField("wrongTries");
        f.setAccessible(true);

        assertEquals(9, f.get(controller));
    }

    @Test
    void testAnswerByPassedArgumentIfWrongTriesAreIs0(){
        for (int i = 0; i < 9; i++) {
            controller.answerByPassedArgument("Letter: b");
        }
        assertEquals("Your tries have finished. Game is over", controller.answerByPassedArgument("Letter: b"));
    }

    @Test
    void testAnswerByPasseArgumentIfWordContainsALetter(){
       assertEquals("This word contains the letter a: _ a _ _ " , controller.answerByPassedArgument("Letter: a"));
    }

    @Test
    void testAnswerByPasseArgumentIfWordDoesNotContainsALetter(){
        assertEquals("This word does not contain the letter b" , controller.answerByPassedArgument("Letter: b"));
    }

    @Test
    void testAnswerByPasseArgumentIfWordDoesNotContainsALetterWrongTriesReducing() throws NoSuchFieldException, IllegalAccessException {
        controller.answerByPassedArgument("Letter: b");
        Field f = Controller.class.getDeclaredField("wrongTries");
        f.setAccessible(true);

        assertEquals(8 , f.get(controller));
    }

    @Test
    void testAnswerByPasseArgumentIfWordMatches(){
        assertEquals("You guessed the word!!!" , controller.answerByPassedArgument("Word: cash"));
    }

    @Test
    void testAnswerByPasseArgumentIfWordDoesNotMatches(){
        assertEquals("This word is not vegan" , controller.answerByPassedArgument("Word: vegan"));
    }

    @Test
    void testAnswerByPasseArgumentIfWordDoesNotMatchesWrongTriesReducing() throws NoSuchFieldException, IllegalAccessException {
        controller.answerByPassedArgument("Word: vegan");
        Field f = Controller.class.getDeclaredField("wrongTries");
        f.setAccessible(true);

        assertEquals(8 , f.get(controller));
    }
}
