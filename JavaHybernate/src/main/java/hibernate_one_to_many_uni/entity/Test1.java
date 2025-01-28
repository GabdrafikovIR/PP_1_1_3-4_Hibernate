package hibernate_one_to_many_uni.entity;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = (SessionFactory) new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {

//            Department dep = new Department("IT", 300, 1200);
//            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
//            Employee emp2 = new Employee("Ildar", "Gabdrafikov", 1000);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            session.beginTransaction();
//            session.save(dep);
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//             factory.close();
//
//************************************************************************
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 3);
//            System.out.println(emp.toString());
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//            factory.close();
//        }
//*************************************************************************
            session.beginTransaction();
            Department department = session.get(Department.class, 2);
            session.delete(department);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }
}
