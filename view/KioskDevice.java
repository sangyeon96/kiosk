package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Color;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Kiosk
//  @ File Name : KioskDevice.java
//  @ Date : 2018-12-16
//  @ Author : 
//
//

public class KioskDevice extends JFrame {

	public JPanel contentPane;
	
	public JPanel panelFood;
	public JLabel lblFood;
	public JCheckBox[] chckbxMenu = new JCheckBox[9];
	public JLabel lblChickenBurritoPrice, lblBeefBurritoPrice, lblMixBurritoPrice, lblFrenchFriedPrice, lblOnionRingPrice, lblNachoChipsPrice, lblCokePrice, lblSodaPrice, lblBeerPrice;	
	
	public JPanel panelFlavor;
	public JLabel lblFlavor;
	public JCheckBox[] chckbxFlavor = new JCheckBox[3];
	
	public JCheckBox[] chckbxTopping = new JCheckBox[14];
	
	public JPanel panelBurritoTopping;
	public JLabel lblBurritoTopping;
	public JLabel lblWedgePotatoPrice, lblDoubleCheesePrice, lblMozzarellaCheesePrice, lblJalapenoPepperPrice, lblPineapplePrice, lblShrimpPrice, lblSausagePrice, lblFishCutletPrice, lblBeanPrice;
	
	public JPanel panelFrenchFriedTopping;
	public JLabel lblFrenchFriedTopping;
	public JLabel lblBaconPrice, lblCheezePrice;

	public JPanel panelNachoChipsTopping;
	public JLabel lblNachoChipsTopping;
	public JLabel lblGuacamolePrice, lblTomatoPrice, lblPeanutButterPrice;
	
	public JButton btnAdminLogin;
	public JButton btnPutInCart;
	public JButton btnPurchase;
	
	private int i;
	
	public void showOrderResult()
	{
	
	}
		
	public void showRefundResult()
	{
	
	}
	
	/**
	 * Create the frame.
	 */
	public KioskDevice() {
		
		setTitle("Kiosk Device");
		setBounds(100, 100, 588, 387);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setBounds(456, 10, 117, 29);
		contentPane.add(btnAdminLogin);
		
		//Food Panel
		panelFood = new JPanel();
		panelFood.setBackground(Color.WHITE);
		panelFood.setLayout(null);
		panelFood.setBounds(19, 44, 193, 274);
		contentPane.add(panelFood);
		panelFood.setVisible(true);
		
		lblFood = new JLabel("Menu");
		lblFood.setBounds(80, 13, 48, 16);
		panelFood.add(lblFood);
		
		chckbxMenu[0] = new JCheckBox("Chicken Burrito");
		chckbxMenu[0].setBounds(6, 40, 129, 23);
		
		chckbxMenu[1] = new JCheckBox("Beef Burrito");
		chckbxMenu[1].setBounds(6, 65, 129, 23);
		
		chckbxMenu[2] = new JCheckBox("Mix Burrito");
		chckbxMenu[2].setBounds(6, 90, 129, 23);
		
		chckbxMenu[3] = new JCheckBox("French Fried");
		chckbxMenu[3].setBounds(6, 115, 129, 23);
		
		chckbxMenu[4] = new JCheckBox("Onion Ring");
		chckbxMenu[4].setBounds(6, 140, 129, 23);
		
		chckbxMenu[5] = new JCheckBox("Nacho Chips");
		chckbxMenu[5].setBounds(6, 165, 129, 23);
		
		chckbxMenu[6] = new JCheckBox("Coke");
		chckbxMenu[6].setBounds(6, 190, 129, 23);
		
		chckbxMenu[7] = new JCheckBox("Soda");
		chckbxMenu[7].setBounds(6, 215, 129, 23);
		
		chckbxMenu[8] = new JCheckBox("Beer");
		chckbxMenu[8].setBounds(6, 240, 129, 23);
		
		for(i = 0; i < 9; i++) {
			panelFood.add(chckbxMenu[i]);
		}
		
		lblChickenBurritoPrice = new JLabel("3000");
		lblChickenBurritoPrice.setBounds(147, 44, 39, 16);
		panelFood.add(lblChickenBurritoPrice);
		
		lblBeefBurritoPrice = new JLabel("3000");
		lblBeefBurritoPrice.setBounds(147, 69, 39, 16);
		panelFood.add(lblBeefBurritoPrice);
		
		lblMixBurritoPrice = new JLabel("3000");
		lblMixBurritoPrice.setBounds(147, 94, 39, 16);
		panelFood.add(lblMixBurritoPrice);
		
		lblFrenchFriedPrice = new JLabel("2000");
		lblFrenchFriedPrice.setBounds(147, 119, 39, 16);
		panelFood.add(lblFrenchFriedPrice);
		
		lblOnionRingPrice = new JLabel("2000");
		lblOnionRingPrice.setBounds(147, 144, 39, 16);
		panelFood.add(lblOnionRingPrice);
		
		lblNachoChipsPrice = new JLabel("2000");
		lblNachoChipsPrice.setBounds(147, 169, 39, 16);
		panelFood.add(lblNachoChipsPrice);
		
		lblCokePrice = new JLabel("1000");
		lblCokePrice.setBounds(147, 194, 39, 16);
		panelFood.add(lblCokePrice);
		
		lblSodaPrice = new JLabel("1000");
		lblSodaPrice.setBounds(147, 219, 39, 16);
		panelFood.add(lblSodaPrice);
		
		lblBeerPrice = new JLabel("2000");
		lblBeerPrice.setBounds(147, 244, 39, 16);
		panelFood.add(lblBeerPrice);
		
		//Flavor Panel
		panelFlavor = new JPanel();
		panelFlavor.setBackground(Color.WHITE);
		panelFlavor.setLayout(null);
		panelFlavor.setBounds(224, 44, 117, 121);
		contentPane.add(panelFlavor);
		panelFlavor.setVisible(false);
		
		lblFlavor = new JLabel("Flavor");
		lblFlavor.setBounds(40, 13, 48, 16);
		panelFlavor.add(lblFlavor);
		
		chckbxFlavor[0] = new JCheckBox("Mild");
		chckbxFlavor[0].setBounds(6, 40, 105, 23);
		
		chckbxFlavor[1] = new JCheckBox("Spicy");
		chckbxFlavor[1].setBounds(6, 65, 105, 23);
		
		chckbxFlavor[2] = new JCheckBox("Very Spicy");
		chckbxFlavor[2].setBounds(6, 90, 105, 23);
		
		for(i = 0; i < 3; i++) {
			panelFlavor.add(chckbxFlavor[i]);
		}
		
		//BurrittoTopping Panel
		panelBurritoTopping = new JPanel();
		panelBurritoTopping.setBackground(Color.WHITE);
		panelBurritoTopping.setLayout(null);
		panelBurritoTopping.setBounds(353, 44, 214, 274);
		contentPane.add(panelBurritoTopping);
		panelBurritoTopping.setVisible(false);
		
		lblBurritoTopping = new JLabel("Burrito Topping");
		lblBurritoTopping.setBounds(60, 13, 107, 16);
		panelBurritoTopping.add(lblBurritoTopping);
		
		chckbxTopping[0] = new JCheckBox("Wedge Potato");
		chckbxTopping[0].setBounds(6, 40, 148, 23);
		
		chckbxTopping[1] = new JCheckBox("Double Cheese");
		chckbxTopping[1].setBounds(6, 65, 148, 23);
		
		chckbxTopping[2] = new JCheckBox("Mozzarella Cheese");
		chckbxTopping[2].setBounds(6, 90, 148, 23);
		
		chckbxTopping[3] = new JCheckBox("Jalapeno Pepper");
		chckbxTopping[3].setBounds(6, 115, 148, 23);
		
		chckbxTopping[4] = new JCheckBox("Pineapple");
		chckbxTopping[4].setBounds(6, 140, 148, 23);
		
		chckbxTopping[5] = new JCheckBox("Shrimp");
		chckbxTopping[5].setBounds(6, 165, 148, 23);
		
		chckbxTopping[6] = new JCheckBox("Sausage");
		chckbxTopping[6].setBounds(6, 190, 148, 23);
		
		chckbxTopping[7] = new JCheckBox("Fish Cutlet");
		chckbxTopping[7].setBounds(6, 215, 148, 23);
		
		chckbxTopping[8] = new JCheckBox("Bean");
		chckbxTopping[8].setBounds(6, 240, 148, 23);
		
		for(i = 0; i < 9; i++) {
			panelBurritoTopping.add(chckbxTopping[i]);
		}
		
		lblWedgePotatoPrice = new JLabel("500");
		lblWedgePotatoPrice.setBounds(173, 44, 29, 16);
		panelBurritoTopping.add(lblWedgePotatoPrice);
		
		lblDoubleCheesePrice = new JLabel("500");
		lblDoubleCheesePrice.setBounds(173, 69, 29, 16);
		panelBurritoTopping.add(lblDoubleCheesePrice);
		
		lblMozzarellaCheesePrice = new JLabel("1000");
		lblMozzarellaCheesePrice.setBounds(165, 94, 38, 16);
		panelBurritoTopping.add(lblMozzarellaCheesePrice);
		
		lblJalapenoPepperPrice = new JLabel("500");
		lblJalapenoPepperPrice.setBounds(173, 119, 29, 16);
		panelBurritoTopping.add(lblJalapenoPepperPrice);
		
		lblPineapplePrice = new JLabel("500");
		lblPineapplePrice.setBounds(173, 144, 29, 16);
		panelBurritoTopping.add(lblPineapplePrice);
		
		lblShrimpPrice = new JLabel("1000");
		lblShrimpPrice.setBounds(165, 169, 38, 16);
		panelBurritoTopping.add(lblShrimpPrice);
		
		lblSausagePrice = new JLabel("1000");
		lblSausagePrice.setBounds(165, 194, 38, 16);
		panelBurritoTopping.add(lblSausagePrice);
		
		lblFishCutletPrice = new JLabel("1000");
		lblFishCutletPrice.setBounds(165, 219, 38, 16);
		panelBurritoTopping.add(lblFishCutletPrice);
		
		lblBeanPrice = new JLabel("500");
		lblBeanPrice.setBounds(173, 244, 29, 16);
		panelBurritoTopping.add(lblBeanPrice);
		
		//FrenchFriedTopping Panel
		panelFrenchFriedTopping = new JPanel();
		panelFrenchFriedTopping.setBackground(Color.WHITE);
		panelFrenchFriedTopping.setLayout(null);
		panelFrenchFriedTopping.setBounds(353, 44, 214, 274);
		contentPane.add(panelFrenchFriedTopping);
		panelFrenchFriedTopping.setVisible(false);
		
		lblFrenchFriedTopping = new JLabel("French Fried Topping");
		lblFrenchFriedTopping.setBounds(44, 12, 134, 16);
		panelFrenchFriedTopping.add(lblFrenchFriedTopping);
		
		chckbxTopping[9] = new JCheckBox("Bacon");
		chckbxTopping[9].setBounds(6, 40, 128, 23);
		
		chckbxTopping[10] = new JCheckBox("Cheeze");
		chckbxTopping[10].setBounds(6, 65, 128, 23);
		
		for(i = 9; i < 11; i++) {
			panelFrenchFriedTopping.add(chckbxTopping[i]);
		}
		
		lblBaconPrice = new JLabel("2000");
		lblBaconPrice.setBounds(145, 44, 49, 16);
		panelFrenchFriedTopping.add(lblBaconPrice);
		
		lblCheezePrice = new JLabel("1000");
		lblCheezePrice.setBounds(146, 69, 48, 16);
		panelFrenchFriedTopping.add(lblCheezePrice);
		
		//NachoChipsTopping Panel
		panelNachoChipsTopping = new JPanel();
		panelNachoChipsTopping.setBackground(Color.WHITE);
		panelNachoChipsTopping.setLayout(null);
		panelNachoChipsTopping.setBounds(353, 44, 214, 274);
		contentPane.add(panelNachoChipsTopping);
		panelNachoChipsTopping.setVisible(false);
		
		lblNachoChipsTopping = new JLabel("Nacho Chips Topping");
		lblNachoChipsTopping.setBounds(39, 12, 142, 16);
		panelNachoChipsTopping.add(lblNachoChipsTopping);
		
		chckbxTopping[11] = new JCheckBox("Guacamole");
		chckbxTopping[11].setBounds(6, 40, 148, 23);
		
		chckbxTopping[12] = new JCheckBox("Tomato");
		chckbxTopping[12].setBounds(6, 65, 148, 23);
		
		chckbxTopping[13] = new JCheckBox("Peanut Butter");
		chckbxTopping[13].setBounds(6, 90, 148, 23);
		
		for(i = 11; i < 14; i++) {
			panelNachoChipsTopping.add(chckbxTopping[i]);
		}
		
		lblGuacamolePrice = new JLabel("1500");
		lblGuacamolePrice.setBounds(164, 44, 38, 16);
		panelNachoChipsTopping.add(lblGuacamolePrice);
		
		lblTomatoPrice = new JLabel("500");
		lblTomatoPrice.setBounds(173, 69, 29, 16);
		panelNachoChipsTopping.add(lblTomatoPrice);
		
		lblPeanutButterPrice = new JLabel("500");
		lblPeanutButterPrice.setBounds(173, 94, 38, 16);
		panelNachoChipsTopping.add(lblPeanutButterPrice);
		
		btnPutInCart = new JButton("Put In Cart");
		btnPutInCart.setBounds(15, 330, 117, 29);
		contentPane.add(btnPutInCart);
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(122, 330, 117, 29);
		contentPane.add(btnPurchase);
	}
}
