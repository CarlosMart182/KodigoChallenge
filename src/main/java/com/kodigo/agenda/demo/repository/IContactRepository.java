package com.kodigo.agenda.demo.repository;

import com.kodigo.agenda.demo.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactRepository extends JpaRepository<Contact, Integer> {
}
