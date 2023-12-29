package by.mariayun.task10;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer1 {
    private IAccount account;

//    @Autowired
//    public Customer(@Qualifier("BYAccount") IAccount account) {
//        this.account = account;
//        System.out.println("Customer was created. Assignable filter is working.");
//
//    }

    public void open() {
        System.out.println("Customer: " + account.registredAccount());
    }

    public void close() {
        System.out.println("Customer: " + account.deleteAccount());

    }
}
