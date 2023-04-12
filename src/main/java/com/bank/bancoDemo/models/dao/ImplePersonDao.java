package com.bank.bancoDemo.models.dao;

import com.bank.bancoDemo.models.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImplePersonDao extends JpaRepository <Person, Long>{

}
