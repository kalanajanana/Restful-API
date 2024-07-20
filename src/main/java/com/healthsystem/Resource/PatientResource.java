/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Resource;

import com.healthsystem.DAO.PatientDAO;
import com.healthsystem.Exception.ResourceNotFoundException;
import com.healthsystem.Modelclasses.Patient;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author kalana_bro
 */
@Path("/patient")
public class PatientResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientResource.class);
    
    private PatientDAO patientDAO = new PatientDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }
    
    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientById(@PathParam("patientId") int patientId) {
        
        LOGGER.info("Getting user by ID: {}", patientId);
        Patient patient = patientDAO.getPatientById(patientId);
        if (patient != null) {
            return patient;
        } else {
            throw new ResourceNotFoundException("Patient with ID " + patientId + " not found.");
        }
    }
    
    @POST
    @Path("/create/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPerson(@PathParam("patientId") int patientId,Patient patient) {
        
        LOGGER.info("Getting user by ID: {}", patientId);
        Patient existingPatient = patientDAO.getPatientById(patientId);
        if (existingPatient == null) {
            patientDAO.addPatient(patient);
            throw new ResourceNotFoundException("Patient ID "+ patientId + " create succuessfully.");
        }else{
            throw new ResourceNotFoundException("Patient with ID " + patientId + " already exsist.");
        }
        
    }

    @PUT
    @Path("/update/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePatient(@PathParam("patientId") int patientId, Patient updatedPatient) {
        
        LOGGER.info("Getting user by ID: {}", patientId);
        Patient existingPatient = patientDAO.getPatientById(patientId);

        if (existingPatient != null) {
            updatedPatient.setId(patientId);
            patientDAO.updatePatient(updatedPatient);
            throw new ResourceNotFoundException("Patient ID "+ patientId + " update succuessfully.");
        }else{
            throw new ResourceNotFoundException("Patient with ID " + patientId + " update failed.");
        }
    }

    @DELETE
    @Path("/delete/{patientId}")
    public void deletePatient(@PathParam("patientId") int patientId) {
        
        LOGGER.info("Getting user by ID: {}", patientId);
        Patient patient = patientDAO.getPatientById(patientId);
        if (patient != null) {
            patientDAO.deletePatient(patientId);
            throw new ResourceNotFoundException("Patient with ID " + patientId + " deleted succuessfully.");
        } else {
            throw new ResourceNotFoundException("Patient with ID " + patientId + " not found.");
        }
        
    }
    
}
