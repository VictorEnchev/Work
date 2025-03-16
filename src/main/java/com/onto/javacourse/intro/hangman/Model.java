package com.onto.javacourse.intro.hangman;

/**
 * Model class which returns only data
 */
public class Model {
    private final String COMPUTER_WORD;

    /**
     * Constructor for the class and setting the COMPUTER_WORD variable
     * @param computerWord random word from the file
     */
    public Model(String computerWord) {
        this.COMPUTER_WORD = computerWord;
    }

    /**
     * Checks if the word contains the given letter from the user
     * @param letter random letter from the user
     * @return true if the letter is present
     */
    public boolean doesContainLetter(char letter){
        return COMPUTER_WORD.contains("" + letter);
    }

    /**
     * Checks if the word from the user matches the computer word
     * @param word random word from the user
     * @return true if the words are matching
     */
    public boolean doWordsMatch(String word){
        return COMPUTER_WORD.equals(word);
    }
}
