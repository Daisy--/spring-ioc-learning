package com.spring.annotation.springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Instrumentalist implements Performer {
    private String song;
    @Autowired
    @Qualifier("piano")
    private Instrument instrument;

    @Override
    public void perform() {
        System.out.print("Playing " + song + ":");
        instrument.play();
    }

    public void setSong(String song) {
        this.song = song;
    }
}
