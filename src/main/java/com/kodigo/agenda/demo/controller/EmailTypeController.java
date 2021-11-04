package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Email;
import com.kodigo.agenda.demo.model.EmailType;
import com.kodigo.agenda.demo.service.IEmailService;
import com.kodigo.agenda.demo.service.IEmailTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/app/v1/email_type")
public class EmailTypeController {
    @Autowired
    private final IEmailTypeService emailTypeService;

    public EmailTypeController(IEmailTypeService emailTypeService) {
        this.emailTypeService = emailTypeService;
    }

    @RequestMapping(value = "/api/email_type", method = RequestMethod.GET)
    public List<EmailType> getEmailType() {
        try{
            List<EmailType> test = emailTypeService.getEmailType();
            test.forEach(System.out::println);
            return test;
        } catch (Exception e){
            return (List<EmailType>) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/api/email_type/{id}", method = RequestMethod.GET)
    public EmailType findEmailTypeById( @PathVariable Integer id_type_of_email) {
        try {
            return emailTypeService.findEmailTypeByID(id_type_of_email);
        } catch (Exception e){
            return new EmailType (null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/email_type", method = RequestMethod.POST)
    public ResponseEntity<Object> saveEmailType(@RequestBody EmailType emailType) {
        try {
            EmailType emailTypeSaved = emailTypeService.saveEmailType(emailType);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(emailTypeSaved.getId_type_of_email()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/email_type", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEmailType(@RequestBody EmailType emailType, @PathVariable EmailType emailType1) {
        try {
            emailTypeService.updateEmailType(emailType1);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "api/email_type/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmailTypeById(@PathVariable Integer id_type_of_email) {
        try {
            emailTypeService.deleteEmailTypeById(id_type_of_email);
            return ResponseEntity.status(HttpStatus.OK).build();
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
