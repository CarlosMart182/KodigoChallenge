package com.kodigo.agenda.demo.controller;

import com.kodigo.agenda.demo.model.Address;
import com.kodigo.agenda.demo.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app/v1/address")
public class AddressController {
    @Autowired
    private final IAddressService addressService;

    public AddressController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/api/address", method = RequestMethod.GET)
    public List<Address> getAddress() {
        try{
            List<Address> test = addressService.getAddress();
            test.forEach(System.out::println);
            return test;
        } catch (Exception e){
            return (List<Address>) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/api/address/{id}", method = RequestMethod.GET)
    public Address findAddressById( @PathVariable Integer id_address) {
        try {
            return addressService.findAddressByID(id_address);
        } catch (Exception e){
            return new Address (null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/address", method = RequestMethod.POST)
    public ResponseEntity<Object> saveAddress(@RequestBody Address address) {
        try {
            Address addressSaved = addressService.saveAddress(address);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(addressSaved.getId_address()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/api/address", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAddress(@RequestBody Address address, @PathVariable Address address1) {
        try {
            addressService.updateAddress(address1);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "api/address/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAddressById(@PathVariable Integer id_address) {
        try {
            addressService.deleteAddressById(id_address);
            return ResponseEntity.status(HttpStatus.OK).build();
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
