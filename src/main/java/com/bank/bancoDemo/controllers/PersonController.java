package com.bank.bancoDemo.controllers;

import com.bank.bancoDemo.dto.DtoPerson;
import com.bank.bancoDemo.dto.DtoPersonAll;
import com.bank.bancoDemo.models.entity.Person;
import com.bank.bancoDemo.services.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class PersonController {

        @Autowired
        PersonService personService;

        @Autowired
        private ModelMapper modelMapper;

        @PostMapping("/created")
        public ResponseEntity<Void> createPerson(@RequestBody DtoPersonAll dtoPersonAll){
                personService.save(dtoPersonAll);
                return ResponseEntity.status(201).build(); //patrón builder
        }

        @GetMapping("/people")
        public ResponseEntity<List<DtoPersonAll>> showAllPerson(){
                List<DtoPersonAll> dtoPersonAll = personService.findAll();
                return ResponseEntity.ok(dtoPersonAll);
        }

        @GetMapping("/people/{id}")
        public DtoPerson showById(@PathVariable long id){
                return personService.findById(id);
        }

        @PutMapping("/people/{id}")
        public ResponseEntity<Void> updatePerson(@PathVariable long id, @RequestBody DtoPersonAll dtoPersonAll){
                personService.update(dtoPersonAll);
                return ResponseEntity.ok().build();
        }


        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deletePerson(@PathVariable long id){
                personService.delete(id);
                return ResponseEntity.ok().build();

        }

}
