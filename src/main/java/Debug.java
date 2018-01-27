import dao.DeveloperDAO;
import dao.hibernate.HibernateDeveloperDAOImpl;
import dao.jdbc.JdbcDeveloperDAOImpl;
import model.Developer;
import model.Entity;
import view.Show;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

public class Debug {
    public static void main(String[] args) throws SQLException {
        DeveloperDAO hibernateDeveloperDAO = new HibernateDeveloperDAOImpl();

        hibernateDeveloperDAO.deleteById(12);
        List<Developer> developerList = hibernateDeveloperDAO.getAll();
        Show.listAll(developerList);
    }
}
