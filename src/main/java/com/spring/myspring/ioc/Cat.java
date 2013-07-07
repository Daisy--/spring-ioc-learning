package com.spring.myspring.ioc;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 12:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Cat {
    private Hobby hobby;

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public Hobby getHobby() {
        return hobby;
    }
}
