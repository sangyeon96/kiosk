package model;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Kiosk
//  @ File Name : VerySpicy.java
//  @ Date : 2018-12-16
//  @ Author : 
//
//

public class VerySpicy extends FlavorDecorator
{
	public VerySpicy(Food food){
		this.name = food.name;
		this.price = food.price;
		this.myToppings = food.myToppings;
		myStr = "Very Spicy";
		setFlavor();
	}
	
	public void setFlavor()
	{
		this.flavor = myStr;
	}
}
