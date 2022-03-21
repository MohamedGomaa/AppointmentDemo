package com.project.demo.service;

import com.project.demo.dao.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPatientService {
    Page<Patient> getAllPatients(Pageable pageable);

    void addPatient(Patient patient);

    Patient getPatientByName(String patientName);
}
