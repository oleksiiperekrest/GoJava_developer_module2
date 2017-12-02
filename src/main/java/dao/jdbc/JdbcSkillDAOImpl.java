package dao.jdbc;

import dao.ConnectionUtil;
import dao.SkillDAO;
import model.Skill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JdbcSkillDAOImpl implements SkillDAO {
    @Override
    public Skill getById(Integer id) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String sql = "select * from skills where id = " + id;

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            int sId = resultSet.getInt("id");
            String description = resultSet.getString("description");
            return new Skill(sId, description);
        }
        return null;
    }

    @Override
    public List<Skill> getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(Skill skill) {

    }

    @Override
    public void update(Skill skill) {

    }

    @Override
    public void delete(Skill skill) {

    }
}
