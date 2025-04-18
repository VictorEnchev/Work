package org.onto.javacourse.intro.hangman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The runner class. User input is being accepted from this class and returns the necessary message
 */
public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    /**
     * Main method where the user's input is being accepted and appropriate message is printed
     * @param args
     * @throws IOException if the file is not present at the given directory
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = getRandomWord();
        LOG.info("Word generated! Ready to begin");
        Controller controller = new Controller(word);

        String input = reader.readLine();
        String message = controller.answerByPassedArgument(input);
        LOG.info(message);
        while(!message.equals("You guessed the word!!!")){
           if(message.equals("Your tries have finished. Game is over")) break;

           input = reader.readLine();
           message = controller.answerByPassedArgument(input);
           LOG.info(message);
        }
    }

    /**
     * Putting all the words from a file into an ArrayList and randomly chooses one of them
     * @return randomly chosen word from the file
     * @throws IOException if file is not present at the given directory
     */
    private static String getRandomWord() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Programming\\Personal Projects\\Internership\\Work\\Hangman\\src\\main\\resources\\hangman words.txt"));

        List<String> words = new ArrayList<>();
        String currWord = reader.readLine();
        while(currWord != null){
            words.add(currWord);
            currWord = reader.readLine();
        }
        reader.close();

        Random rnd = new Random();
        return words.get(rnd.nextInt(0, words.size()));
    }
}
