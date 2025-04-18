package com.onto.javacourse.exceptions.listofelements;

import com.onto.javacourse.exceptions.listofelemnts.ArrayOutOfMemory;
import com.onto.javacourse.exceptions.listofelemnts.ListOfElements;
import com.onto.javacourse.exceptions.listofelemnts.NotEnoughElements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ListOfElementsTest {
    @Test
    void testAddElement() throws ArrayOutOfMemory, NoSuchFieldException, IllegalAccessException {
        ListOfElements list = new ListOfElements(10);
        list.add("1234");

        Field numberOfElements = ListOfElements.class.getDeclaredField("numberOfElements");
        numberOfElements.setAccessible(true);
        assertEquals(1, numberOfElements.get(list));
    }

    @Test
    void testAddThrowsWhenOutOfMemory() throws ArrayOutOfMemory{
        ListOfElements list = new ListOfElements(1);
        list.add("1234");

        Exception ex = assertThrows(ArrayOutOfMemory.class, () -> list.add("wbfiw"));
        assertEquals("Not enough space to add an element", ex.getMessage());
    }

    @Test
    void testRemoveElement() throws ArrayOutOfMemory, NoSuchFieldException, IllegalAccessException, NotEnoughElements {
        ListOfElements list = new ListOfElements(10);
        list.add("1234");
        list.remove();

        Field numberOfElements = ListOfElements.class.getDeclaredField("numberOfElements");
        numberOfElements.setAccessible(true);
        assertEquals(0, numberOfElements.get(list));
    }

    @Test
    void testAddThrowsWhenNotEnoughElements(){
        ListOfElements list = new ListOfElements(1);

        Exception ex = assertThrows(NotEnoughElements.class, list::remove);
        assertEquals("No elements in the array", ex.getMessage());
    }
}
