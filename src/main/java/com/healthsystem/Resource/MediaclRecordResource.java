/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Resource;

import com.healthsystem.DAO.MedicalRecordDAO;
import com.healthsystem.Exception.ResourceNotFoundException;
import com.healthsystem.Modelclasses.MedicalRecord;
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
@Path("/medicalrecords")
public class MediaclRecordResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MediaclRecordResource.class);
    
    private MedicalRecordDAO medicalDAO = new MedicalRecordDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalDAO.getAllMedicalRecords();
    }
    
    @GET
    @Path("/{medicalid}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getMedicalById(@PathParam("medicalid") int medicalid) {
        
        LOGGER.info("Getting user by ID: {}", medicalid);
        MedicalRecord medical = medicalDAO.getMedicalRecordById(medicalid);
        if (medical != null) {
            return medical;
        } else {
            throw new ResourceNotFoundException("Medical Record with ID " + medicalid + " not found.");
        }
    }
    
    @POST
    @Path("/create/{medicalid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMedical(@PathParam("medicalid") int medicalid,MedicalRecord medical) {
        
        LOGGER.info("Getting user by ID: {}", medicalid);
        MedicalRecord existingMedicalRecord = medicalDAO.getMedicalRecordById(medicalid);
        if (existingMedicalRecord == null) {
            medicalDAO.addMedicalRecord(medical);
            throw new ResourceNotFoundException("Medical Record ID "+ medicalid + " create succuessfully.");
        }else{
            throw new ResourceNotFoundException("Medical Record with ID " + medicalid + " already exsist.");
        }
        
    }

    @PUT
    @Path("/{medicalid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateMedicalRecord(@PathParam("medicalid") int medicalid, MedicalRecord updatedMedicalRecord) {
        
        LOGGER.info("Getting user by ID: {}", medicalid);
        MedicalRecord existingMedicalRecord = medicalDAO.getMedicalRecordById(medicalid);

        if (existingMedicalRecord != null) {
            updatedMedicalRecord.setMedId(medicalid);
            medicalDAO.updateMedicalRecord(updatedMedicalRecord);
            throw new ResourceNotFoundException("Medical Record ID "+ medicalid + " update succuessfully.");
        }else{
            throw new ResourceNotFoundException("Medical Record with ID " + medicalid + " update failed.");
        }
    }

    @DELETE
    @Path("/delete/{medicalid}")
    public void deleteMedicalRecord(@PathParam("medicalid") int medicalid) {
        
        LOGGER.info("Getting user by ID: {}", medicalid);
        MedicalRecord medical = medicalDAO.getMedicalRecordById(medicalid);
        if (medical != null) {
            medicalDAO.deleteMedicalRecord(medicalid);
            throw new ResourceNotFoundException("Medical Record ID "+ medicalid + " deleted succuessfully.");
        } else {
            throw new ResourceNotFoundException("Medical Record with ID " + medicalid + " not found.");
        }
        
    }
    
}
