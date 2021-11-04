package com.kodigo.agenda.demo.repository;

import com.kodigo.agenda.demo.model.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMunicipalityRepository extends JpaRepository<Municipality, Integer> {
}
