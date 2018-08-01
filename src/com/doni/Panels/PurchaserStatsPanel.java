package com.doni.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PurchaserStatsPanel extends JPanel {

		
	private JTable table1;
	private DefaultTableModel dtm1;

	public PurchaserStatsPanel(int i) {

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		dtm1  = new DefaultTableModel();
		dtm1.addColumn("Name");
		dtm1.addColumn("ID");
		dtm1.addColumn("Wholesale Price");
		dtm1.addColumn("Retail Price");
		dtm1.addColumn("Quantity in stock");
		dtm1.addRow(new Object[][] { });

		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
		"Costumer Name", "Item Name","Quantity", "Price"
		}
		));
		table1.setModel(dtm1);
		table1.setPreferredScrollableViewportSize(new Dimension(500,50));
		table1.setFillsViewportHeight(true);
		table1.setSize(600,200);

		JScrollPane scrollPane1 = new JScrollPane(table1);

		scrollPane1.setBounds(150,55,840,536);

		add(scrollPane1);

		JLabel lblItems = new JLabel("Stats");
		lblItems.setBackground(Color.LIGHT_GRAY);
		lblItems.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblItems.setBounds(157, 21, 130, 23);
		add(lblItems);

		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.textText);
		separator.setBounds(140, 44, 558, 2);
		add(separator);

		JButton btnItems = new JButton("Items");
		btnItems.addActionListener(e -> setVisible(false));
		btnItems.setBounds(10, 69, 131, 28);
		add(btnItems);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(10, 546, 131, 28);
		add(btnLogOut);

		JButton btnStats = new JButton("Stats");
		btnStats.addActionListener(e -> setVisible(false));
		btnStats.setBounds(10, 108, 130, 28);
		add(btnStats);
	}
}

