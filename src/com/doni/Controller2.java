package com.doni;

/** The business accounting application controller */
public class Controller2 
{
	
	public static void main(String[] args)
	{
	
		Inventory_Database ind = new Inventory_Database(100,100);	
		Purchaser_Database pnd = new Purchaser_Database(100);	
		Purchase_Database pd = new Purchase_Database(100,ind);
      
		LoginFrame lf = new LoginFrame(pnd,ind,pd);     
		lf.setVisible(true);
 
	}
	
}
