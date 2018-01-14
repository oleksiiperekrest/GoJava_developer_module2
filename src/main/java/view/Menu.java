package view;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * Prints out edit menu for specified entity, like:
     * "    1. FirstClassField
     *      2. SecondClassField
     *      ...
     *      5. Show current %className
     *      6. Save current %className
     *      0. Return to previous menu."
     * @param clazz class of entity. Meant to be heir of model.Entity
     *
     * @return i index of Save menu item, returned for filtering user choice of menu options
     * Only integers between 0 and i would be valid choice representing a menu item.
     */
    public static int editMenu(Class clazz) {
        System.out.println("Choose a field to edit:");
        String[] fields = classFieldsNames(clazz);
        int i = 0;
        for ( ; i < fields.length; i++) { //List all class fields paired with a counting number (up from 1)
            System.out.println(i+1 + ". " + fields[i]);
        }

        i++; //next menu entry after last class field
        System.out.println(i + ". Show current " + clazz.getName().split("model.")[1].toLowerCase());

        i++;
        System.out.println(i + ". Save current " + clazz.getName().split("model.")[1].toLowerCase());

        System.out.println("0. Return to previous menu.");
        return i;
    }

    private static String[] classFieldsNames(Class clazz) {
        Field[] superFields = clazz.getSuperclass().getDeclaredFields(); //get filed(s) of Entity
        Field[] classFields = clazz.getDeclaredFields(); //get fields of class
        List<Field> fields = new ArrayList<>();
        fields.addAll(Arrays.asList(superFields));
        fields.addAll(Arrays.asList(classFields));

        String[] stringFields = new String[fields.size()];
        for (int i = 0; i < fields.size(); i++) {
            String raw = fields.get(i).getName();
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
