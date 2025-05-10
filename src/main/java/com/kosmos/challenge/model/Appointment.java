package com.kosmos.challenge.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="office_number")
    private int officeNumber;

    @Column(name="appointment_date")
    private Date appointmentDate;

    @Column(name="patient_name")
    private String patientName;

}
