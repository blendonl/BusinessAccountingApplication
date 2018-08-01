package com.doni.Panels;

import com.doni.Databases.Purchase_Database;
import com.doni.Models.Key;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;
/** SalesPanel models a panel that the PurchaserMainFrame will use after the button stats will clicked */
public class SalesPanel extends JPanel {
	
	private JTable table1; 
	
	private Purchase_Database pd;


	/** Constructor SalesPanel initializes the identification key of a purchaser and the Purchase_Database
	 * @param k - Purchaser identification key
	 * @param pd1 - the Purchase database that the table1 will use to get all purchases of a purchaser */
	public SalesPanel(Key k, Purchase_Database pd1) {
		
		pd = pd1;

		setLayout(null);
		
		table1 = new JTable();		
		table1.setPreferredScrollableViewportSize(new Dimension(500, 70));		
		table1.setFillsViewportHeight(true);		
		table1.setModel(pd.getAllPurchases(k));						
		table1.setSize(600,200);
 
		JScrollPane scrollPane1 = new JScrollPane(table1); //inserts the table in scrollPane 
		scrollPane1.setBounds(0,0,840,536);		
		add(scrollPane1);

	}
}
