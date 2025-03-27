package com.onto.javacourse.objectsinjava.extendkarelj;

import com.onto.javacourse.objectsinjava.createdrawerrobots.Dot;
import kareltherobot.Directions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

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

        assertEquals(expected, ontoRobot.toString());
    }

    @Test
    void testGetStreetCorrectReturningStreet(){
        ontoRobot.move();
        ontoRobot.turnRight();

        assertEquals(6, ontoRobot.getStreet());
    }

    @Test
    void testGetAvenueCorrectReturningAvenue(){
        ontoRobot.move();
        ontoRobot.turnRight();

        assertEquals(6, ontoRobot.getAvenue());
    }

    @Test
    void testGetDirectionCorrectReturningDirection(){
        ontoRobot.move();
        ontoRobot.turnRight();

        assertEquals("East", ontoRobot.getDirection());
    }

    @Test
    void testGoToLocationCorrectVisitingDestination(){
        Dot dot = new Dot(4, 3);
        ontoRobot.goToLocation(dot);
        String expected = "RobotID 0 at (street: 4) (avenue: 3) (beepers: 0) ( direction: West) on";

        assertEquals(expected, ontoRobot.toString());
    }

    @Test
    void testAlignByStreetCorrectAligningStreet() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Dot dot = new Dot(4, 3);

        Method alignByStreet = OntoRobot.class.getDeclaredMethod("alignByStreet", Dot.class);
        alignByStreet.setAccessible(true);
        alignByStreet.invoke(ontoRobot, dot);
        String expected = "RobotID 0 at (street: 4) (avenue: 6) (beepers: 0) ( direction: South) on";

        assertEquals(expected, ontoRobot.toString());
    }

    @Test
    void testAlignByAvenueCorrectAligningAvenue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Dot dot = new Dot(4, 3);

        Method alignByAvenue = OntoRobot.class.getDeclaredMethod("alignByAvenue", Dot.class);
        alignByAvenue.setAccessible(true);
        alignByAvenue.invoke(ontoRobot, dot);
        String expected = "RobotID 0 at (street: 5) (avenue: 3) (beepers: 0) ( direction: West) on";

        assertEquals(expected, ontoRobot.toString());
    }
}
