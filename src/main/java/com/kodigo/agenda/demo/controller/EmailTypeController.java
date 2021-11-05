package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Email;
import com.kodigo.agenda.demo.model.EmailType;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.service.IEmailService;
import com.kodigo.agenda.demo.service.IEmailTypeService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
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

    @GetMapping("/find")
    public List<EmailType> findAll() throws Exception {
        return emailTypeService.getEmailType();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailType> get(@PathVariable("id") int id) {
        try {
            EmailType emailType= emailTypeService.findEmailTypeByID(id);
            return new ResponseEntity<EmailType>(emailType, HttpStatus.OK);

        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody EmailType emailType) {
        try {
            EmailType emailTypeSaved = emailTypeService.create(emailType);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(emailTypeSaved.getId_type_of_email()).toUri();
            return ResponseEntity.created(location).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody EmailType emailType, @PathVariable int id) {
        try {
            emailTypeService.update(emailType, id);
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
            emailTypeService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
