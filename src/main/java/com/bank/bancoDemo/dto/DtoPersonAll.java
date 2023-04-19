package com.bank.bancoDemo.dto;

import com.bank.bancoDemo.utils.GenderPerson;
import com.bank.bancoDemo.utils.StatusPerson;
import lombok.Data;

import java.io.Serializable;

@Data
public class DtoPersonAll implements Serializable {

    private long idPersonaIdentify;
    private String name;
    private String lastName;
    private String password;
    private int age;
    private String address;
    private int numberT;
    private GenderPerson genderPerson;
    private StatusPerson statusPerson;

}
