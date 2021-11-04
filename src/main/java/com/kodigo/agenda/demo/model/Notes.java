package com.kodigo.agenda.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Notes implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_notes",updatable = false, nullable = false)
    private int id_notes;

    @Getter @Setter @Column(name = "notes")
    private String notes;

    @Getter @Setter @Column(name = "dates")
    private Date dates;

    @JsonIgnore
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="id_person", nullable=false)
    private Person person;

    public Notes(Object o, HttpStatus internalServerError) {
    }

    public Notes() {
    }
}
