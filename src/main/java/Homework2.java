import controller.Create;
import controller.Delete;
import controller.Edit;
import controller.Input;
import dao.*;
import dao.jdbc.*;
import model.*;
import view.Menu;
import view.Show;

import java.sql.SQLException;
import java.util.List;


/**
 * Необходимо создать консольное приложение, которое использует БД, созданную в домашнем задании для модуля 2.1
 * и позволяет выполнять CRUD (CREATE, READ, UPDATE, DELETE) операции для таблиц:
 * developers
 * skills
 * companies
 * customers
 * projects
 * <p>
 * Пример:
 * Создать разработчика, добавить ему навыки.
 * Создать проект, и добавить в данный проект разработчиков.
 * <p>
 * Необходимо придерживаться паттерна MVC.
 * Необходимо обработать исключительные ситуации - выход из приложения допустим только по команде пользователя.
 * Все классы должны быть грамотно проименованы и разложены по пакетам.
 * Рекомендуется активно использовать интерфейсы, абстрактные классы, generics и шаблоны проектирования
 * (Factory method, Builder, etc.)
 * <p>
 * Технологии:
 * Java, SQL (MySQL), JDBC.
 * <p>
 * По желанию, для импорта коннектора MySQL, разрешено использовать Maven.
 * <p>
 * Результатом выполнения должен быть созданный ОТДЕЛЬНЫЙ репозиторий Github/Bitbucket с:
 * - файлами для инициализации и заполнения БД;
 * - подробным описание задачи;
 * - инструкцией по разворачиванию приложения на локальной машине.
 */

public class Homework2 {

    public static void main(String[] args) throws SQLException {
        DeveloperDAO developerDAO = new JdbcDeveloperDAOImpl();
        ProjectDAO projectDAO = new JdbcProjectDAOImpl();
        SkillDAO skillDAO = new JdbcSkillDAOImpl();
        CompanyDAO companyDAO = new JdbcCompanyDAOImpl();
        CustomerDAO customerDAO = new JdbcCustomerDAOImpl();

        List<Developer> developers = null;
        List<Project> projects = null;
        List<Skill> skills = null;
        List<Company> companies = null;
        List<Customer> customers = null;

//        Developer developer = developerDAO.getById(43);
//        developerDAO.delete(developer);
//        developer.setId(43);
//        developer.setFirstName("Marc");
//        developer.setLastName("Marvodii");
//        developerDAO.save(developer);
//
//        System.out.println(developer);

//        List<Developer> developers = developerDAO.getAll();
//        for (Developer developer : developers) {
//            System.out.println(developer + "\n");
//        }
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
                                Create.createDeveloper(developers.get(developers.size() - 1).getId());
                                developers = developerDAO.getAll();
                                break;
                            case 2:
                                Create.createProject(projects.get(projects.size() - 1).getId());
                                projects = projectDAO.getAll();
                                break;
                            case 3:
                                Create.createSkill(skills.get(skills.size() - 1).getId());
                                skills = skillDAO.getAll();
                                break;
                            case 4:
                                Create.createCompany(companies.get(companies.size() - 1).getId());
                                companies = companyDAO.getAll();
                                break;
                            case 5:
                                Create.createCustomer(customers.get(customers.size() - 1).getId());
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
                                Edit.editProject(project, projectDAO);
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
                                Edit.editCustomer(customer, customerDAO);
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


}
