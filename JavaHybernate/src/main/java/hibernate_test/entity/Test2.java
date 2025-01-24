package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = (SessionFactory) new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Elena", "Petrova", "Sales", 450000);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            Long myId = emp.getId();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp2 = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(emp2);
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
