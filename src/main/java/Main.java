import entity.Department;
import entity.Employee;
import entity.EmployeeName;
import org.hibernate.SQLQuery;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // Delete data from previous runs
        entityManager.createQuery("DELETE FROM entity.Employee").executeUpdate();
        entityManager.createQuery("DELETE FROM entity.Department").executeUpdate();

        // Create and persist my javaAdvocacyDept
        Department javaAdvocacyDept = new Department();
        javaAdvocacyDept.setName("Java Advocacy");
        javaAdvocacyDept.setId(1L);
        entityManager.persist(javaAdvocacyDept);

        // Create and persist my javaAdvocacyDept
        Department kotlinAdvocacyDept = new Department();
        kotlinAdvocacyDept.setName("Kotlin Advocacy");
        kotlinAdvocacyDept.setId(2L);
        entityManager.persist(kotlinAdvocacyDept);

        // Create and persist Hadi Employee
        EmployeeName hadiName = new EmployeeName();
        hadiName.setFirstName("Hadi");
        hadiName.setLastName("Hariri");
        Employee hadi = new Employee();
        hadi.setId(1L);
        hadi.setName(hadiName);
        hadi.setDepartment(kotlinAdvocacyDept);
        entityManager.persist(hadi);

        // Create and persist Trisha Employee
        EmployeeName trishaName = new EmployeeName();
        trishaName.setFirstName("Trisha");
        trishaName.setLastName("Gee");
        Employee trisha = new Employee();
        trisha.setId(2L);
        trisha.setName(trishaName);
        trisha.setDepartment(javaAdvocacyDept);
        entityManager.persist(trisha);

        // Create and persist Mala Employee
        EmployeeName malaName = new EmployeeName();
        malaName.setFirstName("Mala");
        malaName.setLastName("Gupta");
        Employee mala = new Employee();
        mala.setId(3L);
        mala.setName(malaName);
        mala.setDepartment(javaAdvocacyDept);
        entityManager.persist(mala);

        // Create and persist Helen Employee
        EmployeeName helenName = new EmployeeName();
        helenName.setFirstName("Helen");
        helenName.setLastName("Scott");
        Employee helen = new Employee();
        helen.setId(4L);
        helen.setName(helenName);
        helen.setDepartment(javaAdvocacyDept);
        entityManager.persist(helen);

        // Create and persist Svet Employee
        EmployeeName svetName = new EmployeeName();
        svetName.setFirstName("Svetlana");
        svetName.setLastName("Isakova");
        Employee svet = new Employee();
        svet.setId(5L);
        svet.setName(svetName);
        svet.setDepartment(kotlinAdvocacyDept);
        entityManager.persist(svet);

          // Create and persist Dalia Employee
//        EmployeeName daliaName = new EmployeeName();
//        daliaName.setFirstName("Dalia");
//        daliaName.setLastName("Abo Sheasha");
//        Employee dalia = new Employee();
//        dalia.setId(5L);
//        dalia.setName(daliaName);
//        dalia.setDepartment(javaAdvocacyDept);
//        entityManager.persist(dalia);

        entityManager.getTransaction().commit();

        // Print all the employees that were persisted to the database
        entityManager.getTransaction().begin();
        TypedQuery<Employee> query =
                entityManager.createQuery("SELECT e FROM entity.Employee e", Employee.class);
        List<Employee> employees = query.getResultList();
        for (Employee employee :
                employees) {
            System.out.println(employee);
        }
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
