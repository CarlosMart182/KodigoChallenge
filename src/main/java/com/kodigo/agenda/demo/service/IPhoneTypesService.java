package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.model.PhoneTypes;
import com.kodigo.agenda.demo.utility.RegisterExistException;

import java.util.List;

public interface IPhoneTypesService {
    List<PhoneTypes> getPhoneType() throws Exception;

    PhoneTypes findPhoneTypesByID(int id) throws Exception;

    PhoneTypes create(PhoneTypes phoneTypes) throws Exception;

    void update(PhoneTypes phoneTypes, int id) throws Exception;

    void delete(int id) throws Exception;
}
