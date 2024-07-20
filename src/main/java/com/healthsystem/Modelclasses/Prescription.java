/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Modelclasses;

/**
 *
 * @author kalana_bro
 */
public class Prescription{
    private int presid;
    private String medication;
    private String dosage;
    private String instruction;
    private String duration;
    private Patient patient;
    
    public Prescription(){
        
    }
    public Prescription(Patient patient, int presid,String medication, String dosage, String instruction, String duration){
        this.presid = presid;
        this.patient = patient;
        this.medication = medication;
        this.dosage = dosage;
        this.instruction = instruction;
        this.duration = duration;
        
    }
    public int getPresId(){
        return presid;
    }
    public String getMedication(){
        return medication;
    }
    public String getDosage(){
        return dosage;
    }
    public String getInstruction(){
        return instruction;
    }
    public String getDuration(){
        return duration;
    }
    public Patient getPatient(){
        return patient;
    }
    
    public void setPresId(int presid){
        this.presid = presid;
    }
    public void setMedication(String medication){
        this.medication = medication;
    }
    public void setDosag(String dosage){
        this.dosage = dosage;
    }
    public void setInstruction(String instruction){
        this.instruction = instruction;
    }
    public void setDuration(String duration){
        this.duration = duration;
    }
    public void setPatient(Patient patient){
        this.patient=patient;
    }
}
