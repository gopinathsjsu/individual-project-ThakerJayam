package database;

import java.util.HashMap;

import writers.OutputWriter;

public class OrderDB {
	public static OrderDB instance = null;
	 
    private OrderDB()
    {


    }
    private HashMap<String,Order> db = new HashMap();
    public String cardNum;
    public static OrderDB getInstance()
    {
        if(instance == null)
            instance = new OrderDB();

        return instance;
    }

    public void setItem(Order order)
    {
    	
			db.put(order.itemName, order);

    }
    
    public Order getItem(String name) throws Exception
    {
    	if(!db.containsKey(name)) throw new Exception("");
    	
    	return this.db.get(name);
    	
    }
    public void makeFile() throws Exception
    {
    	int tot_price = 0;
    	for(String key : db.keySet())
    	{
    		OutputWriter.getInstance().write(db.get(key).itemName, db.get(key).qtyNeeded,ItemDB.getInstance().getItem(db.get(key).itemName).price* db.get(key).qtyNeeded);
    		tot_price += ItemDB.getInstance().getItem(db.get(key).itemName).price* db.get(key).qtyNeeded;
    	}
    	OutputWriter.getInstance().writePrice("" + tot_price);
    	
    }


}
