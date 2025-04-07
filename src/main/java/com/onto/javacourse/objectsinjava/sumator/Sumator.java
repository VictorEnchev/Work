package com.onto.javacourse.objectsinjava.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Contains methods for summing numbers of different types
 */
public class Sumator {
    /**
     * Summing two integer numbers
     * @param firstNum int
     * @param secondNum int
     * @return integer sum of the two numbers
     */
    public static int sum(int firstNum, int secondNum){
        return firstNum + secondNum;
    }

    /**
     * Summing two double numbers
     * @param firstNum double
     * @param secondNum double
     * @return double sum of the two numbers
     */
    public static double sum(double firstNum, double secondNum){
        return firstNum + secondNum;
    }

    /**
     * Summing two string numbers
     * @param firstNum string
     * @param secondNum string
     * @return string sum of the two numbers
     */
    public static String sum(String firstNum, String secondNum){
        return "" + (Integer.parseInt(firstNum) + Integer.parseInt(secondNum));
    }

    /**
     * Summing two BigInteger numbers
     * @param firstNum BigInteger
     * @param secondNum BigInteger
     * @return BigInteger sum of the two numbers
     */
    public static BigInteger sum(BigInteger firstNum, BigInteger secondNum){
        return firstNum.add(secondNum);
    }

    /**
     * Summing two BigDecimal numbers
     * @param firstNum BigDecimal
     * @param secondNum BigDecimal
     * @return BigDecimal sum of the two numbers
     */
    public static BigDecimal sum(BigDecimal firstNum, BigDecimal secondNum){
        return firstNum.add(secondNum);
    }
}
