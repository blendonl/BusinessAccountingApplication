package com.doni;

import javax.swing.table.DefaultTableModel;
/**Inventory_Database implements a database of items*/
public class Inventory_Database {
    
	private Item[][] base;	

	private int NOT_FOUND = -1;	
	
	private int row;	
	private int colum;
	
	private DefaultTableModel dtm;
	
	private int i = 0;	
	private int j = 0;  
		
    /** Constructor Inventory_Database initializes the database 
	 * @param initial_size - the size of the database */ 		
	public Inventory_Database(int row, int colum)	
	{			
			
		dtm = new DefaultTableModel();			
		dtm.addColumn("Name");					
		dtm.addColumn("ID" );					
		dtm.addColumn("Wholesale Price");					
		dtm.addColumn("Retail Price");					
		dtm.addColumn("Quantity in stock");			
		
		this.row = row;		
		this.colum = colum;			
		
		if(row > 0)		
		{			
		
			base = new Item[row][colum];
						
		}		
		else		
		{
					
			base = new Item[1][1];
							
		}		
	}		
		
	
	/** findLocation is a helper method that searches base for a item 	 
     * whose key is k. If found, the index of the item is returned,
     * else NOT FOUND is returned. */ 	
	public  int findLocation(Key k)	
	{
		   	
		int rezult = NOT_FOUND;
		
		boolean found = false;
		
		for(int i = 0; !found && i != base.length; i++)		
		{
		
			for(int j = 0;!found && j != base[i].length; j++)			
			{	
				
				if(base[i][j] != null && base[i][j].getID().equals(k))									
				{
				
					found = true;
					
					rezult = i;
					
				}								
			}						
		}		
		return rezult;		
	}

	/**findNameLocation find the location of an item based on a name 
	 * @param name - the item name
	 * @return - the location of the item if the item is founded and return -1 if the item is not founded */
	public int findNameLocation(String name)	
	{
	
		int rezult = NOT_FOUND;
		
		boolean found = false;
					
		for(int i = 0; !found && i != base.length; i++)		
		{
				     		
			for(int j = 0;j != base[i].length;j++)			
			{
			
				if(base[i][j] != null && base[i][j].getName().equals(name))				
				{
			
					found = true;
					
					rezult = i;
			    
				}								
			}				
		}		
		return rezult;		
	}
	
	/** find locates a item in the Inventory_database based on a key	
     * @param key - the key of the desired item 
 	 * @return (the address of) the desired item; 
 	 * return null if item not found. */		
	public Item find(Key key)	
	{
	
		Item answer = null;
		
		boolean found = false;
		
		int index = findLocation(key);		
		
		if(index != NOT_FOUND)		
		{
		
			for(int j = 0; !found && j != base.length; j++)				
			{
			
				if(base[index][j] != null && (base[index][j].getID()).equals(key) == true)				     				
				{
														
					found = true;					  
					
					answer = base[index][j];
		 					
				}							
			}		    			    
		}		
		return answer;		
	}
		
	
	/** findQuantity locates an item quantity in the Inventory_database based on a key	
	 * @param key - the key of the desired item 
	 * @return (the address of) the desired item; 
	 * return null if item not found. */		
	public int findQuantity(Key k)	
	{
	
		int rezult = -1;
		
		int a = 0;			
		
		int index = findLocation(k);
		
		if(index != NOT_FOUND)		
		{
		
			
				     			
			for(int j = 0; j < base[index].length; j++)				     			
			{
			
				if(base[index][j] != null)				    				
				{
				
					rezult = a;
					a = a + 1;
				
				}
	
			}		    
		}				
		return rezult;			
	}
	
	
	public Item findName(String name)	
	{
	
		Item answer = null;
		
		int index = findNameLocation(name);					    
		
		if(index != NOT_FOUND )		
		{
		
			answer = base[index][0];		    	
		    
		}		    		    
		
		return answer;				
	}
	
	/** insert inserts a new item into the Inventory_Database.
	 * @param item - the item
	 * @return true, if item added; return false if item not added because 
	 * another item with the same key already exists in the database */		
	public boolean insert(Item item)	
	{
	
		boolean success = false;
		
		if(findLocation(item.getID()) == NOT_FOUND)		
		{
					
			boolean found_empty_place = false;
			
			int i = 0;										
			
			while(!found_empty_place && i != base.length)		
			{					
			
				for(int j = 0;!found_empty_place &&  j != base[i].length;j++)				
				{
					 				
					if(base[i][j] == null )					  					
					{					 						
					
						found_empty_place = true;
					
					}					 					
					else					 					
					{
					
						i = i + 1;
					
					}										
				}								
			}		      			
			if(found_empty_place && item.getQuantity() < base[i].length)		      			
			{
			
				for(int j = 0; j <= item.getQuantity(); j++)		    					
				{		     		
				
					base[i][j] = item;
					
				}			  				
			}			  			
			else			 			
			{
				boolean found = false;
			
				if(!found_empty_place || item.getQuantity() >= base.length )
				{
					
					Item[][] temp = new Item[row * 2][colum * 2];
					
					for(int x = 0; x != base.length; x++)			  
					{
						for(int y = 0; y != base[i].length; y++)
						{
				   	
						   temp[x][y] = base[x][y];
						   System.out.println(x ); 	
						
						}
					}
				
						
					int a = 0;										
					
					while(a != temp.length && !found)		
					{	
						System.out.println(a ); 	
					
						for(int j = 0; !found && j != temp[a].length;j++)				
						{
							System.out.println(a ); 				
							if(temp[a][j] == null )					  					
							{					 						
							
								found = true;
							
							}					 					
							else					 					
							{
							
								a = a + 1;
							
							}										
						}								
					}	
					
					if(found && item.getQuantity() < temp[a].length)		      			
					{
					
						for(int j = 0; j <= item.getQuantity(); j++)		    					
						{		     		
						
							temp[a][j] = item;
							
							System.out.println(a + " " + j);
							base = temp;
							
						}			  				
					}
					
				}
		
			}
			
		      			
			success = true;	
		
		}				
		return success;			
	}		
		
	
	/** delete removes a item in the database based on a key and on a quantity	
	 * @param key - the item�s key (identification) 
	 * @param quantity - the item quantity in database
	 * @return true, if item is found and deleted; return false otherwise */		
	public boolean delete(Key key,int quantity)	
	{
	
		boolean rezult = false;		
		boolean found = false;
		
		int index = findLocation(key);
		
		int j = 0; 	//the row				
		int i = 0;  //the column
		
		if(index != NOT_FOUND)		
		{
			
		    			    		
			if(quantity < 0 || quantity > findQuantity(key))		    
			{
		    
				rezult = false;		    				
		    	
			}		    
			else		    
			{
		    	
				while(!found && i < findQuantity(key))		    	   		    	
				{	
				
		    	
					if(base[index][i] != null )		    		  		    		
					{
		    					    		
						found = true;
		    			
					}		    		  		    		
					else		    		  		    		
					{
		    			  		    		  		    				    		  		    		
						i++;
		    		  		    			
					}		    	   		    		
				}
		    		  		    	  		    	
				while(j < quantity && found )		    	   		    	
				{
					
					base[index][j + i] = null;
		    		
					rezult = true;			    		
					j++;
					
					
		    		
				}	    			    	
			}		    		    
		}					
		return rezult;		
	}
	
	/** getAllItems prints all items in an TableModel */		
	public DefaultTableModel getAllItems()	
	{
	
		while( i < base.length)						
		{			
					  			
			while(j < base[i].length)				  				
			{
				
				if(base[i][j] != null && dtm.getRowCount() > i)						  						
				{
					
					dtm.addRow(new Object[] {base[i][j].getName(),base[i][j].getID().getInt(),base[i][j].getWholeSalePrice(),base[i][j].getRetailPrice(),findQuantity(base[i][j].getID())});
				       			  			    					
					break; 
				
				}
									
				j++;
				
			}		
			
			i++;			
		}										
		return dtm;				
	}		
}
