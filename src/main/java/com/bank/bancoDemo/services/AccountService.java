package com.bank.bancoDemo.services;

import com.bank.bancoDemo.dto.DtoAccountsAll;
import com.bank.bancoDemo.models.dao.ImpleAccountDao;
import com.bank.bancoDemo.models.dao.ImplePersonDao;
import com.bank.bancoDemo.models.entity.Account;
import com.bank.bancoDemo.models.entity.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AccountService {

    @Autowired
    private ImpleAccountDao impleAccountDao;


    @Autowired
    private ImplePersonDao implePersonaDao;
    @Autowired
    private ModelMapper modelMapper;


    public List<DtoAccountsAll> findAllAccounts(){
        List<Account> account = impleAccountDao.findAll();
        List<DtoAccountsAll> dtoAccountsAlls = account.stream()
                .map(cuentas -> modelMapper.map(cuentas, DtoAccountsAll.class))
                .collect(Collectors.toList());
        return dtoAccountsAlls;
    }


    public DtoAccountsAll findByIdAccount(Long id){
        Optional<Account> account = impleAccountDao.findById(id);
        if(account.isEmpty()){
            throw new RuntimeException("cuenta no existe");
        }
        DtoAccountsAll dtoAccountsAll= modelMapper.map(account.get(), DtoAccountsAll.class);
        return dtoAccountsAll;
    }

    public void saveAccount (DtoAccountsAll dtoAccountsAll){
        Account account= modelMapper.map(dtoAccountsAll, Account.class);
        Person person = implePersonaDao.findById(dtoAccountsAll.getPersonId())
                    .orElseThrow(() -> new EntityNotFoundException("Persona no encontrada"));
        account.setPersonId(person);
        impleAccountDao.save(account);
    }

    public void updateAccount(DtoAccountsAll dtoAccountsAll){
        Account account= modelMapper.map(dtoAccountsAll, Account.class);
        Optional<Account> accountUpdate = impleAccountDao.findById(dtoAccountsAll.getAccountId());
        if(accountUpdate.isEmpty()) {
            throw new RuntimeException();
        }
        impleAccountDao.save(account);
    }

    public void deleteAccount(Long id){
        Optional<Account> accountDelete = impleAccountDao.findById(id);
        if(accountDelete.isEmpty()) {
            throw new RuntimeException();
        }
        impleAccountDao.delete(accountDelete.get());
    }
}
