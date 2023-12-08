package by.mariayun;

import by.mariayun.task7.DBConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class Main4 {
    public static void main(String[] args) {
        try {
            if (args.length != 4) {
                System.out.println("Usage: please enter 4 arguments");
                System.exit(25);
            }

            PaymentDTO paymentDTO = checkInputArgs(args);
            save(paymentDTO);
            readAll();
            System.out.println("Program finished seccessfully");
        } catch (Throwable e) {
            e.printStackTrace();
            System.err.println("Program end with exception" + e.getMessage());
            System.exit(3);
        }
        System.exit(0);
    }


    final static class PaymentDTO {
        final int id;
        final String paydate;
        final int receiver_id;
        final BigDecimal value;

        public PaymentDTO(int id, String paydate, int receiver_id, BigDecimal value) {
            this.id = id;
            this.paydate = paydate;
            this.receiver_id = receiver_id;
            this.value = value;
        }
    }

    private static PaymentDTO checkInputArgs(String[] args) {
        try {
            int id = Integer.parseInt(args[0]);
            String paydate = String.valueOf(args[1]);
            int receiver_id = Integer.parseInt(args[2]);
            BigDecimal value = new BigDecimal(args[3]);
            return new PaymentDTO(id, paydate, receiver_id, value);
        } catch (NumberFormatException e) {
            System.out.println("Invalid argument value: " + e.getMessage());
            System.exit(4);
        }
        return null;
    }

    private static void save(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException {
        try (Connection connection = DBConnection.getConnection()) {
            Statement statement = connection.createStatement();
            String insertValues = String.format("INSERT INTO expenses VALUES(%d, '%s', %d, %s)",
                    paymentDTO.id,
                    paymentDTO.paydate,
                    paymentDTO.receiver_id,
                    paymentDTO.value);
            System.out.println(insertValues);
            statement.executeUpdate(insertValues);

        }
    }

    private static void readAll() throws SQLException, ClassNotFoundException {
        try (Connection connection = DBConnection.getConnection()) {
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM expenses";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                int resId = result.getInt("id");
                Date resDate = result.getDate("paydate");
                int resReceiver = result.getInt("receiver_id");
                BigDecimal resValue = result.getBigDecimal("value");

                String companyName = getName(resReceiver, connection);
                System.out.printf("%d %s %s %s\n", resId, resDate, companyName, resValue);
            }
        }
    }


    private static String getName(int id, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String query = String.format("SELECT name FROM receiver rc, expenses WHERE %d = rc.id", id);
        ResultSet set = statement.executeQuery(query);
        String companyName = "";
        if (set.next()) {
            companyName = set.getString("name");
        }
        return companyName;
    }
}
