package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Address;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.utility.RegisterExistException;

import java.util.List;

public interface IAddressService {

    List<Address> getAddress();

    Address get(int id) throws Exception, RegisterExistException;

    Address create(Address address) throws Exception, RegisterExistException;

    void update(Address address, int id) throws Exception, RegisterExistException;

    void delete(int id) throws Exception, RegisterExistException;
}
