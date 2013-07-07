package com.spring.myspring.ioc;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class MySpringTest {
    public static void main(String[] args) {
        MyApplicationContext context = new MyApplicationContext();
        Cat cat = (Cat) context.getBean("cat");
        cat.getHobby().act();
    }
}
