package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.service.impl.PersonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/app/v1/person")
public class PersonController {
    /*@Autowired
    private final IPersonService person;

    public PersonController(IPersonService person) {
        super();
        this.person = person;
    }*/

    @Autowired
    private PersonImpl personImp;


    @RequestMapping(value = "/api/person", method = RequestMethod.GET)
    public List<Person> findAll() {
        try{
            List<Person> test = personImp.findAll();
            test.forEach(System.out::println);
            return test;
        } catch (Exception e){
            return (List<Person>) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/api/person/{id}", method = RequestMethod.GET)
    public Person findPersonById(@PathVariable Integer id_person) {
        try{
            return personImp.findPersonByID(id_person);
        } catch (Exception e){
            return new Person(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/person", method = RequestMethod.POST)
    public ResponseEntity<Object> savePerson(@RequestBody Person person) {
        try {
            Person personSaved = personImp.savePerson(person);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(personSaved.getId_person()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/person", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePerson(@RequestBody Person person, @PathVariable Person person1) {
        try {
            personImp.updatePerson(person1);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "api/person/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePerson(@PathVariable Integer id_person) {
        try {
            personImp.deletePersonById(id_person);
            return ResponseEntity.status(HttpStatus.OK).build();
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
