package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JOptionPane;

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
import model.Payment;
import model.PeanutButter;
import model.Pineapple;
import model.Sausage;
import model.SelectedFood;
import model.Shrimp;
import model.Spicy;
import model.Tomato;
import model.VerySpicy;
import model.WedgePotato;
import view.CartView;
import view.KioskDevice;

public class MainController {

	// Flavor objects
	static Mild mild;
	static Spicy spicy;
	static VerySpicy veryspicy;
	
	// Topp objects
	static Bacon bacon;
	static Bean bean;
	static Cheeze cheeze;
	static DoubleCheese doublecheese;
	static FishCutlet fishcutlet;
	static Guacamole guacamole;
	static JalapenoPepper jalapenopepper;
	static MozzarellaCheese mozzarellacheese;
	static PeanutButter peanutbutter;
	static Pineapple pineapple;
	static Sausage sausage;
	static Shrimp shrimp;
	static Tomato tomato;
	static WedgePotato wedgepotato;
			
	static int foodIndex = -1;
	static Food selected;
	
	static boolean flavorFlag = false;
	static boolean toppingFlag = false;
	static String currState = "";
	
	static SelectedFood doneSelect;
	static CartView cartView = null;
	
	static ActionListener cartCountPlus;
	static ActionListener cartCountMinus;
			
	public static void main(String[] args) {
		
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
		
		// open new frame
		KioskDevice Kiosk = new KioskDevice();
		Kiosk.setVisible(true);

		ActionListener FoodListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected = new Food();
				boolean status = false;
				for(int i = 0; i < 9; i++) {
					if(Kiosk.chckbxMenu[i].isSelected()) {
						foodIndex = i;
						status = true;
					}
				}
				if(status) {
					for(int j = 0; j < 9; j++) {
						if(j != foodIndex)
							Kiosk.chckbxMenu[j].setEnabled(false);
					}

					if(foodIndex != 4 && foodIndex != 6 && foodIndex != 7 && foodIndex != 8) {
						Kiosk.panelFlavor.setVisible(true);
						toppingFlag = true;
					}
					
					Iterator<Food> iterator = menuController.getMenu().iterator();
					Food tmpFood = menuController.getMenu().getFirst();
					
					while(iterator.hasNext()) {
						tmpFood = iterator.next();
						if(tmpFood.name.equals(Kiosk.chckbxMenu[foodIndex].getText())) {
							selected.name = tmpFood.name;
							selected.price = tmpFood.price;
							break;
						}
					}
				}
				else {
					for(int i = 0; i < 9; i++) {
						Kiosk.chckbxMenu[i].setEnabled(true);
					}
					Kiosk.panelBurritoTopping.setVisible(false);
					Kiosk.panelFrenchFriedTopping.setVisible(false);
					Kiosk.panelNachoChipsTopping.setVisible(false);
				}
			}
			
		};
		
		ActionListener FlavorListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = -1;
				boolean status = false;
				for(int i = 0; i < 3; i++) {
					if(Kiosk.chckbxFlavor[i].isSelected()) {
						index = i;
						status = true;
					}
				}
				if(status) {
					for(int j = 0; j < 3; j++) {
						if(j != index)
							Kiosk.chckbxFlavor[j].setEnabled(false);
					}
					
					if(foodIndex == 0 || foodIndex == 1 || foodIndex == 2) { //Food is Burrito
						Kiosk.panelBurritoTopping.setVisible(true);
					}
					else if(foodIndex == 3) { //Food is French Fried
						Kiosk.panelFrenchFriedTopping.setVisible(true);
					}
					else if(foodIndex == 5) { //Food is Nacho Chips
						Kiosk.panelNachoChipsTopping.setVisible(true);
					}
					else {
						
					}
					
					String tmpFlavor = Kiosk.chckbxFlavor[index].getText();
					switch(tmpFlavor) {
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
				else {
					for(int i = 0; i < 3; i++) {
						Kiosk.chckbxFlavor[i].setEnabled(true);
					}
				}
			}
		};
		
		ActionListener ToppListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = -1;
				boolean status = false;
				for(int i = 0; i < 14; i++) {
					if(Kiosk.chckbxTopping[i].isSelected()) {
						index = i;
						status = true;
					}
				}
				if(status) {
					String tmpTopping = Kiosk.chckbxTopping[index].getText();
					if(!flavorFlag) {
						switch(currState) {
						case "Mild":
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
					
					else { //From Second Topping
						switch(currState) {
						case "Bacon":
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
							switch(tmpTopping) {
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
			}
		};
		
		ActionListener PutinListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Kiosk.btnPutInCart) {
					doneSelect = new SelectedFood();
					if(toppingFlag) {
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
						case "Mild":
							doneSelect = buyController.execute(mild);
							break;
						case "Spicy":
							doneSelect = buyController.execute(spicy);
							break;
						case "Very Spicy":
							doneSelect = buyController.execute(veryspicy);
							break;
						default:
							System.out.println("ayeee");
							break;
						}

					}
					else {
						doneSelect = buyController.execute(selected);
					}
					doneSelect.count = 1;
					cartController.addSelectedFood(doneSelect);
					
					// add cart view visible code
					cartView = new CartView(cartController.currentCart);
					cartView.setVisible(true);
					
					// add cart view's button listener
					cartView.btnPlus.addActionListener(cartCountPlus);
					cartView.btnMinus.addActionListener(cartCountMinus);
					
					//reset KioskDevice
					flavorFlag = false;
					toppingFlag = false;
					for(int i = 0; i < 9; i++) {
						Kiosk.chckbxMenu[i].setSelected(false);
						Kiosk.chckbxMenu[i].setEnabled(true);
					}
					Kiosk.panelFood.setVisible(true);
					for(int i = 0; i < 3; i++) {
						Kiosk.chckbxFlavor[i].setSelected(false);
						Kiosk.chckbxFlavor[i].setEnabled(true);
					}
					Kiosk.panelFlavor.setVisible(false);
					for(int i = 0; i < 14; i++) {
						Kiosk.chckbxTopping[i].setSelected(false);
						Kiosk.chckbxTopping[i].setEnabled(true);
					}
					Kiosk.panelBurritoTopping.setVisible(false);
					Kiosk.panelFrenchFriedTopping.setVisible(false);
					Kiosk.panelNachoChipsTopping.setVisible(false);
				}
			}
		};
		
		cartCountPlus = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = cartView.cartTable.getSelectedRow();
				
				int whereModify;
				whereModify = cartController.currentCart.indexOf(cartController.currentCart.get(row));
			
				SelectedFood tmpSelectedFood = cartController.currentCart.get(whereModify);
				tmpSelectedFood.count++;
				
				cartView.refresh();
			}
		};
		
		cartCountMinus = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = cartView.cartTable.getSelectedRow();
				int whereModify;
				whereModify = cartController.currentCart.indexOf(cartController.currentCart.get(row));
			
				SelectedFood tmpSelectedFood = cartController.currentCart.get(whereModify);
				tmpSelectedFood.count--;
				
				cartView.refresh();
			}
		};
		
		ActionListener purchaseListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Kiosk.btnPurchase) {
					if(buyController.execute(cartController.currentCart)) {
						JOptionPane.showMessageDialog(null, "Purchase Completed.");
						//refresh currentCart
						cartController.currentCart.clear();
					}
					else {
						JOptionPane.showMessageDialog(null, "Purchase Failed. Try Again.", "Error Message", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		};
		
		// add kiosk device's button listener
		for(int i = 0; i < 9; i++) {
			Kiosk.chckbxMenu[i].addActionListener(FoodListener);
		}
		for(int i = 0; i < 3; i++) {
			Kiosk.chckbxFlavor[i].addActionListener(FlavorListener);
		}
		for(int i = 0; i < 14; i++) {
			Kiosk.chckbxTopping[i].addActionListener(ToppListener);
		}
		Kiosk.btnPutInCart.addActionListener(PutinListener);
		Kiosk.btnPurchase.addActionListener(purchaseListener);
	}

}
