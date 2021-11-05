package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Municipality;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.utility.RegisterExistException;

import java.util.List;

public interface IMunicipalityService {
    List<Municipality> getMunicipality() throws Exception;

    Municipality findMunicipalityByID(int id) throws Exception;

    Municipality create(Municipality municipality) throws Exception, RegisterExistException;

    void update(Municipality municipality, int id) throws Exception, RegisterExistException;

    void delete(int id) throws Exception, RegisterExistException;
}
