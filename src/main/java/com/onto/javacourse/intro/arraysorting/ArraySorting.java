package com.onto.javacourse.intro.arraysorting;

import java.util.List;

/**
 * Contains implementation for the Quick Sort method
 */
public class ArraySorting {
    /**
     * Implementation of the Quick Sort method using the last method of the array as pivot
     * @param list a list of unsorted integers
     * @param left the first index of the array we want to sort
     * @param right the last index of the array we want to sort
     * @throws IllegalStateException if list is empty
     */
    public static void quickSort(List<Integer> list, int left, int right){
        if(list.isEmpty()){
            throw new IllegalStateException("List can nt be empty");
        }

        if(left >= right) return;

        int pivot = list.get(right);
        int smaller = left;

        for (int i = left; i < right; i++) {
            if(list.get(i) < pivot) {
                int helper = list.get(i);
                list.set(i, list.get(smaller));
                list.set(smaller, helper);

                smaller++;
            }
        }

        int helper = list.get(right);
        list.set(right, list.get(smaller));
        list.set(smaller, helper);

        quickSort(list, left, smaller - 1);
        quickSort(list, smaller + 1, right);
    }
}
