/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Resource;

import com.healthsystem.DAO.PrescriptionDAO;
import com.healthsystem.Exception.ResourceNotFoundException;
import com.healthsystem.Modelclasses.Prescription;
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
@Path("/prescription")
public class PrescriptionResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionResource.class);
    
    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getAllPrescriptions() {
        return prescriptionDAO.getAllPrescriptions();
    }
    
    @GET
    @Path("/{prescriptionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prescription getPrescriptionById(@PathParam("prescriptionId") int prescriptionId) {
        
        LOGGER.info("Getting user by ID: {}", prescriptionId);
        Prescription prescription = prescriptionDAO.getPrescriptionById(prescriptionId);
        if (prescription != null) {
            return prescription;
        } else {
            throw new ResourceNotFoundException("Prescription with ID " + prescriptionId + " not found.");
        }
    }
    
    @POST
    @Path("/create/{prescriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPrescription(@PathParam("prescriptionId") int prescriptionId,Prescription prescription) {
        
        LOGGER.info("Getting user by ID: {}", prescriptionId);
        Prescription existingPrescription = prescriptionDAO.getPrescriptionById(prescriptionId);
        
        if (existingPrescription == null) {
            prescriptionDAO.addPrescription(prescription);
            throw new ResourceNotFoundException("Prescription ID "+ prescriptionId + " create succuessfully.");
        }else{
            throw new ResourceNotFoundException("Prescription with ID " + prescriptionId + " already exsist.");
        }
        
        
    }

    @PUT
    @Path("/update/{prescriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePrescription(@PathParam("prescriptionId") int prescriptionId, Prescription updatedPrescription) {
        
        LOGGER.info("Getting user by ID: {}", prescriptionId);
        Prescription existingPrescription = prescriptionDAO.getPrescriptionById(prescriptionId);

        if (existingPrescription != null) {
            updatedPrescription.setPresId(prescriptionId);
            prescriptionDAO.updatePrescription(updatedPrescription);
            throw new ResourceNotFoundException("Prescription ID "+ prescriptionId + " update succuessfully.");
        }else{
            throw new ResourceNotFoundException("Prescription with ID " + prescriptionId + " update failed.");
        }
    }

    @DELETE
    @Path("/delete/{prescriptionId}")
    public void deletePrescription(@PathParam("prescriptionId") int prescriptionId) {
        
        LOGGER.info("Getting user by ID: {}", prescriptionId);
        Prescription prescription = prescriptionDAO.getPrescriptionById(prescriptionId);
        if (prescription != null) {
            prescriptionDAO.deletePrescription(prescriptionId);
            throw new ResourceNotFoundException("Prescription ID "+ prescriptionId + " deleted succuessfully");
        } else {
            throw new ResourceNotFoundException("Prescription with ID " + prescriptionId + " not found.");
        }
        
    }
    
}
