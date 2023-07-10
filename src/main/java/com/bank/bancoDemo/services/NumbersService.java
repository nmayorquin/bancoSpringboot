package com.bank.bancoDemo.services;


import com.bank.bancoDemo.exceptions.NotFoundException;
import com.bank.bancoDemo.exceptions.NotSaveException;
import com.bank.bancoDemo.models.entity.Numbers;
import com.bank.bancoDemo.repository.NumbersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NumbersService {


    @Autowired
    NumbersRepository numbersRepo;


    //INSERT ELEMENTS
    public Numbers saveNumber(Numbers number) {
        Optional<Numbers> numberExist;
        numberExist = numbersRepo.findByNumber(number.getNumber());
        if(numberExist.isPresent()) {
            throw new NotSaveException("no se puede guardar un número con el mismo nombre");
        }
        return numbersRepo.save(number);
    }

    //SHOW ALL LIST
    public List<Numbers> obtainNumbers(){
        return numbersRepo.findAll();
    }

    //FIND NUMBER BY ID
    public Numbers getNumberById(int id) {
        Optional<Numbers> numberExist = numbersRepo.findById(id);
        if(!numberExist.isPresent()) {
            throw new NotFoundException("no existe");
        }
        return numberExist.get();
    }

}
