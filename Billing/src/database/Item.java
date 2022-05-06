package database;

public class Item {
	String category;
	public String name;
	int quantity;
	double price;
	
	public Item(String cat,String name, int qut,double price)
	{
		this.category = cat;
		this.name = name;
		this.quantity = qut;
		this.price = price;
	}
}
