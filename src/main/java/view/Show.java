package view;

import java.util.List;

public class Show {
    public static void listAll(List<?> ts) {
        for (Object t : ts) {
            System.out.println(t + "\n");
        }
    }
}
