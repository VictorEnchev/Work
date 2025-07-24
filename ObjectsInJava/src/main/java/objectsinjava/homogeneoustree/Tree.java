package objectsinjava.homogeneoustree;

/**
 * BST class
 * @param <T> generic type that implements the Comparable interface
 */
public class Tree<T extends Comparable<T>>{
    private final T value;
    private Tree<T> child1;
    private Tree<T> child2;

    public Tree(T value){
        this.value = value;
        child1 = null;
        child2 = null;
    }

    public void setChild2(Tree<T> child2) {
        this.child2 = child2;
    }

    public void setChild1(Tree<T> child1) {
        this.child1 = child1;
    }

    public Tree<T> getChild1() {
        return child1;
    }

    public T getValue() {
        return value;
    }

    public Tree<T> getChild2() {
        return child2;
    }

    /**
     * Method for inserting a non-duplicate value in BST
     * @param value generic type value to be inserted in the tree
     */
    public void insert(T value){
        if (value.compareTo(this.getValue()) > 0){
            if(this.getChild2() == null){
                this.setChild2(new Tree<>(value));
            }
            else{
                this.getChild2().insert(value);
            }
        }
        else if(value.compareTo(this.getValue()) < 0){
            if(this.getChild1() == null){
                this.setChild1(new Tree<>(value));
            }
            else{
                this.getChild1().insert(value);
            }
        }
    }

    /**
     * Returns a sorted BST as a StringBuilder
     * @param result StringBuilder that contains the sorted tree
     */
    public void sortedToString(StringBuilder result){
        if(child1 != null){
            child1.sortedToString(result);
        }
        result.append(this.value).append(" ");
        if(child2 != null){
            child2.sortedToString(result);
        }
    }

    /**
     * Searches if a given value is present in the BST
     * @param value value that is being searched
     * @return true or false whether the value is present or not
     */
    public boolean search(T value){
        if (value.compareTo(this.getValue()) > 0){
            if(this.getChild2() == null){
                return false;
            }
            else{
                return this.getChild2().search(value);
            }
        }
        else if(value.compareTo(this.getValue()) < 0){
            if(this.getChild1() == null){
                return false;
            }
            else{
                return this.getChild1().search(value);
            }
        }
        else{
            return true;
        }
    }
}
