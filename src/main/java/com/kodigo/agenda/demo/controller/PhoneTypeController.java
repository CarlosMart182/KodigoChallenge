package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.PhoneTypes;
import com.kodigo.agenda.demo.service.IPhoneTypesService;
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

    @RequestMapping(value = "/api/phone_type", method = RequestMethod.GET)
    public List<PhoneTypes> getPhoneType() {
        try{
            List<PhoneTypes> test = phoneTypesService.getPhoneType();
            test.forEach(System.out::println);
            return test;
        } catch (Exception e){
            return (List<PhoneTypes>) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/api/phone_type/{id}", method = RequestMethod.GET)
    public PhoneTypes findPhoneTypesById( @PathVariable Integer id_type_of_phone) {
        try {
            return phoneTypesService.findPhoneTypesByID(id_type_of_phone);
        } catch (Exception e){
            return new PhoneTypes (null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/phone_type", method = RequestMethod.POST)
    public ResponseEntity<Object> savePhoneTypes(@RequestBody PhoneTypes phoneTypes) {
        try {
            PhoneTypes phoneTypesSaved = phoneTypesService.savePhoneTypes(phoneTypes);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(phoneTypesSaved.getId_type_of_phone()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/phone_type", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePhoneTypes(@RequestBody PhoneTypes phoneTypes, @PathVariable PhoneTypes phoneTypes1) {
        try {
            phoneTypesService.updatePhoneTypes(phoneTypes1);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "api/phone_type/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePhoneTypesById(@PathVariable Integer id_type_of_phone) {
        try {
            phoneTypesService.deletePhoneTypesById(id_type_of_phone);
            return ResponseEntity.status(HttpStatus.OK).build();
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
