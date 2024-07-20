/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.DAO;

import com.healthsystem.Modelclasses.Person;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author kalana_bro
 */
public class PersonDAO {
    private static List<Person> Persons = new ArrayList<>();
    
    static{
        Persons.add(new Person(1,"Kalana",0777435016, "Makandura"));
        Persons.add(new Person(2,"Sthira",0771234567, "Makandura"));
    }
    
    public List<Person> getAllPersons() {
        return Persons;
    }
    
    public Person getPersonById(int id) {
        for (Person person : Persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }
    
    public void addPerson(Person person) {
        Persons.add(person);
    }

    public void updatePerson(Person updatedPerson) {
        for (int i = 0; i < Persons.size(); i++) {
            Person person = Persons.get(i);
            if (person.getId() == updatedPerson.getId()) {
                Persons.set(i, updatedPerson);
                System.out.println("Student updated: " + updatedPerson);
                return;
            }
        }
    }

    public void deletePerson(int id) {
        Persons.removeIf(person -> person.getId() == id);
    }
    
}