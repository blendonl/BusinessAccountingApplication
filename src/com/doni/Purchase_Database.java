package com.doni;

import javax.swing.table.DefaultTableModel;

/** Purchase_Database implements a database of purchases */
public class Purchase_Database {
	
	private Purchase[] base;
	private Inventory_Database ind;	
	
	private DefaultTableModel dtm;
	
	
	private int NOT_FOUND = -1;

	/** Constructor Database initializes the database 
	 * @param initial_size - the size of the database
	 * @param ind1 - the database were the item will be purchased */ 
	public Purchase_Database(int initial_size,Inventory_Database ind1)
	{	
		
	    dtm = new DefaultTableModel();	  //creates the table model
		  
		dtm.addColumn("Items Name");	  
		dtm.addColumn("Price");	  
		dtm.addColumn("Quantity");
		dtm.addColumn("Means of Payment");
		dtm.addColumn("Total");
		
		ind = ind1;

		if(initial_size > 0)
		{
			
			base = new Purchase[initial_size];
		
		}
		else
		{
			
			base = new Purchase[1];
			
		}
	}
	
	
	/** findLocation is a helper method that searches base for a purchase 
	 * whose key is k. If found, the index of the purchase is returned,
	 * else NOT FOUND is returned. */ 
	public int findLocation(Purchase purchase)
	{
		
		int rezult = NOT_FOUND;
		boolean found = false;
		int i = 0;
		
		while(!found && i != base.length)
		{
			
			if(base[i]!= null && base[i].getCostumerID().equals(purchase.getCostumerID()) == true && base[i].getItemID().equals(purchase.getItemID()) == true)
			{
			
				found = true;
				rezult = i;
			
			}
			else
			{
			
				i = i + 1;
			
			}	
		}
	    return rezult;
	}
	
	
	/** find locates a purchase in the database based on a key
	 * @param purchase - the desired purchase 
	 * @return (the address of) the desired purchase; 
	 * return null if purchase not found. */
	public Purchase find(Purchase purchase)
	{
		
		Purchase answer = null;
		int index = findLocation(purchase);
	    
		if(index != NOT_FOUND)
	    {
	    
			answer = base[index];
	    	
	    }
	    return answer;
	}
	
	
	/** insert inserts a new purchase into the database.
	 * @param purchase - the purchase
	 * @return true, if purchase added; return false if purchase not added because 
	 * another purchase with the same key already exists in the database */
	public boolean insert(Purchase purchase)
	{
		boolean success = false;
		
		
			boolean found_empty_place = false;
			
			int i = 0;
			
			while(!found_empty_place && i != base.length)
			{
				
				if(base[i] == null)
				{
					found_empty_place = true;
					
				}
				else
				{
					i = i +1;
				}
			}
	
			if(found_empty_place)	      
			{
	     	
				
	     		if(ind.delete(purchase.getItemID(), purchase.getQuantity()) == true)
	     		{
	     			base[i] = purchase;
	         		
	     			success = true;	
	     		
	     		}	     				
			}		  
			else		
			{
			
				Purchase[] temp = new Purchase[base.length * 2];			  

				for (int j = 0; j != base.length; j = j + 1)			  
				{
			   	
					temp[j] = base[j];
					
				}
					temp[base.length] = purchase;				  
					base = temp;	
					if(ind.delete(purchase.getItemID(), purchase.getQuantity()) == true)
		     		{
		     		
		     		
		     			success = true;	
		     
		     		
		     		}			    	
			}
	
		return success;
	}
	
	
	/** delete removes a purchase in the database
	 * @param purchase - the purchase 
	 * @return true, if purchase is found and deleted; return false otherwise */	
	public boolean delete(Purchase purchase)
	{
			
		boolean rezult = false;
		
		int index = findLocation(purchase);
		
		if(index != NOT_FOUND)
		{
		
			base[index] = null;
			rezult = true;
			
		}
		return rezult;
	}
	
	/** getAllPurchases returns all purchases of a purchaser whose key i k in a table model
	 * @param k - the purchaser key
	 * @return - the table model */
	public DefaultTableModel getAllPurchases(Key k)
	{
		
		for(int i = 0; i < base.length; i++)
		{
		
			if(base[i] != null && base[i].getCostumerID().equals(k))	
				
			{
		
			
	
				dtm.addRow(new Object[]{base[i].getItemName(),base[i].getPrice(),base[i].getQuantity(),base[i].getMeansOfPayment() ,(base[i].getPrice() * base[i].getQuantity())});
		   
 	
		
			}
		}
		
		return dtm;
	}	
	
	
	
}

