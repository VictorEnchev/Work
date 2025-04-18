package com.onto.javacourse.exceptions.readingnumbersfromtheconsole;

/**
 * Custom type of exception thrown when the input from the user is wrong
 */
public class InvalidInputException extends Exception{
    public InvalidInputException(String message) {
        super(message);
    }
}
