package by.mariayun.task2;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import by.mariayun.task2.bean.Person;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
        context.close();
    }
}
