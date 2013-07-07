package com.spring.springidol;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/6/13
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Piano implements Instrument {
    @Override
    public void play() {
        System.out.println("PLINK PLINK PLINK");
    }

    @Override
    public void tune() {
        System.out.println("TUNING PIANO");
    }

    @Override
    public void clean() {
        System.out.println("CLEANING PIANO");
    }
}
