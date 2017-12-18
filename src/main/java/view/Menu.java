package view;

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
        System.out.println("0: Close program");
    }

    public static void selectActionMenu(int tableChoice) {
        String table = tables[tableChoice-1];
        System.out.println("Please select an action to perform:");
        for (int i = 0; i < tablesActions.length; i++) {
            System.out.println( (i+1) + ". " + tablesActions[i] + table);
        }
        System.out.println("0. Return to previous menu");

    }
}
