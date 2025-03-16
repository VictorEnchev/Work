package com.onto.javacourse.intro.arraysorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(com.onto.javacourse.intro.gcd.Runner.class);

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(0);
        list.add(53);
        list.add(23);
        list.add(67);
        list.add(9);
        list.add(11);
        list.add(14);
        ArraySorting.quickSort(list, 0, list.size() - 1);

        LOG.info(list.toString());
    }
}
