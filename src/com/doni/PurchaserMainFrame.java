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
/** PurchaserMainFrame creates a frame which is used if in the LoginFrame a user is login */
public class PurchaserMainFrame extends JFrame {

	private JPanel contentPane;
	private SalesPanel sp;

	private JTable table1;
		
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private Inventory_Database ind;
	private Purchase_Database pd;
	private Purchaser purchaser;
	
	private LoginFrame lf;

	private JScrollPane scrollPane;
	private Purchase purchase;
	

	/** Constructor PurchaserMainFrame initializes the purchaser, the Inventory_Database and the Purchase_Database
	 * @param purchaser1 - the purchaser
	 * @param ind1 - the database that the purchaser use to purchase items after they are inserted in Inventory_Database buy admin
	 * @param pd1 - the database were purchases made buy the purchaser are inserted  */
	public PurchaserMainFrame(LoginFrame lf1,Purchaser purchaser1,Inventory_Database ind1,Purchase_Database pd1) 
	{
			
		purchaser = purchaser1;
		ind = ind1;
		pd = pd1;		
		lf = lf1;
		
        setTitle("Business accounting application");
		setBounds(100, 100, 1012, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		  
		table1 = new JTable(); 	
		table1.setModel(ind.getAllItems());	
		table1.setPreferredScrollableViewportSize(new Dimension(500,50));		
		table1.setFillsViewportHeight(true);		
		table1.setSize(600,200);

		JScrollPane scrollPane1 = new JScrollPane(table1);   	
		scrollPane1.setBounds(150,55,840,536);		
		contentPane.add(scrollPane1);
		
		JLabel lblItems = new JLabel("Items");
		lblItems.setBackground(Color.LIGHT_GRAY);
		lblItems.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblItems.setBounds(157, 21, 130, 23);
		contentPane.add(lblItems);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.textText);
		separator.setBounds(140, 44, 558, 2);
		contentPane.add(separator);
		
		JButton btnBuyItems = new JButton("Buy Items");
		btnBuyItems.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
								
				JFrame f = new JFrame();
				f.setSize(600,200);
				JPanel contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new BorderLayout(0, 0));
				f.setContentPane(contentPane);
				f.setVisible(true);
				
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
				
				textField_2 = new JTextField();
				textField_2.setBounds(359, 48, 139, 25);
				panel.add(textField_2);		
								
				JLabel lblId = new JLabel("ID");
				lblId.setBounds(52, 34, 46, 14);
				panel.add(lblId);							
				
				JLabel lblQuantity = new JLabel("Quantity");
				lblQuantity.setBounds(215, 34, 64, 14);
				panel.add(lblQuantity);
				
				JLabel lblMeans = new JLabel("Means of payment");
				lblMeans.setBounds(365, 34, 150, 14);
				panel.add(lblMeans);
				
				JButton btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						
						btnOkActionPerformed(e);
					
					}
				});
				btnOk.setBounds(150, 94, 89, 31);
				panel.add(btnOk);
				
				JButton btnCancle = new JButton("Cancle");
				btnCancle.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						
						f.setVisible(false);
						if(purchase != null )
						{
					   
							InvoiceFrame iF = new InvoiceFrame(pd,purchase,purchaser.getID());
					    
							iF.setVisible(true);
						}
					
					}
				});
				btnCancle.setBounds(253, 94, 97, 31);
				panel.add(btnCancle);
			
			}
		});
		btnBuyItems.setBounds(10, 501, 130, 28);
		contentPane.add(btnBuyItems);

		JButton btnItems = new JButton("Items");
		btnItems.addActionListener(new ActionListener() 
		{
			
			
			public void actionPerformed(ActionEvent e) 
			{
				btnBuyItems.setVisible(true);
				lblItems.setText("Items");
				scrollPane1.setVisible(true);
				scrollPane.setVisible(false);
			}
		});
		btnItems.setBounds(10, 69, 131, 28);
		contentPane.add(btnItems);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				setVisible(false);
				lf.setVisible(true);
				
				
			}
		});						
		btnLogOut.setBounds(10, 546, 131, 28);
		contentPane.add(btnLogOut);	
		
		JButton btnStats = new JButton("Stats");
		btnStats.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				lblItems.setText("Stats");
				scrollPane1.setVisible(false);
			    sp = new SalesPanel(purchaser.getID(),pd);
			    btnBuyItems.setVisible(false);
				
				
				JTable table1 = new JTable();		
				table1.setPreferredScrollableViewportSize(new Dimension(500, 70));		
				table1.setFillsViewportHeight(true);		
				table1.setModel(pd.getAllPurchases(purchaser.getID()));						
				table1.setSize(600,200);
		 
				scrollPane = new JScrollPane(table1); //inserts the table in scrollPane
				scrollPane.setBounds(150,55,840,536);
				scrollPane.setVisible(true);
				contentPane.add(scrollPane);
			
			}
		});
		btnStats.setBounds(10, 108, 130, 28);
		contentPane.add(btnStats);
	
	}
	
	/** Buy items if the button ok of the frame Buy Items is pressed */
	private void btnOkActionPerformed(ActionEvent evt)
	{
		try{
			
		
			
			
		
			if(textField.getText().trim().equals("") || textField_1.getText().trim().equals("") || textField_2.getText().trim().equals(""))	
		    {
		
			
				System.out.println("Please fill the blank spaces");
	
		    }	
		    else	
		    {
		    	if(textField_2.getText().trim().matches("^[a-zA-Z]+$"))
		    	{
		    	
		    		Key itemID = new Key(new Integer(textField.getText().trim()));
		    	    String means = textField_2.getText().trim();
			
			
		    	
		    	    if(ind.find(itemID) != null  && ind.findQuantity(itemID) >= (new Integer( textField_1.getText().trim())) )					
			        {
			
		    		
		    	    	int	quantity = new Integer(textField_1.getText().trim());
			
				        purchase = new Purchase(ind.find(itemID),purchaser,means,quantity);
				        
				        if( pd.insert(purchase))
				        {
				
				       

									
			            int quantity1 = ind.findQuantity(itemID);	  
				        table1.getModel().setValueAt(quantity1,ind.findLocation(itemID),4);	
				    
				
				        }
				        else
				        {
				  
     	
				         System.out.println("The items were bought successfully");

				        }
			        }
		    	}
			        else	
			        {
					
				       System.out.println("The item dose not exsit or ");
				
			        }	
		     
		    	
		    }	
		} 
		catch (NumberFormatException nf) {
				
		System.out.println("Only numbers are allowed in textField 1, textField 2,");

		}				
	}
}

	
	


