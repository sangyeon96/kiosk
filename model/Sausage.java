package model;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Kiosk
//  @ File Name : Sausage.java
//  @ Date : 2018-12-16
//  @ Author : 
//
//

public class Sausage extends ToppingDecorator
{
	Sausage(){
		myStr = "Sausage";
	}
	
	public void addTopping()
	{
		myToppings.add(myStr);
		price += 1000;
	}
}
