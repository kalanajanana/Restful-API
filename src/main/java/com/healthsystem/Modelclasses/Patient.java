/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Modelclasses;

/**
 *
 * @author kalana_bro
 */
public class Patient extends Person {
    private String medical_History;
    private String health_Status;
    
    // Default constructor
    public Patient(){
        
    }
    
    // Constructor
    public Patient(int id, String name, int number, String address, String medical_History, String health_Status){
        super(id,name,number,address);
        this.health_Status=health_Status;
        this.medical_History=medical_History;
    }
    // Getters and setters for medical history
    public String getMedicalHistroy(){
        return medical_History;
    }
    public void setMedicalHistroy(String medical_History){
        this.medical_History=medical_History;
    }
    
    // Getters and setters for health status
    public String getHealthStatus(){
        return health_Status;
    }
    public void setHealthStatus(String health_Status){
       this.health_Status=health_Status;
    }
}
