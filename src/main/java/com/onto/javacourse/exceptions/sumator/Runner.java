package com.onto.javacourse.exceptions.sumator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String num1 = READER.readLine();
        String num2 = READER.readLine();

        try{
            LOG.info(SummingLargeNumbers.sumLargeNumbers(num1, num2));
        }
        catch (IllegalStateException ex){
            LOG.error(ex.getMessage());
        }
    }
}
