package hibernate_one_to_many_bi.entity;



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

//            Department dep = new Department("Sales", 1500, 800);
//            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
//            Employee emp2 = new Employee("Ildar", "Gabdrafikov", 1000);
//            Employee emp3 = new Employee("Elena", "Smirnova", 1500);
//            dep.addEmploeeToDepartment(emp1);
//            dep.addEmploeeToDepartment(emp2);
//            dep.addEmploeeToDepartment(emp3);
//            session.beginTransaction();
//            session.save(dep);
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//            factory.close();
//        }
//*************************************************************************************
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 3);
//            System.out.println(emp.toString());
//            session.delete(emp);
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//            factory.close();
//        }
//*************************************************************************
            session.beginTransaction();
            Department department = session.get(Department.class, 5);
            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Show employees from department");
            System.out.println(department.getEmps());

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
