package hibernate_many_to_many;



import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            Section section1 = new Section("Football");
            Child child1 = new Child("Ildar", 6);
            Child child2 = new Child("Masha", 5);
            Child child3 = new Child("Ivan", 6);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);
            session.save(section1);
            session.getTransaction().commit();
            System.out.println("Done!!!");


        } finally {
            sessionFactory.close();
        }

    }

}
