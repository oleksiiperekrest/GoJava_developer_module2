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

    public Developer() {
    }

    public Developer(int id, String firstName, String lastName, BigDecimal salary, List<Skill> skills, List<Project> projects, Company company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.skills = skills;
        this.projects = projects;
        this.company = company;
    }

    public Developer withId(int id) {
        this.id = id;
        return this;
    }

    public Developer withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Developer withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Developer withSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public Developer withSkills(List<Skill> skills) {
        this.skills = skills;
        return this;
    }

    public Developer withProjects(List<Project> projects) {
        this.projects = projects;
        return this;
    }

    public Developer withCompany(Company company) {
        this.company = company;
        return this;
    }




    @Override
    public String toString() {
        return "Developer{" +
                "\nid=" + id +
                "\nfirstName='" + firstName + '\'' +
                "\nlastName='" + lastName + '\'' +
                "\nsalary=" + salary +
                "\nskills=" + skills +
                "\nprojects=" + projects +
                "\ncompany=" + company +
                "\n}";
    }
}
