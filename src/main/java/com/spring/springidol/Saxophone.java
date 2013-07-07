package com.spring.springidol;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/6/13
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Saxophone implements Instrument {
    @Override
    public void play() {
        System.out.println("TOOT TOOT TOOT");
    }

    @Override
    public void tune() {
        System.out.println("TUNING SAXOPHONE");
    }

    @Override
    public void clean() {
        System.out.println("CLEANING SAXOPHONE");
    }
}
