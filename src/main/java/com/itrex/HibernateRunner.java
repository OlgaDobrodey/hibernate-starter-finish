package com.itrex;

import com.itrex.converter.BirthdayConverter;
import com.itrex.entity.Birthday;
import com.itrex.entity.Role;
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
        configuration.addAttributeConverter(new BirthdayConverter());
//        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy()); -change
//        configuration.addAnnotatedClass(User.class);
//        configuration.configure("path/to/cfg.xml");
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = User.builder()
                    .username("ivan2@gmail.com")
                    .firstname("Ivan")
                    .lastname("Ivanov")
                    .birthDate(new Birthday(LocalDate.of(2000, 1, 19)))
                    .role(Role.ADMIN)
                    .build();
            session.save(user);

            session.getTransaction().commit();
        }

    }
}
