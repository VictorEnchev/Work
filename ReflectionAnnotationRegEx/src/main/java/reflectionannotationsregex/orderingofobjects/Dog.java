package reflectionannotationsregex.orderingofobjects;

/**
 * Child of the Animal class with a specific value of order
 */
@Order(1)
public class Dog extends Animal{
    @Override
    public String getName() {
        return "Dog";
    }
}
