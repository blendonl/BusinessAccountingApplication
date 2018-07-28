package com.doni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyItemsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel[] label;
	
	private Inventory_Database ind;
	private Purchase_Database pnd;
	private Purchase purchase;
	
	 private DefaultTableModel dtm;
	
	 private JTable t;
	private Key itemID;
	private Key purchaserID;
	private int i1 = 0;
	private Purchaser_Database pd;
	private Purchaser p;
	private Item i;

	
	private int count = 0;

	



	/**
	 * Create the frame.
	 */
	public BuyItemsFrame(JTable table,DefaultTableModel dtm1,Purchaser p1,Item i1,Inventory_Database ind1,Purchaser_Database pd1,Purchase_Database pnd1) {
		this.dtm = dtm1;
		this.ind = ind1;
		t = table;
		p = p1;
		i = i1;
		
	
		
		pd =pd1;
		
		
	
		
		this.pnd = pnd1;
		
		
	
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(48, 48, 139, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(209, 48, 139, 25);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(52, 34, 46, 14);
		panel.add(lblId);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(215, 34, 64, 14);
		panel.add(lblQuantity);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnOkActionPerformed(e);
			}
		});
		btnOk.setBounds(87, 94, 89, 31);
		panel.add(btnOk);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnCancle.setBounds(203, 94, 97, 31);
		panel.add(btnCancle);
	}
	
	private void btnOkActionPerformed(ActionEvent evt)
	{
		
		itemID = new Key(new Integer(textField.getText().trim()));
		
		
	
	
		
		if(textField.getText().trim().equals("") || textField_1.getText().trim().equals(""))
		{
			System.out.println("Please fill the blank spaces");
			
			
		}
		else
		{
			if(ind.find(itemID) != null  && ind.findQuantity(itemID) > (new Integer( textField_1.getText().trim())) )
			{
								
			        String name = ind.find(itemID).getName();
		    	        Key id = ind.find(itemID).getID();
		    	        double wsp = ind.find(itemID).getWholeSalePrice();
		    	        double rsp =ind.find(itemID).getRetailPrice();
		    	        int quantity = ind.findQuantity(ind.find(itemID).getID());
			        
				int q = new Integer( textField_1.getText().trim());
				purchase = new Purchase1(i,p,q);
				
				pnd.insert(purchase);
				
	  
				ind.getAllItems().setValueAt(new String(name),ind.findLocation(itemID),0);
			        ind.getAllItems().setValueAt((id).getInt(),ind.findLocation(itemID),1);
			        ind.getAllItems().setValueAt(wsp,ind.findLocation(itemID),2);
			        ind.getAllItems().setValueAt(rsp,ind.findLocation(itemID),3);
			        ind.getAllItems().setValueAt(quantity,ind.findLocation(itemID),4);
		
				 i1++;
					 
				System.out.println("The items were bought successfully");
				
				count++;
			}
			else
			{
				System.out.println("The item dose not exsit or ");
			}
		}
		
		
		
	}
}
