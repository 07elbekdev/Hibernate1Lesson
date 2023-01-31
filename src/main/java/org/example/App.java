package org.example;

import org.example.configuration.Person;
import org.example.repository.RepositoryImpl;

public class App {
    public static void main(String[] args) {
        Person person = new Person(1, "data", 15);
        Person person1 = new Person(2, "Dastan", 16);
        Person person2 = new Person(3, "Daniel", 156);
        Person person3 = new Person(4, "Marlen", 155);
        Person p = new Person(9, "Biannual", 12);

        RepositoryImpl repository = new RepositoryImpl();
        System.out.println(repository.findByName("Daniel"));
    }
}