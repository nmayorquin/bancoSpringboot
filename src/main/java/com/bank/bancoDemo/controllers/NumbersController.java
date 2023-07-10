package com.bank.bancoDemo.controllers;

import com.bank.bancoDemo.models.entity.Numbers;
import com.bank.bancoDemo.services.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class NumbersController {

        @Autowired
        NumbersService numberService;

        //ADD
        @PostMapping("/add")
        public ResponseEntity<Numbers> saveNumber(@RequestBody Numbers numbers){
                Numbers saveNumber= numberService.saveNumber(numbers);
                return ResponseEntity.status(HttpStatus.CREATED).body(saveNumber);
        }

        //FIND ALL
        @GetMapping("/findAll")
        public List<Numbers> getAllNumbers(){
                return numberService.obtainNumbers();
        }

        //FIND BY ID
        @GetMapping("/findById/{id}")
        public Numbers obtainById(@PathVariable int id) {
                return numberService.getNumberById(id);
        }
}
