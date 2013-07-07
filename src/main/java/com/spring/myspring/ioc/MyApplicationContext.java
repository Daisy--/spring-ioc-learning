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

    public static final String BEAN_ID_HOBBY_SLEEP = "sleeping";
    public static final String BEAN_ID_HOBBY_EAT = "eating";
    public static final String BEAN_ID_CAT = "cat";
    public static final String PROPERTY_TYPE_IN_HOBBY = "type";
    public static final String PROPERTY_HOBBIES_IN_CAT = "hobbies";
    private final Map<String, Object> beansMap;
    private List<MyBean> beans = new ArrayList<MyBean>();

    public MyApplicationContext() {
        beansMap = new HashMap<String, Object>();
        initBeans();
    }

    private void initBeans() {
        createBeans();

        for (MyBean bean : beans) {
                initBean(bean);
        }
    }

    private void createBeans() {
        beans.add(createMyBean(BEAN_ID_CAT, "com.spring.myspring.ioc.Cat", new HashMap<String, ArrayList<String>>() {
            {
                put(PROPERTY_HOBBIES_IN_CAT, new ArrayList<String>(Arrays.asList("ref=sleeping", "ref=eating")));
            }
        }));
        beans.add(createMyBean(BEAN_ID_HOBBY_EAT, "com.spring.myspring.ioc.Hobby", new HashMap<String, ArrayList<String>>() {
            {
                put(PROPERTY_TYPE_IN_HOBBY, new ArrayList<String>(Arrays.asList("value=eating")));
            }
        }));
        beans.add(createMyBean(BEAN_ID_HOBBY_SLEEP, "com.spring.myspring.ioc.Hobby", new HashMap<String, ArrayList<String>>() {
            {
                put(PROPERTY_TYPE_IN_HOBBY, new ArrayList<String>(Arrays.asList("value=sleeping")));
            }
        }));
    }

    private MyBean createMyBean(String beanId, String beanType, HashMap<String, ArrayList<String>> beanProperties) {
        MyBean bean = new MyBean();
        bean.setId(beanId);
        bean.setType(beanType);
        bean.setProperties(beanProperties);
        return bean;
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
