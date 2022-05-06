package Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import database.CardDB;
import database.Item;
import database.ItemDB;
import database.Order;
import database.OrderDB;

public class OrderParser implements IParser{
	
	

	@Override
	public void parse(String filename) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(filename));
        sc.useDelimiter(",");
                
        String[] columns = sc.nextLine().split(",");
        String[] values = new String[columns.length];
        
        try {
        	boolean i = true;
	        while(sc.hasNextLine())
	        {
	        	
	        	String line = sc.nextLine();
	            values = line.split(",");
	            if(i)
	        	{
	        		OrderDB.getInstance().cardNum = values[2];
	        		System.out.println(values[2]);
	        		CardDB.getInstance().checkCard(values[2]);
	        	}
	            Order order;
            	order = new Order(values[0].toLowerCase(),Integer.parseInt(values[1]));
	            OrderDB.getInstance().setItem(order);
	        	i = false;

	         }
	        
            
	        OrderDB.getInstance().makeFile();

        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        sc.close(); 
		
	}

}
