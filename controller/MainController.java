package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import model.Bacon;
import model.Bean;
import model.Cheeze;
import model.DoubleCheese;
import model.FishCutlet;
import model.Food;
import model.Guacamole;
import model.JalapenoPepper;
import model.Mild;
import model.MozzarellaCheese;
import model.PeanutButter;
import model.Pineapple;
import model.Sausage;
import model.SelectedFood;
import model.Shrimp;
import model.Spicy;
import model.Tomato;
import model.VerySpicy;
import model.WedgePotato;
import view.KioskDevice;

public class MainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// set Food Data
		Food[] foodArr = new Food[9];
		
		for(int i = 0; i < 9; i++) {
			foodArr[i] = new Food();
		}
		
		foodArr[0].name = "Chicken Burrito";
		foodArr[0].price = 3000;
		foodArr[1].name = "Beef Burrito";
		foodArr[1].price = 3000;
		foodArr[2].name = "Mix Burrito";
		foodArr[2].price = 3000;
		foodArr[3].name = "French Fried";
		foodArr[3].price = 2000;
		foodArr[4].name = "Onion Ring";
		foodArr[4].price = 2000;
		foodArr[5].name = "Nacho Chips";
		foodArr[5].price = 2000;
		foodArr[6].name = "Coke";
		foodArr[6].price = 1000;
		foodArr[7].name = "Soda";
		foodArr[7].price = 1000;
		foodArr[8].name = "Beer";
		foodArr[8].price = 2000;
		
		Buy buyController = new Buy();
		CartController cartController = new CartController();
		
		// add Foods to menu
		MenuController menuController = new MenuController();
		for(int i = 0; i < 9; i++) {
			menuController.addFood(foodArr[i]);
		}
		
		// Flavor objects
		Mild mild;
		Spicy spicy;
		VerySpicy veryspicy;
		
		// Topp objects
		Bacon bacon;
		Bean bean;
		Cheeze cheeze;
		DoubleCheese doublecheese;
		FishCutlet fishcutlet;
		Guacamole guacamole;
		JalapenoPepper jalapenopepper;
		MozzarellaCheese mozzarellacheese;
		PeanutButter peanutbutter;
		Pineapple pineapple;
		Sausage sausage;
		Shrimp shrimp;
		Tomato tomato;
		WedgePotato wedgepotato;
		
		boolean flavorFlag = false;
		
		// open new frame
		KioskDevice Kiosk = new KioskDevice();
		
		Food selected = new Food();
		String currState = "";
		
		ActionListener FoodListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Iterator<Food> iterator = menuController.getMenu().iterator();
				Food tmpFood = menuController.getMenu().getFirst();
				
				while(iterator.hasNext()) {
					tmpFood = iterator.next();
					if(tmpFood.name.equals(------------------)) {
						selected.name = tmpFood.name;
						selected.price = tmpFood.price;
						break;
					}
				}
			}
			
		};

		ActionListener FlavorListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(checkbox that selected) {
				case "Mild":
					currState = "Mild";
					mild = new Mild(selected);
					break;
				case "Spicy":
					currState = "Spicy";
					spicy = new Spicy(selected);
					break;
				case "Very Spicy":
					currState = "Very Spicy";
					veryspicy = new VerySpicy(selected);
					break;
					
				}
			}
			
		};
		
		ActionListener ToppListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!flavorFlag) {
					switch(currState) {
					case "Mild":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(mild);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(mild);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(mild);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(mild);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(mild);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(mild);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(mild);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(mild);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(mild);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(mild);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(mild);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(mild);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(mild);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(mild);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Spicy":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(spicy);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(spicy);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(spicy);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(spicy);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(spicy);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(spicy);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(spicy);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(spicy);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(spicy);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(spicy);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(spicy);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(spicy);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(spicy);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(spicy);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Very Spicy":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(veryspicy);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(veryspicy);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(veryspicy);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(veryspicy);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(veryspicy);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(veryspicy);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(veryspicy);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(veryspicy);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(veryspicy);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(veryspicy);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(veryspicy);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(veryspicy);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(veryspicy);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(veryspicy);
							currState = "Wedge Potato";
							break;
						}
						break;
					}
					
					flavorFlag = true;
				}
				else {
					switch(currState) {
					case "Bacon":
						switch(checkbox that selected) {
						case "Bacon":
							break;
						case "Bean":
							bean = new Bean(bacon);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(bacon);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(bacon);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(bacon);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(bacon);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(bacon);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(bacon);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(bacon);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(bacon);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(bacon);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(bacon);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(bacon);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(bacon);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Bean":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(bean);
							currState = "Bacon";
							break;
						case "Bean":
							break;
						case "Cheeze":
							cheeze = new Cheeze(bean);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(bean);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(bean);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(bean);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(bean);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(bean);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(bean);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(bean);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(bean);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(bean);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(bean);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(bean);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Cheeze":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(cheeze);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(cheeze);
							currState = "Bean";
						case "Cheeze":
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(cheeze);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(cheeze);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(cheeze);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(cheeze);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(cheeze);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(cheeze);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(cheeze);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(cheeze);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(cheeze);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(cheeze);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(cheeze);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Double Cheese":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(doublecheese);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(doublecheese);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(doublecheese);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(doublecheese);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(doublecheese);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(doublecheese);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(doublecheese);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(doublecheese);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(doublecheese);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(doublecheese);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(doublecheese);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(doublecheese);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(doublecheese);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Fish Cutlet":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(fishcutlet);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(fishcutlet);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(fishcutlet);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(fishcutlet);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							break;
						case "Guacamole":
							guacamole = new Guacamole(fishcutlet);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(fishcutlet);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(fishcutlet);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(fishcutlet);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(fishcutlet);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(fishcutlet);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(fishcutlet);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(fishcutlet);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(fishcutlet);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Guacamole":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(guacamole);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(guacamole);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(guacamole);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(guacamole);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(guacamole);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(guacamole);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(guacamole);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(guacamole);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(guacamole);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(guacamole);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(guacamole);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(guacamole);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(guacamole);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Jalapeno Pepper":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(jalapenopepper);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(jalapenopepper);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(jalapenopepper);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(jalapenopepper);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(jalapenopepper);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(jalapenopepper);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(jalapenopepper);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(jalapenopepper);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(jalapenopepper);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(jalapenopepper);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(jalapenopepper);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(jalapenopepper);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(jalapenopepper);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Mozzarella Cheese":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(mozzarellacheese);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(mozzarellacheese);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(mozzarellacheese);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(mozzarellacheese);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(mozzarellacheese);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(mozzarellacheese);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(mozzarellacheese);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(mozzarellacheese);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(mozzarellacheese);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(mozzarellacheese);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(mozzarellacheese);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(mozzarellacheese);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(mozzarellacheese);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Peanut Butter":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(peanutbutter);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(peanutbutter);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(peanutbutter);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(peanutbutter);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(peanutbutter);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(peanutbutter);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(peanutbutter);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(peanutbutter);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							break;
						case "Pineapple":
							pineapple = new Pineapple(peanutbutter);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(peanutbutter);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(peanutbutter);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(peanutbutter);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(peanutbutter);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Pineapple":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(pineapple);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(pineapple);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(pineapple);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(pineapple);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(pineapple);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(pineapple);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(pineapple);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(pineapple);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(pineapple);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							break;
						case "Sausage":
							sausage = new Sausage(pineapple);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(pineapple);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(pineapple);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(pineapple);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Sausage":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(sausage);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(sausage);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(sausage);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(sausage);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(sausage);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(sausage);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(sausage);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(sausage);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(sausage);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(sausage);
							currState = "Pineapple";
							break;
						case "Sausage":
							break;
						case "Shrimp":
							shrimp = new Shrimp(sausage);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(sausage);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(sausage);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Shrimp":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(shrimp);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(shrimp);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(shrimp);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(shrimp);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(shrimp);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(shrimp);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(shrimp);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(shrimp);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(shrimp);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(shrimp);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(shrimp);
							currState = "Sausage";
							break;
						case "Shrimp":
							break;
						case "Tomato":
							tomato = new Tomato(shrimp);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(shrimp);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Tomato":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(tomato);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(tomato);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(tomato);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(tomato);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(tomato);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(tomato);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(tomato);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(tomato);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(tomato);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(tomato);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(tomato);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(tomato);
							currState = "Shrimp";
							break;
						case "Tomato":
							break;
						case "Wedge Potato":
							wedgepotato = new WedgePotato(tomato);
							currState = "Wedge Potato";
							break;
						}
						break;
					case "Wedge Potato":
						switch(checkbox that selected) {
						case "Bacon":
							bacon = new Bacon(wedgepotato);
							currState = "Bacon";
							break;
						case "Bean":
							bean = new Bean(wedgepotato);
							currState = "Bean";
							break;
						case "Cheeze":
							cheeze = new Cheeze(wedgepotato);
							currState = "Cheeze";
							break;
						case "Double Cheese":
							doublecheese = new DoubleCheese(wedgepotato);
							currState = "Double Cheese";
							break;
						case "Fish Cutlet":
							fishcutlet = new FishCutlet(wedgepotato);
							currState = "Fish Cutlet";
							break;
						case "Guacamole":
							guacamole = new Guacamole(wedgepotato);
							currState = "Guacamole";
							break;
						case "Jalapeno Pepper":
							jalapenopepper = new JalapenoPepper(wedgepotato);
							currState = "Jalapeno Pepper";
							break;
						case "Mozzarella Cheese":
							mozzarellacheese = new MozzarellaCheese(wedgepotato);
							currState = "Mozzarella Cheese";
							break;
						case "Peanut Butter":
							peanutbutter = new PeanutButter(wedgepotato);
							currState = "Peanut Butter";
							break;
						case "Pineapple":
							pineapple = new Pineapple(wedgepotato);
							currState = "Pineapple";
							break;
						case "Sausage":
							sausage = new Sausage(wedgepotato);
							currState = "Sausage";
							break;
						case "Shrimp":
							shrimp = new Shrimp(wedgepotato);
							currState = "Shrimp";
							break;
						case "Tomato":
							tomato = new Tomato(wedgepotato);
							currState = "Tomato";
							break;
						case "Wedge Potato":
							break;
						}
						break;
					}
				}
			}
		};
		
		SelectedFood doneSelect = new SelectedFood();
		
		ActionListener PutinListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(currState) {
				case "Bacon":
					doneSelect = buyController.execute(bacon);
					break;
				case "Bean":
					doneSelect = buyController.execute(bean);
					break;
				case "Cheeze":
					doneSelect = buyController.execute(cheeze);
					break;
				case "Double Cheese":
					doneSelect = buyController.execute(doublecheese);
					break;
				case "Fish Cutlet":
					doneSelect = buyController.execute(fishcutlet);
					break;
				case "Guacamole":
					doneSelect = buyController.execute(guacamole);
					break;
				case "Jalapeno Pepper":
					doneSelect = buyController.execute(jalapenopepper);
					break;
				case "Mozzarella Cheese":
					doneSelect = buyController.execute(mozzarellacheese);
					break;
				case "Peanut Butter":
					doneSelect = buyController.execute(peanutbutter);
					break;
				case "Pineapple":
					doneSelect = buyController.execute(pineapple);
					break;
				case "Sausage":
					doneSelect = buyController.execute(sausage);
					break;
				case "Shrimp":
					doneSelect = buyController.execute(shrimp);
					break;
				case "Tomato":
					doneSelect = buyController.execute(tomato);
					break;
				case "Wedge Potato":
					doneSelect = buyController.execute(wedgepotato);
					break;
				}
				cartController.addSelectedFood(doneSelect);
				
				// add cart view visible code
			}
		};
		
		ActionListener cartCountPlus = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int whereModify;
				whereModify = cartController.currentCart.indexOf(this panel's SelectedFood);
			
				SelectedFood tmpSelectedFood = currentCart.get(whereModify);
				tmpSelectedFood.count++;
			}
		};
		
		ActionListener cartCountMinus = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int whereModify;
				whereModify = cartController.currentCart.indexOf(this panel's SelectedFood);
			
				SelectedFood tmpSelectedFood = currentCart.get(whereModify);
				tmpSelectedFood.count--;
			}
		};
		
		ActionListener purchase = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyController.execute(cartController.currentCart);
			}
		};
		
		// add button listener regist codes here
	}

}
