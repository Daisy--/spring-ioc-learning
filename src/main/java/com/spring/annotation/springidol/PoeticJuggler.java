package com.spring.annotation.springidol;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class PoeticJuggler extends Juggler {
    @Autowired
    private Poem poem;

    public PoeticJuggler() {
    }

    public PoeticJuggler(Poem poem) {
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    @Override
    public void perform() {
        super.perform();    //To change body of overridden methods use File | Settings | File Templates.
        System.out.println("WHILE RECITING...");
        poem.recite();
    }
}
