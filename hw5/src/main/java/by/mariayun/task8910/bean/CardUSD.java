package by.mariayun.task8910.bean;

//@Component
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
