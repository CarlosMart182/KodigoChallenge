package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Notes;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.utility.RegisterExistException;

import java.util.List;

public interface INotesService {
    List<Notes> getNotes() throws Exception;

    Notes findNotesByID(int id) throws Exception;

    Notes create(Notes notes) throws Exception;

    void update(Notes notes, int id) throws Exception;

    void delete(int id) throws Exception;

}
