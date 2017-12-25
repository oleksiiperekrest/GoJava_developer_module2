package controller;

import dao.*;
import dao.jdbc.*;
import model.*;

public class Save {
    public static void saveDeveloper(Developer developer, DeveloperDAO developerDAO) {
        developerDAO.update(developer);
    }

    public static void saveProject(Project project, ProjectDAO projectDAO) {
        projectDAO.update(project);
    }

    public static void saveSkill(Skill skill, SkillDAO skillDAO) {
        skillDAO.update(skill);
    }

    public static void saveCustomer(Customer customer, CustomerDAO customerDAO) {
        customerDAO.update(customer);
    }

    public static void saveCompany(Company company, CompanyDAO companyDAO) {
        companyDAO.update(company);
    }
}
