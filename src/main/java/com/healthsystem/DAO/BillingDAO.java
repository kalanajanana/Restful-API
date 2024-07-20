/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.DAO;

import com.healthsystem.Modelclasses.Billing;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {
    private static List<Billing> billes = new ArrayList<>();
    
    static{
        billes.add(new Billing(1, "B0012", 1200,300));
        billes.add(new Billing(2, "B0013", 1400,100));
        
    }
    public List<Billing> getAllBilles() {
        return billes;
    }

    public Billing getBillesById(int id) {
        for (Billing bill : billes) {
            if (bill.getBillId() == id) {
                return bill;
            }
        }
        return null;
    }

    public void addBilles(Billing bill ) {
        billes.add(bill);
    }

    public void updateBilles(Billing updatedBill) {
        for (int i = 0; i < billes.size(); i++) {
            Billing bill = billes.get(i);
            if (bill.getBillId() == updatedBill.getBillId()) {
                billes.set(i, updatedBill);
                return;
            }
        }
    }

    public void deleteBilles(int id) {
        billes.removeIf(medical -> medical.getBillId() == id);
    }
}
