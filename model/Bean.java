package model;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Kiosk
//  @ File Name : Bean.java
//  @ Date : 2018-12-16
//  @ Author : 
//
//

public class Bean extends ToppingDecorator
{
	public Bean(Food food){
		this.myToppings = food.myToppings;
		this.price = food.price;
		myStr = "Bean";
		addTopping();
	}
	
	public void addTopping()
	{
		myToppings.add(myStr);
		price += 500;
	}
}
