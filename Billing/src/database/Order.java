package database;

import writers.ErrorWriter;
import writers.OutputWriter;

public class Order {
	
	String itemName;
	int qtyNeeded;
	
	public Order(String itemName,int qtyNeeded) throws Exception
	{
		validateName(itemName);
		validateqty(itemName,qtyNeeded);
		
		this.itemName = itemName;
		this.qtyNeeded = qtyNeeded;
		
		
	}

	private void validateCard(String cardNo) {
		// TODO Auto-generated method stub
		
	}

	private void validateqty(String itemName,int qtyNeeded) throws Exception {
		
			Item item = ItemDB.getInstance().getItem(itemName);
			
			if(item.category.equals("essentials"))
			{
				if(qtyNeeded > item.quantity || qtyNeeded > 3)
				{
					ErrorWriter.getInstance().write("Please correct quantity for: " + item.name);
					throw new Exception();
				}
									
			}
			else if(item.category.equals("luxury"))
			{
				if(qtyNeeded > item.quantity || qtyNeeded > 4)
				{
					ErrorWriter.getInstance().write("Please correct quantity for: " + item.name);
					throw new Exception();

				}

			}
			else if(item.category.equals("misc"))
			{
				if(qtyNeeded > item.quantity || qtyNeeded > 6)
				{
					ErrorWriter.getInstance().write("Please correct quantity for: " + item.name);
					throw new Exception();

				}
			}
			
		
	}

	private void validateName(String itemName) {
		// TODO Auto-generated method stub
		
	}

}
