package controller;

import java.util.LinkedList;

import model.Order;
import model.SelectedFood;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Kiosk
//  @ File Name : CartController.java
//  @ Date : 2018-12-16
//  @ Author : 
//
//

public class CartController
{
	LinkedList<SelectedFood> currentCart = new LinkedList<SelectedFood>();
	
	public void addSelectedFood(SelectedFood newSelectedFood)
	{
		currentCart.add(newSelectedFood);
	}
	
	public void deleteSelectedFood(SelectedFood deleteSelected)
	{
		currentCart.remove(deleteSelected);
	}
	
	public void modifySelectedFood(SelectedFood modifySelected)
	{
		int whereModify;
		whereModify = currentCart.indexOf(modifySelected);
	
		SelectedFood tmpSelectedFood = currentCart.get(whereModify);
		
		/*
		 * the modifying logic will be updated, with view interaction
		 */
	}
}
