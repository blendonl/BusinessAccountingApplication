package com.doni.Frames;

import com.doni.Models.Key;
import com.doni.Databases.Purchase_Database;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

/** StatsFrame models a frame that AdminFrame will use to display a purchaser stats */
public class StatsFrame extends JFrame {

	private JPanel contentPane;
	
	private JTable table;
    
	private Purchase_Database pd;
    
	private Key purchaserKey;
	
    /**Constructor StatsFrame initializes the Purchase_Database, the purchaser identification key and creates the frame
	 * @param pd1 - the database that is used to view all the purchases 
	 * @param key - the purchaser key  */
	public StatsFrame(Purchase_Database pd1,Key key) {
		
		pd = pd1;
		purchaserKey = key;
		
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		table = new JTable();
		table.setModel(pd.getAllPurchases(purchaserKey)); //insert all purchases made by the purchaser in table	
		table.setPreferredScrollableViewportSize(new Dimension(500,50));	
		table.setFillsViewportHeight(true);
		table.setSize(600,200);	
		
		JScrollPane scrollPane = new JScrollPane(table); //insert the table in scrollPane					
		scrollPane.setBounds(25,74,749,385);		
		getContentPane().add(scrollPane);
		
		JLabel lblStats = new JLabel("Stats");
		lblStats.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblStats.setBounds(35, 34, 127, 29);
		contentPane.add(lblStats);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 76, 726, 0);
		contentPane.add(separator);
	
	}
}

