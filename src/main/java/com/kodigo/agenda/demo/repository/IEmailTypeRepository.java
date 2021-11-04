package com.kodigo.agenda.demo.repository;

import com.kodigo.agenda.demo.model.EmailType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmailTypeRepository extends JpaRepository<EmailType, Integer> {
}
