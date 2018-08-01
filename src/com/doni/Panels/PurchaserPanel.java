package com.doni.Panels;

import com.doni.Databases.Purchase_Database;
import com.doni.Databases.Purchaser_Database;
import com.doni.Frames.StatsFrame;
import com.doni.Models.Key;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/** PurchaserPanel1 models a panel that AdminFrame will use to display a purchasers */
public class PurchaserPanel extends JPanel {
	private JTable table;

	/** Constructor PurchaserPanel initializes the Purchase_Database, the Purchase_Database and creates the panel
	 * @param pnd - the purchaser database
	 * @param pd - the purchase database */
	public PurchaserPanel(Purchaser_Database pnd, Purchase_Database pd) {
		setLayout(null);
		
		
		table = new JTable(); 	
		table.setModel(pnd.getAllPurchasers());	
		table.setPreferredScrollableViewportSize(new Dimension(500,50));		
		table.setFillsViewportHeight(true);		
		table.setSize(600,200);

		JScrollPane scrollPane1 = new JScrollPane(table);   	
		scrollPane1.setBounds(150,55,840,536);		
		add(scrollPane1);
		
		
		table.getSelectionModel().addListSelectionListener(event -> {
			if (event.getValueIsAdjusting())
				return;

			ListSelectionModel lsm = (ListSelectionModel) event.getSource();
			int selectedRow = lsm.getMinSelectionIndex();
			Key k = new Key(selectedRow);


			StatsFrame s = new StatsFrame(pd,k);
			s.setVisible(true);

		});

	}
}
