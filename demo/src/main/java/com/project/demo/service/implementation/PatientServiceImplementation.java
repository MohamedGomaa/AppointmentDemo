package com.project.demo.service.implementation;

import com.project.demo.dao.model.Patient;
import com.project.demo.dao.repository.PatientRepository;
import com.project.demo.service.IPatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImplementation implements IPatientService {

    private final static Logger _logger = LoggerFactory.getLogger(PatientServiceImplementation.class);

    private final PatientRepository patientRepository;

    PatientServiceImplementation(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Override
    public Page<Patient> getAllPatients(Pageable pageable){
        try {
            return patientRepository.findAll(pageable);
        }catch (Exception e){
            _logger.error(e.getMessage());
        }
        return Page.empty();
    }

    @Override
    public void addPatient(Patient patient){
        try{
            patientRepository.save(patient);
        }catch(Exception e){
            _logger.error(e.getMessage());
            throw new RuntimeException("Error happened while saving data");
        }
    }

    @Override
    public Patient getPatientByName(String patientName){
        try{
            return patientRepository.findByPatientNameLike(patientName);
        }catch(Exception e){
            throw new RuntimeException("Error happened while fetching patient..!");
        }
    }
}
