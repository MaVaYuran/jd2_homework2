package by.mariayun.task10;

public class BYAccount implements IAccount {
    public BYAccount() {
        System.out.println();
    }

    @Override
    public String registredAccount() {
        return "BY Account was registred";
    }

    @Override
    public String deleteAccount() {
        return "BY Account was deleted";
    }
}
