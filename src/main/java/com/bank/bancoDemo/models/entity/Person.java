package com.bank.bancoDemo.models.entity;

import com.bank.bancoDemo.utils.GenderPerson;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "people")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPersonaIdentify;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private GenderPerson genderPerson;

    @Column(name = "age")
    private int age;

    @Column(name = "adress")
    private String adress;

    @Column(name = "telephone")
    private int numberT;

}


