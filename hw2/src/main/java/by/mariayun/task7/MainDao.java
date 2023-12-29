package by.mariayun.task7;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainDao {
    public static void main(String[] args) {
        MyDaoImpl myDao = MyDaoImpl.getInstance();

        ArrayList<Expenses> expenses = myDao.getExpenses();
        for (int i = 0; i < expenses.size(); i++) {
            Expenses exp = expenses.get(i);
            System.out.println(exp.getId() + " " + exp.getPaydate() + " " + exp.getReceiver_id() + " " + exp.getValue());
        }
        System.out.println("-------------------------");

        Expenses expense = new Expenses();

        expense.setId(9);
        expense.setPaydate("2023-11-02");
        expense.setReceiver_id(2);
        expense.setValue(BigDecimal.valueOf(55));

        System.out.println(myDao.addExpense(expense) + " - expense added");
        System.out.println("-----------------------------");

        System.out.println(myDao.getExpense(9) + " - expense got");
        System.out.println("-----------------------------");

        ArrayList<Receiver> receivers = myDao.getReceivers();
        for (int i = 0; i < receivers.size(); i++) {
            Receiver rec = receivers.get(i);
            System.out.println(rec.getId() + " " + rec.getName());
        }
        System.out.println("-----------------------");
        Receiver receiver = new Receiver();

        receiver.setId(6);
        receiver.setName("A-100");

        System.out.println(myDao.addReceiver(receiver) + " - receiver added");
        System.out.println("-----------------------");

        System.out.println(myDao.getReceiver(2) + " - receiver got");


    }
}