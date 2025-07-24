package com.onto.javacourse.exceptions.listofelemnts;

/**
 * Thrown when there are no elements in the array after trying to remove one
 */
public class NotEnoughElements extends Exception {
    public NotEnoughElements(String message) {
        super(message);
    }
}
