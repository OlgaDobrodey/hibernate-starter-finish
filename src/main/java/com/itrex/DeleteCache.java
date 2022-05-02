package com.itrex;

import com.itrex.entity.User;
import com.itrex.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteCache {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = session.get(User.class, "ivan@gmail.com");
            User user1 = session.get(User.class, "ivan@gmail.com");

            session.evict(user1); // delete user  from cache
            session.clear(); //delete all cache
//            session.close(); // delete all cache

            session.getTransaction().commit();
        }
    }
}
