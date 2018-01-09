package model;

public class Skill extends Entity {
    private int id;
    private String description;

    public Skill(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
