package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.model.PhoneTypes;
import com.kodigo.agenda.demo.repository.IPhoneTypesRepository;
import com.kodigo.agenda.demo.service.IPhoneTypesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public PhoneTypes findPhoneTypesByID(Integer id_type_of_phone) {
        PhoneTypes phoneTypesTmp = phoneTypesRepository.getById(id_type_of_phone);
        return phoneTypesTmp;
    }

    @Override
    public PhoneTypes savePhoneTypes(PhoneTypes phoneTypes) {
        return phoneTypesRepository.save(phoneTypes);
    }

    @Override
    public PhoneTypes updatePhoneTypes(PhoneTypes phoneTypes) {
        PhoneTypes phoneTypesTmp = phoneTypesRepository.getById(phoneTypes.getId_type_of_phone());
        return phoneTypesRepository.save(phoneTypesTmp);
    }

    @Override
    public void deletePhoneTypesById(Integer id_type_of_phone) {
        PhoneTypes phoneTypesTmp = phoneTypesRepository.getById(id_type_of_phone);
        phoneTypesRepository.delete(phoneTypesTmp);
    }
}
