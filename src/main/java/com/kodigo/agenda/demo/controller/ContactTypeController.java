package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Contact;
import com.kodigo.agenda.demo.model.ContactType;
import com.kodigo.agenda.demo.service.IContactService;
import com.kodigo.agenda.demo.service.IContactTypeService;
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

    @RequestMapping(value = "/api/contact_type", method = RequestMethod.GET)
    public List<ContactType> getContactType() {
        try{
            List<ContactType> test = contactTypeService.getContactType();
            test.forEach(System.out::println);
            return test;
        } catch (Exception e){
            return (List<ContactType>) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/api/contact_type/{id}", method = RequestMethod.GET)
    public ContactType findContactTypeById(@PathVariable Integer id_type_of_contact) {
        try{
            return contactTypeService.findContactTypeByID(id_type_of_contact);
        } catch (Exception e){
            return new ContactType(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/contact_type", method = RequestMethod.POST)
    public ResponseEntity<Object> saveContactType(@RequestBody ContactType contactType) {
        try {
            ContactType contactTypeSaved = contactTypeService.saveContactType(contactType);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(contactTypeSaved.getId_type_of_contact()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/contact_type", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateContactType(@RequestBody ContactType contactType, @PathVariable ContactType contactType1) {
        try {
            contactTypeService.updateContactType(contactType1);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "api/contact_type/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteContactTypeById(@PathVariable Integer id_type_of_contact) {
        try {
            contactTypeService.deleteContactTypeById(id_type_of_contact);
            return ResponseEntity.status(HttpStatus.OK).build();
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
