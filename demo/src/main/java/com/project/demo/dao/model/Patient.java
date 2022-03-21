package com.project.demo.dao.model;


import com.project.demo.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @NotNull
    @NotEmpty(message = "Patient name cannot be empty")
    private String patientName;

    @NotNull
    @NotEmpty(message = "Patient gender cannot be empty")
    @Enumerated(EnumType.STRING)
    private Gender patientGender;

    @NotNull
    @NotEmpty(message = "Patient age cannot be empty")
    private Integer patientAge;

    @Email
    private String patientEmail;

    @Size(min=5, max=14)
    private String visitorPhoneNumber;


    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Appointment> patientAppointments;



}
