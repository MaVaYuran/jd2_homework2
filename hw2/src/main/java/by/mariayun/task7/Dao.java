package by.mariayun.task7;

import java.util.ArrayList;
import java.util.Optional;

public interface Dao {
    Optional<Receiver> getReceiver(int num);
    ArrayList<Receiver> getReceivers();
    Optional<Expenses> getExpense(int num);
    ArrayList<Expenses> getExpenses();
    int addReceiver(Receiver receiver);
    int addExpense(Expenses expense);
}
