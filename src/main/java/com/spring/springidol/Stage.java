package com.spring.springidol;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/6/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Stage {
    public Stage() {
    }
    private static class StageSingletonHolder{
        static Stage instance = new Stage();
    }

    public static Stage getInstance(){
        return StageSingletonHolder.instance;
    }
}
