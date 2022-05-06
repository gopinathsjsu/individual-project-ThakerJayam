package database;

import java.util.HashMap;

public class DB {
	public static DB instance = null;
	 
    private DB()
    {


    }
    
    public static DB getInstance()
    {
        if(instance == null)
            instance = new DB();

        return instance;
    }

}
