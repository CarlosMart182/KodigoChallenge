package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.ContactType;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IContactTypeRepository;
import com.kodigo.agenda.demo.service.IContactTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service @Transactional
public class ContactTypeImpl implements IContactTypeService {
    private final IContactTypeRepository contactTypeRepository;
    public ContactTypeImpl(IContactTypeRepository contactTypeRepository){
        this.contactTypeRepository = contactTypeRepository;
    }


    @Override
    public List<ContactType> getContactType() {
        return contactTypeRepository.findAll();
    }

    @Override
    public ContactType findContactTypeByID(Integer id_type_of_contact) {
        ContactType contactTypeTmp = contactTypeRepository.getById(id_type_of_contact);
        return contactTypeTmp;
    }

    @Override
    public ContactType saveContactType(ContactType contactType) {
        return contactTypeRepository.save(contactType);

    }

    @Override
    public ContactType updateContactType(ContactType contactType) {
        ContactType contactTypeTmp = contactTypeRepository.getById(contactType.getId_type_of_contact());
        return contactTypeRepository.save(contactTypeTmp);
    }

    @Override
    public void deleteContactTypeById(Integer id_type_of_contact) {
        ContactType contactTypeTmp = contactTypeRepository.getById(id_type_of_contact);
        contactTypeRepository.delete(contactTypeTmp);
    }
}
