package com.bank.bancoDemo.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//la clase dto no debe tener operaciones de negocio o metodos
// con transacciones y se implementa serializable: convertir objetos en bytes
//revisar imp´lementacion dentro de service creando un objeto dtoPerson que reciba los datos de personService
@Data
public class DtoPerson implements Serializable {

  //que atributos quiero devolver al ususario?
    private long idPersonaIdentify;

    private String name;

    private String lastName;

    private int numberT;

}
