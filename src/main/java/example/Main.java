package example;

import org.hibernate.SessionFactory;

/**
 * Created by alex on 07.01.2018.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println("Hello");
    }
}
