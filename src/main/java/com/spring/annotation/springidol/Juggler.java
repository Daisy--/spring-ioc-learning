package com.spring.annotation.springidol;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Juggler implements Performer {
    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() {
        System.out.println("JUGGLER " + beanBags + " BEANBAGS");
    }
}
