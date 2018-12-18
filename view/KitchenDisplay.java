package view;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Order;
import model.SelectedFood;

public class KitchenDisplay extends JFrame {

	public JPanel contentPane;
	public DefaultTableModel kitchenModel;
	public JTable kitchenTable;
	public JScrollPane scroll;
	
	public boolean refundACK;


	/**
	 * Create the frame.
	 */
	public KitchenDisplay() {
		setTitle("Kitchen View");
		setBounds(100, 100, 479, 346);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		String kitchenCategory[] = { "Date", "Order Num", "Price", "Method of Payment" }; 
		kitchenModel = new DefaultTableModel(kitchenCategory, 0);
		kitchenTable = new JTable(kitchenModel);
		scroll = new JScrollPane(kitchenTable);
		scroll.setBounds(10, 10, 454, 300);
		contentPane.add(scroll);
	}
	
	public void displayOrder(LinkedList<Order> orderList)
	{
		kitchenModel.setNumRows(0);
		for(Order tmpOrder: orderList) {
			Vector<Object> orderVector = new Vector();
			SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
			String stringDate = dateFormat.format(tmpOrder.date);
			orderVector.add(stringDate);
			orderVector.add(tmpOrder.orderID);
			orderVector.add(tmpOrder.totalPrice);
			orderVector.add(tmpOrder.payment.name);
			
			kitchenModel.addRow(orderVector);
		}
	}

	public void displayRefundReq()
	{

	}

	public void sendACK()
	{

	}

}
