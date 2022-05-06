import Parser.ItemParser;
import Parser.OrderParser;
import database.CardDB;
import writers.ErrorWriter;
import writers.OutputWriter;

public class Billing {
	public static void main(String[] args) throws Exception
	{
		ErrorWriter.setInstance(args[0]);
		OutputWriter.setInstance(args[1]);
		CardDB.getInstance().getCards(args[2]);

		ItemParser itemparser = new ItemParser();
		itemparser.parse(args[3]);
		
		OrderParser orderparser = new OrderParser();
		
		orderparser.parse(args[4]);

		ErrorWriter.getInstance().close();
		OutputWriter.getInstance().close();
		CardDB.getInstance().makeFile(args[5]);
		
	}
}
