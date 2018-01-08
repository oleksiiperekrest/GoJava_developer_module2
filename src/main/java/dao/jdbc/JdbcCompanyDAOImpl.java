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
            resultSet.close();

            List<Integer> developerIds = new ArrayList<>();
            String devSql = "select developer_id from developers_companies where company_id = " + id;
            ResultSet devResultSet = statement.executeQuery(devSql);
            while (devResultSet.next()) {
                developerIds.add(devResultSet.getInt("developer_id"));
            }
            devResultSet.close();
            statement.close();

            return new Company(cId, name, description, country, developerIds);
        }
        resultSet.close();
        statement.close();
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
        resultSet.close();
        statement.close();
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
            int companyId = company.getId();
            String sql = "insert into companies values ('" +
                    companyId + "', '" +
                    company.getName() + "', '" +
                    company.getDescription() + "', '" +
                    company.getCountry() + "')";
            statement.addBatch(sql);
            if (company.getDeveloperIds().size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("insert into developers_companies values ");
                List<Integer> developerIds = company.getDeveloperIds();
                for (Integer id : developerIds) {
                    stringBuilder.append("('").append(id).append("', '").append(companyId).append("'),");
                }
                stringBuilder.setLength(stringBuilder.length() - 1);
                statement.addBatch(stringBuilder.toString());
                statement.executeBatch();
            }
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
