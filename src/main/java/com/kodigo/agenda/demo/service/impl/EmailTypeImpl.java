package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.EmailType;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IEmailTypeRepository;
import com.kodigo.agenda.demo.service.IEmailTypeService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class EmailTypeImpl implements IEmailTypeService {
    private final IEmailTypeRepository emailTypeRepository;
    public EmailTypeImpl(IEmailTypeRepository emailTypeRepository){
        this.emailTypeRepository = emailTypeRepository;
    }
    @Override
    public List<EmailType> getEmailType() {
        return emailTypeRepository.findAll();
    }

    @Override
    public EmailType findEmailTypeByID(int id) throws Exception {
        Optional<EmailType> emailTypeDB = emailTypeRepository.findById(id);
        if (emailTypeDB.isPresent())
            return emailTypeDB.get();
        throw new RegisterExistException("The id of the EmailType no exist in the DataBase");
    }

    @Override
    public EmailType create(EmailType emailType) throws Exception, RegisterExistException {
        Optional<EmailType> emailTypeDB = emailTypeRepository.findById(emailType.getId_type_of_email());
        if (emailTypeDB.isPresent())
            throw new RegisterExistException("The id of the EmailType already exist in the DataBase");
        return emailTypeRepository.save(emailType);
    }

    @Override
    public void update(EmailType emailType, int id) throws Exception, RegisterExistException {
        Optional<EmailType> emailTypeDB = emailTypeRepository.findById(id);
        if (emailTypeDB.isPresent()) {
            emailType.setId_type_of_email(id);
            emailTypeRepository.save(emailType);
            return;
        }
        throw new RegisterExistException("The id of the EmailType no exist in the DataBase");
    }

    @Override
    public void delete(int id) throws Exception, RegisterExistException {
        Optional<EmailType> emailTypeDB = emailTypeRepository.findById(id);
        if (emailTypeDB.isPresent()) {
            emailTypeRepository.deleteById(id);
            return;
        }
        throw new RegisterExistException("The id of the EmailType no exist in the DataBase");
    }

}
