/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Resource;

import com.healthsystem.DAO.AppointmentDAO;
import com.healthsystem.Exception.ResourceNotFoundException;
import com.healthsystem.Modelclasses.Appointment;
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
@Path("/appointment")
public class AppoinmentResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AppoinmentResource.class);
    
    private AppointmentDAO appoitnmentDAO = new AppointmentDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointments() {
        return appoitnmentDAO.getAllAppointments();
    }
    
    @GET
    @Path("/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("appointmentId") int appointmentId) {
        
        LOGGER.info("Getting user by ID: {}", appointmentId);
        Appointment appointment = appoitnmentDAO.getAppointmentById(appointmentId);
        if (appointment != null) {
            return appointment;
        } else {
            throw new ResourceNotFoundException("Appointment with ID " + appointmentId + " not found.");
        }
    }
    
    @POST
    @Path("/create/{appointmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAppointment(@PathParam("appointmentId") int appointmentId,Appointment appointment) {
        
        LOGGER.info("Getting user by ID: {}", appointmentId);
        Appointment existingAppointment = appoitnmentDAO.getAppointmentById(appointmentId);
        if (existingAppointment == null) {
            appoitnmentDAO.addAppointment(appointment);
            throw new ResourceNotFoundException("Appointment ID "+ appointmentId + " create succuessfully.");
        }else{
            throw new ResourceNotFoundException("Appointment with ID " + appointmentId + " already exsist.");
        }
        
    }

    @PUT
    @Path("/update/{appointmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAppointment(@PathParam("appointmentId") int appointmentId, Appointment updatedAppointment) {
        
        LOGGER.info("Getting user by ID: {}", appointmentId);
        Appointment existingAppointment = appoitnmentDAO.getAppointmentById(appointmentId);

        if (existingAppointment != null) {
            updatedAppointment.setId(appointmentId);
            appoitnmentDAO.updateAppointment(updatedAppointment);
            throw new ResourceNotFoundException("Appointment ID "+ appointmentId + " update succuessfully.");
        }else{
            throw new ResourceNotFoundException("Appointment with ID " + appointmentId + " update failed.");
        }
    }

    @DELETE
    @Path("/{appointmentId}")
    public void deleteAppointment(@PathParam("appointmentId") int appointmentId) {
        
        LOGGER.info("Getting user by ID: {}", appointmentId);
        Appointment appointment = appoitnmentDAO.getAppointmentById(appointmentId);
        
        if (appointment != null) {
            appoitnmentDAO.deleteAppointment(appointmentId);
            throw new ResourceNotFoundException("Appointment ID "+ appointmentId + " deleted succuessfully");
        } else {
            throw new ResourceNotFoundException("Appointment with ID " + appointmentId + " not found.");
        }
        
    }
}
