package com.bank.bancoDemo.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="customer")
public class Customer extends Person {
    @Id
    @Column(name = "id_customer")
    private long customerId;
    @Column(name = "password")
    private String password;

    private enum statusCustomer{
        TRUE, FALSE
    }

    @JoinColumn(name = "fk_person")
    @OneToOne(mappedBy = "people")
    private Person person;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

}
