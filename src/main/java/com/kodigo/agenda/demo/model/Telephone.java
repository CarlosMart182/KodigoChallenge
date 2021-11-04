package com.kodigo.agenda.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "telephone")
@ToString @EqualsAndHashCode
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Telephone implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_telephone")
    private int id_telephone;

    @JsonIgnore
    @Getter @Setter
    @OneToOne
    @JoinColumn(name="id_type_of_phone", nullable=false)
    private PhoneTypes phoneTypes;

    @JsonIgnore
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="id_contact", nullable=false)
    private Contact contact;

    @Getter @Setter @Column(name="phone_number")
    private int phone_number;

    public Telephone(Object o, HttpStatus internalServerError) {
    }

    public Telephone() {
    }
}
