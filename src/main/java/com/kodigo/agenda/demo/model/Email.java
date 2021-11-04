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
    private EmailType emailType;

    @JsonIgnore
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="id_contact", nullable=false)
    private Contact contact;

    @Getter @Setter @Column(name = "email")
    private String email;

    public Email(Object o, HttpStatus internalServerError) {
    }

    public Email(int id_email, EmailType emailType, Contact contact, String email) {
        this.id_email = id_email;
        this.emailType = emailType;
        this.contact = contact;
        this.email = email;
    }
}
