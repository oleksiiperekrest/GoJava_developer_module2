import controller.Input;
import dao.DeveloperDAO;
import dao.ProjectDAO;
import dao.jdbc.*;
import model.*;
import view.Menu;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class Debug {
    public static void main(String[] args) throws NoSuchFieldException, SQLException {
        List<Integer> skillIds = Input.getIntegerList("Enter ID's of skills");
        for ( Integer i : skillIds
             ) {
            System.out.println(i);
        }
    }
}
