package com.kodigo.agenda.demo.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone_types")
public class PhoneTypes implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_type_of_phone")
    private int id_type_of_phone;

    @Getter @Setter @Column(name="type_of_phone")
    private String type_of_phone;

    public PhoneTypes(Object o, HttpStatus internalServerError) {
    }

    public PhoneTypes() {
    }
}
