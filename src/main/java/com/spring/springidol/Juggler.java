package com.spring.springidol;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/6/13
 * Time: 10:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class Juggler implements Performer {
    private int beanBags = 3;

    public Juggler() {}

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() {
        System.out.println("JUGGLER " + beanBags + " BEANBAGS");
    }
}
