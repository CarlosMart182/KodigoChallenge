package com.kodigo.agenda.demo.service;

import com.kodigo.agenda.demo.model.Address;
import com.kodigo.agenda.demo.model.Person;

import java.util.List;

public interface IAddressService {

    List<Address> getAddress();

    Address findAddressByID(Integer id_address);
    Address saveAddress(Address address);
    Address updateAddress(Address address);
    void deleteAddressById(Integer id_address);
}
