package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.PhoneTypes;
import com.kodigo.agenda.demo.model.Telephone;
import com.kodigo.agenda.demo.service.IPhoneTypesService;
import com.kodigo.agenda.demo.service.ITelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/app/v1/phone")
public class TelephoneController {
    @Autowired
    private final ITelephoneService telephoneService;

    public TelephoneController(ITelephoneService telephoneService) {
        this.telephoneService = telephoneService;
    }

    @RequestMapping(value = "/api/phone", method = RequestMethod.GET)
    public List<Telephone> findTelephone() {
        try{
            List<Telephone> test = telephoneService.findTelephone();
            test.forEach(System.out::println);
            return test;
        } catch (Exception e){
            return (List<Telephone>) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/api/phone/{id}", method = RequestMethod.GET)
    public Telephone findTelephoneById( @PathVariable Integer id_telephone) {
        try {
            return telephoneService.findTelephoneByID(id_telephone);
        } catch (Exception e){
            return new Telephone (null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/phone", method = RequestMethod.POST)
    public ResponseEntity<Object> saveTelephone(@RequestBody Telephone telephone) {
        try {
            Telephone telephoneSaved = telephoneService.saveTelephone(telephone);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(telephoneSaved.getId_telephone()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/phone", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateTelephone(@RequestBody Telephone telephone, @PathVariable Telephone telephone1) {
        try {
            telephoneService.updateTelephone(telephone1);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "api/phone/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePhoneTypesById(@PathVariable Integer id_telephone) {
        try {
            telephoneService.deleteTelephoneById(id_telephone);
            return ResponseEntity.status(HttpStatus.OK).build();
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
