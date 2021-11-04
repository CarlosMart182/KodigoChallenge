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
@Table(name = "contact")
@ToString @EqualsAndHashCode
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Getter @Setter @Column(name = "id_contact")
    private int id_contact;

    @JsonIgnore
    @Getter @Setter
    @OneToOne
    @JoinColumn(name="id_type_of_contact", nullable=false)
    private ContactType contactType;

    @Getter @Setter
    @OneToMany(mappedBy="contact")
    private List<Telephone> telephoneList;

    @Getter @Setter
    @OneToMany(mappedBy="contact")
    private List<Address> addressList = new ArrayList<>();

    @Getter @Setter
    @OneToMany(mappedBy="contact")
    private List<Email> emailList = new ArrayList<>();

    @JsonIgnore
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="id_person", nullable=false)
    private Person person;

    public Contact(Object o, HttpStatus internalServerError) {
    }

    public Contact() {
    }
}
