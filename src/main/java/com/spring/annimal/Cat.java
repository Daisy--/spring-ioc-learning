package com.spring.annimal;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 12:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Cat {
    private ArrayList<Hobby> hobbies;

    public void setHobbies(ArrayList<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public ArrayList<Hobby> getHobbies() {
        return hobbies;
    }
}
