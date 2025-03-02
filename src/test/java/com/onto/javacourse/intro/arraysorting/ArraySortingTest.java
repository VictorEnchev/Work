package com.onto.javacourse.intro.arraysorting;

import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySortingTest {
    private static List<Integer> list;

    @BeforeEach
    void setUp(){
        list = new ArrayList<>();
        list.add(6);
        list.add(0);
        list.add(53);
        list.add(23);
        list.add(67);
        list.add(9);
        list.add(11);
        list.add(14);
    }

    @Test
    void test_quickSort_Throws_WhenListIsEmpty(){
        List<Integer> emptyList = new ArrayList<>();
        assertThrows(IllegalStateException.class, () -> ArraySorting.quickSort(emptyList, 0, emptyList.size() - 1));
    }

    @Test
    void test_quickSort_isCorrectSorted(){
        ArraySorting.quickSort(list, 0, list.size() - 1);
        assertEquals(List.of(0, 6, 9, 11, 14, 23, 53, 67), list);
    }
}
