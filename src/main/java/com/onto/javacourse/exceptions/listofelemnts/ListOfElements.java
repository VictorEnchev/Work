package com.onto.javacourse.exceptions.listofelemnts;

/**
 * Custom class for an array
 */
public class ListOfElements {
    private final Object[] elements;
    private int numberOfElements;

    public ListOfElements(int length){
        this.elements = new Object[length];
        numberOfElements = 0;
    }

    /**
     * Adds an element in the array
     * @param obj random element
     * @throws ArrayOutOfMemory if there is no space in the array
     */
    public void add(Object obj) throws ArrayOutOfMemory {
        try {
            elements[numberOfElements++] = obj;
        }
        catch (ArrayIndexOutOfBoundsException ex){
            throw new ArrayOutOfMemory("Not enough space to add an element");
        }
    }

    /**
     * Removes the last element in the array
     * @throws NotEnoughElements if there are no elements to remove
     */
    public void remove() throws NotEnoughElements {
        if(numberOfElements <= 0){
            throw new NotEnoughElements("No elements in the array");
        }
        elements[numberOfElements-- - 1] = null;
    }

    /**
     * Prints the array
     * @return String representation of the array
     */
    @Override
    public String toString() {
        if(numberOfElements == 0){
            return "The array is empty!";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfElements; i++) {
            sb.append(elements[i].toString()).append(" ");
        }
        return sb.toString();
    }
}
