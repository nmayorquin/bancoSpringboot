package com.bank.bancoDemo.repository;


import com.bank.bancoDemo.models.entity.Numbers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NumbersRepository extends JpaRepository<Numbers, Integer> {

    Optional<Numbers> findByNumber(int number);
}
