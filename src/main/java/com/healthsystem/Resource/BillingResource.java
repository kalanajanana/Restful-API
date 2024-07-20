/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Resource;

import com.healthsystem.DAO.BillingDAO;
import com.healthsystem.Exception.ResourceNotFoundException;
import com.healthsystem.Modelclasses.Billing;
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
@Path("/billing")
public class BillingResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BillingResource.class);
    
    private BillingDAO billingDAO = new BillingDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getAllBilles() {
        return billingDAO.getAllBilles();
    }
    
    @GET
    @Path("/{bilingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBillesById(@PathParam("bilingId") int bilingId) {
        
        LOGGER.info("Getting user by ID: {}", bilingId);
        Billing billing = billingDAO.getBillesById(bilingId);
        if (billing != null) {
            return billing;
        } else {
            throw new ResourceNotFoundException("Billes with ID " + bilingId + " not found.");
        }
    }
    
    @POST
    @Path("/create/{bilingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBilles(@PathParam("bilingId") int bilingId,Billing billes) {
        
        LOGGER.info("Getting user by ID: {}", bilingId);
        Billing existingBilles = billingDAO.getBillesById(bilingId);
        if (existingBilles == null) {
            billingDAO.addBilles(billes);
            throw new ResourceNotFoundException("Billes ID "+ bilingId + " create succuessfully.");
        }else{
            throw new ResourceNotFoundException("Billes with ID " + bilingId + " already exsist.");
        }
        
    }

    @PUT
    @Path("/update/{bilingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBilles(@PathParam("bilingId") int bilingId, Billing updatedBilles) {
        
        LOGGER.info("Getting user by ID: {}", bilingId);
        Billing existingBilles = billingDAO.getBillesById(bilingId);

        if (existingBilles != null) {
            updatedBilles.setBillId(bilingId);
            billingDAO.updateBilles(updatedBilles);
            throw new ResourceNotFoundException("Billes ID "+ bilingId + " update succuessfully.");
        }else{
            throw new ResourceNotFoundException("Billes with ID " + bilingId + " update exsist.");
        }
    }

    @DELETE
    @Path("/{bilingId}")
    public void deleteBills(@PathParam("bilingId") int bilingId) {
        
        LOGGER.info("Getting user by ID: {}", bilingId);
        Billing billing = billingDAO.getBillesById(bilingId);
        if (billing != null) {
            billingDAO.deleteBilles(bilingId);
            throw new ResourceNotFoundException("Billes ID "+ bilingId + " deleted succuessfully");
        } else {
            throw new ResourceNotFoundException("Billes with ID " + bilingId + " not found.");
        }
        
    }
}
