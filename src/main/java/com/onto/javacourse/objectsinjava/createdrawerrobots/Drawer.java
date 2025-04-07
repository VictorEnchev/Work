package com.onto.javacourse.objectsinjava.createdrawerrobots;

import com.onto.javacourse.objectsinjava.extendkarelj.OntoRobot;

/**
 * Contains methods for drawing different figures
 */
public class Drawer {
    private final OntoRobot ontoRobot;

    public Drawer(OntoRobot ontoRobot) {
        this.ontoRobot = ontoRobot;
    }

    /**
     * Goes to specific dot and puts a beeper on it
     * @param dot Dot
     */
    public void draw(Dot dot){
        this.ontoRobot.goToLocation(dot);
        this.ontoRobot.putBeeper();
    }

    /**
     * Goes to specific dot and draws line by given length
     * @param line Line
     */
    public void draw(Line line){
        this.ontoRobot.goToLocation(line.getDot1());
        for (int i = 0; i < line.getLength() - 1; i++) {
            this.ontoRobot.putBeeper();
            this.ontoRobot.move();
        }
        this.ontoRobot.putBeeper();
    }

    /**
     * Draws rectangle by reusing the draw method with line parameter
     * @param rectangle Rectangle
     */
    public void draw(Rectangle rectangle){
        this.ontoRobot.goToLocation(rectangle.getDot());
        while(!this.ontoRobot.getDirection().equals("East")){
            this.ontoRobot.turnLeft();
        }

        draw(new Line(new Dot(ontoRobot.getStreet(), ontoRobot.getAvenue()), rectangle.getLength()));
        this.ontoRobot.turnLeft();
        this.ontoRobot.move();
        draw(new Line(new Dot(ontoRobot.getStreet(), ontoRobot.getAvenue()), rectangle.getWidth() - 1));
        this.ontoRobot.turnLeft();
        this.ontoRobot.move();
        draw(new Line(new Dot(ontoRobot.getStreet(), ontoRobot.getAvenue()), rectangle.getLength() - 1));
        this.ontoRobot.turnLeft();
        this.ontoRobot.move();
        draw(new Line(new Dot(ontoRobot.getStreet(), ontoRobot.getAvenue()), rectangle.getWidth() - 2));
    }

    /**
     * Reuse the draw method with rectangle parameter with two same sides
     * @param square Square
     */
    public void draw(Square square){
        draw((Rectangle) square);
    }
}
