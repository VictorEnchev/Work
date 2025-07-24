package objectsinjava.extendkarelj;

import com.onto.javacourse.objectsinjava.createdrawerrobots.Dot;
import kareltherobot.UrRobot;

/**
 * An extension of UrRobot class with an additional method for turning right
 */
public class OntoRobot extends UrRobot {
    public OntoRobot(int street, int avenue, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);
    }

    /**
     * Allows the robot to turn right by turning left three times(using the given methods from the library)
     */
    public void turnRight(){
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * Gives the current street of the robot
     * @return Integer value of the street
     */
    public int getStreet(){
        return Integer.parseInt("" + toString().split(" ")[4].charAt(0));
    }

    /**
     * Gives the current avenue of the robot
     * @return Integer value of the avenue
     */
    public int getAvenue(){
        return Integer.parseInt("" + toString().split(" ")[6].charAt(0));
    }

    /**
     * Gives the current direction of the robot
     * @return String value of the direction
     */
    public String getDirection(){
        return toString().split(" ")[11].split("\\)")[0];
    }

    /**
     * The robot goes to particular location(street and avenue)
     * @param dot - street and avenue coordinates of the destination
     */
    public void goToLocation(Dot dot){
        alignByStreet(dot);
        alignByAvenue(dot);
    }

    /**
     * The robot aligns itself to the street coordinate
     * @param dot Dot
     */
    private void alignByStreet(Dot dot) {
        if(dot.getStreet() > getStreet()){
            while(!getDirection().equals("North")){
                turnLeft();
            }
        }
        else if(dot.getStreet() < getStreet()){
            while(!getDirection().equals("South")){
                turnLeft();
            }
        }
        while(dot.getStreet() != getStreet()){
            move();
        }
    }

    /**
     * The robot aligns itself to the avenue coordinate
     * @param dot Dot
     */
    private void alignByAvenue(Dot dot) {
        if(dot.getAvenue() > getAvenue()){
            while(!getDirection().equals("East")){
                turnLeft();
            }
        }
        else if(dot.getAvenue() < getAvenue()){
            while(!getDirection().equals("West")){
                turnLeft();
            }
        }
        while(dot.getAvenue() != getAvenue()){
            move();
        }
    }
}
