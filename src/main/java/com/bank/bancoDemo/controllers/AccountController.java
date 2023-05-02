package com.bank.bancoDemo.controllers;

import com.bank.bancoDemo.dto.DtoAccounts;
import com.bank.bancoDemo.dto.DtoAccountsAll;
import com.bank.bancoDemo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

        //agregar uno nuevo
    @PostMapping("/accountCreated")
    public ResponseEntity<Void> createAccounts(@RequestBody DtoAccountsAll dtoAccountsAll){
        accountService.saveAccount(dtoAccountsAll);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<DtoAccountsAll>> showAllAccounts(){
        List<DtoAccountsAll> dtoAccountsAll = accountService.findAllAccounts();
        return ResponseEntity.ok(dtoAccountsAll);
    }

    @GetMapping ("/accounts/{id}")
    public DtoAccountsAll showAccountById(@PathVariable Long id){
        return accountService.findByIdAccount(id); //REVISAR!
    }

}
