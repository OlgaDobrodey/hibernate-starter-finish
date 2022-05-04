package com.itrex.entity.mappingManyToOne;

import com.itrex.entity.Birthday;
import com.itrex.entity.PersonalInfo;
import com.itrex.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {
        Company company = Company.builder()
                .name("Google")
                .build();
        UserMapping user = UserMapping.builder()
                .username("petr@gmail.com")
                .personalInfo(PersonalInfo.builder()
                        .lastname("Petrov")
                        .firstname("Petr")
                        .birthDate(new Birthday(LocalDate.of(2000, 1, 2)))
                        .build())
                .company(company)
                .build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {
                Transaction transaction = session1.beginTransaction();

                session1.saveOrUpdate(company);
                session1.saveOrUpdate(user);

                session1.getTransaction().commit();
            }
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session2 = sessionFactory.openSession();
            try (session2) {
                Transaction transaction = session2.beginTransaction();

                UserMapping userMapping = session2.get(UserMapping.class,3l);
                System.out.println(userMapping);
                session2.getTransaction().commit();
            }
        }
    }
}
