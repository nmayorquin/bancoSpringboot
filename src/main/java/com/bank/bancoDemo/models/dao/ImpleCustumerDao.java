package com.bank.bancoDemo.models.dao;

import com.bank.bancoDemo.models.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpleCustumerDao extends JpaRepository<Customer, Long> {
}
