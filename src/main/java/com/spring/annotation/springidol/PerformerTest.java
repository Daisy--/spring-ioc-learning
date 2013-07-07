package com.spring.annotation.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class PerformerTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotation-spring-idol.xml");
        Performer duke = (Performer) applicationContext.getBean("duke");
        duke.perform();

        Performer kenny = (Performer) applicationContext.getBean("kenny");
        kenny.perform();
    }
}
