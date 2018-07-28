package com.doni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
/** Create the Frame that user use to login after they are register */
public class LoginFrame extends JFrame {
	
	private Inventory_Database ind;
	private Purchaser_Database pd;
	private Purchase_Database pnd;

	private AdminFrame af;

	private JPasswordField passwordField;
	private JTextField textField;
	private JPanel contentPane;

	private int checkNamePassword;

	/** Constructor LoginFrame  initializes the AdminFrame,Purchaser_Database,Inventory_Database,Purchase_Database
	 * @param mf1 - the frame that is displayed after the users press the button Login
	 * @param pd1 - the database were is checked if the user that is trying to login exist
	 * @param ind1 - the database that is used in the CostumerMainFrame to buy items
	 * @param pnd1 - the database that is used in the CostumerMainFrame to regist the purchases that users made */
	public LoginFrame(Purchaser_Database pd1,Inventory_Database ind1,Purchase_Database pnd1) 
	{
		
		pd = pd1;		
		pnd = pnd1;
		ind = ind1;
	
		SignupFrame sf = new SignupFrame(this,pd); 
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login");
	
		textField = new JTextField();
		textField.setBounds(24, 74, 224, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogIn = new JButton("Log In");		  
		btnLogIn.addActionListener(new ActionListener() 		
		{
	
			public void actionPerformed(ActionEvent e) 			 			
			{
				
				if(textField.getText().trim().matches("^[a-zA-Z]+$"))
				{			
				
					checkNamePassword = pd.findNamePasswordLocation(textField.getText(),passwordField.getPassword());				  										  
		
					if(textField.getText().equals("") || passwordField.getPassword().length == 0 )				       				  								
					{
									
						System.out.println("Please fill the blank spaces");				  
			
					}				       				  								
					else				       				  								
					{
									
						char[] admin = {'a','d','m','i','n'};					
					
						if(textField.getText().equals("admin") && Arrays.equals(passwordField.getPassword(),admin))					     					  										
						{
												
							af = new AdminFrame(LoginFrame.this,ind,pd,pnd);					    
							af.setVisible(true);
					    
							setVisible(false);					  
					
						}			             					  										
						else			             					  										
						{	   
											
							if(checkNamePassword != -1)					        						  												
							{						
							
								Key k = new Key(checkNamePassword);
							
								PurchaserMainFrame mf = new PurchaserMainFrame(LoginFrame.this,pd.find(k),ind,pnd);		        															
								mf.setVisible(true);
							 
								setVisible(false);
						
							}   			    	        						  											
							else			 	            						  												
							{
													
								System.out.println("Incorrect username or password");
						  						
							}			             					   										
						}				  				
					}					
				}				  							 			  			
			}
			
		});				
		btnLogIn.setBounds(74, 197, 124, 30);				
		contentPane.add(btnLogIn);
		
		JButton btnSignUp = new JButton("Sign Up");		 		
		btnSignUp.addActionListener(new ActionListener() 		 		
		{
			
			public void actionPerformed(ActionEvent e) 			 			
			{
			
				sf.setVisible(true);
				
			}				  
		});		
		
		btnSignUp.setBounds(74, 235, 124, 30);				
		contentPane.add(btnSignUp);
	
		JLabel lblUsername = new JLabel("Username");				
		lblUsername.setBounds(24, 58, 61, 19);				
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");				
		lblPassword.setBounds(24, 124, 105, 14);				
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();				
		passwordField.setBounds(24, 137, 224, 27);				
		contentPane.add(passwordField);

	}
}

