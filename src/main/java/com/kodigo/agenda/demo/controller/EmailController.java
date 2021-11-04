package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Email;
import com.kodigo.agenda.demo.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/app/v1/email")
public class EmailController {
    @Autowired
    private final IEmailService emailService;

    public EmailController(IEmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping(value = "/api/email", method = RequestMethod.GET)
    public List<Email> getEmail() {
        try{
            List<Email> test = emailService.getEmail();
            test.forEach(System.out::println);
            return test;
        } catch (Exception e){
            return (List<Email>) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/api/email/{id}", method = RequestMethod.GET)
    public Email findEmailById( @PathVariable Integer id_email) {
        try {
            return emailService.findEmailByID(id_email);
        } catch (Exception e){
            return new Email (null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/email", method = RequestMethod.POST)
    public ResponseEntity<Object> saveEmail(@RequestBody Email email) {
        try {
            Email emailSaved = emailService.saveEmail(email);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(emailSaved.getId_email()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/email", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEmail(@RequestBody Email email, @PathVariable Email email1) {
        try {
            emailService.updateEmail(email1);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "api/email/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmailById(@PathVariable Integer id_email) {
        try {
            emailService.deleteEmailById(id_email);
            return ResponseEntity.status(HttpStatus.OK).build();
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
