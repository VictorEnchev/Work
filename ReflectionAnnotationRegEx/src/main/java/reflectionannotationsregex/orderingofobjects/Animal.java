package reflectionannotationsregex.orderingofobjects;

/**
 * Abstract parent class that implements the Comparable interface and initialize its method
 */
public abstract class Animal implements Comparable<Animal>{
    /**
     * Used for getting the name of the specific class
     * @return the name of the current class as String
     */
    public abstract String getName();

    /**
     * Comparing all animal classes based on the value in the Order annotation
     * @param animal the object to be compared.
     * @return -1, 0 or -1 depends on which number is bigger
     */
    @Override
    public int compareTo(Animal animal) {
        Order thisOrderAnnotation = animal.getClass().getDeclaredAnnotation(Order.class);
        Order animalOrderAnnotation = this.getClass().getDeclaredAnnotation(Order.class);
        return Integer.compare(animalOrderAnnotation.value(), thisOrderAnnotation.value());
    }
}
