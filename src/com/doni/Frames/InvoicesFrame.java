package com.doni.Frames;

import com.doni.Databases.Inventory_Database;
import com.doni.Models.Key;
import com.doni.Databases.Purchase_Database;
import com.doni.Databases.Purchaser_Database;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class InvoicesFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	private Purchaser_Database pd;
	private Purchase_Database pnd;
	private Inventory_Database ind;
	

	public InvoicesFrame(int i, Purchaser_Database pd1,Purchase_Database pnd1,Inventory_Database ind1) {
		pd = pd1;
		pnd = pnd1;
		ind = ind1;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 551);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInvoice = new JLabel("INVOICE");
		lblInvoice.setBounds(31, 34, 148, 25);
		lblInvoice.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblInvoice);
		
		Key k = new Key(i);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{pd.find(k).getName(),pd.find(k).getAddress()},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setPreferredScrollableViewportSize(new Dimension(500,50));		
		table.setFillsViewportHeight(true);	
		table.setSize(600,200);
				
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(33, 183, 499, -33);
		contentPane.add(scrollPane);
		
	
		
		table_1 = new JTable();
		table_1.setModel(pnd.getAllPurchases(k));
		table_1.setPreferredScrollableViewportSize(new Dimension(500,50));		
		table_1.setFillsViewportHeight(true);	
		table_1.setSize(600,200);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(31, 507, 466, -289);
		contentPane.add(scrollPane_1);
				
		
	}
}
