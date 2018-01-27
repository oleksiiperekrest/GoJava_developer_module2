package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@javax.persistence.Entity
@Table(name = "projects")
public class Project extends Entity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private BigDecimal cost;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "customers_projects",
            joinColumns = @JoinColumn(name="project_id"),
            inverseJoinColumns = @JoinColumn(name="customer_id"))
    private Customer customer;

    @ElementCollection
    @CollectionTable(name="projects_developers",
            joinColumns=@JoinColumn(name="project_id"))
    @Column(name="developer_id")
    private List<Integer> developerIds;

    public Project() {
    }

    public Project(int id, String name, String description, BigDecimal cost, Customer customer, List<Integer> developerIds) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.customer = customer;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Integer> getDeveloperIds() {
        return developerIds;
    }

    public void setDeveloperIds(List<Integer> developerIds) {
        this.developerIds = developerIds;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", customer=" + customer +
                ", developerIds=" + developerIds +
                '}';
    }
}
