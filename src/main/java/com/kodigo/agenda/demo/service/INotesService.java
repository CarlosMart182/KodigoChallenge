package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Notes;
import com.kodigo.agenda.demo.model.Person;

import java.util.List;

public interface INotesService {
    List<Notes> getNotes();

    Notes findNotesByID(Integer id_notes);
    Notes saveNotes(Notes notes);
    Notes updateNotes(Notes notes);
    void deleteNotesById(Integer id_notes);
}
