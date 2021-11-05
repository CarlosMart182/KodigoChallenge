package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.model.Telephone;
import com.kodigo.agenda.demo.repository.ITelephoneRepository;
import com.kodigo.agenda.demo.service.ITelephoneService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class TelephoneImpl implements ITelephoneService {
    private final ITelephoneRepository telephoneRepository;

    public TelephoneImpl(ITelephoneRepository telephoneRepository){
        this.telephoneRepository = telephoneRepository;
    }
    @Override
    public List<Telephone> findTelephone() {
        return telephoneRepository.findAll();

    }

    @Override
    public Telephone findTelephoneByID(int id) throws Exception {
        Optional<Telephone> telephoneDB = telephoneRepository.findById(id);
        if (telephoneDB.isPresent())
            return telephoneDB.get();
        throw new RegisterExistException("The id of the Telephone no exist in the DataBase");
    }

    @Override
    public Telephone create(Telephone telephone) throws Exception {
        Optional<Telephone> telephoneDB = telephoneRepository.findById(telephone.getId_telephone());
        if (telephoneDB.isPresent())
            throw new RegisterExistException("The id of the Telephone already exist in the DataBase");
        return telephoneRepository.save(telephone);
    }

    @Override
    public void update(Telephone telephone, int id) throws Exception {
        Optional<Telephone> telephoneDB = telephoneRepository.findById(id);
        if (telephoneDB.isPresent()) {
            telephone.setId_telephone(id);
            telephoneRepository.save(telephone);
            return;
        }
        throw new RegisterExistException("The id of the Telephone no exist in the DataBase");
    }

    @Override
    public void delete(int id) throws Exception {
        Optional<Telephone> telephoneDB = telephoneRepository.findById(id);
        if (telephoneDB.isPresent()) {
            telephoneRepository.deleteById(id);
            return;
        }
        throw new RegisterExistException("The id of the Telephone no exist in the DataBase");
    }
}
