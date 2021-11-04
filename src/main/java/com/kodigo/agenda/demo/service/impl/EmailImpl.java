package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Email;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IEmailRepository;
import com.kodigo.agenda.demo.service.IEmailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service @Transactional
public class EmailImpl implements IEmailService {
    private final IEmailRepository emailRepository;
    public EmailImpl(IEmailRepository emailRepository){
        this.emailRepository = emailRepository;
    }
    @Override
    public List<Email> getEmail() {
        return emailRepository.findAll();
    }

    @Override
    public Email findEmailByID(Integer id_email) {
        Email emailTmp = emailRepository.getById(id_email);
        return emailTmp;    }

    @Override
    public Email saveEmail(Email email) {
        return emailRepository.save(email);
    }

    @Override
    public Email updateEmail(Email email) {
        Email emailTmp = emailRepository.getById(email.getId_email());
        return emailRepository.save(emailTmp);    }

    @Override
    public void deleteEmailById(Integer id_email) {
        Email emailTmp = emailRepository.getById(id_email);
        emailRepository.delete(emailTmp);
    }
}
