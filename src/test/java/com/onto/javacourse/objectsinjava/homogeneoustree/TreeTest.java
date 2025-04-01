package com.onto.javacourse.objectsinjava.homogeneoustree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    private Tree<Integer> homogeneousTree;

    @BeforeEach
    void setUp(){
        int[] treeArray = {10, 5, 15, 2, 7, 12, 20};
        homogeneousTree = new Tree<>(treeArray[0]);

        for (int i = 1; i < treeArray.length; i++) {
            homogeneousTree.insert(treeArray[i]);
        }
    }

    @Test
    void testInsertCorrectInsertingValues() throws NoSuchFieldException, IllegalAccessException {
        Tree<Integer> tree = new Tree<>(10);
        tree.insert(5);

        Field child1 = Tree.class.getDeclaredField("child1");
        child1.setAccessible(true);

        assertEquals(5, ((Tree<Integer>) child1.get(tree)).getValue());
    }

    @Test
    void testInsertCorrectSkippingDuplicateValues() throws NoSuchFieldException, IllegalAccessException {
        Tree<Integer> tree = new Tree<>(10);
        tree.insert(5);
        tree.insert(5);

        Field child1 = Tree.class.getDeclaredField("child1");
        child1.setAccessible(true);

        assertNull(((Tree<Integer>) child1.get(tree)).getChild1());
        assertNull(((Tree<Integer>) child1.get(tree)).getChild2());
    }

    @Test
    void testSortedToStringCorrectSortingTree(){
        StringBuilder result = new StringBuilder();

        homogeneousTree.sortedToString(result);

        assertEquals("2 5 7 10 12 15 20 ", result.toString());
    }

    @Test
    void testSearchTrueIfValueIsPresent(){
        assertTrue(homogeneousTree.search(5));
    }

    @Test
    void testSearchFalseIfValueIsNotPresent(){
        assertFalse(homogeneousTree.search(9));
    }
}
