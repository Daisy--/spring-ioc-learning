package com.spring.hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/3/13
 * Time: 11:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloApp {
    public static void main(String[] args) throws FileNotFoundException {
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("hello.xml"));

        GreetingService greetingService = (GreetingService) factory.getBean("greetingService");

        greetingService.sayGreeting();
    }
}
