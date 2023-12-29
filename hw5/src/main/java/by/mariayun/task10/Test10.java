package by.mariayun.task10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test10 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"application10.xml", "application11.xml"});

        Customer1 customer = context.getBean("customer1", Customer1.class);

//        context.close();
//
//        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext();
//
//        BYAccount byAccount = context.getBean("BYAccount", BYAccount.class);
//        USDAccount usdAccount = context.getBean("USDAccount", USDAccount.class);

//        customer.open();
//        customer.close();



   //     context.close();
    }
}
