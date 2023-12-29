package by.mariayun.task89.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("customer")
public class Customer {
//    @Autowired    //comment out constructor for using these annotations
//    @Qualifier("cardBY")
    private ICard card;

    @Autowired
    public Customer(@Qualifier("cardUSD") ICard card) {
        this.card = card;
    }


    public void topUp() {
        System.out.println("Customer top up the card for " + card.topUpCard(500.00));
    }

    public void withdraw() {
        System.out.println("Customer withdraw" + card.withdrawMoney(305.50));
    }
}
