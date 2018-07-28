package com.doni;

/** Purchaser models a purchaser with a key, name, password and address*/
public class Purchaser {
	
  private Key k;
  private String n;
  private String a;
  private char[] p;
	
  /** Constructor Purchaser initializes the key, name, password and address
   * @param ID - the purchaser id
   * @param name - the purchaser name
   * @param password - the purchaser password
   * @param address - the purchaser address */
	public Purchaser(Key ID,String name,char[] password,String address)
	{
		k = ID;
		n = name;
		a = address;
		p = password;
		
		
	}
	
	/** getID returns the purchaser key */
	public Key getID()
	{
		return k;
	}
	
	/** getPassword returns the purchaser password */
	public char[] getPassword()
	{
		return p;
	}
	
	/** getName returns the purchaser name */
	public String getName()
	{
	  return n;
	}
	
	/** getAddress returns the purchaser address */
	public String getAddress()
	{
		return a;
	}

}
