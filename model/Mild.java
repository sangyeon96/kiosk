package model;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Kiosk
//  @ File Name : Mild.java
//  @ Date : 2018-12-16
//  @ Author : 
//
//

public class Mild extends FlavorDecorator
{	
	public Mild(Food food){
		this.name = food.name;
		this.price = food.price;
		this.myToppings = food.myToppings;
		myStr = "Mild";
		setFlavor();
	}
	
	public void setFlavor()
	{
		this.flavor = myStr;
	}
}
