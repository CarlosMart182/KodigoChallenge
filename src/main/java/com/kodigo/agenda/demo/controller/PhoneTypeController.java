package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.model.PhoneTypes;
import com.kodigo.agenda.demo.service.IPhoneTypesService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/app/v1/phone_type")
public class PhoneTypeController {
    @Autowired
    private final IPhoneTypesService phoneTypesService;

    public PhoneTypeController(IPhoneTypesService phoneTypesService) {
        this.phoneTypesService = phoneTypesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneTypes> get(@PathVariable("id") int id) {
        try {
            PhoneTypes phoneTypes = phoneTypesService.findPhoneTypesByID(id);
            return new ResponseEntity<PhoneTypes>(phoneTypes, HttpStatus.OK);
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find")
    public List<PhoneTypes> findAll() throws Exception {
        return phoneTypesService.getPhoneType();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody PhoneTypes phoneTypes) {
        try {
            PhoneTypes phoneTypesSaved = phoneTypesService.create(phoneTypes);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(phoneTypesSaved.getId_type_of_phone()).toUri();
            return ResponseEntity.created(location).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody PhoneTypes phoneTypes, @PathVariable int id) {
        try {
            phoneTypesService.update(phoneTypes, id);
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
            phoneTypesService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
