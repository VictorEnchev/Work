package com.onto.javacourse.exceptions.sumator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains a method for summing large numbers as strings
 */
public class SummingLargeNumbers {
    private static final Logger LOG = LoggerFactory.getLogger(SummingLargeNumbers.class);
    
    /**
     * Sums two numbers the way people do it - sum the ones column, sum tens column and add carry in if sum is greater than 10 and so on.
     * @param num1 string representation of very large number
     * @param num2 string representation of very large number
     * @return the result as a string
     */
    public static String sumLargeNumbers(String num1, String num2) {
        if(num1.isEmpty() || num2.isEmpty()){
            throw new IllegalStateException("Numbers can not be empty");
        }

        try{
            Double.parseDouble(num1);
            Double.parseDouble(num2);
        }
        catch (NumberFormatException e){
            throw new IllegalStateException("Numbers should contain only digits!");
        }

        StringBuilder number1 = new StringBuilder(num1);
        StringBuilder number2 = new StringBuilder(num2);
        insertNecessaryZeroes(num1, num2, number1, number2);

        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = number1.length() - 1; i >= 0; i--){
            if((number1.charAt(i) <= 47 || number1.charAt(i) >= 58) || (number2.charAt(i) <= 47 || number2.charAt(i) >= 58)){
                throw new IllegalStateException("You must enter number");
            }

            int currSum = Integer.parseInt("" + number1.charAt(i)) + Integer.parseInt("" + number2.charAt(i)) + carry;
            carry = 0;
            if(currSum >= 10){
                carry = Integer.parseInt("" + ("" + currSum).charAt(0));
            }

            result.append(currSum % 10);
        }

        return result.reverse().toString();
    }

    /**
     * Inserts zeroes in front of the numbers where necessary
     * @param num1 user's first big number as
     * @param num2 user's second big number as String
     * @param number1 updated version of the first number
     * @param number2 updated version of the second number
     */
    private static void insertNecessaryZeroes(String num1, String num2, StringBuilder number1, StringBuilder number2){
        int diff = Math.abs(num1.length() - num2.length());
        if(num1.length() >= num2.length()) {
            for (int i = 0; i < diff; i++) {
                number2.insert(0, "0");
            }
        }
        else{
            for (int i = 0; i < diff; i++) {
                number1.insert(0, "0");
            }
        }
    }
}