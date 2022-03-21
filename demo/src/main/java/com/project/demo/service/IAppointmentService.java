package com.project.demo.service;

import com.project.demo.dao.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAppointmentService {
    Page<Appointment> getAllAppointmentsByPage(Pageable pageable);

    void addAppointment(Appointment appointment);

    Page<Appointment> getAllAppointmentsForPatient(String patientName, Pageable pageable);

    Page<Appointment> getAllPatientHistoryByPatientId(Integer patientId, Pageable pageable);

    Page<Appointment> getAllAppointmentsOfToday(Pageable pageable);
}
