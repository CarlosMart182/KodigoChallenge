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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_contact")
    private int id_contact;


    @Getter @Setter
    @Basic(optional = true)
    @Column(name="id_type_of_contact")
    private ContactType id_type_of_contact;

    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_telephone")
    private List<Telephone> telephoneList;

    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_address")
    private List<Address> addressList = new ArrayList<>();

    @Getter @Setter
    @OneToMany(mappedBy="id_contact")
    private List<Email> emailList = new ArrayList<>();


    @ManyToOne
    @Basic(optional = true)
    @JoinColumn(name="id_person", nullable=false)
    private Person id_person;

    public Contact(Object o, HttpStatus internalServerError) {
    }

    public Contact() {
    }
}
