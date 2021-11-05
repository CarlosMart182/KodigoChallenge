package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IPersonRepository;
import com.kodigo.agenda.demo.service.IPersonService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonImpl implements IPersonService {
    private IPersonRepository repository;

    public PersonImpl(IPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> findAll() throws Exception {
        return  repository.findAll();
    }

    @Override
    public Person create(Person person) throws Exception, RegisterExistException {
        Optional<Person> personDB = repository.findById(person.getId_person());
        if (personDB.isPresent())
            throw new RegisterExistException("The id of the Person already exist in the DataBase");
        return repository.save(person);
    }

    @Override
    public void update(Person person, int id) throws Exception, RegisterExistException {
        Optional<Person> personDB = repository.findById(id);
        if (personDB.isPresent()) {
            person.setId_person(id);
            repository.save(person);
            return;
        }
        throw new RegisterExistException("The id of the Person no exist in the DataBase");
    }


    @Override
    public void delete(int id) throws Exception, RegisterExistException {
        Optional<Person> personDB = repository.findById(id);
        if (personDB.isPresent()) {
            repository.deleteById(id);
            return;
        }
        throw new RegisterExistException("The id of the Person no exist in the DataBase");
    }


    @Override
    public Person get(int id) throws Exception, RegisterExistException {
        Optional<Person> personDB = repository.findById(id);
        if (personDB.isPresent())
            return personDB.get();
        throw new RegisterExistException("The id of the Person no exist in the DataBase");
    }

}
