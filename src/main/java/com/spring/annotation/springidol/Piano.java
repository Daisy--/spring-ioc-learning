package com.spring.annotation.springidol;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Piano implements Instrument {
    @Override
    public void play() {
        System.out.println("PLINK PLINK PLINK");
    }
}
