package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Notes;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.INotesRepository;
import com.kodigo.agenda.demo.service.INotesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public Notes findNotesByID(Integer id_notes) {
        Notes notesTmp = notesRepository.getById(id_notes);
        return notesTmp;
    }

    @Override
    public Notes saveNotes(Notes notes) {
        return notesRepository.save(notes);

    }

    @Override
    public Notes updateNotes(Notes notes) {
        Notes notesTmp = notesRepository.getById(notes.getId_notes());
        return notesRepository.save(notesTmp);
    }

    @Override
    public void deleteNotesById(Integer id_notes) {
        Notes notesTmp = notesRepository.getById(id_notes);
        notesRepository.delete(notesTmp);
    }
}
