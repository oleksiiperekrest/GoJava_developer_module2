package controller.services;

import dao.*;
import dao.jdbc.*;
import model.*;
import utils.Input;
import view.Show;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Create {

    public static void createDeveloper(int lastId, DeveloperDAO developerDAO, SkillDAO skillDAO, ProjectDAO projectDAO, CompanyDAO companyDAO) {
        Developer developer = new Developer();

        developer.withId(lastId + 1);

        String firstName = Input.getStringInputLimitNotNull(50, "Enter first name");
        developer.withFirstName(firstName);

        String lastName = Input.getStringInputLimitNotNull(50, "Enter last name");
        developer.withLastName(lastName);

        BigDecimal salary = Input.getBigDecimalPositive("Enter salary");
        developer.withSalary(salary);

        List<Integer> allSkillIds = null;
        try {
            List<Skill> allSkills = skillDAO.getAll();
            Show.listAll(allSkills);
            allSkillIds = Show.getIds(allSkills);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Integer> skillIds = Input.getAllowedIntegerList("Enter ID's of skills", allSkillIds);
        List<Skill> skills = new ArrayList<>();
        for (Integer id : skillIds) {
            try {
                skills.add(skillDAO.getById(id));
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        developer.withSkills(skills);

        List<Integer> allProjectIds = null;
        try {
            List<Project> allProjects = projectDAO.getAll();
            Show.listAll(allProjects);
            allProjectIds = Show.getIds(allProjects);
            allProjectIds.add(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Integer> projectIds = Input.getAllowedIntegerList("Enter ID's of projects", allProjectIds);
        List<Project> projects = new ArrayList<>();
        if (!(projectIds.size() == 1 && projectIds.get(0) == 0)) {
            for (Integer id : projectIds) {
                try {
                    projects.add(projectDAO.getById(id));
                } catch (SQLException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
        developer.withProjects(projects);

        List<Integer> allCompanyIds = null;
        try {
            List<Company> allCompanies = companyDAO.getAll();
            Show.listAll(allCompanies);
            allCompanyIds = Show.getIds(allCompanies);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Company company = null;
        try {
            company = companyDAO.getById(Input.getAllowedIntInput("Enter ID of company", allCompanyIds));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        developer.withCompany(company);

        try {
            System.out.println("Created new developer:");
            System.out.println(developer);
            developerDAO.save(developer);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createProject(int lastId, ProjectDAO projectDAO, CustomerDAO customerDAO, DeveloperDAO developerDAO) {

        int id = lastId + 1;
        String name = Input.getStringInputLimitNotNull(50, "Enter name");
        String description = Input.getStringInputLimitNotNull(100, "Enter description");
        BigDecimal cost = Input.getBigDecimalPositive("Enter cost");

        Customer customer = null;
        try {
            List<Customer> allCustomers = customerDAO.getAll();
            Show.listAll(allCustomers);
            List<Integer> allCustomerIds = Show.getIds(allCustomers);
            customer = customerDAO.getById(Input.getAllowedIntInput("Enter ID of a customer", allCustomerIds));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Integer> allDeveloperIds = null;
        try {
            List<Developer> developers = developerDAO.getAll();
            Show.listAll(developers);
            allDeveloperIds = Show.getIds(developers);
            allDeveloperIds.add(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Integer> developerIds = Input.getAllowedIntegerList("Enter IDs of developers", allDeveloperIds);
        if (!(developerIds.size() == 1 && developerIds.get(0) == 0)) {
            if (developerIds.contains(0)) developerIds.remove(new Integer(0));
        }
        else developerIds.clear();

        Project project = new Project(id, name, description, cost, customer, developerIds);

        try {
            System.out.println("Created new project:");
            System.out.println(project);
            projectDAO.save(project);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createSkill(int lastId, SkillDAO skillDAO) {
        int id = lastId + 1;
        String description = Input.getStringInputLimitNotNull(100, "Enter description");

        Skill skill = new Skill(id, description);

        try {
            System.out.println("Created new skill:");
            System.out.println(skill);
            skillDAO.save(skill);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createCompany(int lastId, CompanyDAO companyDAO) {
        int id = lastId + 1;
        String name = Input.getStringInputLimitNotNull(50, "Enter name");
        String description = Input.getStringInputLimitNotNull(100, "Enter description");
        String country = Input.getStringInputLimitNotNull(20, "Enter country");
        Company company = new Company(id, name, description, country, null);

        try {
            System.out.println("Created new company:");
            System.out.println(company);
            companyDAO.save(company);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createCustomer(int lastId, CustomerDAO customerDAO) {
        int id = lastId + 1;
        String firstName = Input.getStringInputLimitNotNull(50, "Enter first name");
        String lastName = Input.getStringInputLimitNotNull(50, "Enter last name");
        String info = Input.getStringInputLimitNotNull(100, "Enter info");

        Customer customer = new Customer(id, firstName, lastName, info, new ArrayList<Integer>());

        try {
            System.out.println("Created new customer:");
            System.out.println(customer);
            customerDAO.save(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
