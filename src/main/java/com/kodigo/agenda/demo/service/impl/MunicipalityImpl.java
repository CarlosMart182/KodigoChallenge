package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Municipality;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IMunicipalityRepository;
import com.kodigo.agenda.demo.service.IMunicipalityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MunicipalityImpl implements IMunicipalityService {
    private final IMunicipalityRepository municipalityRepository;

    public MunicipalityImpl(IMunicipalityRepository municipalityRepository){
        this.municipalityRepository = municipalityRepository;
    }
    @Override
    public List<Municipality> getMunicipality() {
        return municipalityRepository.findAll();
    }

    @Override
    public Municipality findMunicipalityByID(Integer id_municipality) {
        Municipality municipalityTmp = municipalityRepository.getById(id_municipality);
        return municipalityTmp;
    }

    @Override
    public Municipality saveMunicipality(Municipality municipality) {
        return municipalityRepository.save(municipality);

    }

    @Override
    public Municipality updateMunicipality(Municipality municipality) {
        Municipality municipalityTmp = municipalityRepository.getById(municipality.getId_municipality());
        return municipalityRepository.save(municipalityTmp);
    }

    @Override
    public void deleteMunicipalityById(Integer id_municipality) {
        Municipality municipalityTmp = municipalityRepository.getById(id_municipality);
        municipalityRepository.delete(municipalityTmp);
    }
}
