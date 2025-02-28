package com.onto.javacourse.intro.arrayreverse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(com.onto.javacourse.intro.arrayprocessing.Runner.class);

    public static void main(String[] args) {
        int[] arr = {1, 84, 634, 74, 92, 4, 22, 9, 53};
        LOG.info(ArrayReverse.Reverse(arr));
    }
}
