package org.example.configuration;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "someone")
@Data
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String name;

    private int age;

    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Person() {

    }
}