package  writers;

import java.io.FileWriter;

public class OutputWriter {
	
	static OutputWriter instance;
	
	FileWriter writer;
	private OutputWriter(String filename) throws Exception
	{
		writer = new FileWriter(filename);
		writer.write("filename");
		
	}
	
	
	public static void setInstance(String filename) throws Exception
	{
		if(instance == null)
		{
			instance = new OutputWriter(filename);
			instance.writer.write("Item,Quantity,Price,TotalPrice\n");
			return;
		}
		throw new Exception("Already Initialized");
		
	}
	
	public static OutputWriter getInstance() throws Exception
	{
		if(instance == null)
			throw new Exception("Please set the instance first");
		
		return instance;

	}
	
	public void write(String item,int quantity, double price)
	{
		try
		{
			writer.write(item + "," + quantity + "," + price + "\n");
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void writePrice(String price)
 	{
		try
		{
			writer.write(",,," + price);
		}
		catch(Exception e)
		{
			
		}
	}
	public void close()
	{
		try
		{
			writer.close();
		}
		catch(Exception e)
		{
			
		}
	}

}
