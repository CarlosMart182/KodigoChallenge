package com.kodigo.agenda.demo.repository;

import com.kodigo.agenda.demo.model.PhoneTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhoneTypesRepository extends JpaRepository<PhoneTypes, Integer> {
}
