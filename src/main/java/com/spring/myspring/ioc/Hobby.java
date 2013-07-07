package com.spring.myspring.ioc;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hobby {
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public void act(){
        System.out.println("I love my hobby:" + type);
    }
}
