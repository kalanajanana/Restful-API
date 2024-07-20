/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.DAO;

import com.healthsystem.Modelclasses.Patient;
import com.healthsystem.Modelclasses.Prescription;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO {
    private static List <Prescription> prescrips = new ArrayList<>();
    
    static{
        Patient p1 = new Patient(1,"kalana",123456789,"wfsfjj","Good","Good");
        Patient p2 = new Patient(2,"janana",123457879,"sfnfk","bad","bad");
        prescrips.add(new Prescription(p1,1,"None","2 per day","1 in morning after breakfirst, oter one in nigt before dinner","1 week"));
        prescrips.add(new Prescription(p2,2,"None","2 per day","1 in morning after breakfirst, oter one in nigt before dinner","1 week"));
    }
    public List<Prescription> getAllPrescriptions() {
        return prescrips;
    }

    public Prescription getPrescriptionById(int id) {
        for (Prescription prescription : prescrips) {
            if (prescription.getPresId() == id) {
                return prescription;
            }
        }
        return null;
    }

    public void addPrescription(Prescription prescription ) {
        prescrips.add(prescription);
    }

    public void updatePrescription(Prescription updatedPrescription) {
        for (int i = 0; i < prescrips.size(); i++) {
            Prescription prescription = prescrips.get(i);
            if (prescription.getPresId() == updatedPrescription.getPresId()) {
                prescrips.set(i, updatedPrescription);
                return;
            }
        }
    }

    public void deletePrescription(int id) {
        prescrips.removeIf(prescription -> prescription.getPresId() == id);
    }
    
}
