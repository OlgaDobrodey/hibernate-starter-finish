package com.itrex.entity;

import com.itrex.entity.mappingOneToMany.UserOneToMany;
import com.itrex.util.HibernateUtil;
import org.junit.jupiter.api.Test;

class ChatTest {

    @Test
    void checkManyToMany() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            var user = session.get(UserOneToMany.class, 1L);
            user.getUserChats().clear();

//            var chat = Chat.builder()
//                    .name("dmdev")
//                    .build();
//            user.addChat(chat);
//
//            session.save(chat);

            session.getTransaction().commit();
        }
    }

}