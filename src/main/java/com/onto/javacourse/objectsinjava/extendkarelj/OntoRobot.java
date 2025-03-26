package com.onto.javacourse.objectsinjava.extendkarelj;

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
}
