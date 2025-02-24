package com.onto.javacourse.intro.findingarraysmedian;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindingArrayMedianTest {
    @Test
    void test_findArrayMedian_WithRandomValues(){
        int[] arr = {4, 5, 99, -1, 5, 6};
        assertEquals(3, FindingArrayMedian.findArrayMedian(arr));
    }

    @Test
    void test_findArrayMedian_WithOneElement(){
        int[] arr = {10};
        assertEquals(1, FindingArrayMedian.findArrayMedian(arr));
    }

    @Test
    void test_findArrayMedian_WithTwoElements(){
        int[] arr = {10, 20};
        assertEquals(2, FindingArrayMedian.findArrayMedian(arr));
    }

    @Test
    void test_findArrayMedian_WithNegativeNumbers(){
        int[] arr = {-5, -10, -3, -7};
        assertEquals(2, FindingArrayMedian.findArrayMedian(arr));
    }

    @Test
    void test_findArrayMedian_WithSameElements(){
        int[] arr = {5, 5, 5, 5};
        assertEquals(2, FindingArrayMedian.findArrayMedian(arr));
    }

    @Test
    void test_findArrayMedian_ThrowsWhenArrayIsEmpty(){
        int[] arr = {};
        assertThrows(IllegalStateException.class,() -> FindingArrayMedian.findArrayMedian(arr));
    }
}
