/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Modelclasses;

/**
 *
 * @author kalana_bro
 */
public class Person {
    private int id;
    private String name;
    private int number;
    private String address;
    
    // Default constructor
    public Person(){
        
    }
    
    // constructor
    public Person(int id, String name, int number, String address){
        this.id = id;
        this.name=name;
        this.address=address;
        this.number=number;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    // getters and setters for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // getters and setters for number
    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number = number;
    }
    
    // getters and setters for address
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    
    
}
