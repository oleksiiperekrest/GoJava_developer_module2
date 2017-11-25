package dao.jdbc;

import dao.ConnectionUtil;
import dao.ProjectDAO;
import model.Project;
import model.Skill;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JdbcProjectDAOImpl implements ProjectDAO {
    @Override
    public Project getById(Integer id) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String sql = "select * from projects where id = " + id;

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            int pId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            BigDecimal cost = resultSet.getBigDecimal("cost");
            return new Project(pId, name, description, cost);
            }
        return null;
    }

    @Override
    public List<Project> getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(Project project) {

    }

    @Override
    public void update(Project project) {

    }

    @Override
    public void delete(Project project) {

    }
}
