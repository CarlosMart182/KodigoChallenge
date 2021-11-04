package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Address;
import com.kodigo.agenda.demo.model.Municipality;
import com.kodigo.agenda.demo.service.IAddressService;
import com.kodigo.agenda.demo.service.IMunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/app/v1/municipality")
public class MunicipalityController {
    @Autowired
    private final IMunicipalityService municipalityService;

    public MunicipalityController(IMunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    @RequestMapping(value = "/api/municipality", method = RequestMethod.GET)
    public List<Municipality> getMunicipality() {
        try{
            List<Municipality> test = municipalityService.getMunicipality();
            test.forEach(System.out::println);
            return test;
        } catch (Exception e){
            return (List<Municipality>) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/api/municipality/{id}", method = RequestMethod.GET)
    public Municipality findMunicipalityById( @PathVariable Integer id_municipality) {
        try {
            return municipalityService.findMunicipalityByID(id_municipality);
        } catch (Exception e){
            return new Municipality (null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/municipality", method = RequestMethod.POST)
    public ResponseEntity<Object> saveMunicipality(@RequestBody Municipality municipality) {
        try {
            Municipality municipalitySaved = municipalityService.saveMunicipality(municipality);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(municipalitySaved.getId_municipality()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/municipality", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateMunicipality(@RequestBody Municipality municipality, @PathVariable Municipality municipality1) {
        try {
            municipalityService.updateMunicipality(municipality1);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "api/municipality/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteMunicipalityById(@PathVariable Integer id_municipality) {
        try {
            municipalityService.deleteMunicipalityById(id_municipality);
            return ResponseEntity.status(HttpStatus.OK).build();
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
