import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Main4 {
    public static void main(String[] args) {
        try {
            int id = Integer.parseInt(args[0]);
            String paydate = String.valueOf(args[1]);
            int receiver_id = Integer.parseInt(args[2]);
            BigDecimal value = new BigDecimal(args[3]);


            try(Connection connection = DBConnection.getConnection()) {
                Statement statement = connection.createStatement();

                String insertValues = String.format("INSERT INTO expenses VALUES(%d, '%s', %d, %s)", id, paydate, receiver_id, value);
                System.out.println(insertValues);
                statement.executeUpdate(insertValues);


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
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
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
