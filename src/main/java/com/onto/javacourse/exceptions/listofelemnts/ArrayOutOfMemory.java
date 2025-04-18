package com.onto.javacourse.exceptions.listofelemnts;

/**
 * Thrown after trying to add an element in an array with no space
 */
public class ArrayOutOfMemory extends Exception {
    public ArrayOutOfMemory(String message) {
        super(message);
    }
}
