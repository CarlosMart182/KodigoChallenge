package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.ContactType;

import java.util.List;

public interface IContactTypeService {
    List<ContactType> getContactType();

    ContactType findContactTypeByID(Integer id_type_of_contact);
    ContactType saveContactType(ContactType contactType);
    ContactType updateContactType(ContactType contactType);
    void deleteContactTypeById(Integer id_type_of_contact);
}
