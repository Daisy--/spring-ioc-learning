package com.spring.springidol;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/6/13
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Instrumentalist implements Performer, InitializingBean, DisposableBean{
    private String song;
    private Instrument instrument;

    public Instrumentalist(String song, Instrument instrument) {
        this.song = song;
        this.instrument = instrument;
    }

    public Instrumentalist(Instrument instrument) {

        this.instrument = instrument;
    }

    public Instrumentalist() {

    }

    public void setSong(String song) {
        this.song = song;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

//    public void tuneInstrument(){
//        instrument.tune();
//    }
//
//    public void cleanInstrument(){
//        instrument.clean();
//    }

    @Override
    public void perform() {
        System.out.print("Playing " + song + ":");
        instrument.play();
    }

    @Override
    public void destroy() throws Exception {
        instrument.clean();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        instrument.tune();
    }
}