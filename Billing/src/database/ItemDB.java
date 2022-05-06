package database;
import java.util.HashMap;

public class ItemDB {
	
	 public static ItemDB instance = null;
	 
	    private ItemDB()
	    {


	    }
	    private HashMap<String,Item> db = new HashMap<String,Item>();
	    
	    public static ItemDB getInstance()
	    {
	        if(instance == null)
	            instance = new ItemDB();

	        return instance;
	    }

	    public void setItem(Item item)
	    {
	    	db.put(item.name, item);

	    	
	    		
	    }
	    
	    public Item getItem(String name) throws Exception
	    {
	    	if(!db.containsKey(name)) throw new Exception("No such key");
	    	
	    	return this.db.get(name);
	    	
	    }
	    

}
