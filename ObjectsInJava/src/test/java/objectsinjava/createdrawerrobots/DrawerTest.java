package objectsinjava.createdrawerrobots;

import com.onto.javacourse.objectsinjava.extendkarelj.OntoRobot;
import kareltherobot.Directions;
import kareltherobot.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DrawerTest {
    private static OntoRobot ontoRobot;
    private static Drawer drawer;

    @BeforeEach
    void setUp(){
        ontoRobot = new OntoRobot(1, 1, Directions.North, 50);
        drawer = new Drawer(ontoRobot);

        World.readWorld("stairworld.kwld");
        World.setVisible(true);
    }

    @Test
    void testDrawDotCorrectDrawingDot(){
    }

    @Test
    void testDrawLineCorrectDrawingLine(){

    }

    @Test
    void testDrawRectangleCorrectDrawingRectangle(){

    }

    @Test
    void testDrawSquareCorrectDrawingSquare(){

    }
}
