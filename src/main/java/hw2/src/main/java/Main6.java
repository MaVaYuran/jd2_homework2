import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main6 {
    public static void main(String[] args) {
        try (Connection connection = DBConnection.getConnection()) {
            selectNamesValues(connection);
            selectSumOfPayments(connection);
            selectMaxPayment(connection);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void selectNamesValues(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT name, SUM(value) AS TOTAL_PAYMENT FROM expenses e, receiver r WHERE e.receiver_id = r.id GROUP BY name";
        statement.executeQuery(query);
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            String resName = resultSet.getString("name");
            BigDecimal resSum = resultSet.getBigDecimal("TOTAL_PAYMENT");
            System.out.println("Company: " + resName + " Sum: " + resSum);

        }
        System.out.println("-------------------------------");
        statement.close();
    }

    public static void selectSumOfPayments(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT SUM(value) AS SUM FROM expenses WHERE paydate = (SELECT paydate FROM expenses ORDER BY value DESC LIMIT 1)";
        statement.executeQuery(query);
        ResultSet resultSet = statement.getResultSet();
        if(resultSet.next()) {
            BigDecimal sum = resultSet.getBigDecimal("SUM");
            System.out.println("Sum of payments in the day - " + sum);
        }
        System.out.println("---------------------------------------");
        statement.close();
    }

    public static void selectMaxPayment(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT MAX(value) AS MAX FROM expenses WHERE paydate = (SELECT paydate FROM expenses GROUP BY paydate ORDER BY SUM(value) DESC LIMIT 1)";
        statement.executeQuery(query);
        ResultSet resultSet = statement.getResultSet();
        if(resultSet.next()) {
            BigDecimal max = resultSet.getBigDecimal("MAX");
            System.out.println("The biggest payment of the day - " + max);
        }
        System.out.println("---------------------------------------");
        statement.close();
    }
}
