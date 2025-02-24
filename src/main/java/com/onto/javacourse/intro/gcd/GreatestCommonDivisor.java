package com.onto.javacourse.intro.gcd;


/**
 * Contains methods for finding the greatest common divisor and the smallestCommonMultiple of two numbers
 */
public class GreatestCommonDivisor {
    /**
     * Finds the greatest common divisor between two given numbers
     * @param a integer number
     * @param b integer number
     * @return returns the greatest common divisor between the two integers
     * @throws IllegalStateException if both numbers are 0
     */
    public static int findGreatestCommonDivisor(int a, int b){
        if(a == 0 && b == 0){
            throw new IllegalStateException("Both numbers can not be 0");
        }

        if(a < 0) a *= -1;
        if(b < 0) b *= -1;
        if(a == 0) return b;
        if(b == 0) return a;

        while(a != b){
            if(a > b){
                a -= b;
            }
            else {
                b -= a;
            }
        }

        return a;
    }

    /**
     * Finds the least common multiple of two given numbers
     * @param a integer number
     * @param b integer number
     * @return the least common multiple of the two integers
     * @throws IllegalStateException if both numbers are 0
     */
    public static int findLeastCommonMultiple(int a, int b)
    {
        if(a < 0) a *= -1;
        if(b < 0) b *= -1;

        try {
            return (a * b) / findGreatestCommonDivisor(a, b);
        }
        catch (IllegalStateException ex) {
            return 0;
        }
    }
}
