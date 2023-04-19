package com.bank.bancoDemo.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//la clase dto no debe tener operaciones de negocio o metodos
// con transacciones y se implementa serializable: convertir objetos en bytes
//revisar imp´lementacion dentro de service creando un objeto dtoPerson que reciba los datos de personService

public class DtoPerson implements Serializable {

  //que atributos quiero devolver al ususario?
    private long idPersonaIdentify;

    private String name;

    private String lastName;

    private int numberT;

  public DtoPerson() {

  }

  public DtoPerson(long idPersonaIdentify, String name, String lastName, int numberT) {
    this.idPersonaIdentify = idPersonaIdentify;
    this.name = name;
    this.lastName = lastName;
    this.numberT = numberT;
  }

  public long getIdPersonaIdentify() {
    return idPersonaIdentify;
  }

  public void setIdPersonaIdentify(long idPersonaIdentify) {
    this.idPersonaIdentify = idPersonaIdentify;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getNumberT() {
    return numberT;
  }

  public void setNumberT(int numberT) {
    this.numberT = numberT;
  }
}
