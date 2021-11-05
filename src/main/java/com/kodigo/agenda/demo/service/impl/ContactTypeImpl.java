package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.ContactType;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IContactTypeRepository;
import com.kodigo.agenda.demo.service.IContactTypeService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class ContactTypeImpl implements IContactTypeService {
    private final IContactTypeRepository contactTypeRepository;
    public ContactTypeImpl(IContactTypeRepository contactTypeRepository){
        this.contactTypeRepository = contactTypeRepository;
    }

    @Override
    public List<ContactType> getContactType() throws Exception {
        return (List<ContactType>) contactTypeRepository.findAll();

    }

    @Override
    public ContactType findContactTypeByID(int id) throws Exception {
        Optional<ContactType> contactTypeDB = contactTypeRepository.findById(id);
        if (contactTypeDB.isPresent())
            return contactTypeDB.get();
        throw new RegisterExistException("The id of the ContactType no exist in the DataBase");    }

    @Override
    public ContactType create(ContactType contactType) throws Exception, RegisterExistException {
        Optional<ContactType> contactType1 = contactTypeRepository.findById(contactType.getId_type_of_contact());
        if (contactType1.isPresent())
            throw new RegisterExistException("The id of the ContactType already exist in the DataBase");
        return contactTypeRepository.save(contactType);
    }

    @Override
    public void update(ContactType contactType, int id) throws Exception, RegisterExistException {
        Optional<ContactType> contactType1 = contactTypeRepository.findById(id);
        if (contactType1.isPresent()) {
            contactType.setId_type_of_contact(id);
            contactTypeRepository.save(contactType);
            return;
        }
        throw new RegisterExistException("The id of the ContactType no exist in the DataBase");
    }

    @Override
    public void delete(int id) throws Exception, RegisterExistException {
        Optional<ContactType> contactType = contactTypeRepository.findById(id);
        if (contactType.isPresent()) {
            contactTypeRepository.deleteById(id);
            return;
        }
        throw new RegisterExistException("The id of the ContactType no exist in the DataBase");
    }
}
