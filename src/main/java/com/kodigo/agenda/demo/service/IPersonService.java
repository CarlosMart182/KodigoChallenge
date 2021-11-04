package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Person;

import java.util.List;

public interface IPersonService {

    List<Person> findAll();

    Person findPersonByID(Integer id_person);
    Person savePerson(Person person);
    Person updatePerson(Person person);
    void deletePersonById(Integer id_person);
}
