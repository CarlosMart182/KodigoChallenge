package com.kodigo.agenda.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Entity
@Table(name = "email")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Email implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_email")
    private int id_email;

    @JsonIgnore
    @Getter @Setter
    @OneToOne
    @JoinColumn(name="id_type_of_email", nullable=false)
    private EmailType id_type_of_email;

    @JsonIgnore
    @Getter @Setter
    @OneToOne
    @JoinColumn(name="id_contact", nullable=false)
    private Contact id_contact;

    @Getter @Setter @Column(name = "email")
    private String email;

    public Email(Object o, HttpStatus internalServerError) {
    }

    public Email() {

    }
}
