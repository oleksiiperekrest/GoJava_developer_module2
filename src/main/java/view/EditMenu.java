package view;
import java.lang.reflect.Field;

public class EditMenu {
    public static void developerEditMenu(Class aClass) {
        System.out.println("Choose a field to edit:");
        String[] fields = classFieldsNames(aClass);
        for (int i = 0; i < fields.length; i++) {
            System.out.println(i+1 + ". " + fields[i]);
        }

    }

    private static String[] classFieldsNames(Class aClass) {
        Field[] fields = aClass.getDeclaredFields();
        String[] stringFields = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            String raw = fields[i].getName();
            String[] camelCaseWords = raw.split("(?=[A-Z])");
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : camelCaseWords) {
                stringBuilder.append(s.toLowerCase()).append(" ");
            }
            String name = stringBuilder.toString().trim();
            stringFields[i] = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        }
        return stringFields;
    }
}
