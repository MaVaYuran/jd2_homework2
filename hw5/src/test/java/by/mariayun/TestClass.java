package by.mariayun;

import by.mariayun.task2.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test.applicationContext1.xml")
public class TestClass {
    //Task10
    @Test
    public void filterTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.applicationContext1.xml");
        List<String> beans = Arrays.stream(context.getBeanDefinitionNames()).filter(bean -> !bean.contains("org.springframework")
                && bean.contains("assignable")).toList();
        System.out.println(beans);
        assertEquals(beans.size(),1);
    }

    //Task2
    @Test
    public void createBeanTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.applicationContext.xml");
        Person person = context.getBean("person", Person.class);
        assertNotNull(person);
        assertNotNull(person.getAddress());
        assertEquals("Sharapova", person.getSurname());
        assertEquals("Boston", person.getAddress().getCity());

    }

}
