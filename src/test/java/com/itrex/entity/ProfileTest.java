package com.itrex.entity;

import com.itrex.entity.mappingOneToMany.UserOneToMany;
import com.itrex.util.HibernateUtil;
import org.junit.jupiter.api.Test;

class ProfileTest {

    @Test
    void checkOneToOne() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var user = session.get(UserOneToMany.class, 4L);
            System.out.println();

//println            var user = UserOneToMany.builder()
//                    .username("test2@gmail.com")
//                    .build();
//            var profile = Profile.builder()
//                    .language("ru")
//                    .street("Kolasa 18")
//                    .build();
//
//            session.save(user);
//            profile.setUser(user);
//            session.save(profile);
//
//            session.getTransaction().commit();
        }
    }
}