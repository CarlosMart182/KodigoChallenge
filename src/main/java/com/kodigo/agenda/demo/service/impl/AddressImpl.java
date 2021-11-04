package com.kodigo.agenda.demo.service.impl;

import com.kodigo.agenda.demo.model.Address;
import com.kodigo.agenda.demo.model.Person;
import com.kodigo.agenda.demo.repository.IAddressRepository;
import com.kodigo.agenda.demo.service.IAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class AddressImpl implements IAddressService {
    private final IAddressRepository addressRepository;

    public AddressImpl(IAddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address findAddressByID(Integer id_address) {
        Address addressTmp = addressRepository.getById(id_address);
        return addressTmp;
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        Address addressTmp = addressRepository.getById(address.getId_address());
        return addressRepository.save(addressTmp);
    }

    @Override
    public void deleteAddressById(Integer id_address) {
        Address addressTmp = addressRepository.getById(id_address);
        addressRepository.delete(addressTmp);
    }
}
