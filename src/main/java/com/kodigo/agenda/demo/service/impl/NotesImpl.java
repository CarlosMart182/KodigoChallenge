package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Notes;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.INotesRepository;
import com.kodigo.agenda.demo.service.INotesService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class NotesImpl implements INotesService {
    private final INotesRepository notesRepository;

    public NotesImpl(INotesRepository notesRepository){
        this.notesRepository = notesRepository;
    }
    @Override
    public List<Notes> getNotes() {
        return notesRepository.findAll();
    }

    @Override
    public Notes findNotesByID(int id) throws Exception {
        Optional<Notes> notesDB = notesRepository.findById(id);
        if (notesDB.isPresent())
            return notesDB.get();
        throw new RegisterExistException("The id of the Notes no exist in the DataBase");
    }

    @Override
    public Notes create(Notes notes) throws Exception {
        Optional<Notes> notesDB = notesRepository.findById(notes.getId_notes());
        if (notesDB.isPresent())
            throw new RegisterExistException("The id of the Notes already exist in the DataBase");
        return notesRepository.save(notes);
    }

    @Override
    public void update(Notes notes, int id) throws Exception {
        Optional<Notes> notesDB = notesRepository.findById(id);
        if (notesDB.isPresent()) {
            notes.setId_notes(id);
            notesRepository.save(notes);
            return;
        }
        throw new RegisterExistException("The id of the Notes no exist in the DataBase");
    }

    @Override
    public void delete(int id) throws Exception {
        Optional<Notes> notesDB = notesRepository.findById(id);
        if (notesDB.isPresent()) {
            notesRepository.deleteById(id);
            return;
        }
        throw new RegisterExistException("The id of the Notes no exist in the DataBase");
    }


}
