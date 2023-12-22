package by.mariayun.task8910.bean;

//@Component
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
