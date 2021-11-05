package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Contact;
import com.kodigo.agenda.demo.model.ContactType;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.service.IContactService;
import com.kodigo.agenda.demo.service.IContactTypeService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/app/v1/contact_type")
public class ContactTypeController {

    @Autowired
    private final IContactTypeService contactTypeService;

    public ContactTypeController(IContactTypeService contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

    @GetMapping("/find")
    public List<ContactType> findAll() throws Exception {
        return contactTypeService.getContactType();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactType> get(@PathVariable("id") int id) {
        try {
            ContactType contactType = contactTypeService.findContactTypeByID(id);
            return new ResponseEntity<ContactType>(contactType, HttpStatus.OK);

        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody ContactType contactType) {
        try {
            ContactType contactTypeSaved = contactTypeService.create(contactType);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(contactTypeSaved.getId_type_of_contact()).toUri();
            return ResponseEntity.created(location).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody ContactType contactType, @PathVariable int id) {
        try {
            contactTypeService.update(contactType, id);
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
            contactTypeService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
