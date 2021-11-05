package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Email;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.utility.RegisterExistException;

import java.util.List;

public interface IEmailService {
    List<Email> getEmail() throws Exception;

    Email findEmailByID(int id) throws Exception;

    Email create(Email email) throws Exception, RegisterExistException;

    void update(Email email, int id) throws Exception, RegisterExistException;

    void delete(int id) throws Exception, RegisterExistException;

}
