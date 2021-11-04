package com.kodigo.agenda.demo.repository;

import com.kodigo.agenda.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository <Person, Integer>{

}
