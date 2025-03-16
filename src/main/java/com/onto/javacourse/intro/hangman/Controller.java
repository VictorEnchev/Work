package com.onto.javacourse.intro.hangman;

/**
 * Controller class that combines both the Model and the View class and
 */
public class Controller {
    private Model model;
    private View view;
    private int wrongTries;

    /**
     * Constructor for the Controller class and initializing all the variables
     * @param computerWord randomly generated word from the file
     */
    public Controller(String computerWord) {
        model = new Model(computerWord);
        view = new View(computerWord);
        wrongTries = 9;
    }

    /**
     * Processes the user's input and decides which method to invoke
     * @param argument user's input
     * @return message based on user's input
     */
    public String answerByPassedArgument(String argument){
        String message = "";

        if(wrongTries == 0){
            message = "Your tries have finished. Game is over";
            return message;
        }

        if(argument.contains("Letter")) {
            char currLetter = argument.split(": ")[1].charAt(0);
            if(model.doesContainLetter(currLetter)) {
                message = view.containsLetter(currLetter);
            }
            else {
                message = String.format("This word does not contain the letter %s", "" + currLetter);
                wrongTries--;
            }
        }
        else if (argument.contains("Word")) {
            String currWord = argument.split(": ")[1];
            if(model.doWordsMatch(currWord)){
                message = view.wordsMatch();
            }
            else {
                message = String.format("This word is not %s", currWord);
                wrongTries--;
            }
        }

        return message;
    }
}
