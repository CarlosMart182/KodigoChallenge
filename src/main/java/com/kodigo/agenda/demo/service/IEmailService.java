package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Email;
import com.kodigo.agenda.demo.model.Person;

import java.util.List;

public interface IEmailService {
    List<Email> getEmail();

    Email findEmailByID(Integer id_email);
    Email saveEmail(Email email);
    Email updateEmail(Email email);
    void deleteEmailById(Integer id_email);
}
