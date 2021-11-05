package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Email;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.service.IEmailService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
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

    @GetMapping("/find")
    public List<Email> findAll() throws Exception {
        return emailService.getEmail();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> get(@PathVariable("id") int id) {
        try {
            Email email = emailService.findEmailByID(id);
            return new ResponseEntity<Email>(email, HttpStatus.OK);

        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Email email) {
        try {
            Email emailSaved = emailService.create(email);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(emailSaved.getId_email()).toUri();
            return ResponseEntity.created(location).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Email email, @PathVariable int id) {
        try {
            emailService.update(email, id);
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
            emailService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
