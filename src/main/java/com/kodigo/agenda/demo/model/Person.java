package com.kodigo.agenda.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@ToString @EqualsAndHashCode
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_person", updatable = false, nullable = false)
    private int id_person;

    @Getter @Setter @Column(name = "first_name")
    private String first_name;

    @Getter @Setter @Column(name = "last_name")
    private String last_name;

    @Getter @Setter
    @OneToMany(mappedBy="person")
    private List<Notes> notesList = new ArrayList<>();

    @Getter @Setter
    @OneToMany(mappedBy="person")
    private  List<Contact> contactList = new ArrayList<>();

    public Person(Object o, HttpStatus internalServerError) {
    }

    public Person() {
    }
}
