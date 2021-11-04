package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.model.Telephone;

import java.util.List;

public interface ITelephoneService {
    List<Telephone> findTelephone();

    Telephone findTelephoneByID(Integer id_telephone);
    Telephone saveTelephone(Telephone telephone);
    Telephone updateTelephone(Telephone telephone);
    void deleteTelephoneById(Integer id_telephone);
}
