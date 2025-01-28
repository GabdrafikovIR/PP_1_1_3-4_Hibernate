package hibernate_one_to_one.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = (SessionFactory) new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//            Employee emp = new Employee("Zaur","Tregulov", "IT", 500);
//            Detail detail = new Detail("Baku", "1234567890", "zaur@gmail.com");
//            emp.setEmpDetail(detail);
//
//            session.save(emp);
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            session.beginTransaction();
//            Employee emp = new Employee("Oleg","Smirnov", "Sales", 700);
//            Detail detail = new Detail("Moscow", "+1234567890", "oleg@gmail.com");
//            emp.setEmpDetail(detail);
//
//            session.save(emp);
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 10);
//            System.out.println(emp.getEmpDetail());
//            session.getTransaction().commit();
//            System.out.println("Done!");

            session.beginTransaction();
            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
