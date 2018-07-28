package com.doni;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/** AdminFrame models a frame that is displayed after the admin login from LoginFrame */
public class AdminFrame extends JFrame {
	
	private JFrame addItemsF; //the frame that is used to add items
	private JFrame deleteItemsF;//the frame that is used to delete items
	
	private JPanel contentPane1;
	private JPanel contentPane; //the items panel
	private PurchaserPanel cp; //the purchaser panel
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField11;
	private JTextField textField_11;
	
	private JTable  table1; //the items table

	private JButton btnOk; //the OK button of the add items
	private JButton btnCancle;

	private Inventory_Database ind; 
	private Purchaser_Database pnd; 
	private Purchase_Database pd; 
	private Item item; 
	private Key itemID; 
	
	private String itemName;	
	private double itemWP;
	private double itemRP;
	private int itemKey;
	private int itemQ;
	
	private LoginFrame af;

	/** Constructor AdminFrame  initializes  the Inventory_Database, Purchaser_Database and Purchase_Database
	 * @param ind1 - the database were the items can added or deleted by admin .
	 * @param pnd1 - the database were the admin can check purchasers stats
	 * @param pd1 - the database were the admin can view all the purchases made by purchasers */
	public AdminFrame(LoginFrame af1,Inventory_Database ind1, Purchaser_Database pnd1, Purchase_Database pd1) 
	{
			
		ind = ind1;		
		pnd = pnd1;
		pd = pd1;
		af = af1;

		cp = new PurchaserPanel(pnd,pd);
		
		setTitle("Business accounting application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 640);
		getContentPane().setLayout(null);
       	setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setTitle("AdminFrame");
			       
		JPanel panel = new JPanel(); //the items panel
		panel.setBounds(0, 0, 1002, 601);	
		getContentPane().add(panel);
		panel.setLayout(null);
	
		JLabel lblItems = new JLabel("Items");
		lblItems.setBounds(157, 21, 130, 23);
		lblItems.setBackground(Color.LIGHT_GRAY);
		lblItems.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblItems);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(140, 44, 558, 2);
		separator.setForeground(SystemColor.textText);
		panel.add(separator);
		
	    table1 = new JTable();	  
		table1.setModel(ind.getAllItems()); //insert all the items in table 
		table1.setPreferredScrollableViewportSize(new Dimension(500,50));		
		table1.setFillsViewportHeight(true);	
		table1.setSize(600,200);
				
		JScrollPane scrollPane1 = new JScrollPane(table1); //add table to scrollPane
        scrollPane1.setBounds(150,55,840,536);	
        panel.add(scrollPane1);
        
        JButton btnDeleteItems = new JButton("Delete Items");
		btnDeleteItems.setBounds(10, 507, 130, 28);
		btnDeleteItems.addActionListener(new ActionListener() 
		{	
			     
			public void actionPerformed(ActionEvent e) 
			{				 
			    	  
				deleteItemsF = new JFrame();			    
				deleteItemsF.setTitle("Delete Items");				
				deleteItemsF.setSize(450,200);
				
				contentPane1 = new JPanel();				
				contentPane1.setBackground(Color.WHITE);				
				contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
				
				deleteItemsF.add(contentPane1);
				contentPane1.setLayout(null);				
				deleteItemsF.setVisible(true);
								
				textField11 = new JTextField();				
				textField11.setBounds(44, 52, 168, 25);				
				contentPane1.add(textField11);
				
				textField11.setColumns(10);								
				textField_11 = new JTextField();				
				textField_11.setBounds(222, 52, 168, 25);
				contentPane1.add(textField_11);				
				
				JLabel lblIdNumber = new JLabel("ID number");				
				lblIdNumber.setBounds(44, 35, 79, 14);				
				contentPane1.add(lblIdNumber);				
				
				JLabel lblQuantity = new JLabel("Quantity");				
				lblQuantity.setBounds(222, 35, 80, 14);				
				contentPane1.add(lblQuantity);				
				
				JButton btnOk = new JButton("Ok");				
				btnOk.addActionListener(new ActionListener() 				
				{
				
					public void actionPerformed(ActionEvent evt)
					{

						btnDeleteOKActionPerformed(evt);
				    
					}
				    
				});		        
				btnOk.setBounds(122, 99, 89, 32);		        
				contentPane1.add(btnOk);				
		        
				JButton btnCancle = new JButton("Cancle");		        
				btnCancle.addActionListener(new ActionListener() 
				{
				
					public void actionPerformed(ActionEvent e) 
					{
											
						deleteItemsF.setVisible(false);
					   
					}				    
				});
				
				btnCancle.setBounds(222, 99, 89, 32);			 	
				contentPane1.add(btnCancle);
    
			}	
		});
		
		panel.add(btnDeleteItems);
		
		JButton btnAddItems = new JButton("Add Items");
		btnAddItems.setBounds(10, 468, 130, 28);
		btnAddItems.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{							      
								
				contentPane = new JPanel();				
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));				
				contentPane.setLayout(new BorderLayout(0, 0));	
				
				addItemsF = new JFrame();				
				addItemsF.setSize(700,200);
				addItemsF.setContentPane(contentPane);								
				addItemsF.setVisible(true);
				addItemsF.setTitle("Add Items");
		
				JPanel panel = new JPanel();				
				contentPane.add(panel);				
				panel.setLayout(null);
				        		
				JLabel lblName = new JLabel("Name");        		
				lblName.setBounds(29, 39, 46, 14);         		
				panel.add(lblName);
				
				JLabel lblRetailPrice = new JLabel("Retail price");        		
				lblRetailPrice.setBounds(400, 39, 97, 14);         		
				panel.add(lblRetailPrice);
				       		
				textField = new JTextField();        		
				textField.setBounds(29, 55, 121, 26);        		
				panel.add(textField);				
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setBounds(160, 55, 110, 26);
				panel.add(textField_1);
				textField_1.setColumns(10);
				
				textField_2 = new JTextField();
				textField_2.setBounds(276, 55, 110, 26);
				panel.add(textField_2);
				textField_2.setColumns(10);
				
				textField_3 = new JTextField();
				textField_3.setBounds(396, 55, 110, 27);
				panel.add(textField_3);
				textField_3.setColumns(10);
				
				JLabel lblId = new JLabel("ID");
				lblId.setBounds(160, 39, 57, 14);
				panel.add(lblId);
				
				JLabel lblWholesalePrice = new JLabel("WholeSale Price");
				lblWholesalePrice.setBounds(276, 39, 97, 14);
				panel.add(lblWholesalePrice);
								
				JLabel lblQuantity = new JLabel("Quantity");
				lblQuantity.setBounds(516, 39, 55, 20);
				panel.add(lblQuantity);
				
				btnOk = new JButton("OK");
				btnOk.setBounds(216, 102, 103, 32);
				panel.add(btnOk);
				btnOk.addActionListener(new ActionListener()
				{
		           
					public void actionPerformed(ActionEvent evt)
		            {
		            	          					
						btnOKActionPerformed(evt);
		            
		            }			  
				});
				
			    btnCancle = new JButton("Cancle");
			    btnCancle.addActionListener(new ActionListener() 
			    {
			    	public void actionPerformed(ActionEvent e) 
			    	{
		    	
			    		addItemsF.setVisible(false);
			    	
			    	}
			    });
				btnCancle.setBounds(329, 102, 103, 32);
				panel.add(btnCancle);
				
				textField_4 = new JTextField();
				textField_4.setBounds(516, 55, 97, 26);
				panel.add(textField_4);
				textField_4.setColumns(10);
		
			}
		});
		panel.add(btnAddItems);
		
		
		JButton btnItems = new JButton("Items");
		btnItems.setBounds(10, 69, 131, 28);
		btnItems.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				
				scrollPane1.setVisible(true);
				
				cp.setVisible(false);
				
				lblItems.setText("Items");
				
				btnDeleteItems.setVisible(true);
			    
				btnAddItems.setVisible(true);
			
			}
		});
		panel.add(btnItems);
		
		JButton btnCostumers = new JButton("Costumers");
		btnCostumers.setBounds(10, 103, 131, 28);
		btnCostumers.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
							
				cp.setBounds(0,0,1010,700);
				cp.setVisible(true);				
				panel.add(cp);
			   
			    lblItems.setText("Costumers");
			    
			    btnDeleteItems.setVisible(false);
			    btnAddItems.setVisible(false);
				
			    scrollPane1.setVisible(false);
	
			}
		});
		panel.add(btnCostumers);
		

		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				setVisible(false);
				af.setVisible(true);
			
			}
		});
		btnLogOut.setBounds(10, 546, 131, 28);
		panel.add(btnLogOut);

	}

	
	/** btnOKActionPerformed add items if item dose not exist */
	private void btnOKActionPerformed(ActionEvent evt)
	{
		
		try{
			
			if(textField.getText().trim().equals("") || textField_1.getText().trim().equals("") || textField_2.getText().trim().equals("") || textField_3.getText().trim().equals("") ||textField_4.getText().trim().equals(""))		  		
			{
						
				System.out.println("Please fill the blank spaces");
				 
			}	 		
			else		 		 
			{
				if(textField_1.getText().trim().equals("-1") || textField_2.getText().trim().equals("-1") || textField_3.getText().trim().equals("-1") ||textField_4.getText().trim().equals("-1"))		  		
				{
					System.out.println("Please enter numbers bigger than -1");
				}
				
				if(textField.getText().trim().matches("^[a-zA-Z]+$"))
				{	
				
					itemName = textField.getText().trim();							     							
					itemWP = new Double(textField_2.getText().trim()).doubleValue();			 							
					itemKey = new Integer(textField_1.getText().trim()).intValue();			 						
					itemRP = new Double(textField_3.getText().trim()).doubleValue();			 							
					itemQ = new Integer(textField_4.getText().trim()).intValue(); 			
				    itemID = new Key(itemKey);
			    						 
				    if(ind.findName(textField.getText()) != null || ind.find(itemID) != null)		    			
				    {
				 							   
				    	System.out.println("This item alredy exist");
				    			 
				    }				  			 			
				    else			 			
				    {  			     					
					
				    	item = new Item(itemName,itemID,itemWP,itemRP,itemQ);            				
					    ind.insert(item);
								 												    							
					    String name = ind.find(itemID).getName();			    				
					    int id = itemID.getInt();				
				 	    double wsp = ind.find(item.getID()).getWholeSalePrice();				
					    double rsp =ind.find(item.getID()).getRetailPrice();		    				
					    int quantity = ind.findQuantity(item.getID());			  
														 				
					    ((DefaultTableModel) table1.getModel()).addRow(new Object[]{name, id,wsp,rsp,quantity});
					
					    System.out.println("Items added successfully");
								 
			 	    }					
				}
				else
				{
					System.out.println("Please enter a valid item name");
				}
			}	
		
		
	} catch (NumberFormatException nf) {
		
		
		System.out.println("Only numbers are allowed in textField 1, textField 2, textField 3 and textField 4 ");
 
	  }					 	 
	}
	
	/** btnDeleteOKActionPerformed delete item if the item exist */
	public void btnDeleteOKActionPerformed(ActionEvent e) 	
	{
		
		try {
				
			
		
							
			if(textField11.getText().trim().equals("") || textField_11.getText().trim().equals(""))				
			{
									
				System.out.println("Please fill the blank places");
					 
			}				
			else				
			{
				int i = new Integer(textField_11.getText().trim());		
				
				Key itemID = new Key(new Integer(textField11.getText().trim()));;
										
				if(ind.delete(itemID,i) == false)						 
				{
							 			
					System.out.println("The item does not exist or not enough in stock ");
							 					 
				}						 
				else						
				{
											
					int quantity = ind.findQuantity(itemID);
																			
					table1.getModel().setValueAt(quantity,ind.findLocation(itemID),4);
						
					System.out.println("Items deleted succesfully");
					 			 
				}		 
			}	 
		    
		} catch (NumberFormatException nf) {
			
			
			System.out.println("Only numbers are allowed in textField 1, textField 2,");
			
		    
		}				
		
	
	}
}