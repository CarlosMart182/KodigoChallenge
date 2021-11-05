package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Address;
import com.kodigo.agenda.demo.model.Municipality;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.service.IAddressService;
import com.kodigo.agenda.demo.service.IMunicipalityService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
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

    @GetMapping("/{id}")
    public ResponseEntity<Municipality> get(@PathVariable("id") int id) {
        try {
            Municipality municipality = municipalityService.findMunicipalityByID(id);
            return new ResponseEntity<Municipality>(municipality, HttpStatus.OK);

        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/find")
    public List<Municipality> findAll() throws Exception {
        return municipalityService.getMunicipality();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Municipality municipality) {
        try {
            Municipality municipalitySaved = municipalityService.create(municipality);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(municipalitySaved.getId_municipality()).toUri();
            return ResponseEntity.created(location).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Municipality municipality, @PathVariable int id) {
        try {
            municipalityService.update(municipality, id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        try {
            municipalityService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
