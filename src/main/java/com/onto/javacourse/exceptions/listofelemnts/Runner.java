package com.onto.javacourse.exceptions.listofelemnts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) throws ArrayOutOfMemory, NotEnoughElements {
        ListOfElements list = new ListOfElements(10);
        list.add("kjbva");
        list.add(8);
        list.add("onafw");
        list.remove();
        LOG.info(list.toString());
    }
}
