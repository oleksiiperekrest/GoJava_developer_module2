package dao.jdbc;

import dao.CompanyDAO;
import dao.ConnectionUtil;
import model.Company;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcCompanyDAOImpl implements CompanyDAO {
    @Override
    public Company getById(Integer id) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String sql = "select * from companies where id = " + id;

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            int cId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            String country = resultSet.getString("country");
            return new Company(cId, name, description, country);
        }
        return null;
    }

    @Override
    public List<Company> getAll() throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String sql = "select id from companies";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Integer> compIds = new ArrayList<>();
        while (resultSet.next()) {
            compIds.add(resultSet.getInt("id"));
        }
        List<Company> companies = new ArrayList<>();
        for (Integer i : compIds) {
            companies.add(getById(i));
        }
        return companies;
    }

    @Override
    public void save(Company company) {
        try
                (Statement statement = ConnectionUtil.getConnection().createStatement())
        {
            String sql = "insert into companies values ('" +
                    company.getId() + "', '" +
                    company.getName() + "', '" +
                    company.getDescription() + "', '" +
                    company.getCountry() + "')";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Company company) {
        deleteById(company.getId());
        save(company);
    }

    @Override
    public void delete(Company company) {
        deleteById(company.getId());
    }

    @Override
    public void deleteById(Integer id) {
        try
                (Statement statement = ConnectionUtil.getConnection().createStatement())
        {
            statement.addBatch("delete from developers_companies where company_id = " + id);
            statement.addBatch("delete from companies where id = " + id);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
