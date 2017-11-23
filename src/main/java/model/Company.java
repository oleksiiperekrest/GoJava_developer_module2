package model;

public class Company {
    private int id;
    private String name;
    private String description;
    private String country;

    public Company(int id, String name, String description, String country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
