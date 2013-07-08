package com.spring.myspring.ioc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/6/13
 * Time: 6:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyBean {

    private String id;
    private String type;
    private HashMap<String, ArrayList<String>> properties = new HashMap<String, ArrayList<String>>();

    public MyBean(String id, String type, HashMap<String, ArrayList<String>> properties) {
        this.id = id;
        this.type = type;
        this.properties = properties;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public HashMap<String, ArrayList<String>> getProperties() {
        return properties;
    }

}

