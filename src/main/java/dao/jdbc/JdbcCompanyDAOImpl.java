package dao.jdbc;

import dao.CompanyDAO;
import dao.ConnectionUtil;
import model.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        return null;
    }

    @Override
    public void save(Company company) {

    }

    @Override
    public void update(Company company) {

    }

    @Override
    public void delete(Company company) {

    }
}
