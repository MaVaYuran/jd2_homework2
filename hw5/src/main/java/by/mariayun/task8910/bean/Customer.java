package by.mariayun.task8910.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//@Component("customer")
public class Customer {
//    @Autowired    //for using this annotations comment out constructor
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
