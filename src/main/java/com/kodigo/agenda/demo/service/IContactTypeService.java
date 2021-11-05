package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.ContactType;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.utility.RegisterExistException;

import java.util.List;

public interface IContactTypeService {
    List<ContactType> getContactType()throws Exception;

    ContactType findContactTypeByID(int id)throws Exception;

    ContactType create(ContactType contactType) throws Exception, RegisterExistException;

    void update(ContactType contactType, int id) throws Exception, RegisterExistException;

    void delete(int id) throws Exception, RegisterExistException;

}
