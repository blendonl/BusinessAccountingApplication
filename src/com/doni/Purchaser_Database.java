package com.doni;

import java.util.Arrays;

import javax.swing.table.DefaultTableModel;
/** Purchaser_Database implements a database of purchasers */
public class Purchaser_Database {	

		private Purchaser[] base;
		
		private int NOT_FOUND = -1;
		
	    private	DefaultTableModel dtm1; // the table model
		
		/** Constructor Purchaser_Database initializes the database and the DefaultTableModel 
		 * @param initial_size - the size of the database */ 
		public Purchaser_Database(int initial_size)
		{
		    dtm1 = new DefaultTableModel(); 
			dtm1.addColumn("Name");	        
			dtm1.addColumn("ID");	        
			dtm1.addColumn("Address");
			
			
			if(initial_size > 0)
			{
				
				base = new Purchaser[initial_size];
			
			}
			else
			{
			
				base = new Purchaser[1];
				
			}
		}
		
		
		/** findLocation is a helper method that searches base for a purchaser
		 * whose key is k. If found, the index of the purchaser is returned,
		 * else NOT FOUND is returned. */ 
		public int findLocation(Key k)
		{
			
			int rezult = NOT_FOUND;
			
			boolean found = false;
			
			int i = 0; 
			
			while(!found && i != base.length)
			{
			
				if(base[i]!= null && base[i].getID().equals(k))
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
		
		
		/** findLocation is a helper method that searches base for a purchaser 
		 * whose password is p. If found, the index of the purchaser is returned,
		 * else NOT FOUND is returned. */ 
		public int findNameLocation(String name)
		{
			
			int rezult = NOT_FOUND;
			
			boolean found = false;
			
			int i = 0;
			
			while(!found && i != base.length)
			{
			
				if(base[i]!= null && base[i].getName().equals(name))
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
		
		/** findNameLocation is a helper method that searches base for a purchaser 
		 * whose name is name. If found, the index of the purchaser is returned,
		 * else NOT FOUND is returned. */ 
		public int findNamePasswordLocation(String name,char[] password)
		{
			
			int rezult = NOT_FOUND;
			
			boolean found = false;
			
			int i = 0;
			
			while(!found && i != base.length)
			{
			
				if(base[i]!= null && base[i].getName().equals(name) && Arrays.equals (base[i].getPassword(),password))
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

		/** find locates a purchaser in the Purchaser_Database based on a key
		 * @param key - the key of the desired purchaser 
		 * @return (the address of) the desired purchaser; 
		 * return null if purchaser not found. */
		public Purchaser find(Key key)
		{
			
			Purchaser answer = null;
			
			int index = findLocation(key);
		    
			if(index != NOT_FOUND)
		    {
		    
				answer = base[index];
		    	
		    }
		    return answer;
		}

		
		/** insert inserts a new purchaser into the Purchaser_Database.
		 * @param r - the purchaser
		 * @return true, if purchaser added; return false if purchaser not added because 
		 * another purchaser with the same key already exists in the Purchaser_Database */
		public boolean insert(Purchaser r)
		{
			boolean success = false;
			
			if(findLocation(r.getID()) == NOT_FOUND)
			{
			
				boolean found_empty_place = false;
				int i = 0;
				
				while(!found_empty_place && i != base.length)
				{
					
					if(base[i]== null)
					{
					
						found_empty_place = true;
						
					}
					else
					{
						
						i = i + 1;
					}
				}
			
			
		      if(found_empty_place)
		      {
		     		
		    	  base[i] = r;
		    		
		    	  dtm1.addRow(new Object[]{base[i].getName(),base[i].getID().getInt(),base[i].getAddress()});	
		 		
			  }
			  else
			  {
				 
				  Purchaser[] temp = new Purchaser[base.length * 2];
				  
				  for (int j = 0; j != base.length; j = j + 1)
				  {
				  
					  temp[j] = base[j];
					 
				  
				  }	  
				  
				  temp[base.length] = r;
				  base = temp;	
		      }
		      
		      success = true;	
		   
			}			
			return success;			
		}
		
	
		
		/** delete removes a purchaser in the Purchaser_Database based on a key 
		 * @param key - the purchaser�s key (identification) 
		 * @return true, if purchaser is found and deleted; return false otherwise */
		public boolean delete(Key key)
		{
			
			boolean rezult = false;
			
			int index = findLocation(key);
			
			if(index != NOT_FOUND)
			{
			
				base[index] = null;
				rezult = true;
				
			}
			return rezult;
		}

		/** getAllPurchasers returns on a table model all purchasers */
		public DefaultTableModel getAllPurchasers()
		{
	    
			return dtm1;
	    
		}
}
