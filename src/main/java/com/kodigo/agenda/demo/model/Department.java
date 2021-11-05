package com.kodigo.agenda.demo.model;

import lombok.*;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department")
public class Department implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_department")
    private int id_department;

    @Getter @Setter @Column(name="department_name")
    private String department_name;

    @OneToMany(mappedBy = "id_department")
    private List<Municipality> municipalityList;

    public Department(Object o, HttpStatus internalServerError) {
    }

    public Department() {
    }
}
