package com.kosmos.challenge.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Entity
@Table(name="doctor")
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="first_surname")
    private String firstSurname;

    @Column(name="second_surname")
    private String secondSurname;

    @Column(name="specialty")
    private String specialty;

}
