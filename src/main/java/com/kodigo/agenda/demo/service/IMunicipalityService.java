package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Municipality;
import com.kodigo.agenda.demo.model.Person;

import java.util.List;

public interface IMunicipalityService {
    List<Municipality> getMunicipality();

    Municipality findMunicipalityByID(Integer id_municipality);
    Municipality saveMunicipality(Municipality municipality);
    Municipality updateMunicipality(Municipality municipality);
    void deleteMunicipalityById(Integer id_municipality);
}
