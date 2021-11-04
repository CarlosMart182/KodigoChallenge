package com.kodigo.agenda.demo.repository;

import com.kodigo.agenda.demo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address,Integer> {
}
