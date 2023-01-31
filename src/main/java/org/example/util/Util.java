package org.example.util;

import org.example.configuration.Person;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class Util {
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .setProperty(Environment.DRIVER, "org.postgresql.Driver")
                .setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres")
                .setProperty(Environment.PASS, "iamnumber1")
                .setProperty(Environment.USER, "postgres")
                .setProperty(Environment.HBM2DDL_AUTO, "validate")
                .setProperty(Environment.SHOW_SQL, "true")
                .setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
    }
        public static SessionFactory getSessionFactory () {
            return sessionFactory;
        }
    }