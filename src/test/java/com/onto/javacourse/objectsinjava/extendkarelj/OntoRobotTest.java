package com.onto.javacourse.objectsinjava.extendkarelj;

import kareltherobot.Directions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OntoRobotTest {
    private static OntoRobot ontoRobot;
    @BeforeEach
    void setUp(){
        ontoRobot = new OntoRobot(5, 6, Directions.North, 0);
    }

    @Test
    void testTurnRightCorrectTurningRight(){
        ontoRobot.move();
        ontoRobot.turnRight();
        String expected = "RobotID 0 at (street: 6) (avenue: 6) (beepers: 0) ( direction: East) on";

        Assertions.assertEquals(expected, ontoRobot.toString());
    }
}
