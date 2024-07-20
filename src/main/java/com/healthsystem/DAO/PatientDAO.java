/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.DAO;

import com.healthsystem.Modelclasses.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO{
    private static List<Patient> patients = new ArrayList<>();
    
    static{
        patients.add(new Patient(1,"kalana",123456789,"wfsfjj","Good","Good"));
        patients.add(new Patient(2,"janana",123457879,"sfnfk","bad","bad"));
    }
    public List<Patient> getAllPatients() {
        return patients;
    }

    public Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }
    
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void updatePatient(Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if (patient.getId() == updatedPatient.getId()) {
                patients.set(i, updatedPatient);
                return;
            }
        }
    }

    public void deletePatient(int id) {
        patients.removeIf(patient -> patient.getId() == id);
    }
}
