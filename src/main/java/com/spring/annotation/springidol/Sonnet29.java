package com.spring.annotation.springidol;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 3:53 PM
 * To change this template use File | Settings | File Templates.
 */
//@Component
public class Sonnet29 implements Poem {
    private static final String LINES = "I am reciting sonnet29.";

    @Override
    public void recite() {
        System.out.println(LINES);
    }
}
