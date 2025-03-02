package com.onto.javacourse.intro.randomstringswithgivenlegth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(com.onto.javacourse.intro.gcd.Runner.class);

    public static void main(String[] args) {
        LOG.info(RandomString.getRandomString(5));
    }
}
