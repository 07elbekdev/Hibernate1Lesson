package org.example.repository;

import org.example.configuration.Person;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RepositoryImpl implements Repository {

    private static SessionFactory sessionFactory = Util.getSessionFactory();

    @Override
    public void save(Person person) {
        try (Session session = sessionFactory.openSession()) {
            session.save(person);
        }
    }

    @Override
    public Person getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Person.class, id);
        }
    }

    @Override
    public List findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select p from Person p").getResultList();
        }
    }

    @Override
    public void updateById(Long id, Person newPerson) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person p1 = new Person();
            p1.setName(newPerson.getName());
            p1.setAge(newPerson.getAge());
            session.saveOrUpdate(p1);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person person = getById(id);
            session.delete(person);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Person p").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public Person findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return (Person) session.createQuery("select p from Person p where p.name = ?1")
                    .setParameter(1, name).getSingleResult();
        }
    }
}