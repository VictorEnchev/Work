package com.onto.javacourse.intro.arrayprocessing;

import com.onto.javacourse.intro.gcd.Runner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains three different processing methods for an integer array
 */
public class ArrayProcessing {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    /**
     * Finds the index of the smallest integer number in the given array. If the number is contained twice, the method returns its first occurrence
     * @param array array of integers
     * @return returns integer value of the - the index of the smallest element
     * @throws IllegalStateException if array is empty
     */
    public static int getMinElementIndex(int[] array){
        if(array.length == 0){
            throw new IllegalStateException("Array can not be empty!");
        }

        int minIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if(array[minIndex] > array[i]) minIndex = i;
        }

        return minIndex;
    }

    /**
     * Calculates the sum of all numbers in a given integer array
     * @param array array of integers
     * @return returns the sum of all numbers
     * @throws IllegalStateException if array is empty
     */
    public static int sum(int[] array) {
        if(array.length == 0    ){
            throw new IllegalStateException("Array can not be empty!");
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }

    /**
     * Prints all the numbers in teh given array
     * @param array array of integers
     * @throws IllegalStateException if array is empty
     */
    public static void print(int[] array) {
        if(array.length == 0){
            throw new IllegalStateException("Array can not be empty!");
        }

        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i + " ");
        }

        LOG.info(sb.toString());
    }
}
