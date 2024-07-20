/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Resource;

import com.healthsystem.DAO.PersonDAO;
import com.healthsystem.Modelclasses.Person;
import com.healthsystem.Exception.ResourceNotFoundException;
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

@Path("/person")
public class PersonResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonResource.class);
    
    private PersonDAO personDAO= new PersonDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllStudents() {
        return personDAO.getAllPersons();
    }
    
    @GET
    @Path("/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("personId") int personId) {
        
        LOGGER.info("Getting user by ID: {}", personId);
        Person person = personDAO.getPersonById(personId);
        if (person != null) {
            return person;
        } else {
            throw new ResourceNotFoundException("Person with ID " + personId + " not found.");
        }
    }
    
    @POST
    @Path("/create/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPerson(@PathParam("personId") int personId,Person person) {
        
        LOGGER.info("Getting user by ID: {}", personId);
        Person existingPerson = personDAO.getPersonById(personId);
        if (existingPerson == null) {
            personDAO.addPerson(person);
            throw new ResourceNotFoundException("Person ID "+ personId + " create succuessfully.");
        }else{
            throw new ResourceNotFoundException("Person with ID " + personId + " already exsist.");
        }
    }

    @PUT
    @Path("/update/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("personId") int personId, Person updatedPerson) {
        
        LOGGER.info("Getting user by ID: {}", personId);
        Person existingPerson = personDAO.getPersonById(personId);

        if (existingPerson != null) {
            updatedPerson.setId(personId);
            personDAO.updatePerson(updatedPerson);
            throw new ResourceNotFoundException("Person ID "+ personId + " update succuessfully.");
        }else{
            throw new ResourceNotFoundException("Person with ID " + personId + " update failed.");
        }
    }

    @DELETE
    @Path("/delete/{personId}")
    public void deletePerson(@PathParam("personId") int personId) {
        
        LOGGER.info("Getting user by ID: {}", personId);
        Person person = personDAO.getPersonById(personId);
        if (person != null) {
            personDAO.deletePerson(personId); 
            throw new ResourceNotFoundException("Person ID "+ personId + " deleted succuessfully");
        } else {
            throw new ResourceNotFoundException("Person with ID " + personId + " not found.");
        }
        
    }
    
}
