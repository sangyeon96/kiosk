package model;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Kiosk
//  @ File Name : Shrimp.java
//  @ Date : 2018-12-16
//  @ Author : 
//
//

public class Shrimp extends ToppingDecorator
{
	Shrimp(){
		myStr = "Shrimp";
	}
	
	public void addTopping()
	{
		myToppings.add(myStr);
		price += 1000;
	}
}
