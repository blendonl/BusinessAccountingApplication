package com.doni.Models;

/**Item models a item with an name, identification key, wholesale price, retail price and quantity */
public class Item {

	private Key k = null;
    private String s = "";
    private double i = 0;
    private double r = 0;
    private int q =0;
 
    /** Constructor Item  initializes the account 
     * @param name - the item name
     * @param key - the item identification key
     * @param w_price - the item wholesale price
     * @param r_price - the item retail price
     * @param quantity - the item quantity    */
	public Item(String name,Key key,double w_price,double r_price,int quantity) {
		
		s = name;
		k = key;
		i = w_price;
		r = r_price;
		q = quantity;

	}
	
	/** getName returns the item name */
	public String getName()
	{
		return s;
	}
	
	/** getID returns the item key */
	public Key getID() {
		return k;
		
	}
	
	/** getWholeSalePrice returns the item wholesale price */
	public double getWholeSalePrice()
	{
		return i;
	}
	
	/** getRetailPrice returns the item retailPrice */
	public double getRetailPrice() {
	
		return r;
  	}
	
	/** getQuantity returns the item quantity */
	public int getQuantity() {
	
		return q;
  	}
}
