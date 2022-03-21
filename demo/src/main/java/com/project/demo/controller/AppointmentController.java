package com.project.demo.controller;

import com.project.demo.dao.model.Appointment;
import com.project.demo.service.IAppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private static final Logger _logger = LoggerFactory.getLogger(AppointmentController.class);

    private final IAppointmentService appointmentService;

    AppointmentController(IAppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @GetMapping("/all")
    public Page<Appointment> getAllAppointments(Pageable pageable){
        try{
            return appointmentService.getAllAppointmentsByPage(pageable);
        }catch(Exception e){
            _logger.error(e.getMessage());
            throw new RuntimeException("Error happened while fetching data");
        }
    }


    // we can cancel our appointment by setting appointmentCancelled as true and typing cancelling reason on appointmentComment
    @PostMapping("/add")
    public ResponseEntity<String> addNewAppointment(Appointment appointment){
        try{
            appointmentService.addAppointment(appointment);
            return new ResponseEntity<>("Appointment saved successfully..!",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Cannot save appointment error happened: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allToday")
    public Page<Appointment> getAllTodayAppointments(Pageable pageable){
        try{
            return appointmentService.getAllAppointmentsOfToday(pageable);
        }catch(Exception e){
            _logger.error(e.getMessage());
            throw new RuntimeException("Error happened while fetching data");
        }
    }

    @GetMapping("/allByPatientName/{patientName}")
    public Page<Appointment> getAllAppointmentsForPatientNameLike(@PathVariable("patientName") String patientName, Pageable pageable){
        try{
            return appointmentService.getAllAppointmentsForPatient(patientName,pageable);
        }catch(Exception e){
            _logger.error(e.getMessage());
            throw new RuntimeException("Error happened while fetching data");
        }
    }

    @GetMapping("/allByPatient/{patientId}")
    public Page<Appointment> getAllAppointmentsForPatient(@PathVariable("patientId") Integer patientId, Pageable pageable){
        try{
            return appointmentService.getAllPatientHistoryByPatientId(patientId,pageable);
        }catch(Exception e){
            _logger.error(e.getMessage());
            throw new RuntimeException("Error happened while fetching data");
        }
    }


}
