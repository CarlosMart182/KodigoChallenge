package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Contact;
import com.kodigo.agenda.demo.model.ContactType;
import com.kodigo.agenda.demo.repository.IContactRepository;
import com.kodigo.agenda.demo.repository.IContactTypeRepository;
import com.kodigo.agenda.demo.service.IContactService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactImpl implements IContactService {

    private IContactRepository repository;
    private  IContactTypeRepository contactTypeRepository;

    public ContactImpl(IContactRepository repository, IContactTypeRepository contactTypeRepository) {
        this.repository = repository;
        this.contactTypeRepository = contactTypeRepository;
    }

    @Override
    public List<Contact> findAll() throws Exception {
        return (List<Contact>) repository.findAll();
    }

    @Override
    public Contact create(Contact contact) throws Exception, RegisterExistException {
        Optional<Contact> contactDB = repository.findById(contact.getId_contact());
        if (contactDB.isPresent())
            throw new RegisterExistException("The id of the Contact already exist in the DataBase");
            return repository.save(contact);

    }

    @Override
    public void update(Contact contact, int id) throws Exception, RegisterExistException {
        Optional<Contact> contactDB = repository.findById(id);
        if (contactDB.isPresent()) {
            contact.setId_contact(id);
            repository.save(contact);
            return;
        }
        throw new RegisterExistException("The id of the Contact no exist in the DataBase");
    }

    @Override
    public void delete(int id) throws Exception, RegisterExistException {
        Optional<Contact> contactDB = repository.findById(id);
        if (contactDB.isPresent()) {
            repository.deleteById(id);
            return;
        }
        throw new RegisterExistException("The id of the Contact no exist in the DataBase");
    }

    @Override
    public Contact get(int id) throws Exception, RegisterExistException {
        Optional<Contact> contactDB = repository.findById(id);
        if (contactDB.isPresent())
            return contactDB.get();
        throw new RegisterExistException("The id of the Contact no exist in the DataBase");
    }
}
