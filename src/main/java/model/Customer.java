package model;

import java.util.List;

public class Customer extends Entity {
    private String firstName;
    private String lastName;
    private String info;
    private List<Integer> projectIds;

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
