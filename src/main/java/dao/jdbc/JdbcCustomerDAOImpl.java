package dao.jdbc;

import dao.ConnectionUtil;
import dao.CustomerDAO;
import model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDAOImpl implements CustomerDAO {
    @Override
    public Customer getById(Integer id) {
        try
                (
                        Connection connection = ConnectionUtil.getConnection();
                        Statement statement = connection.createStatement()
                ) {


            String sql = "select * from customers where id = " + id;

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                int cId = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String info = resultSet.getString("info");

                List<Integer> projectsIds = new ArrayList<>();
                String projSql = "select project_id from customers_projects where customer_id = " + id;
                ResultSet projResultSet = statement.executeQuery(projSql);
                while (projResultSet.next()) {
                    projectsIds.add(projResultSet.getInt("project_id"));
                }
                projResultSet.close();

                resultSet.close();
                statement.close();
                connection.close();
                return new Customer(cId, firstName, lastName, info, projectsIds);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        resultSet.close();
        statement.close();
        List<Customer> customers = new ArrayList<>();
        for (Integer i : custIds) {
            customers.add(getById(i));
        }
        return customers;
    }

    @Override
    public void save(Customer customer) {
        try
                (Statement statement = ConnectionUtil.getConnection().createStatement()) {
            int customerId = customer.getId();
            String sql = "insert into customers values ('" +
                    customerId + "', '" +
                    customer.getFirstName() + "', '" +
                    customer.getLastName() + "', '" +
                    customer.getInfo() + "')";
            statement.addBatch(sql);
            if (customer.getProjectIds().size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("insert into customers_projects values ");
                List<Integer> projectIds = customer.getProjectIds();
                for (Integer id : projectIds) {
                    stringBuilder.append("('").append(customerId).append("', '").append(id).append("'),");
                }
                stringBuilder.setLength(stringBuilder.length() - 1);
                statement.addBatch(stringBuilder.toString());
            }
            statement.executeBatch();

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
                (Statement statement = ConnectionUtil.getConnection().createStatement()) {
            statement.addBatch("delete from customers_projects where customer_id = " + id);
            statement.addBatch("delete from customers where id = " + id);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
