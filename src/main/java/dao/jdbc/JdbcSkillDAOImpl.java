package dao.jdbc;

import dao.ConnectionUtil;
import dao.SkillDAO;
import model.Skill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcSkillDAOImpl implements SkillDAO {
    @Override
    public Skill getById(Integer id){

        try
                (
                        Connection connection = ConnectionUtil.getConnection();
                        Statement statement = connection.createStatement()
                )
        {
        String sql = "select * from skills where id = " + id;

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            int sId = resultSet.getInt("id");
            String description = resultSet.getString("description");
            resultSet.close();
            statement.close();
            connection.close();
            return new Skill(sId, description);
        }
        } catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    }

    @Override
    public List<Skill> getAll() throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String sql = "select id from skills";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Integer> skillIds = new ArrayList<>();
        while (resultSet.next()) {
            skillIds.add(resultSet.getInt("id"));
        }
        resultSet.close();
        statement.close();
        List<Skill> skills = new ArrayList<>();
        for (Integer i : skillIds) {
            skills.add(getById(i));
        }
        return skills;
    }

    @Override
    public void save(Skill skill) {
        try
                (Statement statement = ConnectionUtil.getConnection().createStatement())
        {
            String sql = "insert into skills values ('" +
                    skill.getId() + "', '" +
                    skill.getDescription() + "')";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Skill skill) {
        deleteById(skill.getId());
        save(skill);
    }

    @Override
    public void delete(Skill skill) {
        deleteById(skill.getId());
    }

    @Override
    public void deleteById(Integer id) {
        try
                (Statement statement = ConnectionUtil.getConnection().createStatement())
        {
            statement.addBatch("delete from developers_skills where skill_id = " + id);
            statement.addBatch("delete from skills where id = " + id);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
