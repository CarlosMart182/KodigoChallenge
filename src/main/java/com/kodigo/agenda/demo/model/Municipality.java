package com.kodigo.agenda.demo.model;
import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "municipality")
public class Municipality implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_municipality")
    private int id_municipality;

    @Getter @Setter @Column(name="municipality_name")
    private String municipality_name;

    public Municipality(Object o, HttpStatus internalServerError) {
    }

    public Municipality() {
    }
}
