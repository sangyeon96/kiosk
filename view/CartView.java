package view;

import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.SelectedFood;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CartView extends JFrame {

	public JPanel contentPane;
	public DefaultTableModel cartModel;
	public JTable cartTable;
	public JScrollPane scroll;
	
	public JButton btnClose;
	public JButton btnMinus;
	public JButton btnPlus;
	
	private LinkedList<SelectedFood> currCart = new LinkedList();
	
	/**
	 * Create the frame.
	 */
	public CartView(LinkedList<SelectedFood> currentCart) {
		this.currCart = currentCart;
		
		setTitle("Cart");
		setBounds(100, 100, 1349, 300);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		String cartCategory[] = { "Food Name", "Count", "Flavor", "Toppings", "", "", "", "", "", "", "", "" };
		cartModel = new DefaultTableModel(cartCategory, 0);
		cartTable = new JTable(cartModel);
		scroll = new JScrollPane(cartTable);
		scroll.setBounds(10, 10, 1333, 222);
		contentPane.add(scroll);
		
		for(SelectedFood selected: currCart) {
			Vector<Object> foodVector = new Vector();
			foodVector.add(selected.name);
			foodVector.add(selected.count);
			foodVector.add(selected.flavor);
			for(String topping: selected.selectedTopping)
				foodVector.add(topping);
			
			cartModel.addRow(foodVector);
		}
		
		btnPlus = new JButton("+");
		btnPlus.setBounds(10, 244, 31, 25);
		contentPane.add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.setBounds(50, 244, 31, 25);
		contentPane.add(btnMinus);
		
		ActionListener btnCloseActionListener = new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnClose) {
					btnCloseActionPerformed();
				}
			}
		};
		btnClose = new JButton("Close");
		btnClose.setBounds(239, 241, 85, 30);
		contentPane.add(btnClose);
		btnClose.addActionListener(btnCloseActionListener);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(e.getSource() == this) {
					btnCloseActionPerformed();
				}
			}
		});
	}
	
	public void btnCloseActionPerformed() {
		CartView.this.dispose();
	}
	
	public void refresh() {
		cartModel.setNumRows(0);
		for(SelectedFood selected: currCart) {
			Vector<Object> foodVector = new Vector();
			foodVector.add(selected.name);
			foodVector.add(selected.count);
			foodVector.add(selected.flavor);
			for(String topping: selected.selectedTopping)
				foodVector.add(topping);
			
			cartModel.addRow(foodVector);
		}
	}
}
