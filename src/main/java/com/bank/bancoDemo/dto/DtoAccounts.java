package com.bank.bancoDemo.dto;

import com.bank.bancoDemo.models.entity.Person;
import com.bank.bancoDemo.utils.AccountType;
import lombok.Data;

@Data
public class DtoAccounts {
    private String accountNumber;

    private AccountType accountType;

    private Person person;
}
