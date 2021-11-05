package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.utility.RegisterExistException;

import java.util.List;

public interface IPersonService {

    List<Person> findAll() throws Exception;

    Person create(Person person) throws Exception, RegisterExistException;

    void update(Person person, int id) throws Exception, RegisterExistException;

    void delete(int id) throws Exception, RegisterExistException;

    Person get(int id) throws Exception, RegisterExistException;

}
