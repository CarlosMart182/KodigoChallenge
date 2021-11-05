package com.kodigo.agenda.demo.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "email_type")
public class EmailType implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_type_of_email")
    private int id_type_of_email;

    @Getter @Setter @Column(name="email_type")
    private String email_type;

    @OneToMany(mappedBy = "id_type_of_email")
    private List<Email> emailList;

    public EmailType(Object o, HttpStatus internalServerError) {
    }

    public EmailType() {
    }
}
