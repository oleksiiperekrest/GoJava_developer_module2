package model;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name = "customers")
public class Customer extends Entity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "info")
    private String info;

    @ElementCollection
    @CollectionTable(name="customers_projects", joinColumns=@JoinColumn(name="customer_id"))
    @Column(name="project_id")
    private List<Integer> projectIds;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, String info, List<Integer> projectIds) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.info = info;
        this.projectIds = projectIds;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Integer> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<Integer> projectIds) {
        this.projectIds = projectIds;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", info='" + info + '\'' +
                ", projectIds=" + projectIds +
                '}';
    }
}
