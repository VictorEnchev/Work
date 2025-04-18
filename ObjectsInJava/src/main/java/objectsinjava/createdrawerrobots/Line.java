package objectsinjava.createdrawerrobots;

import com.onto.javacourse.objectsinjava.createdrawerrobots.Figure;

/**
 * Specific type of Figure
 */
public class Line extends Figure {
    private final Dot dot1;
    private final int length;

    public Line(Dot dot1, int length){
        this.dot1 = dot1;
        this.length = length;
    }

    /**
     * Returns the value of the field Dot1
     * @return Dot
     */
    public Dot getDot1() {
        return dot1;
    }

    /**
     * Returns the value of the field Length
     * @return int
     */
    public int getLength() {
        return length;
    }
}
