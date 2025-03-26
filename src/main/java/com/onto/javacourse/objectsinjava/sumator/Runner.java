package com.onto.javacourse.objectsinjava.sumator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        LOG.info("{}", Sumator.sum(3, 5));
        LOG.info("{}", Sumator.sum(3.5, 5.3));
        LOG.info(Sumator.sum("3", "5"));
        LOG.info("{}", Sumator.sum(BigInteger.valueOf(3), BigInteger.valueOf(5)));
        LOG.info("{}", Sumator.sum(new BigDecimal("3"), new BigDecimal("5")));
    }
}
