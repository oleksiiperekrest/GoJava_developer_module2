package model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name = "companies")
public class Company extends Entity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "country")
    private String country;

    @ElementCollection
    @CollectionTable(name="developers_companies", joinColumns=@JoinColumn(name="company_id"))
    @Column(name="developer_id")
    private List<Integer> developerIds;

    public Company() {
    }

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
