package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.EmailType;
import com.kodigo.agenda.demo.model.Person;

import java.util.List;

public interface IEmailTypeService {
    List<EmailType> getEmailType();

    EmailType findEmailTypeByID(Integer id_type_of_email);
    EmailType saveEmailType(EmailType emailType);
    EmailType updateEmailType(EmailType emailType);
    void deleteEmailTypeById(Integer id_type_of_email);
}
