import model.Developer;
import model.Entity;

import java.lang.reflect.Field;

public class Debug {
    public static void main(String[] args) {
        Developer developer = new Developer();
        Entity entity = new Entity();
        entity.setId(1);
        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
