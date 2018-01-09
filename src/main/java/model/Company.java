package model;

import java.util.List;

public class Company extends Entity {
    private int id;
    private String name;
    private String description;
    private String country;
    private List<Integer> developerIds;

    public Company(int id, String name, String description, String country, List<Integer> developerIds) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.developerIds = developerIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Integer> getDeveloperIds() {
        return developerIds;
    }

    public void setDeveloperIds(List<Integer> developerIds) {
        this.developerIds = developerIds;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", developerIds=" + developerIds +
                '}';
    }
}
