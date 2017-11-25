package dao.jdbc;

import com.sun.org.apache.regexp.internal.RE;
import dao.ConnectionUtil;
import dao.DeveloperDAO;
import model.Company;
import model.Developer;
import model.Project;
import model.Skill;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDeveloperDAOImpl implements DeveloperDAO{
    @Override
    public Developer getById(Integer id) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String sql = "select * from developers where id = " + id;

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            int devId = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            BigDecimal salary = resultSet.getBigDecimal("salary");

            List<Skill> skills = new ArrayList<>();
            String skillSql = "select s.id from skills s, developers_skills ds where s.id = ds.skill_id and ds.developer_id = " + devId;
            ResultSet sResultSet = statement.executeQuery(skillSql);
            while(sResultSet.next()) {
                int sId = sResultSet.getInt("id");
                skills.add(new JdbcSkillDAOImpl().getById(sId));
            }

            List<Project> projects = new ArrayList<>();
            String projectSql = "select p.id from projects p, projects_developers pd where p.id = pd.project_id and pd.developer_id =  " + devId;
            ResultSet pResultSet = statement.executeQuery(projectSql);
            while(pResultSet.next()) {
                int pId = pResultSet.getInt("id");
                projects.add(new JdbcProjectDAOImpl().getById(pId));
            }

            Company company = null;
            String companySql = "select c.id from companies c, developers_companies dc where c.id = dc.company_id and dc.developer_id = " + devId;
            ResultSet cResultSet = statement.executeQuery(companySql);
            if(cResultSet.next()) {
                int cId = cResultSet.getInt("id");
                company = new JdbcCompanyDAOImpl().getById(cId);
            }

            return new Developer()
                    .withId(devId)
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .withSalary(salary)
                    .withSkills(skills)
                    .withProjects(projects)
                    .withCompany(company);
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
    public void save(Developer developer) throws SQLException {
        String sql = "";
        PreparedStatement statement = ConnectionUtil.getConnection().prepareStatement(sql);

        statement.executeUpdate();
    }

    @Override
    public void update(Developer developer) {

    }

    @Override
    public void delete(Developer developer) {

    }
}
