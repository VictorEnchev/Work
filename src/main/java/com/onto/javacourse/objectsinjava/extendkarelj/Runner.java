package com.onto.javacourse.objectsinjava.extendkarelj;

import kareltherobot.Directions;
import kareltherobot.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        OntoRobot ontoRobot = new OntoRobot(5, 6, Directions.North, 0);

        World.readWorld("stairworld.kwld");
        World.setVisible(true);

        ontoRobot.move();
        ontoRobot.turnRight();
        ontoRobot.move();

        LOG.info(ontoRobot.toString());
    }
}


