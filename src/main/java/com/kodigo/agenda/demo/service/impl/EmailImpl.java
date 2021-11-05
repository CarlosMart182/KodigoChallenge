package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Email;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IEmailRepository;
import com.kodigo.agenda.demo.service.IEmailService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Email findEmailByID(int id) throws Exception {
        Optional<Email> emailDB = emailRepository.findById(id);
        if (emailDB.isPresent())
            return emailDB.get();
        throw new RegisterExistException("The id of the Email no exist in the DataBase");    }

    @Override
    public Email create(Email email) throws Exception, RegisterExistException {
        Optional<Email> email1 = emailRepository.findById(email.getId_email());
        if (email1.isPresent())
            throw new RegisterExistException("The id of the Email already exist in the DataBase");
        return emailRepository.save(email);
    }

    @Override
    public void update(Email email, int id) throws Exception, RegisterExistException {
        Optional<Email> emailDB = emailRepository.findById(id);
        if (emailDB.isPresent()) {
            email.setId_email(id);
            emailRepository.save(email);
            return;
        }
        throw new RegisterExistException("The id of the Email no exist in the DataBase");
    }

    @Override
    public void delete(int id) throws Exception, RegisterExistException {
        Optional<Email> emailDB = emailRepository.findById(id);
        if (emailDB.isPresent()) {
            emailRepository.deleteById(id);
            return;
        }
        throw new RegisterExistException("The id of the Email no exist in the DataBase");
    }

}
