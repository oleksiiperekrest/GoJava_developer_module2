package view;

import model.Entity;

import java.util.ArrayList;
import java.util.List;

public class Show {
    public static void listAll(List<?> ts) {
        for (Object t : ts) {
            System.out.println(t + "\n");
        }
    }

    public static List<Integer> getIds(List<? extends Entity> ts) {
        List<Integer> ids = new ArrayList<>();
        for (Entity entity : ts) {
            ids.add(entity.getId());
        }
        return ids;
    }
}
