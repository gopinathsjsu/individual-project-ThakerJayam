package Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import database.Item;
import database.ItemDB;

public class ItemParser implements IParser {

	@Override
	public void parse(String filename) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(filename));
        sc.useDelimiter(",");
                
        String[] columns = sc.nextLine().split(",");
        String[] values = new String[columns.length];
        
        while(sc.hasNextLine())
        {
            values = sc.nextLine().split(",");
            Item item = new Item(values[1].toLowerCase(),values[0].toLowerCase(),Integer.parseInt(values[2]),Double.parseDouble(values[3]));
            ItemDB.getInstance().setItem(item);
            
            
        }       
        sc.close();  
		
	}

}
