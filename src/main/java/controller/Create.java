package controller;

import dao.DeveloperDAO;
import dao.jdbc.JdbcCompanyDAOImpl;
import dao.jdbc.JdbcDeveloperDAOImpl;
import dao.jdbc.JdbcProjectDAOImpl;
import dao.jdbc.JdbcSkillDAOImpl;
import model.Company;
import model.Developer;
import model.Project;
import model.Skill;
import view.Show;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Create {

    public static void createDeveloper(int lastId) {
        Developer developer = new Developer();

        developer.withId(lastId+1);

        String firstName = Input.getStringInputLimit(50, "Enter first name");
        developer.withFirstName(firstName);

        String lastName = Input.getStringInputLimitNotNull(50, "Enter last name");
        developer.withLastName(lastName);

        BigDecimal salary = Input.getBigDecimalPositive("Enter salary");
        developer.withSalary(salary);

        JdbcSkillDAOImpl skillDAO = new JdbcSkillDAOImpl();
        try {
            Show.listAll(skillDAO.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Integer> skillIds = Input.getIntegerList("Enter ID's of skills");
        List<Skill> skills = new ArrayList<>();
        for (Integer id : skillIds) {
            try {
                skills.add(skillDAO.getById(id));
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        developer.withSkills(skills);

        JdbcProjectDAOImpl projectDAO = new JdbcProjectDAOImpl();
        try {
            Show.listAll(projectDAO.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Integer> projectIds = Input.getIntegerList("Enter ID's of projects");
        List<Project> projects = new ArrayList<>();
        for (Integer id : projectIds) {
            try {
                projects.add(projectDAO.getById(id));
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        developer.withProjects(projects);

        JdbcCompanyDAOImpl companyDAO = new JdbcCompanyDAOImpl();
        try {
            Show.listAll(companyDAO.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Company company = null;
        try {
            company = companyDAO.getById(Input.getIntInput("Enter ID of company"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        developer.withCompany(company);

        DeveloperDAO developerDAO = new JdbcDeveloperDAOImpl();
        try {
            System.out.println(developer);

            developerDAO.save(developer);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createProject() {

    }

    public static void createSkill() {

    }

    public static void createCompany() {

    }

    public static void createCustomer() {

    }


}
