package com.bank.bancoDemo.dto;

import com.bank.bancoDemo.utils.GenderPerson;
import lombok.Data;

import javax.persistence.*;
@Data
public class DtoPersonAll {

    private long idPersonaIdentify;

    private String name;

    private String lastName;


    private GenderPerson genderPerson;

    private int age;


    private String address;

    private int numberT;
}
