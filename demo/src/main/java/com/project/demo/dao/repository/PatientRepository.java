package com.project.demo.dao.repository;

import com.project.demo.dao.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByPatientNameLike(String patientName);
}
