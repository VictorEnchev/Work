package com.onto.javacourse.exceptions.readingnumbersfromtheconsole;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, InvalidInputException {
        double number = Double.parseDouble(READER.readLine());

        LOG.info(readNumber(number));
    }

    /**
     * Reads a number from 0 to 100
     * @throws InvalidInputException if the input does not meet the requirements
     */
    static String readNumber(double number) throws InvalidInputException {
        if (number < 0 || number > 100) {
            throw new InvalidInputException("Number should be between 0 and 100");
        }
        return String.format("You entered: %.2f", number);
    }

}
