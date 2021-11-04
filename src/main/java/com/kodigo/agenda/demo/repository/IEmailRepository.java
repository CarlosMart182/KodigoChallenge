package com.kodigo.agenda.demo.repository;

import com.kodigo.agenda.demo.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmailRepository extends JpaRepository<Email, Integer> {
}
