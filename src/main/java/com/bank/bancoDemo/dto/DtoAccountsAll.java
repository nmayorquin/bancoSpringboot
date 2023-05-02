package com.bank.bancoDemo.dto;

import com.bank.bancoDemo.utils.AccountStatus;
import com.bank.bancoDemo.utils.AccountType;
import lombok.Data;

import java.io.Serializable;

@Data
public class DtoAccountsAll implements Serializable {

    private Long accountId;

    private String accountNumber;

    private AccountType accountType;

    private long accountBalance;

    private AccountStatus accountStatus;

    private long personId;
}
