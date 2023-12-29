package by.mariayun.task89.bean;

import org.springframework.stereotype.Component;

@Component
public class CardUSD implements ICard{
    @Override
    public String withdrawMoney(double sum) {
        return " sum USD" + sum;
    }

    @Override
    public String topUpCard(double sum) {
       return "sum USD" + sum;
    }
}
