package com.project.demo.service.implementation;

import com.project.demo.dao.model.Appointment;
import com.project.demo.dao.repository.AppointmentRepository;
import com.project.demo.service.IAppointmentService;
import com.project.demo.service.IPatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;

@Service
public class AppointmentServiceImplementation implements IAppointmentService {
    private static final Logger _logger = LoggerFactory.getLogger(AppointmentServiceImplementation.class);

    private final AppointmentRepository appointmentRepository;
    private final IPatientService patientService;

    AppointmentServiceImplementation(AppointmentRepository appointmentRepository, IPatientService patientService){
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
    }

    @Override
    public Page<Appointment> getAllAppointmentsByPage(Pageable pageable){
        try{
            return appointmentRepository.findAll(pageable);
        }catch(Exception e){
            _logger.error(e.getMessage());
        }
        return Page.empty();
    }

    @Override
    public void addAppointment(Appointment appointment){
        try{
            appointmentRepository.save(appointment);
        }catch(Exception e){
            _logger.error(e.getMessage());
            throw new RuntimeException("Error happened while saving data");
        }
    }

    @Override
    public Page<Appointment> getAllAppointmentsForPatient(String patientName, Pageable pageable){
        try{
            return appointmentRepository.findByPatient_PatientNameLike(patientName, pageable);
        }catch(Exception e){
            throw new RuntimeException("Error on fetching data...!");
        }
    }

    @Override
    public Page<Appointment> getAllPatientHistoryByPatientId(Integer patientId, Pageable pageable){
        try{
            return appointmentRepository.findByPatient_PatientId(patientId, pageable);
        }catch(Exception e){
            throw new RuntimeException("Error on fetching data...!");
        }
    }

    @Override
    public Page<Appointment> getAllAppointmentsOfToday(Pageable pageable){
        try {
            LocalDate localDate = LocalDate.now();
            return appointmentRepository.findByAppointmentDateAfter(Timestamp.valueOf(localDate.atStartOfDay()), pageable);
        }catch(Exception e){
            throw new RuntimeException("Error happened while fetching data ...!");
        }
    }
}