package task7;

import java.math.BigDecimal;

public class Expenses {
    private int id;
    private String paydate;
    private int receiver_id;
    private BigDecimal value;

    public Expenses(int id, String date, int receiver_id, BigDecimal value) {
        this.id = id;
        this.paydate = date;
        this.receiver_id = receiver_id;
        this.value = value;
    }

    public Expenses() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", paydate='" + paydate + '\'' +
                ", receiver_id=" + receiver_id +
                ", value=" + value +
                '}';
    }
}
