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
import java.util.HashSet;
import java.util.List;

public class JdbcDeveloperDAOImpl implements DeveloperDAO{
    @Override
    public Developer getById(Integer id) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String sql = "select\n" +
                "    d.id,\n" +
                "    d.first_name,\n" +
                "    d.last_name,\n" +
                "    d.salary,\n" +
                "    s.id as s_id,\n" +
                "    s.description as s_description,\n" +
                "    p.id as p_id,\n" +
                "    p.cost as p_cost,\n" +
                "    p.name as p_name,\n" +
                "    p.description as p_description,\n" +
                "    c.id as c_id,\n" +
                "    c.name as c_name,\n" +
                "    c.description as c_description,\n" +
                "    c.country as c_country\n" +
                "from\n" +
                "developers d, skills s, projects p, companies c,\n" +
                "developers_companies dc, developers_skills ds, projects_developers pd\n" +
                "where\n" +
                "d.id = dc.developer_id and dc.company_id = c.id and\n" +
                "d.id = ds.developer_id and ds.skill_id = s.id and\n" +
                "d.id = pd.developer_id and pd.project_id = p.id and\n" +
                "d.id =" + id;

        ResultSet resultSet = statement.executeQuery(sql);

        List<Project> projects = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();
        HashSet<Integer> pIds = new HashSet<>();
        HashSet<Integer> sIds = new HashSet<>();
        while (resultSet.next()) {
            int pId = resultSet.getInt("p_id");
            if (!pIds.contains(pId)) {
                pIds.add(pId);
                BigDecimal pCost = resultSet.getBigDecimal("p_cost");
                String pDescription = resultSet.getString("p_description");
                String pName = resultSet.getString("p_name");
                Project project = new Project(pId, pName, pDescription, pCost);
                projects.add(project);
            }
            int sId = resultSet.getInt("s_id");
            if(!sIds.contains(sId)) {
                sIds.add(sId);
                String sDescription = resultSet.getString("s_description");
                Skill skill = new Skill(sId, sDescription);
                skills.add(skill);
            }
        }

        resultSet.last();
        int devId = resultSet.getInt("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        BigDecimal salary = resultSet.getBigDecimal("salary");
        int cId = resultSet.getInt("c_id");
        String cName = resultSet.getString("c_name");
        String cDescription = resultSet.getString("c_description");
        String cCountry = resultSet.getString("c_country");
        Company company = new Company(cId, cName, cDescription, cCountry);

        return new Developer(devId, firstName, lastName, salary, skills, projects, company);
    }

    @Override
    public List<Developer> getAll() {
        return null;
    }

    @Override
    public void save(Developer developer) {

    }

    @Override
    public void update(Developer developer) {

    }

    @Override
    public void delete(Developer developer) {

    }
}
