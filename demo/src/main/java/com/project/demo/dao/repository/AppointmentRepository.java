package com.project.demo.dao.repository;

import com.project.demo.dao.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Page<Appointment> findAll(Pageable pageable);

    Page<Appointment> findByAppointmentDate(Date appointmentDate, Pageable pageable);

    Page<Appointment> findByPatient_PatientNameLike(String patientName, Pageable pageable);

    Page<Appointment> findByAppointmentDateAfter(Date date, Pageable pageable);

    Page<Appointment> findByPatient_PatientId(Integer patientId, Pageable pageable);
}
