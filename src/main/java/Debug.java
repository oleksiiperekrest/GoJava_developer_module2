import dao.DeveloperDAO;
import dao.ProjectDAO;
import dao.jdbc.*;
import model.*;
import view.Menu;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.SQLException;

public class Debug {
    public static void main(String[] args) throws NoSuchFieldException, SQLException {
        Customer skill = new JdbcCustomerDAOImpl().getById(1);
        Menu.editMenu(skill.getClass());
    }
}
