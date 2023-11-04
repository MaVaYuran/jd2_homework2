import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dataSource;

    private DBConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/ListExpenses",
                "root", "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new DBConnection();
        }
        return dataSource.getDBConnection();
    }
}
