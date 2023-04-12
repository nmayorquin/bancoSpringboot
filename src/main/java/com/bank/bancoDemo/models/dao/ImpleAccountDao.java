package com.bank.bancoDemo.models.dao;

import com.bank.bancoDemo.models.entity.Account;
import com.bank.bancoDemo.models.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpleAccountDao extends JpaRepository<Account, Long> {

}