package com.doni.Frames;

import com.doni.Models.Key;
import com.doni.Models.Purchaser;
import com.doni.Databases.Purchaser_Database;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/** SignupFrame models a frame that will be used after in the LoginFrame the singup button clicked */
public class SignupFrame extends JFrame {
	
	private LoginFrame lf;
	private Purchaser_Database pd;
	private Purchaser purchaser;
	private Key ID; //the users ID;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	
	private String name; //the users name
	private char[] password;//the users password
	private String address;//the users address
	private int count = 0;
	

	/** Constructor SignupFrame initializes the LoginFrrame, the Purchaser_Database
	 * @param lf1 - the Frame that users use to login after they are registered
	 * @param pd1 - the Database were the users are registered 	 **/
	public SignupFrame(LoginFrame lf1,Purchaser_Database pd1) {
		
		lf = lf1;
		pd = pd1;

		setBounds(100, 100, 300, 448);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(37, 70, 205, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(37, 240, 205, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(37, 128, 205, 27);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(37, 182, 205, 27);
		contentPane.add(passwordField_1);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(e -> btnOkactionPerformed(e));
		btnSignUp.setBounds(76, 296, 111, 27);
		contentPane.add(btnSignUp);
		
		JButton btnCancle = new JButton("Cancle");
		  btnCancle.addActionListener(e -> {

			  lf.setVisible(true);
			  setVisible(false);

		  });
		btnCancle.setBounds(74, 334, 113, 27);
		contentPane.add(btnCancle);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(38, 53, 102, 19);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(37, 108, 78, 24);
		contentPane.add(lblPassword);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(37, 167, 88, 14);
		contentPane.add(lblPassword_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(37, 225, 118, 14);
		contentPane.add(lblAddress);
	
	}
	
	
	/** The action that is performed after the user  click the "OK" button 	 **/	
	public void btnOkactionPerformed(ActionEvent e) {
		           
		ID = new Key(count); //the users key gets the index count
					  
					  
		if(textField.getText().trim().equals("") || passwordField.getPassword().length == 0|| passwordField_1.getPassword().length == 0 || textField_3.getText().trim().equals("") ) {

		                    
			System.out.println("Please fill the blank spaces");
					  
		} else {
			
			if(textField.getText().trim().matches("^[a-zA-Z]+$") && textField_3.getText().trim().matches("^[a-zA-Z]+$") ) {

				if(Arrays.equals(passwordField.getPassword(), passwordField_1.getPassword())) {
							  
					if(pd.findNameLocation(textField.getText().trim()) != -1) {

						System.out.println("Username alredy exist");

					} else {

						name = textField.getText().trim();
						password = passwordField.getPassword();
						address = textField_3.getText();

						purchaser = new Purchaser(ID,name,password,address);

						pd.insert(purchaser); //inserts the purchaser in database

						System.out.println("Account created successfully");

						count++;

					}
				} else {

					System.out.println("Confirm password does not match password");
				}
			} else {
				System.out.println("Please enter a valid name");
			}
		}							                     
	}			
}





			
			
			
					  
			

