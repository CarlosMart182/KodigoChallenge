package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.model.PhoneTypes;
import com.kodigo.agenda.demo.repository.IPhoneTypesRepository;
import com.kodigo.agenda.demo.service.IPhoneTypesService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class PhoneTypesImpl implements IPhoneTypesService {
    private final IPhoneTypesRepository phoneTypesRepository;

    public PhoneTypesImpl(IPhoneTypesRepository phoneTypesRepository){
        this.phoneTypesRepository = phoneTypesRepository;
    }
    @Override
    public List<PhoneTypes> getPhoneType() {
        return phoneTypesRepository.findAll();
    }

    @Override
    public PhoneTypes findPhoneTypesByID(int id) throws Exception{
        Optional<PhoneTypes> phoneTypesDB = phoneTypesRepository.findById(id);
        if (phoneTypesDB.isPresent())
            return phoneTypesDB.get();
        throw new RegisterExistException("The id of the PhoneTypes no exist in the DataBase");
    }

    @Override
    public PhoneTypes create(PhoneTypes phoneTypes) throws Exception {
        Optional<PhoneTypes> phoneTypesDB = phoneTypesRepository.findById(phoneTypes.getId_type_of_phone());
        if (phoneTypesDB.isPresent())
            throw new RegisterExistException("The id of the PhoneType already exist in the DataBase");
        return phoneTypesRepository.save(phoneTypes);    }

    @Override
    public void update(PhoneTypes phoneTypes, int id) throws Exception {
        Optional<PhoneTypes> phoneTypesDB = phoneTypesRepository.findById(id);
        if (phoneTypesDB.isPresent()) {
            phoneTypes.setId_type_of_phone(id);
            phoneTypesRepository.save(phoneTypes);
            return;
        }
        throw new RegisterExistException("The id of the PhoneType no exist in the DataBase");
    }

    @Override
    public void delete(int id) throws Exception {
        Optional<PhoneTypes> phoneTypesDB = phoneTypesRepository.findById(id);
        if (phoneTypesDB.isPresent()) {
            phoneTypesRepository.deleteById(id);
            return;
        }
        throw new RegisterExistException("The id of the PhoneType no exist in the DataBase");
    }

}
