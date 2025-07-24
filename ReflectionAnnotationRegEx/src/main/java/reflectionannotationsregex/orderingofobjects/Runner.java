package reflectionannotationsregex.orderingofobjects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        Animal[] animals = {new Cow(), new Dog(), new Cat()};
        Arrays.sort(animals);

        for (Animal animal : animals) {
            LOG.info(animal.getName());
        }
    }
}
