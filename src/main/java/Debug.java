import controller.Create;
import controller.Edit;
import controller.Input;
import dao.*;
import dao.jdbc.*;
import model.Customer;
import model.Developer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Debug {
    public static void main(String[] args) throws SQLException {
//        DeveloperDAO developerDAO = new JdbcDeveloperDAOImpl();
//        ProjectDAO projectDAO = new JdbcProjectDAOImpl();
//        SkillDAO skillDAO = new JdbcSkillDAOImpl();
//        CompanyDAO companyDAO = new JdbcCompanyDAOImpl();
//        CustomerDAO customerDAO = new JdbcCustomerDAOImpl();
//
//        Customer customer = customerDAO.getById(1);
//        Create.createCustomer(68, projectDAO);

        List<Integer> integers = Input.getIntegerList("Enter ints");
//        List<Integer> next = Input.getAllowedIntegerList("Enter right numbers", integers);
//        System.out.println("Filtered input:");
//        System.out.println(next);
        int i = Input.getAllowedIntInput("Enter a number", integers);
        System.out.println("i = " + i);
    }
}
