package com.kodigo.agenda.demo.repository;

import com.kodigo.agenda.demo.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotesRepository extends JpaRepository<Notes, Integer> {
}
