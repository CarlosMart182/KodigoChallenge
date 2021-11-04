package com.kodigo.agenda.demo.repository;

import com.kodigo.agenda.demo.model.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactTypeRepository extends JpaRepository<ContactType, Integer> {
}
