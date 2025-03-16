package com.onto.javacourse.intro.findingarraysmedian;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(com.onto.javacourse.intro.arrayprocessing.Runner.class);

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        LOG.info("{}", FindingArrayMedian.findArrayMedian(arr));
    }
}
