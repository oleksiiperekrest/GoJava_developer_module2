package model;

import java.math.BigDecimal;
import java.util.List;

public class Developer {
private int id;
private String firstName;
private String lastName;
private BigDecimal salary;
private List<Skill> skills;
private List<Project> projects;
private Company company;

    public Developer(int id, String firstName, String lastName, BigDecimal salary, List<Skill> skills, List<Project> projects, Company company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.skills = skills;
        this.projects = projects;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                ", projects=" + projects +
                ", company=" + company +
                '}';
    }
}
