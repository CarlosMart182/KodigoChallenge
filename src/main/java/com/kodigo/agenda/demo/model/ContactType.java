package com.kodigo.agenda.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "contact_type")
@ToString @EqualsAndHashCode
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContactType implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_type_of_contact")
    private int id_type_of_contact;

    @Getter @Setter @Column(name="type_of_contact")
    private String type_of_contact;

    public ContactType(Object o, HttpStatus internalServerError) {
    }

    public ContactType() {
    }
}
