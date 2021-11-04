package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Contact;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/app/v1/contact")
public class ContactController {
    @Autowired
    private final IContactService contactService;

    public ContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/api/contact", method = RequestMethod.GET)
    public List<Contact> findAllContacts() {
        try{
            List<Contact> test = contactService.findAllContacts();
            test.forEach(System.out::println);
            return test;
        } catch (Exception e){
            return (List<Contact>) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/api/contact/{id}", method = RequestMethod.GET)
    public Contact findContactById(@PathVariable Integer id_contact) {
        try{
            return contactService.findContactByID(id_contact);
        } catch (Exception e){
            return new Contact(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/contact", method = RequestMethod.POST)
    public ResponseEntity<Object> saveContact(@RequestBody Contact contact) {
        try {
            Contact contactSaved = contactService.saveContact(contact);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(contactSaved.getId_contact()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/contact", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateContact(@RequestBody Contact contact, @PathVariable Contact contact1) {
        try {
            contactService.updateContact(contact1);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "api/contact/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteContactById(@PathVariable Integer id_contact) {
        try {
            contactService.deleteContactById(id_contact);
            return ResponseEntity.status(HttpStatus.OK).build();
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
