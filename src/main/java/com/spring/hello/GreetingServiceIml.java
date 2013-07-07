package com.spring.hello;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/3/13
 * Time: 11:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class GreetingServiceIml implements GreetingService{
    private String greeting;

//    public GreetingServiceIml() {
//    }

    public GreetingServiceIml(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public void sayGreeting() {
        System.out.println(greeting);
    }

    public void setGreeting(String greeting){
        this.greeting = greeting;
    }
}
