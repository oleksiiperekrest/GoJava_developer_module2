package model;

import java.math.BigDecimal;

public class Project extends Entity {
    private int id;
    private String name;
    private String description;
    private BigDecimal cost;
    private Customer customer;

    public Project(int id, String name, String description, BigDecimal cost, Customer customer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", customer=" + customer +
                '}';
    }
}
