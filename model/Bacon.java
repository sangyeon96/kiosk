package model;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Kiosk
//  @ File Name : Bacon.java
//  @ Date : 2018-12-16
//  @ Author : 
//
//

public class Bacon extends ToppingDecorator
{
	public Bacon(Food food){
		this.name = food.name;
		this.flavor = food.flavor;
		this.price = food.price;
		this.myToppings = food.myToppings;
		myStr = "Bacon";
		addTopping();
	}

	public Bacon(ToppingDecorator topping){
		this.name = topping.name;
		this.flavor = topping.flavor;
		this.price = topping.price;
		this.myToppings = topping.myToppings;
		myStr = "Bacon";
		addTopping();
	}
	
	public void addTopping()
	{
		myToppings.add(myStr);
		price += 2000;
	}
}
