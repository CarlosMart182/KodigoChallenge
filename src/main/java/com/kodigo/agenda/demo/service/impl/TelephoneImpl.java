package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.model.Telephone;
import com.kodigo.agenda.demo.repository.ITelephoneRepository;
import com.kodigo.agenda.demo.service.ITelephoneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public Telephone findTelephoneByID(Integer id_telephone) {
        Telephone telephoneTmp = telephoneRepository.getById(id_telephone);
        return telephoneTmp;
    }

    @Override
    public Telephone saveTelephone(Telephone telephone) {
        return telephoneRepository.save(telephone);

    }

    @Override
    public Telephone updateTelephone(Telephone telephone) {
        Telephone telephoneTmp = telephoneRepository.getById(telephone.getId_telephone());
        return telephoneRepository.save(telephoneTmp);
    }

    @Override
    public void deleteTelephoneById(Integer id_telephone) {
        Telephone telephoneTmp = telephoneRepository.getById(id_telephone);
        telephoneRepository.delete(telephoneTmp);
    }
}
