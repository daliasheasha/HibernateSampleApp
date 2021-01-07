package entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private EmployeeName name;
    @ManyToOne
    private Department department;

    public Employee() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public EmployeeName getName() {
        return name;
    }

    public void setName(EmployeeName name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
