package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.EmailType;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.utility.RegisterExistException;

import java.util.List;

public interface IEmailTypeService {
    List<EmailType> getEmailType() throws Exception;

    EmailType findEmailTypeByID(int id) throws Exception;

    EmailType create(EmailType emailType) throws Exception, RegisterExistException;

    void update(EmailType emailType, int id) throws Exception, RegisterExistException;

    void delete(int id) throws Exception, RegisterExistException;
}
