/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthsystem.Modelclasses;

/**
 *
 * @author kalana_bro
 */
public class Billing {
    private int billId;
    private String invoice;
    private int payments;
    private int balance;
    
    public Billing(){
        
    }
    public Billing(int billId,String invoice, int payments, int balance){
        this.billId = billId;
        this.invoice = invoice;
        this.payments = payments;
        this.balance = balance;
    }
    
    public int getBillId(){
        return billId;
    }
    
    public void setBillId(int billId){
        this.billId = billId;
    }
    
    public String getInvoice(){
        return invoice;
    }
    public int getPayments(){
        return payments;
    }
    public int getbalance(){
        return balance;
    }
    
    public void setInvoice(String invoice){
        this.invoice = invoice;
    }
    public void setPayments(int payments){
        this.payments = payments;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
}
