/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Resource;

import com.healthsystem.DAO.DoctorDAO;
import com.healthsystem.Exception.ResourceNotFoundException;
import com.healthsystem.Modelclasses.Doctor;
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
@Path("/doctor")
public class DoctorResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorResource.class);
    
    private DoctorDAO doctorDAO = new DoctorDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }
    
    @GET
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorById(@PathParam("doctorId") int doctorId) {
        
        LOGGER.info("Getting user by ID: {}", doctorId);
        Doctor doctor = doctorDAO.getDoctorById(doctorId);
        if (doctor != null) {
            return doctor;
        } else {
            throw new ResourceNotFoundException("Doctor with ID " + doctorId + " not found.");
        }
        
    }
    
    @POST
    @Path("/create/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDoctor(@PathParam("doctorId") int doctorId,Doctor doctor) {
        
        LOGGER.info("Getting user by ID: {}", doctorId);
        Doctor existingDoctor = doctorDAO.getDoctorById(doctorId);
        if (existingDoctor == null) {
            doctorDAO.addDoctor(doctor);
            throw new ResourceNotFoundException("Doctor ID "+ doctorId + " create succuessfully.");
        }else{
            throw new ResourceNotFoundException("Doctor with ID " + doctorId + " already exsist.");
        }
        
    }

    @PUT
    @Path("/update/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDoctor(@PathParam("doctorId") int doctorId, Doctor updatedDoctor) {
        
        LOGGER.info("Getting user by ID: {}", doctorId);
        Doctor existingDoctor = doctorDAO.getDoctorById(doctorId);

        if (existingDoctor != null) {
            updatedDoctor.setId(doctorId);
            doctorDAO.updateDoctor(updatedDoctor);
            throw new ResourceNotFoundException("Doctor ID "+ doctorId + " update succuessfully.");
        }else{
            throw new ResourceNotFoundException("Doctor with ID " + doctorId + " update failed.");
        }
    }

    @DELETE
    @Path("/delete/{doctorId}")
    public void deleteDoctor(@PathParam("doctorId") int doctorId) {
        
       LOGGER.info("Getting user by ID: {}", doctorId);
        Doctor doctor = doctorDAO.getDoctorById(doctorId);
        if (doctor != null) {
            doctorDAO.deleteDoctor(doctorId);
            throw new ResourceNotFoundException("Doctor ID "+ doctorId + " deleted succuessfully");
        } else {
            throw new ResourceNotFoundException("Doctor with ID " + doctorId + " not found.");
        }
        
    }
}
