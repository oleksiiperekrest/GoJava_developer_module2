package controller;

import dao.*;
import dao.jdbc.*;
import model.*;
import view.Show;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Create {

    public static void createDeveloper(int lastId) {
        Developer developer = new Developer();

        developer.withId(lastId + 1);

        String firstName = Input.getStringInputLimitNotNull(50, "Enter first name");
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
            System.out.println("Created new developer:");
            System.out.println(developer);
            developerDAO.save(developer);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createProject(int lastId) {

        int id = lastId + 1;
        String name = Input.getStringInputLimitNotNull(50, "Enter name");
        String description = Input.getStringInputLimitNotNull(100, "Enter description");
        BigDecimal cost = Input.getBigDecimalPositive("Enter cost");

        Project project = new Project(id, name, description, cost);
        ProjectDAO projectDAO = new JdbcProjectDAOImpl();
        try {
            System.out.println("Created new project:");
            System.out.println(project);
            projectDAO.save(project);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createSkill(int lastId) {
        int id = lastId + 1;
        String description = Input.getStringInputLimitNotNull(100, "Enter description");

        Skill skill = new Skill(id, description);
        SkillDAO skillDAO = new JdbcSkillDAOImpl();
        try {
            System.out.println("Created new skill:");
            System.out.println(skill);
            skillDAO.save(skill);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createCompany(int lastId) {
        int id = lastId + 1;
        String name = Input.getStringInputLimitNotNull(50, "Enter name");
        String description = Input.getStringInputLimitNotNull(100, "Enter description");
        String country = Input.getStringInputLimitNotNull(20, "Enter country");
        Company company = new Company(id, name, description, country);
        CompanyDAO companyDAO = new JdbcCompanyDAOImpl();
        try {
            System.out.println("Created new company:");
            System.out.println(company);
            companyDAO.save(company);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createCustomer(int lastId) {
        int id = lastId + 1;
        String firstName = Input.getStringInputLimitNotNull(50, "Enter first name");
        String lastName = Input.getStringInputLimitNotNull(50, "Enter last name");
        String info = Input.getStringInputLimitNotNull(100, "Enter info");
        Customer customer = new Customer(id, firstName, lastName, info);
        CustomerDAO customerDAO = new JdbcCustomerDAOImpl();
        try {
            System.out.println("Created new company:");
            System.out.println(customer);
            customerDAO.save(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
