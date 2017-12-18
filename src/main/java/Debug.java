import controller.Input;
import dao.DeveloperDAO;
import dao.jdbc.JdbcDeveloperDAOImpl;

import java.util.List;

public class Debug {
    public static void main(String[] args) {
        DeveloperDAO developerDAO = new JdbcDeveloperDAOImpl();
        developerDAO.deleteById(0);
    }
}
