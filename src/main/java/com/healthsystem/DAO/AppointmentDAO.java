/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.DAO;

import com.healthsystem.Modelclasses.Appointment;
import com.healthsystem.Modelclasses.Doctor;
import com.healthsystem.Modelclasses.Patient;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private static List<Appointment> appointments = new ArrayList<>();
    
    static{
        
        Doctor doctor1 = new Doctor(3,"Namal",234567813,"fdrfd","OPD","Skin");
        Doctor doctor2 = new Doctor(4,"Priyankara",12347680,"fsuie","Child","Operation");
        
        Patient patient1 = new Patient(1,"kalana",123456789,"wfsfjj","Good","Good");
        Patient patient2 = new Patient(2,"janana",123457879,"sfnfk","bad","bad");
        
        appointments.add(new Appointment(1,"2024-03-12","10,00",patient1,doctor1));
        appointments.add(new Appointment(2,"2024-04-1","11.00",patient2,doctor2));
        

    }
    
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public Appointment getAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            if (appointment.getId() == updatedAppointment.getId()) {
                appointments.set(i, updatedAppointment);
                return;
            }
        }
    }

    public void deleteAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getId() == id);
    }
}
