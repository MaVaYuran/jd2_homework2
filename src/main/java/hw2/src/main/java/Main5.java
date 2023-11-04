import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Main5 {
    public static void main(String[] args) {
        try {
            int id = Integer.parseInt(args[0]);
            String paydate = String.valueOf(args[1]);
            int receiver_id = Integer.parseInt(args[2]);
            BigDecimal value = new BigDecimal(args[3]);

            try (Connection connection = DBConnection.getConnection()) {
                preparedUpdate(connection, id, paydate, receiver_id, value);
                preparedQuery(connection);

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }

    public static void preparedUpdate(Connection connection, int id, String paydate, int receiver_id, BigDecimal value) throws SQLException {

        String insertValues = "INSERT INTO expenses(id, paydate, receiver_id, value)  VALUES(?, ?, ?, ?)";
        try (PreparedStatement pStatement = connection.prepareStatement(insertValues)) {


            pStatement.setInt(1, id);
            pStatement.setString(2, paydate);
            pStatement.setInt(3, receiver_id);
            pStatement.setBigDecimal(4, value);

            int rows = pStatement.executeUpdate();

            System.out.printf("%d row added\n", rows);

        }
    }

    public static void preparedQuery(Connection connection) throws SQLException {
        int minId = (int) (Math.random() * 20);
        System.out.printf("minId = %d\n", minId);
        String query = "SELECT * FROM expenses WHERE id > ?";
        try (PreparedStatement pStatement = connection.prepareStatement(query)) {
            pStatement.setInt(1, minId);
            ResultSet presult = pStatement.executeQuery();
            if(presult.next()) {
                int resId = presult.getInt("id");
                Date resDate = presult.getDate("paydate");
                int resReceiver = presult.getInt("receiver_id");
                BigDecimal resValue = presult.getBigDecimal("value");

                System.out.printf("%d %s %s %s\n", resId, resDate, resReceiver, resValue);
            }
        }
    }

}
