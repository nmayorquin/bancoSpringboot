package com.bank.bancoDemo.models.entity;

import com.bank.bancoDemo.utils.GenderPerson;
import com.bank.bancoDemo.utils.StatusPerson;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity(name = "people")
public class Person {
    @Id
    //@Column(name = "id")
    private long idPersonaIdentify;
    //@Column(name = "name")
    private String name;
   // @Column(name = "lastname")
    private String lastName;

   // @Column(name = "password")
    private String password;

    //@Column(name = "age")
    private int age;

    //@Column(name = "address")
    private String address;

   @Column(name = "telephone")
    private int numberT;

    @Enumerated(EnumType.STRING)
    private GenderPerson genderPerson;

    @Enumerated(EnumType.STRING)
    private StatusPerson statusPerson;

    @OneToMany(mappedBy = "person")//se mapea a la tabla pople o la tabla counts
    private List<Account> accounts;

}


