package com.spring.annotation.springidol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class SpringIdolConfig {
    @Bean
    public Poem sonnet29(){
        return new Sonnet29();
    }

    @Bean
    public Instrument piano(){
        return new Piano();
    }

    @Bean
    public Instrument saxophone(){
        return new Saxophone();
    }

    @Bean
    public Performer duke(){
        return new PoeticJuggler();
    }

    @Bean
    public Performer kenny(){
        return new Instrumentalist("Jingle Bells");
    }
}
