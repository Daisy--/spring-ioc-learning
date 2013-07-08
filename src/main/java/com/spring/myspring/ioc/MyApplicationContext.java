package com.spring.myspring.ioc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/7/13
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyApplicationContext {
    private final Map<String, Object> beansMap;
    private List<MyBean> beans = new ArrayList<MyBean>();

    public MyApplicationContext(ArrayList<MyBean> beans) {
        this.beans = beans;
        beansMap = new HashMap<String, Object>();
        initBeans();
    }

    private void initBeans() {
        for (MyBean bean : beans) {
            initBean(bean);
        }
    }

    private void initBean(MyBean bean) {
        Object instanceOfMyBean = newInstance(bean.getType());
        setProperties(instanceOfMyBean, collectProperties(bean.getProperties()));
        beansMap.put(bean.getId(), instanceOfMyBean);
    }

    private Map<String, List> collectProperties(HashMap<String, ArrayList<String>> attributes) {
        Map<String, List> resultMap = new HashMap<String, List>();
        for (String fieldName : attributes.keySet()) {
            ArrayList value = (ArrayList) returnValue(attributes.get(fieldName));
            resultMap.put(fieldName, value);
        }
        return resultMap;
    }

    private List returnValue(ArrayList<String> valueList) {
        List values = new ArrayList();
        for (String everyValue : valueList) {
            String[] valueSet = everyValue.split("=");
            values.add(valueSet[0].equals("ref") ? lookingForBean(valueSet[1]) : valueSet[1]);
        }
        return values;
    }

    private Object lookingForBean(String beanId) {
        if (beansMap.get(beanId) == null) {
            initBean(getBeanFromBeans(beanId));
        }
        return beansMap.get(beanId);
    }

    private MyBean getBeanFromBeans(String beanId) {
        for (MyBean bean : beans) {
            if (bean.getId().equals(beanId)) {
                return bean;
            }
        }
        return null;
    }

    private void setProperties(Object obj, Map<String, List> properties) {
        for (String field : properties.keySet()) {
            setProperty(obj, field, properties.get(field));
        }
    }

    private void setProperty(Object obj, String field, List values) {
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals(returnSetterName(field))) {
                if (isSpecifiedSetter(method)) {
                    setFieldValue(obj, method, values);
                }
            }
        }
    }

    private void setFieldValue(Object obj, Method method, List value) {
        try {
            method.invoke(obj, value.size() == 1 ? value.get(0) : value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private boolean isSpecifiedSetter(Method method) {
        return method.getParameterTypes().length == 1;
    }

    private String returnSetterName(String field) {
        return "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
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

    public Object getBean(String beanId) {
        return beansMap.get(beanId);
    }
}
