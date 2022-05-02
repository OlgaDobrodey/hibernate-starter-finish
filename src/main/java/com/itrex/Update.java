package com.itrex;

import com.itrex.entity.Role;
import com.itrex.entity.User;
import com.itrex.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Update {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = session.get(User.class, "ivan@gmail.com");
            user.setRole(Role.ADMIN);
            System.out.println(session.isDirty());

            session.getTransaction().commit();
        }
    }

}
