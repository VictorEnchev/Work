package objectsinjava.createdrawerrobots;

import com.onto.javacourse.objectsinjava.createdrawerrobots.Rectangle;

/**
 * Inheritor of the Rectangle class(Private case of a rectangle)
 */
public class Square extends Rectangle {
    public Square(Dot dot, int length) {
        super(dot, length, length);
    }
}
