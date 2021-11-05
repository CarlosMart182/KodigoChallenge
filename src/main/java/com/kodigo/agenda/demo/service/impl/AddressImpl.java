package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Address;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IAddressRepository;
import com.kodigo.agenda.demo.repository.IPersonRepository;
import com.kodigo.agenda.demo.service.IAddressService;
import com.kodigo.agenda.demo.utility.RegisterExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class AddressImpl implements IAddressService {

    private IAddressRepository repository;

    public AddressImpl(IAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Address> getAddress() {
        return (List<Address>) repository.findAll();
    }

    @Override
    public Address get(int id) throws Exception, RegisterExistException {
        Optional<Address> addressDB = repository.findById(id);
        if (addressDB.isPresent())
            return addressDB.get();
        throw new RegisterExistException("The id of the Address no exist in the DataBase");
    }

    @Override
    public Address create(Address address) throws Exception, RegisterExistException {
        Optional<Address> address1 = repository.findById(address.getId_address());
        if (address1.isPresent())
            throw new RegisterExistException("The id of the Address already exist in the DataBase");
        return repository.save(address);
    }

    @Override
    public void update(Address address, int id) throws Exception, RegisterExistException {
        Optional<Address> address1 = repository.findById(id);
        if (address1.isPresent()) {
            address.setId_address(id);
            repository.save(address);
            return;
        }
        throw new RegisterExistException("The id of the Address no exist in the DataBase");
    }

    @Override
    public void delete(int id) throws Exception, RegisterExistException {
        Optional<Address> address1 = repository.findById(id);
        if (address1.isPresent()) {
            repository.deleteById(id);
            return;
        }
        throw new RegisterExistException("The id of the Address no exist in the DataBase");
    }
}
