import entity.Department;
import entity.Employee;
import entity.EmployeeName;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // Create and persist my department
        Department department = new Department();
        department.setName("Java Advocacy");
        entityManager.persist(department);

        // Create and persist Dalia Employee
        EmployeeName daliaName = new EmployeeName();
        daliaName.setFirstName("Dalia");
        daliaName.setLastName("Abo Sheasha");
        Employee dalia = new Employee();
        dalia.setName(daliaName);
        dalia.setDepartment(department);
        entityManager.persist(dalia);

        // Create and persist Trisha Employee
        EmployeeName trishaName = new EmployeeName();
        trishaName.setFirstName("Trisha");
        trishaName.setLastName("Gee");
        Employee trisha = new Employee();
        trisha.setName(trishaName);
        trisha.setDepartment(department);
        entityManager.persist(trisha);

        // Create and persist Helen Employee
        EmployeeName helenName = new EmployeeName();
        helenName.setFirstName("Helen");
        helenName.setLastName("Scott");
        Employee helen = new Employee();
        helen.setName(helenName);
        helen.setDepartment(department);
        entityManager.persist(helen);

        // Create and persist Mala Employee
        EmployeeName malaName = new EmployeeName();
        malaName.setFirstName("Mala");
        malaName.setLastName("Gupta");
        Employee mala = new Employee();
        mala.setName(malaName);
        mala.setDepartment(department);
        entityManager.persist(mala);

        entityManager.getTransaction().commit();

        // Print all the employees that were persisted to the database
        entityManager.getTransaction().begin();
        List<Employee> employees = entityManager.createQuery("FROM Employee", Employee.class).getResultList();
        for (Employee employee :
                employees) {
            System.out.println(employee);
        }
        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}
