package controller;

import dao.*;
import model.*;

public class Delete {
    public static void deleteDeveloper(Developer developer, DeveloperDAO developerDAO) {
        developerDAO.delete(developer);
    }
    public static void deleteProject(Project project, ProjectDAO projectDAO) {
        projectDAO.delete(project);
    }
    public static void deleteSkill(Skill skill, SkillDAO skillDAO) {
        skillDAO.delete(skill);
    }
    public static void deleteCompany(Company company, CompanyDAO companyDAO) {
        companyDAO.delete(company);
    }
    public static void deleteCustomer(Customer customer, CustomerDAO customerDAO) {
        customerDAO.delete(customer);
    }
}
