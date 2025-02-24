package com.onto.javacourse.intro.arrayprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        int[] array = {1, 4, 5, 9, 12, 3, 78, 53, 36, 31, 10};
        LOG.info(" " + ArrayProcessing.getMinElementIndex(array));
        LOG.info(" " + ArrayProcessing.sum(array));
        ArrayProcessing.print(array);
    }
}
