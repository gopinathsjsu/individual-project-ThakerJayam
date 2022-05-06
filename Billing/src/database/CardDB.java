package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class CardDB {
	public static CardDB instance = null;
	 
    private CardDB()
    {


    }
    HashSet<String> cards = new HashSet();
    
    public static CardDB getInstance()
    {
        if(instance == null)
            instance = new CardDB();

        return instance;
    }
    
    public void checkCard(String card)
    {
    	if(!cards.contains(card))
    	{
    		cards.add(card);
    	}
    }
    
    public void makeFile(String filename) throws IOException
    {
    	FileWriter writer = new FileWriter(filename);
    	for(String card : cards)
    	{
    		writer.write(card + "\n");
    	}
    	writer.close();
    	
    }
    
    public void getCards(String filename) throws FileNotFoundException
    {
    	Scanner sc = new Scanner(new File(filename));
    	
    	while(sc.hasNextLine())
        {
    		String card = sc.nextLine();
    		this.cards.add(card);
        }
    	
    }



}
