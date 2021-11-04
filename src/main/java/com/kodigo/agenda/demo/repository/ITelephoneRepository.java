package com.kodigo.agenda.demo.repository;

import com.kodigo.agenda.demo.model.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITelephoneRepository extends JpaRepository<Telephone, Integer> {
}
