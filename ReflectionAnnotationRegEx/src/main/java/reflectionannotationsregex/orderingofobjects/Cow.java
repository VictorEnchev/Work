package reflectionannotationsregex.orderingofobjects;

/**
 * Child of the Animal class with a specific value of order
 */
@Order(3)
public class Cow extends Animal{
    @Override
    public String getName() {
        return "Cow";
    }
}
