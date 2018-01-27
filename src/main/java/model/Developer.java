package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@javax.persistence.Entity
@Table(name = "developers")
public class Developer extends Entity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private BigDecimal salary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "developers_skills",
            joinColumns = @JoinColumn(name="developer_id"),
            inverseJoinColumns = @JoinColumn(name="skill_id"))
    private List<Skill> skills;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "projects_developers",
            joinColumns = @JoinColumn(name="developer_id"),
            inverseJoinColumns = @JoinColumn(name="project_id"))
    private List<Project> projects;

    @OneToOne
    @JoinTable(name = "developers_companies",
            joinColumns = @JoinColumn(name="developer_id"),
            inverseJoinColumns = @JoinColumn(name="company_id"))
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
