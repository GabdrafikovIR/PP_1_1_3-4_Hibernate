package hibernate_one_to_one.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = (SessionFactory) new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
//            Employee emp = new Employee("Nikolay", "Ivanov", "HR", 200000);
//            Detail detail = new Detail("NewYork", "651616562651", "Nikolaj@gmail.com");
//            emp.setEmpDetail(detail);
//            detail.setEmployee(emp);
//            session.beginTransaction();
//            session.save(detail);
//            session.getTransaction().commit();
//            System.out.println("Done!");


//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, 5);
//            System.out.println(detail.getEmployee());
//            session.getTransaction().commit();
//            System.out.println("Done!");

            session.beginTransaction();
            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);
            session.getTransaction().commit();
            System.out.println("Done!");


        }
    }
}
