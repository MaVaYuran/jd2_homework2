package task7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class MyDaoImpl implements Dao {
    private final static MyDaoImpl INSTANCE = new MyDaoImpl();

    public static MyDaoImpl getInstance() {
        return INSTANCE;
    }

    private MyDaoImpl() {

    }

    public static final String GET_RECEIVER = "SELECT * FROM receiver WHERE id = ?";
    public static final String GET_EXPENSE = "SELECT * FROM expenses WHERE id = ?";
    public static final String All_RECEIVER = "SELECT * FROM receiver";
    public static final String All_EXPENSE = "SELECT * FROM expenses";
    public static final String ADD_RECEIVER = "INSERT INTO receiver(id, name) VALUES(?,?)";
    public static final String ADD_EXPENSE = "INSERT INTO expenses(id, paydate, receiver_id, value) VALUES(?,?,?,?)";


    @Override
    public Optional<Receiver> getReceiver(int num) {

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_RECEIVER);
            statement.setInt(1, num);

            ResultSet resultSet = statement.executeQuery();
            Receiver receiver = null;
            if (resultSet.next()) {
                String rName = resultSet.getString("name");
                receiver = new Receiver(num, rName);
            }
            return Optional.ofNullable(receiver);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ArrayList<Receiver> getReceivers() {
        ArrayList<Receiver> receivers = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(All_RECEIVER);
            ResultSet rSet = statement.executeQuery();

            while (rSet.next()) {
                receivers.add(
                        new Receiver(
                                rSet.getInt("id"),
                                rSet.getString("name"))
                );
            }

        } catch (SQLException | ClassNotFoundException ee) {
            throw new RuntimeException(ee);

        }
        return receivers;
    }


    @Override
    public Optional<Expenses> getExpense(int id) {

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_EXPENSE)) {
            preparedStatement.setInt(1, id);
            ResultSet res = preparedStatement.executeQuery();
            Expenses expense = null;
            if (res.next()) {
                expense = new Expenses(
                        res.getInt("id"),
                        res.getString("paydate"),
                        res.getInt("receiver_id"),
                        res.getBigDecimal("value")
                );
            }
            return Optional.ofNullable(expense);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public ArrayList<Expenses> getExpenses() {
        ArrayList<Expenses> expenses = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(All_EXPENSE);
            ResultSet rSet = statement.executeQuery();
            while (rSet.next()) {
                expenses.add(new Expenses(
                        rSet.getInt("id"),
                        rSet.getString("paydate"),
                        rSet.getInt("receiver_id"),
                        rSet.getBigDecimal("value"))
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return expenses;
    }

    @Override
    public int addReceiver(Receiver receiver) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_RECEIVER)) {
            preparedStatement.setInt(1, receiver.getId());
            preparedStatement.setString(2, receiver.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public int addExpense(Expenses expense) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_EXPENSE)) {
            preparedStatement.setInt(1, expense.getId());
            preparedStatement.setString(2, expense.getPaydate());
            preparedStatement.setInt(3, expense.getReceiver_id());
            preparedStatement.setBigDecimal(4, expense.getValue());
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}