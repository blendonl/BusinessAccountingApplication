package com.doni;

/** Purchase1 models a purchase with a item, purchaser and quantity*/
public class Purchase
{
  
	private Item i;	
	private Purchaser p;	
	private int q;
	private String mop;
	
 
	/** Constructor Purchase initializes the purchaser, item and quantity
	 * @param item - the item that purchaser is buying. 
	 * @param purchaser - the purchaser
	 * @param quantity - the quantity that the purchaser is going to purchase
	 * @param meansOfPayment - the means of payment */ 	
	public Purchase(Item item, Purchaser purchaser,String meansOfPayment, int quantity)
	{
		
	    	i = item;		
	    	p = purchaser;
	    	q = quantity;
	    	mop = meansOfPayment;
    
	}

	
	/** getCostumerID  returns the Purchaser id . 
	 * @return the key */    
	public Key getCostumerID()    
	{
			
			  
	    	return p.getID();
	    	
	}
		  
	 
	/** getPurchaserName returns the Purchasers Name
	 *@return the  name */  
	 public String getCostumerName()
	 {
	
	    	return p.getName();
 
	 }
		  	
	 /** getItemName returns the Item Name
      *@return the name */   
	 public String getItemName()   
	 {
	
	    	
		 return i.getName();
  
	 }
		  
	 /** getPrice returns the item Price
	  *@return the WholeSalePrice */  
	 public double getPrice()   
	 {
	
		 return i.getWholeSalePrice();
	    
	 }
	
		
	 /** getItemKey returns the item key
	  *@return the key */   
	 public Key getItemID()   
	 {
	
		 return i.getID();
  
	 }
		  
		
	 /** getQuantity returns the item quantity
	  *@return the quantity */      
	 public int getQuantity()   
	 {
	
		 return q;
   
	 }	
	 
	 /**getMeansOfPayment returns the items means of payment
	  * @return the means of payment
	  */
	 public String getMeansOfPayment()
	 {
		 return mop;
		 
	 }
	 
}
