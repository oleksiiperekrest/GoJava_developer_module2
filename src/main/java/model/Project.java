package model;

import java.math.BigDecimal;

public class Project {
    private int id;
    private String name;
    private String description;
    private BigDecimal cost;

    public Project(int id, String name, String description, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
