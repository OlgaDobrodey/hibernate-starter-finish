package com.itrex;

import com.itrex.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {

    public static void main(String[] args) {
//        DriverManager
//                .getConnection(
//                        "db.url",
//                        "db.username",
//                        "db.password"
//                );

        Configuration configuration = new Configuration();
        configuration.configure();
//        configuration.configure("path/to/cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = User.builder()
                    .username("ivan1@gmail.com")
                    .firstname("Ivan")
                    .lastname("Ivanov")
                    .birthDate(LocalDate.of(2000, 1, 19))
                    .age(20)
                    .build();
            session.save(user);

            session.getTransaction().commit();
        }

    }
}
