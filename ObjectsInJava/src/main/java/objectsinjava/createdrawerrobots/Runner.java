package objectsinjava.createdrawerrobots;

import com.onto.javacourse.objectsinjava.createdrawerrobots.Drawer;
import com.onto.javacourse.objectsinjava.extendkarelj.OntoRobot;
import kareltherobot.Directions;
import kareltherobot.World;

public class Runner {
    public static void main(String[] args) {
        OntoRobot ontoRobot = new OntoRobot(1, 1, Directions.North, 50);
        Drawer drawer = new Drawer(ontoRobot);

        World.readWorld("stairworld.kwld");
        World.setVisible(true);

        Dot dot = new Dot(3, 4);
        drawer.draw(dot);

        Line line = new Line(dot, 5);
        drawer.draw(line);

        Rectangle rectangle = new Rectangle(dot, 5, 7);
        drawer.draw(rectangle);

        Square square = new Square(dot, 5);
        drawer.draw(square);
    }
}
