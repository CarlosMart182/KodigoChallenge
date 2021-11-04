package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.EmailType;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IEmailTypeRepository;
import com.kodigo.agenda.demo.service.IEmailTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public EmailType findEmailTypeByID(Integer id_type_of_email) {
        EmailType emailTypeTmp = emailTypeRepository.getById(id_type_of_email);
        return emailTypeTmp;    }

    @Override
    public EmailType saveEmailType(EmailType emailType) {
        return emailTypeRepository.save(emailType);
    }

    @Override
    public EmailType updateEmailType(EmailType emailType) {
        EmailType emailTypeTmp = emailTypeRepository.getById(emailType.getId_type_of_email());
        return emailTypeRepository.save(emailTypeTmp);
    }

    @Override
    public void deleteEmailTypeById(Integer id_type_of_email) {
        EmailType emailTypeTmp = emailTypeRepository.getById(id_type_of_email);
        emailTypeRepository.delete(emailTypeTmp);
    }
}
