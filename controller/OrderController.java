package controller;

import java.util.LinkedList;

import model.Order;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Kiosk
//  @ File Name : OrderController.java
//  @ Date : 2018-12-16
//  @ Author : 
//
//

public class OrderController
{
	public LinkedList<Order> orderList;
	
	OrderController(){
		orderList = new LinkedList<Order>();
	}
	
	public void appendOrder(Order newOrder)
	{
		orderList.addLast(newOrder);
	}
	
	public void removeOrder(Order refundOrder)
	{
		orderList.remove(refundOrder);
	}
}
