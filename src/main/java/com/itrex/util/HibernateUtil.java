package com.itrex.util;

import com.itrex.converter.BirthdayConverter;
import com.itrex.entity.User;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {

    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.addAnnotatedClass(User.class);
        configuration.addAttributeConverter(new BirthdayConverter());
        configuration.registerTypeOverride(new JsonBinaryType());
        //        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy()); -change
//        configuration.addAnnotatedClass(User.class);
//        configuration.configure("path/to/cfg.xml");
        configuration.configure();

        return configuration.buildSessionFactory();
    }
}
