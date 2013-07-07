package com.spring.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/6/13
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class PerformerApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");
        Performer performer = (Performer) ctx.getBean("duke");
        performer.perform();

        Performer performer1 = (Performer) ctx.getBean("duke2");
        performer1.perform();

        Performer performer2 = (Performer) ctx.getBean("kenny");
        performer2.perform();
    }
}
