package com.kodigo.agenda.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Entity(name = "address")
@Table(name = "address")
@ToString @EqualsAndHashCode
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Getter @Setter @Column(name = "id_address")
    private int id_address;

    @JsonIgnore
    @Getter @Setter
    @OneToOne
    @JoinColumn(name="id_municipality", nullable=false)
    private Municipality id_municipality;

    @JsonIgnore
    @Getter @Setter
    @OneToOne
    @JoinColumn(name="id_department", nullable=false)
    private Department department;

    @JsonIgnore
    @Getter @Setter
    @OneToOne
    @JoinColumn(name="id_contact", nullable=false)
    private Contact id_contact;

    @Getter @Setter @Column(name = "address")
    private String address;

    public Address(Object o, HttpStatus internalServerError) {
    }

    public Address() {
    }
}
