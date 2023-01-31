package org.example.repository;

import org.example.configuration.Person;

import java.util.List;

public interface Repository {
    void save(Person person);

    Person getById(Long id);

    List findAll();

    void updateById(Long id, Person newPerson);

    void deleteById(Long id);

    void deleteAll();

    Person findByName(String name);
}