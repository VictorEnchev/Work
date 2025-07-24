package librariesandclasspath.packagecodeasreusablemodule;

import org.onto.javacourse.intro.hangman.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

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

        reader.close();
    }

    /**
     * Putting all the words from a file into an ArrayList and randomly chooses one of them
     * @return randomly chosen word from the file
     * @throws IOException if file is not present at the given directory
     */
    private static String getRandomWord() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/hangman words.txt"));

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
