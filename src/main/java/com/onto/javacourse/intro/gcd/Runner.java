package com.onto.javacourse.intro.gcd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        LOG.info("The greatest common divisor is: {}", GreatestCommonDivisor.findGreatestCommonDivisor(5, 7));

    }
}
