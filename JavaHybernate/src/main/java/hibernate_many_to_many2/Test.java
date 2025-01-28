package hibernate_many_to_many2;

import hibernate_many_to_many2.entity.Children;
import hibernate_many_to_many2.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Children.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
//            Section section1 = new Section("Dance");
//            Children child1 = new Children("Olya", 12);
//            Children child2 = new Children("Grisha", 8);
//            Children child3 = new Children("Pavlik", 9);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//            session.beginTransaction();
//            session.persist(section1);
//            session.getTransaction().commit();
//            System.out.println("Done!");
//
//        } finally {
//            sessionFactory.close();
//        }
//***************************************************************************
//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Computer Science");
//            Children child1 = new Children("Igor", 10);
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//            session.beginTransaction();
//            session.save(child1);
//            session.getTransaction().commit();
//            System.out.println("Done!");
//
//        } finally {
//            sessionFactory.close();
//        }
//*****************************************************************************************
//            session.beginTransaction();
//            Section section = session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChilds());
//            session.getTransaction().commit();
//            System.out.println("Done!");
//
//        } finally {
//            sessionFactory.close();
//        }
            //******************************************************************
//            session.beginTransaction();
//            Children children = session.get(Children.class, 4);
//            System.out.println(children);
//            System.out.println(children.getSections());
//            session.getTransaction().commit();
//            System.out.println("Done!");
//
//        } finally {
//            sessionFactory.close();
//        }
//******************************************************************************************
//            session.beginTransaction();
//            Section section = session.get(Section.class, 7);
//            session.delete(section);
//                session.getTransaction().commit();
//            System.out.println("Done!");
//
//        } finally {
//            sessionFactory.close();
//        }

            session.beginTransaction();
            Children children = session.get(Children.class, 5);
            session.delete(children);
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
