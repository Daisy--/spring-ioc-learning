package com.spring.myspring.ioc;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/8/13
 * Time: 11:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyBeanTest {
    private static final String BEAN_ID_HOBBY_EAT = "eating";
    private static final String PROPERTY_TYPE_IN_HOBBY = "type";
    private MyBean bean;
    private HashMap<String,ArrayList<String>> eatProperties;

    @Before
    public void setUp() throws Exception {
        eatProperties = new HashMap<String, ArrayList<String>>(){
            {
                put(PROPERTY_TYPE_IN_HOBBY, new ArrayList<String>(Arrays.asList("value=eating")));
            }
        };
        bean = new MyBean(BEAN_ID_HOBBY_EAT, "com.spring.annimal.Hobby", eatProperties);
    }

    @Test
    public void should_get_properties_of_bean() throws Exception {
        // then
        assertThat(bean.getId(), is(BEAN_ID_HOBBY_EAT));
        assertThat(bean.getType(),is("com.spring.annimal.Hobby"));
        assertThat(bean.getProperties(),is(eatProperties));
    }
}
