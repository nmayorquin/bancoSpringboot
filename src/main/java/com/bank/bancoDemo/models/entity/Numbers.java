package com.bank.bancoDemo.models.entity;


import lombok.*;

import javax.persistence.*;



@Data
@Entity
@Table(name="numeros")
public class Numbers {

    @Id
    @Column(name = "number_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numberId;

    @Column(name = "number")
    private int number;
}