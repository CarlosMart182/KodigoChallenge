package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Address;
import com.kodigo.agenda.demo.model.Notes;
import com.kodigo.agenda.demo.service.INotesService;
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

    @RequestMapping(value = "/api/notes", method = RequestMethod.GET)
    public List<Notes> getNotes() {
        try{
            List<Notes> test = notesService.getNotes();
            test.forEach(System.out::println);
            return test;
        } catch (Exception e){
            return (List<Notes>) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/api/notes/{id}", method = RequestMethod.GET)
    public Notes findNotesById( @PathVariable Integer id_notes) {
        try {
            return notesService.findNotesByID(id_notes);
        } catch (Exception e){
            return new Notes (null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/notes", method = RequestMethod.POST)
    public ResponseEntity<Object> saveNotes(@RequestBody Notes notes) {
        try {
            Notes notesSaved = notesService.saveNotes(notes);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(notesSaved.getId_notes()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/notes", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateNotes(@RequestBody Notes notes, @PathVariable Notes notes1) {
        try {
            notesService.updateNotes(notes1);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "api/notes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteNotesById(@PathVariable Integer id_notes) {
        try {
            notesService.deleteNotesById(id_notes);
            return ResponseEntity.status(HttpStatus.OK).build();
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
