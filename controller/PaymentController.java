package controller;

import java.util.LinkedList;

import model.Payment;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Kiosk
//  @ File Name : PaymentController.java
//  @ Date : 2018-12-16
//  @ Author : 
//
//

public class PaymentController
{	
	public LinkedList<Payment> paymentList;
	
	PaymentController(){
		paymentList = new LinkedList<Payment>();
	}
	
	public void addPayment(Payment payment)
	{
		paymentList.add(payment);
	}
	
	public void deletePayment(Payment payment)
	{
		paymentList.remove(payment);
	}
}
