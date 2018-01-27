package controller;

import controller.services.Create;
import controller.services.Delete;
import controller.services.Edit;
import dao.*;
import dao.hibernate.*;
import dao.jdbc.*;
import model.*;
import utils.Input;
import view.Menu;
import view.Show;

import java.sql.SQLException;
import java.util.*;

public class Controller {
    public static void run() throws SQLException {
        Map<String,GenericDAO> DAOs = getDAOs();
        DeveloperDAO developerDAO = (DeveloperDAO) DAOs.get("Developer");
        ProjectDAO projectDAO = (ProjectDAO) DAOs.get("Project");
        SkillDAO skillDAO = (SkillDAO) DAOs.get("Skill");
        CompanyDAO companyDAO = (CompanyDAO) DAOs.get("Company");
        CustomerDAO customerDAO = (CustomerDAO) DAOs.get("Customer");

        List<Developer> developers = null;
        List<Project> projects = null;
        List<Skill> skills = null;
        List<Company> companies = null;
        List<Customer> customers = null;

        while (true) {
            Menu.selectTableMenu();
            int tableSelect = Input.getBoundIntInput("", 0, 5);
            if (tableSelect == 0) break;
            switch (tableSelect) {
                case 1:
                    developers = developerDAO.getAll();
                    break;
                case 2:
                    projects = projectDAO.getAll();
                    break;
                case 3:
                    skills = skillDAO.getAll();
                    break;
                case 4:
                    companies = companyDAO.getAll();
                    break;
                case 5:
                    customers = customerDAO.getAll();
                    break;
            }

            while (true) {
                Menu.selectActionMenu(tableSelect);
                int actionSelect = Input.getBoundIntInput("", 0, 4);
                if (actionSelect == 0) break;
                switch (actionSelect) {
                    case 1:
                        switch (tableSelect) {
                            case 1:
                                Show.listAll(developers);
                                break;
                            case 2:
                                Show.listAll(projects);
                                break;
                            case 3:
                                Show.listAll(skills);
                                break;
                            case 4:
                                Show.listAll(companies);
                                break;
                            case 5:
                                Show.listAll(customers);
                                break;
                        }
                        break;

                    case 2:
                        switch (tableSelect) {
                            case 1:
                                Create.createDeveloper(developers.get(developers.size() - 1).getId(), developerDAO, skillDAO, projectDAO, companyDAO);
                                developers = developerDAO.getAll();
                                break;
                            case 2:
                                Create.createProject(projects.get(projects.size() - 1).getId(), projectDAO, customerDAO, developerDAO);
                                projects = projectDAO.getAll();
                                break;
                            case 3:
                                Create.createSkill(skills.get(skills.size() - 1).getId(), skillDAO);
                                skills = skillDAO.getAll();
                                break;
                            case 4:
                                Create.createCompany(companies.get(companies.size() - 1).getId(), companyDAO);
                                companies = companyDAO.getAll();
                                break;
                            case 5:
                                Create.createCustomer(customers.get(customers.size() - 1).getId(), customerDAO);
                                customers = customerDAO.getAll();
                                break;
                        }
                        break;

                    case 3:
                        switch (tableSelect) {
                            case 1:
                                Developer developer = developerDAO.getById(Input.getIntInput("Enter ID of developer"));
                                while (developer == null) {
                                    developer = developerDAO.getById(Input.getIntInput("ID not found, please re-enter!"));
                                }
                                Edit.editDeveloper(developer, developerDAO, skillDAO, projectDAO, companyDAO);
                                developers = developerDAO.getAll();
                                break;
                            case 2:
                                Project project = projectDAO.getById(Input.getIntInput("Enter ID of project"));
                                while (project == null) {
                                    project = projectDAO.getById(Input.getIntInput("ID not found, please re-enter!"));
                                }
                                Edit.editProject(project, projectDAO, customerDAO, developerDAO);
                                projects = projectDAO.getAll();
                                break;
                            case 3:
                                Skill skill = skillDAO.getById(Input.getIntInput("Enter ID of project"));
                                while (skill == null) {
                                    skill = skillDAO.getById(Input.getIntInput("ID not found, please re-enter!"));
                                }
                                Edit.editSkill(skill, skillDAO);
                                skills = skillDAO.getAll();
                                break;
                            case 4:
                                Company company = companyDAO.getById(Input.getIntInput("Enter ID of company"));
                                while (company == null) {
                                    company = companyDAO.getById(Input.getIntInput("ID not found, please re-enter!"));
                                }
                                Edit.editCompany(company, companyDAO);
                                companies = companyDAO.getAll();
                                break;
                            case 5:
                                Customer customer = customerDAO.getById(Input.getIntInput("Enter ID of customer"));
                                while (customer == null) {
                                    customer = customerDAO.getById(Input.getIntInput("ID not found, please re-enter!"));
                                }
                                Edit.editCustomer(customer, customerDAO, projectDAO);
                                customers = customerDAO.getAll();
                                break;
                        }
                        break;

                    case 4:
                        switch (tableSelect) {
                            case 1:
                                Developer developer = developerDAO.getById(Input.getIntInput("Enter ID of developer"));
                                while (developer == null) {
                                    developer = developerDAO.getById(Input.getIntInput("ID not found, please re-enter!"));
                                }
                                Delete.deleteDeveloper(developer, developerDAO);
                                developers = developerDAO.getAll();
                                break;
                            case 2:
                                Project project = projectDAO.getById(Input.getIntInput("Enter ID of project"));
                                while (project == null) {
                                    project = projectDAO.getById(Input.getIntInput("ID not found, please re-enter!"));
                                }
                                Delete.deleteProject(project, projectDAO);
                                projects = projectDAO.getAll();
                                break;
                            case 3:
                                Skill skill = skillDAO.getById(Input.getIntInput("Enter ID of project"));
                                while (skill == null) {
                                    skill = skillDAO.getById(Input.getIntInput("ID not found, please re-enter!"));
                                }
                                Delete.deleteSkill(skill, skillDAO);
                                skills = skillDAO.getAll();
                                break;
                            case 4:
                                Company company = companyDAO.getById(Input.getIntInput("Enter ID of company"));
                                while (company == null) {
                                    company = companyDAO.getById(Input.getIntInput("ID not found, please re-enter!"));
                                }
                                Delete.deleteCompany(company, companyDAO);
                                companies = companyDAO.getAll();
                                break;
                            case 5:
                                Customer customer = customerDAO.getById(Input.getIntInput("Enter ID of customer"));
                                while (customer == null) {
                                    customer = customerDAO.getById(Input.getIntInput("ID not found, please re-enter!"));
                                }
                                Delete.deleteCustomer(customer, customerDAO);
                                customers = customerDAO.getAll();
                                break;
                        }
                        break;
                }
            }
        }
    }

    private static Map<String, GenericDAO> getDAOs() {
        Map<String,GenericDAO> DAOs = new HashMap<>();
        int menuCount = Menu.selectDAOMenu();
        int userDAOChoice = Input.getBoundIntInput("Choose DAO method to use:", 1, menuCount);
        switch (userDAOChoice) {
            case 1: //JDBC
                DAOs.put("Company", new JdbcCompanyDAOImpl());
                DAOs.put("Customer", new JdbcCustomerDAOImpl());
                DAOs.put("Developer", new JdbcDeveloperDAOImpl());
                DAOs.put("Project", new JdbcProjectDAOImpl());
                DAOs.put("Skill", new JdbcSkillDAOImpl());
                break;
            case 2: //Hibernate
                DAOs.put("Company", new HibernateCompanyDAOImpl());
                DAOs.put("Customer", new HibernateCustomerDAOImpl());
                DAOs.put("Developer", new HibernateDeveloperDAOImpl());
                DAOs.put("Project", new HibernateProjectDAOImpl());
                DAOs.put("Skill", new HibernateSkillDAOImpl());
                break;
        }

        return DAOs;
    }
}

