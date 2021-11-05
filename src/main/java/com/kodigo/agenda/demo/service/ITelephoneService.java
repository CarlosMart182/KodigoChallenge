package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.model.Telephone;
import com.kodigo.agenda.demo.utility.RegisterExistException;

import java.util.List;

public interface ITelephoneService {
    List<Telephone> findTelephone()throws Exception;

    Telephone findTelephoneByID(int id) throws Exception;

    Telephone create(Telephone telephone) throws Exception;

    void update(Telephone telephone, int id) throws Exception;

    void delete(int id) throws Exception;

}
