package com.onto.javacourse.objectsinjava.createdrawerrobots;

/**
 * Specific type of Figure
 */
public class Rectangle extends Figure{
    private final Dot dot;
    private final int length;
    private final int width;

    public Rectangle(Dot dot, int length, int width){
        this.dot = dot;
        this.length = length;
        this.width = width;
    }

    /**
     * Returns the value of the field Dot
     * @return Dot
     */
    public Dot getDot() {
        return dot;
    }

    /**
     * Returns the value of the field Length
     * @return int
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the value of the field Width
     * @return int
     */
    public int getWidth() {
        return width;
    }
}
