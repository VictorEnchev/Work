package reflectionannotationsregex.displayclassinformation;

/**
 * Random class with no actual purpose
 */
public class RandomClass {
    private int privateField;
    public int publicField;
    protected int protectedField;

    public RandomClass(int privateField, int publicField, int protectedField) {
        this.privateField = privateField;
        this.publicField = publicField;
        this.protectedField = protectedField;
    }

    public void publicVoidMethod(int par1){}
    private int privateIntMethod(int par1, int par2){return 0;}
    protected void protectedVoidMethod(int par1, int par2, int par3){};
}
