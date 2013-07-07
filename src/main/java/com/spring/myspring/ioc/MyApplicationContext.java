package com.spring.myspring.ioc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyApplicationContext {

    private final Map<String,Object> beansMap;

    public MyApplicationContext() {
        beansMap = new HashMap<String, Object>();
        initBeans();
    }

    private void initBeans() {
        initBean("hobby", "com.spring.myspring.ioc.Hobby", new HashMap<String, Object>());
        initBean("cat", "com.spring.myspring.ioc.Cat", new HashMap<String, Object>() {
            {
                put("hobby", lookingForBean("hobby"));
            }
        });
    }

    private void initBean(String beanId, String beanType, Map<String, Object> beanProperties) {
        MyBean myBean = new MyBean();

        myBean.setId(beanId);
        myBean.setType(beanType);
        myBean.setProperties(beanProperties);

        Object instanceOfMyBean = newInstance(myBean.getType());
        setProperties(instanceOfMyBean,myBean.getProperties());
        beansMap.put(myBean.getId(), instanceOfMyBean);
    }

    private Object lookingForBean(String beanName) {
        return beansMap.get(beanName);
    }

    private void setProperties(Object obj, Map<String, Object> properties) {
        for (String field : properties.keySet()){
            setProperty(obj,field,properties.get(field));
        }
    }

    private void setProperty(Object obj, String field, Object value) {
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods){
            if (method.getName().equals(returnSetterName(field))){
                if (isSpecifiedSetter(value, method)){
                    setFieldValue(obj,method,value);
                }
            }
        }
    }

    private void setFieldValue(Object obj, Method method, Object value) {
        try {
            method.invoke(obj,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private boolean isSpecifiedSetter(Object value, Method method) {
        return method.getParameterTypes().length == 1 && method.getParameterTypes()[0].equals(value.getClass());
    }

    private String returnSetterName(String field) {
        return "set" + field.substring(0,1).toUpperCase() + field.substring(1);
    }

    private Object newInstance(String className) {
        Class<?> cls;
        Object obj = null;
        try {
            cls = Class.forName(className);
            obj = cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public Object getBean(String beanId){
        return beansMap.get(beanId);
    }
}
