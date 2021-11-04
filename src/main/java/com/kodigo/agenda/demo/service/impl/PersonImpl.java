package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IPersonRepository;
import com.kodigo.agenda.demo.service.IPersonService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonImpl implements IPersonService {
    private final IPersonRepository personRepository;
    public PersonImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
       return personRepository.findAll();
    }

    @Override
    public Person findPersonByID(Integer id_person) {
        Person personTmp = personRepository.getById(id_person);
        return personTmp;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        Person personTmp = personRepository.getById(person.getId_person());
        return personRepository.save(personTmp);
    }

    @Override
    public void deletePersonById(Integer id_person) {
        Person personTmp = personRepository.getById(id_person);
        personRepository.delete(personTmp);
    }


}
