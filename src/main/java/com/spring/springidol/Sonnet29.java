package com.spring.springidol;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/6/13
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class Sonnet29 implements Poem {
    private static String LINES = "This is sonnet29";

    @Override
    public void recite() {
        System.out.println(LINES);
    }
}
