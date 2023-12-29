package by.mariayun.task10;

public class USDAccount implements IAccount {
    public USDAccount() {
        System.out.println();
    }

    @Override
    public String registredAccount() {
        return "USD Account was registred";
    }

    @Override
    public String deleteAccount() {
        return "USD Account was deleted";
    }
}
