package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.model.PhoneTypes;
import com.kodigo.agenda.demo.model.Telephone;
import com.kodigo.agenda.demo.service.IPhoneTypesService;
import com.kodigo.agenda.demo.service.ITelephoneService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/app/v1/telephone")
public class TelephoneController {
    @Autowired
    private final ITelephoneService telephoneService;

    public TelephoneController(ITelephoneService telephoneService) {
        this.telephoneService = telephoneService;
    }

    @GetMapping("/find")
    public List<Telephone> findAll() throws Exception {
        return telephoneService.findTelephone();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telephone> get(@PathVariable("id") int id) {
        try {
            Telephone telephone = telephoneService.findTelephoneByID(id);
            return new ResponseEntity<Telephone>(telephone, HttpStatus.OK);

        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Telephone telephone) {
        try {
            Telephone telephoneSaved = telephoneService.create(telephone);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(telephoneSaved.getId_telephone()).toUri();
            return ResponseEntity.created(location).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Telephone telephone, @PathVariable int id) {
        try {
            telephoneService.update(telephone, id);
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
            telephoneService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
