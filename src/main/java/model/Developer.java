package model;

import java.math.BigDecimal;
import java.util.List;

public class Developer extends Entity {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
