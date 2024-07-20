/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Modelclasses;

/**
 *
 * @author kalana_bro
 */
public class Doctor extends Person{
    private String Professinals;
    private String Specialization;
    
    // Defualt constructor
    public Doctor(){
        
    }
    
    // Constructor
    public Doctor(int id, String name, int number, String address, String Professinals, String Specialization){
        super(id, name, number, address);
        this.Professinals=Professinals;
        this.Specialization=Specialization;
    }
    
    // Getters and setters for professinals
    public String getProfessinals(){
        return Professinals;
    }
    public void setProfessinals(String Professinals){
        this.Professinals=Professinals;
    }
    
    // Getters and setters for Specailization
    public String getSpecialization(){
        return Specialization;
    }
    public void setSpecialization(String Specialization){
        this.Specialization=Specialization;
    }
}
