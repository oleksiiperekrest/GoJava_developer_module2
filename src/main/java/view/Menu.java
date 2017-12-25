package view;

import java.lang.reflect.Field;

public class Menu
{
        private static String[] tables = {"Developer", "Project", "Skill", "Company", "Customer"};
        private static String[] tablesActions = {"List all items of table ", "Create new ", "Edit existing ",
                "Delete existing "};

    public static void selectTableMenu() {
        System.out.println("Please select a table:");
        for (int i = 0; i < tables.length; i++) {
            System.out.println( (i+1) + ". " + tables[i]);
        }
        System.out.println("0. Close program");
    }

    public static void selectActionMenu(int tableChoice) {
        String table = tables[tableChoice-1];
        System.out.println("Please select an action to perform:");
        for (int i = 0; i < tablesActions.length; i++) {
            System.out.println( (i+1) + ". " + tablesActions[i] + table);
        }
        System.out.println("0. Return to previous menu");
    }

    public static int editMenu(Class clazz) {
        System.out.println("Choose a field to edit:");
        String[] fields = classFieldsNames(clazz);
        int i = 0;
        for ( ; i < fields.length; i++) {
            System.out.println(i+1 + ". " + fields[i]);
        }
        System.out.println((i+1) + ". Show current " + clazz.getName().split("model.")[1].toLowerCase());
        System.out.println((i+2) + ". Save current " + clazz.getName().split("model.")[1].toLowerCase());
        System.out.println("0. Return to previous menu.");
        return i+2;
    }

    public static String[] classFieldsNames(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
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
