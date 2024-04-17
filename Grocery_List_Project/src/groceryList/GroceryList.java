package groceryList;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class GroceryList
 */
public class GroceryList {
	List<GroceryItem> groceryList;
	String file;
	
	public GroceryList(List<GroceryItem> groceryList, String file) {
		this.groceryList = groceryList;
		this.file = file;
	}
	
	public int getNumberOfItems() {
		return groceryList.size();
	}
	
	public int getNumberOfVegetables() {
		int numOfVeg = 0;
		for (GroceryItem g : groceryList) {
			if(g instanceof Vegetable) {
				numOfVeg++;
			}
		}
		return numOfVeg;
	} 
	
	/**
	 * Method returns a list of price objects based on the Prices file
	 * @return List<Price>   list of price objects created from Prices file 
	 */
	public List<Price> generatePriceList() {
		List<Price> prices = new ArrayList<>();
		try(Scanner reader = new Scanner(GroceryList.class.getResourceAsStream(file))){
			while(reader.hasNext()) {
				String line = reader.nextLine();
				try{
					line = line.strip();
					String[] splitLine = line.split(",");
				
					String name = splitLine[0];
					double p = Double.parseDouble(splitLine[1]);
					Price price = new Price(name, p);
					prices.add(price);
				} catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
					System.err.println("Error: " + line);
				}
			} // end while 
		}// end outer try
		return prices;
	} // end method
	
	/**
	 * Method estimates the total price of the groceryList based off of the prices listed in 
	 * the Prices file
	 * @return double    estimated price of the groceryList
	 */
	public String estimatePrice() {
		List<Price> prices = this.generatePriceList();
		double total = 0;
		
		for(int i = 0; i < prices.size(); i++) {
			Price price = prices.get(i); 
			for (GroceryItem g: groceryList) {
				if (g.name.equals(price.name)) {
					total += price.price;
				}
			} // end inner
		} // end outer
		DecimalFormat df = new DecimalFormat("#.##");
		String roundedValue = df.format(total);
		return "$" + roundedValue;
	} // end method
	
} // end class
