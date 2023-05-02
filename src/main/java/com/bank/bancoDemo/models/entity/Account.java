package com.bank.bancoDemo.models.entity;

import com.bank.bancoDemo.utils.AccountStatus;
import com.bank.bancoDemo.utils.AccountType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @Column(name = "account_Id")
    private Long accountId;
    @Column(name = "account_number")
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "account_Balance")
    private long accountBalance;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @JoinColumn(name = "fk_people")
    @ManyToOne
    private Person personId;

}
