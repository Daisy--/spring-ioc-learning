package com.spring.annotation.springidol;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 4:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Saxophone implements Instrument {
    @Override
    public void play() {
        System.out.println("TOOT TOOT TOOT");
    }
}
