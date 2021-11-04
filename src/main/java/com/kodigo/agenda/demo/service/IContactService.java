package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Contact;
import com.kodigo.agenda.demo.model.Person;

import java.util.List;

public interface IContactService {
    List<Contact> findAllContacts();

    Contact findContactByID(Integer id_contact);
    Contact saveContact(Contact contact);
    Contact updateContact(Contact contact);
    void deleteContactById(Integer id_contact);
}
