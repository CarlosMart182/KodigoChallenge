package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.model.PhoneTypes;

import java.util.List;

public interface IPhoneTypesService {
    List<PhoneTypes> getPhoneType();

    PhoneTypes findPhoneTypesByID(Integer id_type_of_phone);
    PhoneTypes savePhoneTypes(PhoneTypes phoneTypes);
    PhoneTypes updatePhoneTypes(PhoneTypes phoneTypes);
    void deletePhoneTypesById(Integer id_type_of_phone);
}
