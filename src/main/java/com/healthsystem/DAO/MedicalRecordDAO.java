/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.DAO;

import com.healthsystem.Modelclasses.MedicalRecord;
import com.healthsystem.Modelclasses.Patient;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDAO {
    private static List <MedicalRecord> medicals = new ArrayList<>();
    
    static{
        Patient patient1 = new Patient(1,"kalana",123456789,"wfsfjj","Good","Good");
        Patient patient2 = new Patient(2,"janana",123457879,"sfnfk","bad","bad");
        
        medicals.add(new MedicalRecord(4,patient1,"Good","dsf","dds","fggh"));
        medicals.add(new MedicalRecord(5,patient2,"Bad","fgh","asf","nht"));
        
    }
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicals;
    }

    public MedicalRecord getMedicalRecordById(int id) {
        for (MedicalRecord medical : medicals) {
            if (medical.getMedId() == id) {
                return medical;
            }
        }
        return null;
    }

    public void addMedicalRecord(MedicalRecord medical ) {
        medicals.add(medical);
    }

    public void updateMedicalRecord(MedicalRecord updatedMedical) {
        for (int i = 0; i < medicals.size(); i++) {
            MedicalRecord medical = medicals.get(i);
            if (medical.getMedId() == updatedMedical.getMedId()) {
                medicals.set(i, updatedMedical);
                return;
            }
        }
    }

    public void deleteMedicalRecord(int id) {
        medicals.removeIf(medical -> medical.getMedId() == id);
    }
}
