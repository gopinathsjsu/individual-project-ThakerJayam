package writers;

import java.io.FileWriter;
import java.io.IOException;

public class ErrorWriter {
	
	static ErrorWriter instance;
    FileWriter writer;
	private  ErrorWriter(String filename) throws Exception
	{
		
		writer = new FileWriter(filename);
		writer.write("The following errors have occoured:\n");
	
	}
	
	
	public static void setInstance(String filename) throws Exception
	{
		if(instance == null)
		{
			instance = new ErrorWriter(filename);
			return;
		}
		throw new Exception("Already Initialized");
		
	}
	
	public static ErrorWriter getInstance()
	{
		
		return instance;
			

	}
	
	public void write(String message)
	{
		try {
		writer.write(message + "\n");
		}
		catch(Exception e)
		{
			System.out.println("Cannot write to file");
		}
	}
	
	public void close()
	{
		try
		{
			writer.close();
			instance = null;
		}
		catch(Exception e)
		{
			System.out.println("Cannot close the file");
		}
		
	}

}
