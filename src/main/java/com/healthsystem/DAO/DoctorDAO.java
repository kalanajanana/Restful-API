/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.DAO;

import com.healthsystem.Modelclasses.Doctor;
import com.healthsystem.Modelclasses.Person;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private static List<Doctor> doctors = new ArrayList<>();
    
    static{
        doctors.add(new Doctor(1,"Namal",234567813,"fdrfd","OPD","Skin"));
        doctors.add(new Doctor(2,"Priyankara",12347680,"fsuie","Child","Operation"));
    }
    
    public List<Doctor> getAllDoctors() {
        return doctors;
    }
    
    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void updateDoctor(Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if (doctor.getId() == updatedDoctor.getId()) {
                doctors.set(i, updatedDoctor);
                System.out.println("Student updated: " + updatedDoctor);
                return;
            }
        }
    }

    public void deleteDoctor(int id) {
        doctors.removeIf(doctor -> doctor.getId() == id);
    }
    
}
