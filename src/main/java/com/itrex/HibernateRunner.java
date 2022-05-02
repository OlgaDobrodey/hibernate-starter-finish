package com.itrex;

import com.itrex.entity.Birthday;
import com.itrex.entity.Role;
import com.itrex.entity.User;
import com.itrex.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class HibernateRunner {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = User.builder()
                    .username("ivan@gmail.com")
                    .firstname("Ivan12")
                    .lastname("Ivanov")
                    .birthDate(new Birthday(LocalDate.of(2000, 1, 19)))
                    .role(Role.ADMIN)
                    .info("""
                            {"name": "Ivan",
                            "id": 25}
                            """)
                    .build();
            session.update(user);
            System.out.println(session.get(User.class, "ivan@gmail.com"));

            session.getTransaction().commit();
        }

    }
}
