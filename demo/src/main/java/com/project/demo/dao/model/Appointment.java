package com.project.demo.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    @NotNull
    @NotEmpty(message = "Appointment date must specifies")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentDate;

    private Boolean appointmentCanceled;

    private String appointmentComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patientId")
    private Patient patient;

}
