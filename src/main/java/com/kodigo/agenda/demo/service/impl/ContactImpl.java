package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Contact;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IContactRepository;
import com.kodigo.agenda.demo.repository.IContactTypeRepository;
import com.kodigo.agenda.demo.service.IContactService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service @Transactional
public class ContactImpl implements IContactService {
    private final IContactRepository contactRepository;
    public ContactImpl(IContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }
    @Override
    public List<Contact> findAllContacts() {
        return null;
    }

    @Override
    public Contact findContactByID(Integer id_contact) {
        Contact contactTmp = contactRepository.getById(id_contact);
        return contactTmp;
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);

    }

    @Override
    public Contact updateContact(Contact contact) {
        Contact contactTmp = contactRepository.getById(contact.getId_contact());
        return contactRepository.save(contactTmp);
    }

    @Override
    public void deleteContactById(Integer id_contact) {
        Contact contactTmp = contactRepository.getById(id_contact);
        contactRepository.delete(contactTmp);
    }
}
