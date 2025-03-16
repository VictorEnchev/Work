package com.onto.javacourse.intro.hangman;

/**
 * View class that says how the data from the Model class to be represented
 */
public class View {
    private final String COMPUTER_WORD;
    private StringBuilder currGuessedLetters;

    /**
     * Constructor for the class that sets the values for the fields
     * currGuessedLetters is a representation of the word with empty positions
     * @param computerWord randomly generated word from the file
     */
    public View(String computerWord) {
        this.COMPUTER_WORD = computerWord;

        currGuessedLetters = new StringBuilder();
        for (int i = 0; i < computerWord.length(); i++) {
            currGuessedLetters.append("_").append(" ");
        }
    }

    /**
     * Reveals the position of the guessed letter. Positions if the letter occurs more than ones
     * @param letter guessed letter from the user
     * @return message with all currently revealed letters
     */
    public String containsLetter(char letter){
        for (int i = 0; i < COMPUTER_WORD.length(); i++) {
            if(COMPUTER_WORD.charAt(i) == letter) currGuessedLetters.setCharAt(i * 2, letter);
        }

        StringBuilder message = new StringBuilder(currGuessedLetters);
        message.insert(0, String.format("This word contains the letter %s: ", "" + letter));
        return message.toString();
    }

    /**
     * Checks if the user has guessed the word
     * @return message if he has guessed the word
     */
    public String wordsMatch(){
        return "You guessed the word!!!";
    }
}
