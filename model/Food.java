package model;

import java.util.LinkedList;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Kiosk
//  @ File Name : Food.java
//  @ Date : 2018-12-16
//  @ Author : 
//
//

public class Food
{
	public String name;
	public String flavor;
	public int price;
	public LinkedList<String> availableTopping;
	public LinkedList<String> myToppings;
	
	public Food(){
		myToppings 		 = new LinkedList<String>();
		availableTopping = new LinkedList<String>();
	}
}
