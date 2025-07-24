package objectsinjava.createdrawerrobots;

import com.onto.javacourse.objectsinjava.createdrawerrobots.Figure;

/**
 * Specific type of Figure
 */
public class Dot extends Figure {
    private final int street;
    private final int avenue;

    public Dot(int street, int avenue){
        if(street < 0 || avenue < 0){
            throw new IllegalArgumentException("Invalid input for street or avenue!");
        }

        this.street = street;
        this.avenue = avenue;
    }

    /**
     * Returns the value of the Street
     * @return
     */
    public int getStreet(){
        return this.street;
    }

    /**
     * Returns the value of the field Avenue
     * @return
     */
    public int getAvenue(){
        return this.avenue;
    }
}
