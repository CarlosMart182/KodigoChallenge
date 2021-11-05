package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Address;
import com.kodigo.agenda.demo.model.Municipality;
import com.kodigo.agenda.demo.model.Notes;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.service.INotesService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/app/v1/notes")
public class NotesController {
    @Autowired
    private final INotesService notesService;

    public NotesController(INotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/find")
    public List<Notes> findAll() throws Exception {
        return notesService.getNotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notes> get(@PathVariable("id") int id) {
        try {
            Notes notes = notesService.findNotesByID(id);
            return new ResponseEntity<Notes>(notes, HttpStatus.OK);

        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Notes notes) {
        try {
            Notes notesSaved = notesService.create(notes);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(notesSaved.getId_notes()).toUri();
            return ResponseEntity.created(location).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Notes notes, @PathVariable int id) {
        try {
            notesService.update(notes, id);
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
            notesService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RegisterExistException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
