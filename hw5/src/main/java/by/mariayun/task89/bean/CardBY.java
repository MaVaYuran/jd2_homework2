package by.mariayun.task89.bean;

import org.springframework.stereotype.Component;

@Component
public class CardBY implements ICard{

    @Override
    public String withdrawMoney(double sum) {
        return " sum BY" + sum;
    }

    @Override
    public String topUpCard(double sum) {
        return "sum BY" + sum;
    }
}
