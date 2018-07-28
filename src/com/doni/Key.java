package com.doni;

/** Key models an integer key */
public class Key 
{
	
	private int key;

	/** Key models an integer key */ 	
	public Key(int i )
	{
	
		key = i;
	
	}
	
	
	/** equals compares this Key to another for equality
	 *   @param c - the other key
	 *   @return true, if this key equals k�s; return false, otherwise */ 
	public boolean equals(Key c)
	{
	
		return (key == c.getInt());
	
	}
	
	
	/** getInt returns the integer value held within this key */
	public int getInt()
	{
	
		return key;
	
	}
	
	
	

}
