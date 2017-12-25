package controller;

import dao.*;
import model.*;
import view.Menu;
import view.Show;

import java.sql.SQLException;
import java.util.List;

public class Edit {

    public static void editDeveloper(Developer developer, DeveloperDAO developerDAO, SkillDAO skillDAO, ProjectDAO projectDAO,
                                     CompanyDAO companyDAO) {
        System.out.println(developer);
        int menuCount = Menu.editMenu(developer.getClass());
        int choice = Input.getBoundIntInput("", 0, menuCount);
        while (choice != 0) {
            switch (choice) {
                case 1:
                    developer.setId(Input.getPositiveIntInput("Enter new ID"));
                    break;
                case 2:
                    developer.setFirstName(Input.getStringInputLimitNotNull(50, "Enter new first name"));
                    break;
                case 3:
                    developer.setLastName(Input.getStringInputLimitNotNull(50, "Enter new last name"));
                    break;
                case 4:
                    developer.setSalary(Input.getBigDecimalPositive("Enter new salary"));
                    break;
                case 5:
                    try {
                        List<Skill> skills = skillDAO.getAll();
                        Show.listAll(skills);
                        List<Integer> skillIds = Input.getIntegerList("Enter ID's of skills");
                        skills.clear();
                        for (Integer skillId : skillIds) {
                            skills.add(skillDAO.getById(skillId));
                        }
                        developer.setSkills(skills);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    break;
                case 6:
                    try {
                        List<Project> projects = projectDAO.getAll();
                        Show.listAll(projects);
                        List<Integer> projectIds = Input.getIntegerList("Enter ID's of projects");
                        projects.clear();
                        for (Integer projectId : projectIds) {
                            projects.add(projectDAO.getById(projectId));
                        }
                        developer.setProjects(projects);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        List<Company> companies = companyDAO.getAll();
                        Show.listAll(companies);
                        Company company = companyDAO.getById(Input.getPositiveIntInput("Enter company ID"));
                        while (company == null) {
                            company = companyDAO.getById(Input.getPositiveIntInput("ID not found, please re-enter!"));
                        }
                        developer.setCompany(company);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    System.out.println(developer);
                    break;
                case 9:
                    Save.saveDeveloper(developer, developerDAO);
            }
            Menu.editMenu(developer.getClass());
            choice = Input.getBoundIntInput("", 0, menuCount);
        }

    }

    public static void editProject(Project project, ProjectDAO projectDAO) {
        System.out.println(project);
        int menuCount = Menu.editMenu(project.getClass());
        int choice = Input.getBoundIntInput("", 0, menuCount);
        while (choice != 0) {
            switch (choice) {
                case 1:
                    project.setId(Input.getPositiveIntInput("Enter new ID"));
                    break;
                case 2:
                    project.setName(Input.getStringInputLimitNotNull(50, "Enter new name"));
                    break;
                case 3:
                    project.setDescription(Input.getStringInputLimitNotNull(100, "Enter new description"));
                    break;
                case 4:
                    project.setCost(Input.getBigDecimalPositive("Enter new cost"));
                    break;
                case 5:
                    System.out.println(project);
                    break;
                case 6:
                    Save.saveProject(project, projectDAO);
            }
            Menu.editMenu(project.getClass());
            choice = Input.getBoundIntInput("", 0, menuCount);
        }
    }

    public static void editSkill(Skill skill, SkillDAO skillDAO) {
        System.out.println(skill);
        int menuCount = Menu.editMenu(skill.getClass());
        int choice = Input.getBoundIntInput("", 0, menuCount);
        while (choice != 0) {
            switch (choice) {
                case 1:
                    skill.setId(Input.getPositiveIntInput("Enter new ID"));
                    break;
                case 2:
                    skill.setDescription(Input.getStringInputLimitNotNull(50, "Enter new description"));
                    break;
                case 3:
                    System.out.println(skill);
                    break;
                case 4:
                    Save.saveSkill(skill, skillDAO);
            }
            Menu.editMenu(skill.getClass());
            choice = Input.getBoundIntInput("", 0, menuCount);
        }
    }

    public static void editCompany(Company company, CompanyDAO companyDAO) {
        System.out.println(company);
        int menuCount = Menu.editMenu(company.getClass());
        int choice = Input.getBoundIntInput("", 0, menuCount);
        while (choice != 0) {
            switch (choice) {
                case 1:
                    company.setId(Input.getPositiveIntInput("Enter new ID"));
                    break;
                case 2:
                    company.setName(Input.getStringInputLimitNotNull(50, "Enter new name"));
                    break;
                case 3:
                    company.setDescription(Input.getStringInputLimitNotNull(100, "Enter new description"));
                    break;
                case 4:
                    company.setCountry(Input.getStringInputLimitNotNull(20, "Enter new country"));
                case 5:
                    System.out.println(company);
                    break;
                case 6:
                    Save.saveCompany(company, companyDAO);
            }
            Menu.editMenu(company.getClass());
            choice = Input.getBoundIntInput("", 0, menuCount);
        }

    }

    public static void editCustomer(Customer customer, CustomerDAO customerDAO) {
        System.out.println(customer);
        int menuCount = Menu.editMenu(customer.getClass());
        int choice = Input.getBoundIntInput("", 0, menuCount);
        while (choice != 0) {
            switch (choice) {
                case 1:
                    customer.setId(Input.getPositiveIntInput("Enter new ID"));
                    break;
                case 2:
                    customer.setFirstName(Input.getStringInputLimitNotNull(50, "Enter new first name"));
                    break;
                case 3:
                    customer.setLastName(Input.getStringInputLimitNotNull(50, "Enter new last name"));
                    break;
                case 4:
                    customer.setInfo(Input.getStringInputLimitNotNull(100, "Enter new info"));
                    break;
                case 5:
                    System.out.println(customer);
                    break;
                case 6:
                    Save.saveCustomer(customer, customerDAO);
            }
            Menu.editMenu(customer.getClass());
            choice = Input.getBoundIntInput("", 0, menuCount);
        }

    }
}