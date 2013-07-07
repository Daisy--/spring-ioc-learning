package com.spring.annotation.springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
//@Component("kenny")
public class Instrumentalist implements Performer {
//    @Value("Jingle Bells")
    private String song;
    @Autowired
    @Qualifier("saxophone")
    private Instrument instrument;

    public Instrumentalist(String song, Instrument instrument) {
        this.song = song;
        this.instrument = instrument;
    }

    public Instrumentalist(String song) {
        this.song = song;
    }

    @Override
    public void perform() {
        System.out.print("Playing " + song + ":");
        instrument.play();
    }

    public void setSong(String song) {
        this.song = song;
    }
}
