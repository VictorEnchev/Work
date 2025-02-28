package com.onto.javacourse.intro.arrayreverse;

public class ArrayReverse {
    /**
     * Reverses a given array of integers
     * @param array array of integers
     * @return string representation of the elements separated with spaces
     * @throws IllegalStateException if array is empty
     */
    public static String Reverse(int array[]) {
        if(array.length == 0) {
            throw new IllegalStateException("Array can not be empty!");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length / 2; i++) {
            int helper = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = helper;

            sb.append(array[i]).append(" ");
        }

        for (int i = array.length / 2;i < array.length; i++) {
            sb.append(array[i]).append(" ");
        }

        return sb.toString();
    }
}
