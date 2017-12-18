package dao.jdbc;

import dao.ConnectionUtil;
import dao.CustomerDAO;
import model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDAOImpl implements CustomerDAO {
    @Override
    public Customer getById(Integer id) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String sql = "select * from customers where id = " + id;

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            int cId = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String info = resultSet.getString("info");
            return new Customer(cId, firstName, lastName, info);
        }
        return null;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String sql = "select id from customers";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Integer> custIds = new ArrayList<>();
        while (resultSet.next()) {
            custIds.add(resultSet.getInt("id"));
        }
        List<Customer> customers = new ArrayList<>();
        for (Integer i : custIds) {
            customers.add(getById(i));
        }
        return customers;
    }

    @Override
    public void save(Customer customer) {
        try
                (Statement statement = ConnectionUtil.getConnection().createStatement())
        {
            String sql = "insert into customers values ('" +
                    customer.getId() + "', '" +
                    customer.getFirstName() + "', '" +
                    customer.getLastName() + "', '" +
                    customer.getInfo() + "')";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Customer customer) {
        deleteById(customer.getId());
        save(customer);
    }

    @Override
    public void delete(Customer customer) {
        deleteById(customer.getId());
    }

    @Override
    public void deleteById(Integer id) {
        try
                (Statement statement = ConnectionUtil.getConnection().createStatement())
        {
            statement.addBatch("delete from customers_projects where customer_id = " + id);
            statement.addBatch("delete from customers where id = " + id);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
