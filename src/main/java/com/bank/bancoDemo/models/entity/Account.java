package com.bank.bancoDemo.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="accounts")
public class Account extends Customer {
    @Id
    @Column(name = "account_Id")
    private Long accontId;
    @Column(name = "account_number")
    private String accountNumber;

    private enum AccountType{
        SavingsAccount, checkingAccount
    }

    @Column(name = "account_Balance")
    private long accountBalance;


    private enum accountStatus{
        TRUE, FALSE
    }

    @JoinColumn(name = "fk_customer")
    @ManyToOne
    private Customer customer;


}
