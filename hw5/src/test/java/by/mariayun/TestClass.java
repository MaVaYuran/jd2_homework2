package by.mariayun;

import by.mariayun.task10.BYAccount;
import by.mariayun.task10.Customer1;
import by.mariayun.task10.USDAccount;
import by.mariayun.task2.bean.Person;
import by.mariayun.task89.bean.CardBY;
import by.mariayun.task89.bean.CardUSD;
import by.mariayun.task89.bean.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test.applicationContext1.xml")
public class TestClass {
    //Task10
    @Test
    public void assignableFilterTest() {
        //when
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("test.application10.xml");
        //then
        Customer1 customer = context1.getBean("customer1", Customer1.class);
        assertNotNull(customer);

        context1.close();
    }

    @Test
    public void regexFilterTest() {
        //when
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.application11.xml");
        //then
        BYAccount byAccount = context.getBean("BYAccount", BYAccount.class);
        assertNotNull(byAccount);
        USDAccount usdAccount = context.getBean("USDAccount", USDAccount.class);
        assertNotNull(usdAccount);

        context.close();
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

        context.close();
    }

    //Task89
    @Test
    public void annotationTest() {
        //When
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        //Then
        Customer customer = context.getBean("customer", Customer.class);
        assertNotNull(customer);
        assertNotNull("cardUSD", CardUSD.class);
        assertNotNull("cardBY", CardBY.class);

        context.close();

    }
}
