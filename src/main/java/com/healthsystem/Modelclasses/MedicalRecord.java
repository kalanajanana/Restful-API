/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Modelclasses;

/**
 *
 * @author kalana_bro
 */
public class MedicalRecord{
    private int medId;
    private Patient patient;
    private String medicalInfor;
    private String covering_diagnoses;
    private String treatments;
    private String otherData;
    
    public MedicalRecord(){
        
    }
    
    public MedicalRecord(int medId,Patient patient, String medicalInfor, String covering_diagnoses, String treatments, String otherData ){
        this.medId = medId;
        this.patient = patient;
        this.covering_diagnoses = covering_diagnoses;
        this.medicalInfor = medicalInfor;
        this.otherData = otherData;
        this.treatments = treatments;
    }
    
    public Patient getPatient(){
        return patient;
    }
    public void setPatient(Patient patient){
        this.patient = patient;
    }
    
   public int getMedId(){
       return medId;
   } 
   public String getMedicalInfor(){
       return medicalInfor;
   }
   public String getCoveringDiagnoses(){
       return covering_diagnoses;
   }
   public String getTreatments(){
       return treatments;
   }
   public String getOtherData(){
       return otherData;
   }
   
   public void setMedId(int medId){
       this.medId = medId;
   }
   public void setMedicalInfor(String medicalInfor){
       this.medicalInfor = medicalInfor;
   }
   public void setCoveringDiagnoses(String covering_diagnoses){
       this.covering_diagnoses = covering_diagnoses;
   }
   public void setTreatments(String treatments){
       this.treatments = treatments;
   }
   public void setOtherData(String otherData){
       this.otherData = otherData;
   }
}


