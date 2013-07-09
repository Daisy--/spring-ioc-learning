package com.spring.myspring.ioc;

import com.spring.simple.Cat;
import com.spring.simple.Hobby;
import com.spring.springidol.Instrumentalist;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/8/13
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyApplicationContextTest {
    private static final String BEAN_ID_HOBBY_SLEEP = "sleeping";
    private static final String BEAN_ID_HOBBY_EAT = "eating";
    private static final String BEAN_ID_CAT = "cat";
    private static final String PROPERTY_TYPE_IN_HOBBY = "type";
    private static final String PROPERTY_HOBBIES_IN_CAT = "hobbies";

    @Test
    public void should_get_hobbies_of_sleeping_and_eating_for_cat() throws Exception {
        MyApplicationContext context = new MyApplicationContext(loadConfigFile());
        Cat cat = (Cat) context.getBean("cat");
        for (Hobby hobby : cat.getHobbies()) {
            hobby.act();
        }
    }

    @Test
    public void should_get_sound_of_piano() throws Exception {
        MyApplicationContext context = new MyApplicationContext(loadConfigFile2());
        Instrumentalist kenny = (Instrumentalist) context.getBean("kenny");
        kenny.perform();
    }

    private ArrayList<MyBean> loadConfigFile2() {
        MyBean beanInstrumentalist = new MyBean("kenny", "com.spring.springidol.Instrumentalist", new HashMap<String, ArrayList<String>>() {
            {
                put("song", new ArrayList<String>(Arrays.asList("value=Jingle Bells")));
                put("instrument", new ArrayList<String>(Arrays.asList("ref=piano")));
            }
        });
        MyBean beanPiano = new MyBean("piano", "com.spring.springidol.Piano", new HashMap<String, ArrayList<String>>() {
        });
        return new ArrayList<MyBean>((Arrays.asList(beanInstrumentalist, beanPiano)));
    }

    private ArrayList<MyBean> loadConfigFile() {
        MyBean bean1 = new MyBean(BEAN_ID_CAT, "com.spring.simple.Cat", new HashMap<String, ArrayList<String>>() {
            {
                put(PROPERTY_HOBBIES_IN_CAT, new ArrayList<String>(Arrays.asList("ref=sleeping", "ref=eating")));
            }
        });
        MyBean bean2 = new MyBean(BEAN_ID_HOBBY_EAT, "com.spring.simple.Hobby", new HashMap<String, ArrayList<String>>() {
            {
                put(PROPERTY_TYPE_IN_HOBBY, new ArrayList<String>(Arrays.asList("value=eating")));
            }
        });
        MyBean bean3 = new MyBean(BEAN_ID_HOBBY_SLEEP, "com.spring.simple.Hobby", new HashMap<String, ArrayList<String>>() {
            {
                put(PROPERTY_TYPE_IN_HOBBY, new ArrayList<String>(Arrays.asList("value=sleeping")));
            }
        });
        return new ArrayList<MyBean>(Arrays.asList(bean1, bean2, bean3));
    }
}
