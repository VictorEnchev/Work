package reflectionannotationsregex.orderingofobjects;

/**
 * Child of the Animal class with a specific value of order
 */
@Order(2)
public class Cat extends Animal {
    @Override
    public String getName() {
        return "Cat";
    }
}
