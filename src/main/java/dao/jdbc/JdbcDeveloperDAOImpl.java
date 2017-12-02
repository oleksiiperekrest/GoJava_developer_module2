package dao.jdbc;

import dao.ConnectionUtil;
import dao.DeveloperDAO;
import model.Company;
import model.Developer;
import model.Project;
import model.Skill;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDeveloperDAOImpl implements DeveloperDAO {
    @Override
    public Developer getById(Integer id) {
        try
                (Statement statement = ConnectionUtil.getConnection().createStatement()

                ) {
            String sql = "select * from developers where id = " + id;

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                int devId = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                BigDecimal salary = resultSet.getBigDecimal("salary");

                List<Skill> skills = new ArrayList<>();
                String skillSql = "select s.id from skills s, developers_skills ds where s.id = ds.skill_id " +
                        "and ds.developer_id = " + devId;
                ResultSet sResultSet = statement.executeQuery(skillSql);
                while (sResultSet.next()) {
                    int sId = sResultSet.getInt("id");
                    skills.add(new JdbcSkillDAOImpl().getById(sId));
                }
                resultSet.close();

                List<Project> projects = new ArrayList<>();
                String projectSql = "select p.id from projects p, projects_developers pd where p.id = pd.project_id " +
                        "and pd.developer_id =  " + devId;
                ResultSet pResultSet = statement.executeQuery(projectSql);
                while (pResultSet.next()) {
                    int pId = pResultSet.getInt("id");
                    projects.add(new JdbcProjectDAOImpl().getById(pId));
                }
                pResultSet.close();

                Company company = null;
                String companySql = "select c.id from companies c, developers_companies dc where c.id = dc.company_id " +
                        "and dc.developer_id = " + devId;
                ResultSet cResultSet = statement.executeQuery(companySql);
                if (cResultSet.next()) {
                    int cId = cResultSet.getInt("id");
                    company = new JdbcCompanyDAOImpl().getById(cId);
                }
                cResultSet.close();

                return new Developer()
                        .withId(devId)
                        .withFirstName(firstName)
                        .withLastName(lastName)
                        .withSalary(salary)
                        .withSkills(skills)
                        .withProjects(projects)
                        .withCompany(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Developer> getAll() throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String sql = "select id from developers";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Integer> devIds = new ArrayList<>();
        while (resultSet.next()) {
            devIds.add(resultSet.getInt("id"));
        }
        List<Developer> developers = new ArrayList<>();
        for (Integer i : devIds) {
            developers.add(getById(i));
        }
        return developers;
    }

    @Override
    public void save(Developer developer) {
        try
                (Statement statement = ConnectionUtil.getConnection().createStatement()) {
            int id = developer.getId();

            statement.addBatch("insert into developers values ('" +
                    id + "', '" +
                    developer.getFirstName() + "', '" +
                    developer.getLastName() + "', '" +
                    developer.getSalary() + "')");
            statement.addBatch("insert into developers_companies values ('" + id + "', '" +
                    developer.getCompany().getId() + "')");

            for (Skill skill : developer.getSkills()) {
                statement.addBatch("insert into developers_skills values ('" + id + "', '" +
                        skill.getId() + "')");
            }

            for (Project project : developer.getProjects()) {
                statement.addBatch("insert into projects_developers values ('" + project.getId() + "', '" +
                        id + "')");
            }

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Developer developer) {

    }

    @Override
    public void delete(Developer developer) {
        try
                (Statement statement = ConnectionUtil.getConnection().createStatement()) {
            int id = developer.getId();
            statement.addBatch("delete from developers_companies where developer_id = " + id);
            statement.addBatch("delete from developers_skills where developer_id = " + id);
            statement.addBatch("delete from projects_developers where developer_id = " + id);
            statement.addBatch("delete from developers where id = " + id);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
