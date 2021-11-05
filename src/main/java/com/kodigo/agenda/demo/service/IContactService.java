package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Contact;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.utility.RegisterExistException;

import java.util.List;

public interface IContactService {
    List<Contact> findAll() throws Exception;

    Contact create(Contact contact) throws Exception, RegisterExistException;

    void update(Contact contact, int id) throws Exception, RegisterExistException;

    void delete(int id) throws Exception, RegisterExistException;

    Contact get(int id) throws Exception, RegisterExistException;
}
