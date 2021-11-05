package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Municipality;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IMunicipalityRepository;
import com.kodigo.agenda.demo.service.IMunicipalityService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Municipality findMunicipalityByID(int id) throws Exception {
        Optional<Municipality> municipalityDB = municipalityRepository.findById(id);
        if (municipalityDB.isPresent())
            return municipalityDB.get();
        throw new RegisterExistException("The id of the Municipality no exist in the DataBase");
    }

    @Override
    public Municipality create(Municipality municipality) throws Exception, RegisterExistException {
        Optional<Municipality> municipalityDB = municipalityRepository.findById(municipality.getId_municipality());
        if (municipalityDB.isPresent())
            throw new RegisterExistException("The id of the Municipality already exist in the DataBase");
        return municipalityRepository.save(municipality);
    }

    @Override
    public void update(Municipality municipality, int id) throws Exception, RegisterExistException {
        Optional<Municipality> municipalityDB = municipalityRepository.findById(id);
        if (municipalityDB.isPresent()) {
            municipality.setId_municipality(id);
            municipalityRepository.save(municipality);
            return;
        }
        throw new RegisterExistException("The id of the Municipality no exist in the DataBase");
    }

    @Override
    public void delete(int id) throws Exception, RegisterExistException {
        Optional<Municipality> municipalityDB = municipalityRepository.findById(id);
        if (municipalityDB.isPresent()) {
            municipalityRepository.deleteById(id);
            return;
        }
        throw new RegisterExistException("The id of the Municipality no exist in the DataBase");
    }


}
