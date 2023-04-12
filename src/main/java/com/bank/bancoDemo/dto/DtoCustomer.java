package com.bank.bancoDemo.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
@Data
public class DtoCustomer {

    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private String status;


}


