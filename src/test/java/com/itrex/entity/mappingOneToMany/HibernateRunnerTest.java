package com.itrex.entity.mappingOneToMany;

import com.itrex.entity.mappingManyToOne.Company;
import com.itrex.util.HibernateUtil;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;

class HibernateRunnerTest {

    @Test
    void oneToMany() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        var company = session.get(CompanyOneToMany.class, 1);
        System.out.println(company);
        session.getTransaction().commit();
    }

    @Test
    void addUserToNewCompany(){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var company = CompanyOneToMany.builder()
                .name("Facebook")
                .build();

        UserOneToMany sveta = UserOneToMany.builder().username("Sveta").build();
        company.addUser(sveta);

        session.save(company);

        session.getTransaction().commit();
    }

    @Test
    void deleteCompany(){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var company = session.get(CompanyOneToMany.class,2);
        session.delete(company);

        session.getTransaction().commit();
    }


    @Test
    void checkLazyInitialisation() {
        CompanyOneToMany  company = null;
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

//            company = session.getReference(CompanyOneToMany .class, 1);
            company = session.get(CompanyOneToMany .class, 1);

            session.getTransaction().commit();
        }
        var users = company.getUserMappings();
        System.out.println(users.size());
    }

}