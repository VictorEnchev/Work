package reflectionannotationsregex.orderingofobjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AnimalTest {
    @Test
    void testSortingCorrectSortingBasedOnTheAnnotation() {
        Animal[] animals = {new Dog(), new Cow(), new Dog(), new Cat(), new Cat(), new Dog(), new Cow()};

        Arrays.sort(animals);
        StringBuilder result = new StringBuilder();
        for (Animal animal : animals) {
            result.append(animal.getName()).append(" ");
        }

        String expected = "Dog Dog Dog Cat Cat Cow Cow ";
        Assertions.assertEquals(expected, result.toString());
    }
}
