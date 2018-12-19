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
import javax.swing.JTextArea;

public class KitchenDisplay extends JFrame {

	public JPanel contentPane;
	public DefaultTableModel kitchenModel;
	public JTable kitchenTable;
	public JScrollPane scroll;
	public JScrollPane textAreaScroll;
	public JTextArea orderTextArea;
	
	public boolean refundACK;
	
	/**
	 * Create the frame.
	 */
	public KitchenDisplay() {
		setTitle("Kitchen View");
		setBounds(100, 100, 976, 346);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		String kitchenCategory[] = { "Date", "Order Num", "Price", "Method of Payment" }; 
		kitchenModel = new DefaultTableModel(kitchenCategory, 0);
		kitchenTable = new JTable(kitchenModel);
		scroll = new JScrollPane(kitchenTable);
		scroll.setBounds(10, 10, 454, 300);
		contentPane.add(scroll);
		
		textAreaScroll = new JScrollPane();
		textAreaScroll.setBounds(476, 10, 494, 300);
		contentPane.add(textAreaScroll);
		
		orderTextArea = new JTextArea();
		orderTextArea.setEditable(false);
		orderTextArea.setBounds(476, 10, 300, 300);
		textAreaScroll.setViewportView(orderTextArea);
	}
	
	public void displayOrder(LinkedList<Order> orderList)
	{
		LinkedList<SelectedFood> purchasedFoods = new LinkedList();
		LinkedList<String> toppings = new LinkedList();
		
		for(Order tmpOrder: orderList) {
			purchasedFoods = tmpOrder.purchasedFoods;
			for(SelectedFood food: purchasedFoods) {
				String foodName = food.name;
				String flavor = food.flavor;
				toppings = food.selectedTopping;
				int count = food.count;
			
				if(flavor != null)
					orderTextArea.append(flavor+" ");
				
				orderTextArea.append(foodName+" ");
				if(toppings != null) {
					orderTextArea.append(" with ");
					orderTextArea.append("( ");
					for(String topping: toppings) {
						orderTextArea.append(" "+topping+" ");
					}
					orderTextArea.append(" )");
				}
				orderTextArea.append(" X"+count);
				orderTextArea.append("\n");
			}
			break;
		}
		
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
