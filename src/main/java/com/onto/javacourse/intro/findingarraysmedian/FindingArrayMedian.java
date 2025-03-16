package com.onto.javacourse.intro.findingarraysmedian;

/**
 * Contains onr method for finding the median of an array.
 */
public class FindingArrayMedian {
    /**
     * Finds the index of the median of an array. The sum of the elements before and after the median should be as close as possible.
     * @param array array of integers
     * @return the index of the median
     * @throws IllegalStateException if the given array is empty
     */
    public static int findArrayMedian(int[] array)
    {
        if(array.length == 0){
            throw new IllegalStateException("Array can not be empty!");
        }

        int totalSum = 0;

        for (int i : array) {
            totalSum += i;
        }

        int leftSum = 0;
        int minDiff = Integer.MAX_VALUE;
        int median = 0;

        for (int i = 0; i < array.length; i++) {
            int rightSum = totalSum - leftSum - array[i];

            int currMinDiff = Math.abs(rightSum - leftSum);
            if(minDiff > currMinDiff){
                minDiff = currMinDiff;
                median = i;
            }

            leftSum += array[i];
        }

        return median + 1;
    }
}
