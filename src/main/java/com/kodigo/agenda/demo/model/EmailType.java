package com.kodigo.agenda.demo.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "email_type")
public class EmailType implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_type_of_email")
    private int id_type_of_email;

    @Getter @Setter @Column(name="email_type")
    private String email_type;

    public EmailType(Object o, HttpStatus internalServerError) {
    }

    public EmailType() {
    }
}
