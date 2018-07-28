package com.doni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
/** InvoiceFrame models a invoice */
public class InvoiceFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private int count  = 1; // the invoice number


	/** InvoiceFrame constructor iniciliasez the Purchase_Database, the Purchase, the Key
	 * @param pnd - the database were the table model is get from
	 * @param p - the purchase
	 * @param k - the purchaser key	 */
	public InvoiceFrame(Purchase_Database pnd, Purchase p, Key k) {
		
		
		GregorianCalendar gc =new GregorianCalendar();
		
		
		setBounds(100, 100, 712, 609);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Invoice");
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCompanyName.setBounds(56, 39, 300, 22);
		contentPane.add(lblCompanyName);
		
		JLabel lblInvoiceNo = new JLabel("Invoice no.:   " + count++);
		lblInvoiceNo.setBounds(27, 119, 300, 14);
		contentPane.add(lblInvoiceNo);
		
		JLabel lblData = new JLabel("Data:     " + gc.getTime());
		lblData.setBounds(25, 144, 300, 14);
		contentPane.add(lblData);
		
		JLabel lblPurchaser = new JLabel("Purchaser:   " + pnd.find(p).getCostumerName());
		lblPurchaser.setBounds(353, 119, 82, 14);
		contentPane.add(lblPurchaser);
		
		  
			table = new JTable(); 	
			table.setModel(pnd.getAllPurchases(k));	
			table.setPreferredScrollableViewportSize(new Dimension(500,50));		
			table.setFillsViewportHeight(true);		
			table.setSize(600,200);

			JScrollPane scrollPane1 = new JScrollPane(table);   	
			scrollPane1.setBounds(27,177,646,339);		
			contentPane.add(scrollPane1);
		
	
	
	}
}
